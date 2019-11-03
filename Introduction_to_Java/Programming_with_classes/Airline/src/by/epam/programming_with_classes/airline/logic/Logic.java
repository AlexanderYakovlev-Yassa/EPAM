package by.epam.programming_with_classes.airline.logic;

import by.epam.programming_with_classes.airline.airline.Flight;
import by.epam.programming_with_classes.airline.airline.Time;
import by.epam.programming_with_classes.airline.airline.Timetable;
import by.epam.programming_with_classes.airline.enumerators.Airliner;
import by.epam.programming_with_classes.airline.enumerators.CodeIATA;
import by.epam.programming_with_classes.airline.enumerators.DayOfWeek;

public class Logic {

    public int parseToFlightNumber(String string) {

        int flightNumber;

        try {
            flightNumber = Integer.parseInt(string);
        } catch (Exception e) {
            flightNumber = 0;
        }

        if (flightNumber < 0 || flightNumber > 9999) {
            flightNumber = 0;
        }

        return flightNumber;
    }

    public CodeIATA parseToCodeIATA(String string) {

        CodeIATA code = null;

        for (CodeIATA c : CodeIATA.values()) {
            if (c.name().equals(string)) {

                code = c;
                break;
            }
        }

        return code;
    }

    public DayOfWeek parseToDayOfWeek(String string) {

        DayOfWeek dayOfWeek = null;

        for (DayOfWeek w : DayOfWeek.values()) {
            if (w.name().equals(string)) {
                dayOfWeek = w;
                break;
            }
        }

        return dayOfWeek;
    }

    public Airliner parseToAirliner(String string) {

        Airliner airliner = null;

        for (Airliner a : Airliner.values()) {
            if (a.name().equals(string)) {
                airliner = a;
                break;
            }
        }

        return airliner;
    }

    public Flight parseToFlight(String string) {

        Flight flight = null;
        String[] field = string.split(", ");
        TimeLogic timeLogic = new TimeLogic();

        if (field.length >= 5 ) {
            int flightNumber = parseToFlightNumber(field[0]);
            CodeIATA code = parseToCodeIATA(field[1]);
            DayOfWeek dayOfWeek = parseToDayOfWeek(field[2]);
            Time time = timeLogic.parseToTime(field[3]);
            Airliner airliner = parseToAirliner(field[4]);

            if (flightNumber != 0 && code != null && dayOfWeek != null && time != null && airliner != null){
                flight = new Flight(flightNumber,code,dayOfWeek,time,airliner);
            }
        }

        return flight;
    }

    public Timetable flightsByDestination(Timetable timetable, CodeIATA destination){
        Timetable newTimetable = new Timetable();
        for (Flight flight : timetable.getFlights()) {
            if (flight.getDestination() == destination) {
                newTimetable.add(flight);
            }
        }

        return newTimetable;
    }

    public Timetable flightsByDayOfWeek(Timetable timetable, DayOfWeek day){
        Timetable newTimetable = new Timetable();
        for (Flight flight : timetable.getFlights()) {
            if (flight.getDayOfWeek() == day) {
                newTimetable.add(flight);
            }
        }

        return newTimetable;
    }

    public Timetable allByDayOfWeekAndAfterTime(Timetable timetable, DayOfWeek day, Time time){
        Timetable newTimetable = new Timetable();
        for (Flight flight : timetable.getFlights()) {
            if ((flight.getDayOfWeek() == day) && (time.compare(flight.getDeparture()) <= 0)) {
                newTimetable.add(flight);
            }
        }
        return newTimetable;
    }
}
