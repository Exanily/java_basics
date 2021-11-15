import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

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

    public void testCalculateDuration() {
        Line line1 = new Line(1, "1");
        Line line2 = new Line(2, "2");
        Line line3 = new Line(3, "3");

        line1.addStation(new Station("Горьковская", line1));
        line1.addStation(new Station("Невский проспект", line1));

        line2.addStation(new Station("Гостиный двор", line2));
        line2.addStation(new Station("Маяковская", line2));

        line3.addStation(new Station("Площадь Восстания", line3));
        line3.addStation(new Station("Чернышевская", line3));

        Station fromRouteOnTheLine = new Station("Горьковская", line1);
        Station toRouteOnTheLine = new Station("Невский проспект", line1);

        Station fromWithOneConnections = new Station("Горьковская", line1);
        Station toWithOneConnections = new Station("Маяковская", line2);

        Station fromWithTwoConnections = new Station("Горьковская", line1);
        Station toWithTwoConnections = new Station("Чернышевская", line3);

        RouteCalculator calculator = new RouteCalculator(stationIndex);

        List<Station> routeOnTheLine = calculator.getShortestRoute(fromRouteOnTheLine, toRouteOnTheLine);
        List<Station> routeWithOneConnections = calculator.getShortestRoute(fromWithOneConnections, toWithOneConnections);
        List<Station> routeWithTwoConnections = calculator.getShortestRoute(fromWithTwoConnections, toWithTwoConnections);

        double actualTimeRouteOnTheLine = RouteCalculator.calculateDuration(routeOnTheLine);
        double expectedTimeRouteOnTheLine = 2.5;

        double actualTimeWithOneConnection = RouteCalculator.calculateDuration(routeWithOneConnections);
        double expectedTimeWithOneConnection = 8.5;

        double actualTimeWithTwoConnections = RouteCalculator.calculateDuration(routeWithTwoConnections);
        double expectedTimeWithTwoConnections = 14.5;

        assertEquals(expectedTimeRouteOnTheLine, actualTimeRouteOnTheLine);
        assertEquals(expectedTimeWithOneConnection, actualTimeWithOneConnection);
        assertEquals(expectedTimeWithTwoConnections,actualTimeWithTwoConnections);

        List<Station> actualRouteOnTheLine = new ArrayList<>();
        actualRouteOnTheLine.add(new Station("Горьковская", line1));
        actualRouteOnTheLine.add(new Station("Невский проспект", line1));

        List<Station> actualRouteWithOneConnection = new ArrayList<>();
        actualRouteWithOneConnection.add(new Station("Горьковская", line1));
        actualRouteWithOneConnection.add(new Station("Невский проспект", line1));
        actualRouteWithOneConnection.add(new Station("Гостиный двор", line2));
        actualRouteWithOneConnection.add(new Station("Маяковская", line2));

        List<Station> actualRouteWithTwoConnections = new ArrayList<>();
        actualRouteWithTwoConnections.add(new Station("Горьковская", line1));
        actualRouteWithTwoConnections.add(new Station("Невский проспект", line1));
        actualRouteWithTwoConnections.add(new Station("Гостиный двор", line2));
        actualRouteWithTwoConnections.add(new Station("Маяковская", line2));
        actualRouteWithTwoConnections.add(new Station("Площадь Восстания", line3));
        actualRouteWithTwoConnections.add(new Station("Чернышевская", line3));

        assertEquals(routeOnTheLine, actualRouteOnTheLine);
        assertEquals(routeWithOneConnections, actualRouteWithOneConnection);
        assertEquals(routeWithTwoConnections, actualRouteWithTwoConnections);
    }
}
