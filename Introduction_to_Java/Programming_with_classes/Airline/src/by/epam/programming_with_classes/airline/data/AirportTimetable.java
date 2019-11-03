package by.epam.programming_with_classes.airline.data;

import by.epam.programming_with_classes.airline.airline.Timetable;
import by.epam.programming_with_classes.airline.logic.Logic;

public class AirportTimetable {

    public Timetable readTimetable(){

        Logic logic = new Logic();
        Timetable timetable = new Timetable();

        String[] fields = read().split("\n");


        for (String f : fields){

            timetable.add(logic.parseToFlight(f));
        }

        return timetable;
    }

    public String read(){
        return  "3666, BOJ, MON, 06:00:00, B737300\n" +
                "3666, BOJ, WED, 06:00:00, B737300\n" +
                "3666, BOJ, FRI, 06:00:00, B737300\n" +
                "3666, BOJ, SUN, 06:00:00, B737300\n" +
                "3365, CDG, MON, 06:50:00, A320\n" +
                "3365, CDG, WED, 06:50:00, A320\n" +
                "3375, CDG, THU, 18:50:00, A320\n" +
                "3375, CDG, FRI, 18:50:00, A320\n" +
                "1254, LAX, MON, 07:30:00, B7767300\n" +
                "1254, LAX, THU, 07:30:00, B7767300\n" +
                "1888, LED, MON, 08:00:00, B737500\n" +
                "1888, LED, TUE, 08:00:00, B737500\n" +
                "1888, LED, WED, 08:00:00, B737500\n" +
                "1888, LED, THU, 08:00:00, B737500\n" +
                "1888, LED, FRI, 08:00:00, B737500\n" +
                "1888, LED, SAT, 08:00:00, B737500\n" +
                "1889, LED, MON, 20:00:00, B737500\n" +
                "1889, LED, TUE, 20:00:00, B737500\n" +
                "1889, LED, WED, 20:00:00, B737500\n" +
                "1889, LED, THU, 20:00:00, B737500\n" +
                "1889, LED, FRI, 20:00:00, B737500\n" +
                "1889, LED, SAT, 20:00:00, B737500\n" +
                "2277, SVO, MON, 10:00:00, B737800\n" +
                "2277, SVO, TUE, 10:00:00, B737800\n" +
                "2277, SVO, WED, 10:00:00, B737800\n" +
                "2277, SVO, THU, 10:00:00, B737800\n" +
                "2277, SVO, FRI, 10:00:00, B737800\n" +
                "2277, SVO, SAT, 10:00:00, B737800\n" +
                "2277, SVO, SUN, 10:00:00, B737800\n" +
                "2278, SVO, MON, 22:00:00, B737800\n" +
                "2278, SVO, TUE, 22:00:00, B737800\n" +
                "2278, SVO, WED, 22:00:00, B737800\n" +
                "2278, SVO, THU, 22:00:00, B737800\n" +
                "2278, SVO, FRI, 22:00:00, B737800\n" +
                "2278, SVO, SAT, 22:00:00, B737800\n" +
                "2278, SVO, SUN, 22:00:00, B737800\n" +
                "8877, JRB, MON, 11:00:00, B737800\n" +
                "8877, JRB, THU, 11:00:00, B737800\n" +
                "9977, JRB, TUE, 23:00:00, B737800\n" +
                "9977, JRB, FRI, 23:00:00, B737800\n" +
                "1177, VAR, TUE, 7:00:00, CRJ200\n" +
                "1177, VAR, THU, 7:00:00, CRJ200\n";
    }
}
