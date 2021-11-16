import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    private static final StationIndex stationIndex = new StationIndex();

    @Override
    protected void setUp() {
        Line line1 = new Line(1, "1");
        line1.addStation(new Station("Горьковская", line1));
        line1.addStation(new Station("Невский проспект", line1));

        Line line2 = new Line(2, "2");
        line2.addStation(new Station("Гостиный двор", line2));
        line2.addStation(new Station("Маяковская", line2));

        Line line3 = new Line(3, "3");
        line3.addStation(new Station("Площадь Восстания", line3));
        line3.addStation(new Station("Чернышевская", line3));

        stationIndex.addStation(new Station("Горьковская", line1));
        stationIndex.addStation(new Station("Невский проспект", line1));
        stationIndex.addStation(new Station("Гостиный двор", line2));
        stationIndex.addStation(new Station("Маяковская", line2));
        stationIndex.addStation(new Station("Площадь Восстания", line3));
        stationIndex.addStation(new Station("Чернышевская", line3));

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        List<Station> stations1 = new ArrayList<>();
        stations1.add(new Station("Невский проспект", line1));
        stations1.add(new Station("Гостиный двор", line2));

        List<Station> stations2 = new ArrayList<>();
        stations2.add(new Station("Маяковская", line2));
        stations2.add(new Station("Площадь Восстания", line3));

        stationIndex.addConnection(stations1);
        stationIndex.addConnection(stations2);
    }

    public void testTimeRouteOnTheLine() {
        double actualTimeRouteOnTheLine = RouteCalculator.calculateDuration(routeOnTheLine());
        double expectedTimeRouteOnTheLine = 2.5;
        assertEquals(expectedTimeRouteOnTheLine, actualTimeRouteOnTheLine);
    }

    public void testTimeWithOneConnection() {
        double actualTimeWithOneConnection = RouteCalculator.calculateDuration(routeWithOneConnections());
        double expectedTimeWithOneConnection = 8.5;
        assertEquals(expectedTimeWithOneConnection, actualTimeWithOneConnection);
    }

    public void testTimeWithTwoConnections() {
        double actualTimeWithTwoConnections = RouteCalculator.calculateDuration(routeWithTwoConnections());
        double expectedTimeWithTwoConnections = 14.5;
        assertEquals(expectedTimeWithTwoConnections, actualTimeWithTwoConnections);
    }

    public void testRouteOnTheLine() {
        List<Station> actualRouteOnTheLine = new ArrayList<>();
        actualRouteOnTheLine.add(new Station("Горьковская", line1()));
        actualRouteOnTheLine.add(new Station("Невский проспект", line1()));
        assertEquals(routeOnTheLine(), actualRouteOnTheLine);
    }

    public void testRouteWithOneConnection() {
        List<Station> actualRouteWithOneConnection = new ArrayList<>();
        actualRouteWithOneConnection.add(new Station("Горьковская", line1()));
        actualRouteWithOneConnection.add(new Station("Невский проспект", line1()));
        actualRouteWithOneConnection.add(new Station("Гостиный двор", line2()));
        actualRouteWithOneConnection.add(new Station("Маяковская", line2()));
        assertEquals(routeWithOneConnections(), actualRouteWithOneConnection);
    }

    public void testRouteWithTwoConnections() {
        List<Station> actualRouteWithTwoConnections = new ArrayList<>();
        actualRouteWithTwoConnections.add(new Station("Горьковская", line1()));
        actualRouteWithTwoConnections.add(new Station("Невский проспект", line1()));
        actualRouteWithTwoConnections.add(new Station("Гостиный двор", line2()));
        actualRouteWithTwoConnections.add(new Station("Маяковская", line2()));
        actualRouteWithTwoConnections.add(new Station("Площадь Восстания", line3()));
        actualRouteWithTwoConnections.add(new Station("Чернышевская", line3()));
        assertEquals(routeWithTwoConnections(), actualRouteWithTwoConnections);
    }

    private Line line1() {
        Line line = new Line(1, "1");
        line.addStation(new Station("Горьковская", line));
        line.addStation(new Station("Невский проспект", line));
        return line;
    }

    private Line line2() {
        Line line = new Line(2, "2");
        line.addStation(new Station("Гостиный двор", line));
        line.addStation(new Station("Маяковская", line));
        return line;
    }

    private Line line3() {
        Line line = new Line(3, "3");
        line.addStation(new Station("Площадь Восстания", line));
        line.addStation(new Station("Чернышевская", line));
        return line;
    }

    private List<Station> routeOnTheLine() {
        Station fromRouteOnTheLine = new Station("Горьковская", line1());
        Station toRouteOnTheLine = new Station("Невский проспект", line1());
        RouteCalculator calculator = new RouteCalculator(stationIndex);
        return calculator.getShortestRoute(fromRouteOnTheLine, toRouteOnTheLine);
    }

    private List<Station> routeWithOneConnections() {
        Station fromWithOneConnections = new Station("Горьковская", line1());
        Station toWithOneConnections = new Station("Маяковская", line2());
        RouteCalculator calculator = new RouteCalculator(stationIndex);
        return calculator.getShortestRoute(fromWithOneConnections, toWithOneConnections);
    }

    private List<Station> routeWithTwoConnections() {
        Station fromWithTwoConnections = new Station("Горьковская", line1());
        Station toWithTwoConnections = new Station("Чернышевская", line3());
        RouteCalculator calculator = new RouteCalculator(stationIndex);
        return calculator.getShortestRoute(fromWithTwoConnections, toWithTwoConnections);
    }
}
