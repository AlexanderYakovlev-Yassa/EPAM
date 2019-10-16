package by.epam.basic_oop.calendar.runner;

import by.epam.basic_oop.calendar.enumerators.DayOfWeek;
import by.epam.basic_oop.calendar.enumerators.Month;
import by.epam.basic_oop.calendar.logic.Logic;
import by.epam.basic_oop.calendar.objects.Calendar;

public class Runner {

    public static void main(String[] args) {

        Calendar c2020 = new Calendar("Производственный календарь РБ на 2020 г.",
        DayOfWeek.WED, true);

        Logic l = new Logic();
        System.out.println(l.getDayOfYear(true, Month.DES, 1));
    }


}
