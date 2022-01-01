import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class StationIndex {

    private final Map<Integer, Line> number2line;
    private final TreeSet<Station> stations;

    public StationIndex() {
        this.number2line = new HashMap<>();
        this.stations = new TreeSet<>();
    }


    public void addStation(Station station) {
        stations.add(station);
    }

    public void addLine(Line line) {
        number2line.put(line.getNumber(), line);
    }

    public Line getLine(int number) {
        return number2line.get(number);
    }

    public Map<Integer, Line> getNumber2line() {
        return number2line;
    }
}
