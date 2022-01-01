import java.util.ArrayList;
import java.util.List;

public class Line implements Comparable<Line>{
    private String name;
    private int number;
    private List<Station> stations;

    public Line(String name, int number) {
        this.name = name;
        this.number = number;
        this.stations = new ArrayList<>();
    }

    public int getNumber()
    {
        return number;
    }

    public String getName()
    {
        return name;
    }
    public List<Station> getStations()
    {
        return stations;
    }

    public void addStation(Station station)
    {
        stations.add(station);
    }
    @Override
    public int compareTo(Line line)
    {
        return Integer.compare(number, line.getNumber());
    }

    @Override
    public boolean equals(Object obj)
    {
        return compareTo((Line) obj) == 0;
    }
}
