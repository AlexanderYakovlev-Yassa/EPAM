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

        if (logic.isDateCorrect(calendar.isLeapYear(), month, date)) {

            info.append(month.getRusName() + " ");
            info.append(date + " ");
            info.append(logic.dayOfWeek(calendar, dayOfYear).getRusName());

            if (calendar.isHoliday(dayOfYear)) {
                info.append("\n" + calendar.getHolidayName(dayOfYear));
                if (calendar.isDayOff(dayOfYear)) {
                    info.append("\nвыходной день");
                } else if (calendar.isHalfHoliday(dayOfYear)) {
                    info.append("\nсокращенный рабочий день");
                } else {
                    info.append("\nрабочий день");
                }
            } else {
                if (calendar.isDayOff(dayOfYear)) {
                    info.append("\nвыходной день");
                } else {
                    info.append("\nрабочий день");
                }
            }
        } else {
            info.append("день введен некорректно");
        }
        info.append("\n");

        return info.toString();
    }

    public String allHolidays(Calendar calendar){

        StringBuilder sb = new StringBuilder();
        boolean leapYear = calendar.isLeapYear();
        Logic logic = new Logic();

        for (int dayOfYear = 1; dayOfYear <= 366; dayOfYear++){

            if (calendar.isHoliday(dayOfYear)){
                sb.append(logic.month(leapYear, dayOfYear).getRusName() + " ");
                sb.append(logic.date(leapYear, dayOfYear) + " - ");
                sb.append(calendar.getHolidayName(dayOfYear) + "\n");
            }
        }

        return sb.toString();
    }
}
