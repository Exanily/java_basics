import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RecursiveTask;
import java.util.regex.Pattern;


public class Processor extends RecursiveTask<Map<String, Map>> {

    private final String URL;
    private final String childPage;
    private final Pattern PATTERN_URL;
    private final Pattern PATTERN = Pattern.compile("/[^#]+");
    private final List<String> repetition;
    private final Map<String, Map> map;


    private static final int SLEEP = 100;

    private Processor(String URL, String childPage, List<String> repetition, Map<String, Map> map) {
        this.URL = URL;
        this.childPage = childPage;
        this.repetition = repetition;
        PATTERN_URL = Pattern.compile(URL + ".+");
        this.map = map;
    }

    public Processor(String URL) {
        if (URL.charAt(URL.length() - 1) == '/') {
            this.URL = URL.substring(0, URL.length() - 1);
        } else this.URL = URL;
        childPage = "";
        this.repetition = new ArrayList<>();
        repetition.add(URL);
        PATTERN_URL = Pattern.compile(URL + ".+");
        this.map = new HashMap<>();
    }

    @Override
    protected Map<String, Map> compute() {
        Map<String, Map> list = new HashMap<>();
        List<Processor> tasks = new ArrayList<>();
        String address;
        if (PATTERN_URL.matcher(childPage).matches()) {
            address = childPage;
        } else {
            address = URL + childPage;
        }
        map.put(address, list);

        try {
            Thread.sleep(SLEEP);
            Document document = Jsoup.connect(address).get();

            Elements elements = document.select("a");
            elements.forEach(element -> {
                String s = element.attr("href");
                if (s.isEmpty()) {
                    return;
                }
                if (!PATTERN.matcher(s).matches() && !PATTERN_URL.matcher(s).matches()) {
                    return;
                }
                String newS = checkURL(s);
                synchronized (repetition) {
                    if (repetition.contains(newS)) {
                        return;

                    }
                    repetition.add(newS);
                }
                Processor task = new Processor(URL, newS, repetition, list);
                task.fork();
                tasks.add(task);
            });

        } catch (IOException ignore) {
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        addResultsFromTasks(list, tasks);
        list.remove(URL);
        return map;
    }

    private void addResultsFromTasks(Map<String, Map> list, List<Processor> tasks) {
        for (Processor item : tasks) {
            list.put(URL, item.join());
        }
    }

    private String checkURL(String s) {
        String address;
        if (PATTERN_URL.matcher(s).matches()) {
            address = s;
        } else {
            address = URL + s;
        }
        return address;
    }
}
