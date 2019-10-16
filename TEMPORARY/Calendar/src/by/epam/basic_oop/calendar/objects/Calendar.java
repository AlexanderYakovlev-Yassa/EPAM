package by.epam.basic_oop.calendar.objects;

import by.epam.basic_oop.calendar.enumerators.DayOfWeek;
import by.epam.basic_oop.calendar.enumerators.Month;

public class Calendar {

    private String name;
    private DayOfWeek firstDay;
    private boolean leapYear;
    private Holiday[] holidays;

    //***********************************  inner HOLIDAY  ************************************
    private class Holiday{

        private Month month;
        private int day;
        private String name;
        private boolean isDayOff;
        private boolean isHalfHoliday;

    }
    //****************************************************************************************


    public Calendar(String name, DayOfWeek firstDay, boolean leapYear) {
        this.name = name;
        this.firstDay = firstDay;
        this.leapYear = leapYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DayOfWeek getFirstDay() {
        return firstDay;
    }

    public void setFirstDay(DayOfWeek firstDay) {
        this.firstDay = firstDay;
    }

    public boolean isLeapYear() {
        return leapYear;
    }

    public void setLeapYear(boolean leapYear) {
        this.leapYear = leapYear;
    }
}
