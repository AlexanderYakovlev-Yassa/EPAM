package by.epam.programming_with_classes.airline.main;

import by.epam.programming_with_classes.airline.airline.Timetable;
import by.epam.programming_with_classes.airline.data.AirportTimetable;
import by.epam.programming_with_classes.airline.enumerators.Airliner;
import by.epam.programming_with_classes.airline.enumerators.CodeIATA;
import by.epam.programming_with_classes.airline.enumerators.DayOfWeek;
import by.epam.programming_with_classes.airline.airline.Time;
import by.epam.programming_with_classes.airline.logic.Logic;
import by.epam.programming_with_classes.airline.view.View;

public class Demo {

    public static void main(String[] args) {

        AirportTimetable airportTimetable = new AirportTimetable();
        Timetable timetable = airportTimetable.readTimetable();

        Logic logic = new Logic();
        View view = new View();

        System.out.println("\nAll the flights:\n");
        System.out.println(view.printTimetable(timetable));

        System.out.println("\nAll the flights to st.Petersburg:\n");
        System.out.println(view.printTimetable(logic.flightsByDestination(timetable, CodeIATA.LED)));

        System.out.println("\nAll the flights for Friday:\n");
        System.out.println(view.printTimetable(logic.flightsByDayOfWeek(timetable, DayOfWeek.FRI)));

        System.out.println("\nAll the flights for Friday and later than 10:00 :\n");
        System.out.println(view.printTimetable(logic.allByDayOfWeekAndAfterTime(timetable, DayOfWeek.FRI,
                new Time(10, 00, 00))));
    }
}
