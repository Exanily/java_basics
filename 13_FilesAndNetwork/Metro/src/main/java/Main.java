import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static StationIndex stationIndex;

    public static void main(String[] args) {
        String url = "https://www.moscowmap.ru/metro.html#lines";
        createJSON(url);
        print();
    }

    private static void createJSON(String url) {
        JSONObject jsonObject = new JSONObject();
        try {
            Document document = Jsoup.connect(url).maxBodySize(0).get();
            Elements elements = document.select("#metrodata").select("div.t-text-simple");
            jsonObject.put("lines", createLine(elements));
            jsonObject.put("stations", createStation(elements));
            save(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<JSONObject> createLine(Elements elements) {
        ArrayList<JSONObject> list = new ArrayList();
        for (int i = 1; i <= 17; i++) {
            int finalI = i;
            String tage = "span[data-line=\"" + i + "\"]";
            if (i == 16) {
                tage = "span[data-line=\"D1\"]";
            }
            if (i == 17) {
                tage = "span[data-line=\"D2\"]";
            }
            elements.select(tage).forEach(element -> {
                JSONObject object = new JSONObject();
                object.put("number", finalI);
                object.put("name", element.text());
                list.add(object);
            });
        }
        return list;
    }

    private static JSONObject createStation(Elements elements) {
        JSONObject jsonObject = new JSONObject();
        for (int i = 1; i <= 17; i++) {
            String tage = "div[data-line=\"" + i + "\"]";
            if (i == 16) {
                tage = "div[data-line=\"D1\"]";
            }
            if (i == 17) {
                tage = "div[data-line=\"D2\"]";
            }
            List<String> strings = new ArrayList<>();
            elements.select(tage).select("a").select("span.name").forEach(element -> {
                strings.add(element.text());
            });
            jsonObject.put(i, strings);
        }
        return jsonObject;
    }

    private static void save(JSONObject jsonObject) {
        try (FileWriter file = new FileWriter("src/main/resources/map.json")) {
            file.write(jsonObject.toJSONString());
            file.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void print() {
        parse();
        stationIndex.getNumber2line().keySet().forEach(lineNumber -> {
            Line line = stationIndex.getLine(lineNumber);
            System.out.println(line.getName() + " - количество станций : " + line.getStations().size());
        });
    }

    private static void parse() {
        stationIndex = new StationIndex();
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonData = (JSONObject) parser.parse(getJsonFile());
            JSONArray linesArray = (JSONArray) jsonData.get("lines");
            parseLines(linesArray);

            JSONObject stationsObject = (JSONObject) jsonData.get("stations");
            parseStations(stationsObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getJsonFile() {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get("src/main/resources/map.json"));
            lines.forEach(builder::append);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }

    private static void parseLines(JSONArray linesArray) {
        linesArray.forEach(lineObject -> {
            JSONObject lineJsonObject = (JSONObject) lineObject;
            Line line = new Line(
                    (String) lineJsonObject.get("name"),
                    ((Long) lineJsonObject.get("number")).intValue()
            );
            stationIndex.addLine(line);
        });
    }

    private static void parseStations(JSONObject stationsObject) {
        stationsObject.keySet().forEach(lineNumberObject ->
        {
            int lineNumber = Integer.parseInt((String) lineNumberObject);
            Line line = stationIndex.getLine(lineNumber);
            JSONArray stationsArray = (JSONArray) stationsObject.get(lineNumberObject);
            stationsArray.forEach(stationObject ->
            {
                Station station = new Station((String) stationObject, line);
                stationIndex.addStation(station);
                line.addStation(station);
            });
        });
    }
}
