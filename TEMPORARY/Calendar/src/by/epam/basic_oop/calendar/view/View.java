package by.epam.basic_oop.calendar.view;

import by.epam.basic_oop.calendar.enumerators.DayOfWeek;
import by.epam.basic_oop.calendar.enumerators.Month;
import by.epam.basic_oop.calendar.logic.Logic;
import by.epam.basic_oop.calendar.objects.Calendar;

public class View {

    public String dayInfo(Calendar calendar, Month month, int date){

        StringBuilder info = new StringBuilder();
        Logic logic = new Logic();
        int dayOfYear = logic.getDayOfYear(calendar.isLeapYear(), month, date);
        System.out.println(DayOfWeek.getDayByNumber(dayOfYear));

        info.append(month.getRusName() + " ");
        info.append(date + " ");
        info.append(DayOfWeek.getDayByNumber(dayOfYear).getRusName());

        info.append(calendar.getHoliday(month, date));

        return info.toString();
    }

    public String allHolidays(Calendar calendar){

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 366; i++){

        }

        return sb.toString();
    }


}
