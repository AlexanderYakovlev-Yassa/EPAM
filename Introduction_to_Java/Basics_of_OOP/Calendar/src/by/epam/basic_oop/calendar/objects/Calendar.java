package by.epam.basic_oop.calendar.objects;

import by.epam.basic_oop.calendar.enumerators.DayOfWeek;
import by.epam.basic_oop.calendar.enumerators.Month;
import by.epam.basic_oop.calendar.logic.Logic;

import java.util.Arrays;

public class Calendar {

    private String name;
    private DayOfWeek firstDay;
    private boolean leapYear;
    private Holiday[] holidays;

    //***********************************  inner HOLIDAY  ************************************
    private class Holiday {

        private int dayOfYear;
        private String name;
        private boolean dayOff; //выходной день
        private boolean halfHoliday; //сокращенный день

        public Holiday(int dayOfYear, String name) {
            this.dayOfYear = dayOfYear;
            this.name = name;
            this.dayOff = false;
            this.halfHoliday = false;
        }

        public int getDayOfYear() {
            return dayOfYear;
        }

        public void setDayOfYear(int dayOfYear) {
            this.dayOfYear = dayOfYear;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isDayOff() {
            return dayOff;
        }

        public void setDayOff(boolean dayOff) {
            if (dayOff) {
                this.dayOff = dayOff;
                this.halfHoliday = false;
            }
        }

        public boolean isHalfHoliday() {
            return halfHoliday;
        }

        public void setHalfHoliday(boolean halfHoliday) {
            if (halfHoliday) {
                this.halfHoliday = halfHoliday;
                this.dayOff = false;
            }
        }
    }
    //****************************************************************************************


    public Calendar(String name, DayOfWeek firstDay, boolean leapYear) {
        this.name = name;
        this.firstDay = firstDay;
        this.leapYear = leapYear;
        this.holidays = new Holiday[0];
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

    public boolean isHoliday(int dayOfYear) {

        Holiday holiday = findHoliday(dayOfYear);

        return holiday != null;
    }

    public String getHolidayName(int dayOfYear) {

        Holiday holiday = findHoliday(dayOfYear);
        String name = holiday != null ? holiday.getName() : "";

        return name;
    }

    public boolean isDayOff(int dayOfYear) {

        boolean res = false;
        Logic logic = new Logic();
        DayOfWeek dayOfWeek = logic.dayOfWeek(this, dayOfYear);

        Holiday holiday = findHoliday(dayOfYear);

        if (holiday != null) {

            res = holiday.isDayOff();

        } else {

            if (dayOfWeek == DayOfWeek.SUN || dayOfWeek == DayOfWeek.SAT) {
                res = true;
            }
        }

        return res;
    }

    public boolean isHalfHoliday(int dayOfYear) {

        Holiday holiday = findHoliday(dayOfYear);
        boolean res = holiday != null ? holiday.isHalfHoliday() : false;

        return res;
    }

    public boolean addHoliday(Month month, int date, String name, boolean dayOff, boolean halfHoliday) {
        Logic logic = new Logic();
        boolean res = false;

        if (logic.isDateCorrect(this.leapYear, month, date)) {

            int dayOfYear = logic.getDayOfYear(this.leapYear, month, date);

            if (findHoliday(dayOfYear) == null) {

                Holiday holiday = new Holiday(dayOfYear, name);
                holiday.setDayOff(dayOff);
                holiday.setHalfHoliday(halfHoliday);

                this.holidays = Arrays.copyOf(this.holidays, this.holidays.length + 1);
                this.holidays[this.holidays.length - 1] = holiday;

                res = true;
            }
        }

        return res;
    }

    private Holiday findHoliday(int dayOfYear) {

        Holiday holiday = null;
        Logic logic = new Logic();

        if (logic.isDateCorrect(this.isLeapYear(), dayOfYear)) {
            for (Holiday h : holidays) {
                if (h.dayOfYear == dayOfYear) {
                    holiday = h;
                    break;
                }
            }
        }

        return holiday;
    }
}
