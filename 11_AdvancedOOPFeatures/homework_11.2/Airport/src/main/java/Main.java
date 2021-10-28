import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        return airport.getTerminals().stream().map(Terminal::getFlights).flatMap(Collection::stream).filter(flight -> {
            Calendar calendarFlight = new GregorianCalendar();
            Calendar calendar = new GregorianCalendar();
            calendarFlight.setTime(flight.getDate());
            Date date = new Date();
            calendar.setTime(date);
            long milliseconds = flight.getDate().getTime() - date.getTime();
            double hours = (double) milliseconds / (60 * 60 * 1000);
            boolean time = hours <= 2 && hours >= 0;
            return time && flight.getType() == Flight.Type.DEPARTURE;
        }).collect(Collectors.toList());
    }

}