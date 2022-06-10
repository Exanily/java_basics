import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class XMLHandler extends DefaultHandler {

    private Voter voter;
    private static final SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");
    private final ArrayList<Voter> voterCounts;

    public XMLHandler() {
        voterCounts = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        try {
            if (qName.equals("voter")) {
                Date birthDay = birthDayFormat.parse(attributes.getValue("birthDay"));
                voter = new Voter(attributes.getValue("name"), birthDay);
            } else if (qName.equals("visit") && voter != null) {
                voterCounts.add(voter);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("voter")) {
            voter = null;
        }
    }

    public void printDuplicatedVoter() {
        for (Voter voter : voterCounts) {
            System.out.println(voter.toString());
        }
    }

    public ArrayList<Voter> getVoters() {
        return voterCounts;
    }
}
