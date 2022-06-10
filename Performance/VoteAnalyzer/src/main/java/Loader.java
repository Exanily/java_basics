import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Loader {

    private static final SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");
    private static final SimpleDateFormat visitDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

    private static final HashMap<Integer, WorkTime> voteStationWorkTimes = new HashMap<>();
    private static final HashMap<Voter, Integer> voterCounts = new HashMap<>();

    public static void main(String[] args) throws Exception {
        String fileName = "res/data-1572M.xml";
        long start = System.currentTimeMillis();

        parseFile(fileName);
        System.out.println(System.currentTimeMillis() - start + " ms");


    }

    private static void parseFile(String fileName) throws Exception {
       /* DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File(fileName));*/

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        XMLHandler handler = new XMLHandler();
        parser.parse(new File(fileName), handler);

        ArrayList<Voter> voters = handler.getVoters();

        findEqualVoters(voters);
        //fixWorkTimes(doc);
    }

    private static void findEqualVoters(ArrayList<Voter> voters) throws Exception {
        int votersCount = voters.size();
        for (int i = 0; i < votersCount; i++) {
            Voter voter = voters.get(i);
            String name = voter.getName();
            String birthDay = birthDayFormat.format(voter.getBirthDay());
            DBConnection.countVoter(name, birthDay);
            if(i % 1_300_000 == 0){
                DBConnection.executeMultiInsert();
            }
        }
        DBConnection.executeMultiInsert();
    }

    private static void fixWorkTimes(Document doc) throws Exception {
        NodeList visits = doc.getElementsByTagName("visit");
        int visitCount = visits.getLength();
        for (int i = 0; i < visitCount; i++) {
            Node node = visits.item(i);
            NamedNodeMap attributes = node.getAttributes();

            Integer station = Integer.parseInt(attributes.getNamedItem("station").getNodeValue());
            Date time = visitDateFormat.parse(attributes.getNamedItem("time").getNodeValue());
            WorkTime workTime = voteStationWorkTimes.get(station);
            if (workTime == null) {
                workTime = new WorkTime();
                voteStationWorkTimes.put(station, workTime);
            }
            workTime.addVisitTime(time.getTime());
        }
    }
}