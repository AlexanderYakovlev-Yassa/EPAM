package by.epam.programming_with_classes.airline.view;

import by.epam.programming_with_classes.airline.airline.Flight;
import by.epam.programming_with_classes.airline.airline.Timetable;

public class View {

    public String printTimetable(Timetable timetable) {

        StringBuilder sb = new StringBuilder();

        if (timetable != null && timetable.getFlights() != null) {

            for (Flight f : timetable.getFlights()) {
                sb.append(printFlight(f) + "\n");
            }
        } else {
            sb.append("there are no flights");
        }

        return sb.toString();
    }

    public String printFlight(Flight flight) {

        String s;

        if (flight != null) {
             s = String.format("Рейс N %s,  %-17s %-5s %s   %s",
                    flight.getFlightNumber(),
                    flight.getDestination().getCity(),
                    flight.getDayOfWeek().getRusShort(),
                    flight.getDeparture().toStringShort(),
                    flight.getAirliner().longName);
        } else {
            s = "empty flight";
        }
        return s;
    }
}
