package by.epam.basic_oop.calendar.main;

import by.epam.basic_oop.calendar.enumerators.DayOfWeek;
import by.epam.basic_oop.calendar.enumerators.Month;
import by.epam.basic_oop.calendar.logic.Logic;
import by.epam.basic_oop.calendar.objects.Calendar;
import by.epam.basic_oop.calendar.view.View;

public class Main {

    public static void main(String[] args) {

        Calendar c2019 = new Calendar("Производственный календарь РБ на 2019 г.",
        DayOfWeek.TUE, false);

        Logic l = new Logic();
        System.out.println(l.getDayOfYear(false, Month.DES, 31));

        View view = new View();

        System.out.println(view.dayInfo(c2019, Month.OCT, 19));

        c2019.addHoliday(Month.MAR, 8, "Международный женский день", true, false);

        System.out.println(view.dayInfo(c2019, Month.MAR, 8));
    }


}
