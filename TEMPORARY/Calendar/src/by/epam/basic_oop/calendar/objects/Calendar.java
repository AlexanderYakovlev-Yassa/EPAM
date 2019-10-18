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
    private class Holiday{

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

    public String getHoliday(int dayOfYear){

        Logic logic = new Logic();
        StringBuilder sb = new StringBuilder("");
        int maxDays = this.leapYear ? 366 : 365;

        if (dayOfYear > 0 && dayOfYear <= maxDays){

            for (Holiday h : holidays){

                if (h.getDayOfYear() == dayOfYear){

                    sb.append("\n" + h.getName());

                    if (h.isDayOff()) {

                        sb.append("\nвыходной");

                    } else if (h.isHalfHoliday()){

                        sb.append("\nсокращенный");
                    } else {

                        if (logic.dayOfWeek(this, dayOfYear) == DayOfWeek.SAT ||
                                logic.dayOfWeek(this, dayOfYear) == DayOfWeek.SUN ){

                            sb.append("\nвыходной");
                        } else {

                            sb.append("\nрабочий");
                        }
                    }
                }
            }
        }

        return sb.toString();
    }

    /*public boolean isDayOff(int dayOfYear){
        boolean res = false;

        for (Holiday h : holidays){

            if (h.getDayOfYear() == dayOfYear){

                if (h.isDayOff()) {

                    res = true;
                    break;

                } else if (h.isHalfHoliday()){

                    sb.append("\nсокращенный");
                } else {

                    if (logic.dayOfWeek(this, dayOfYear) == DayOfWeek.SAT ||
                            logic.dayOfWeek(this, dayOfYear) == DayOfWeek.SUN ){

                        sb.append("\nвыходной");
                    } else {

                        sb.append("\nрабочий");
                    }
                }
            }
        }

        return res;
    }

    public boolean isHalfHoliday(int dayOfYear){
        boolean res = false;


        return res;
    }
*/
    public String getHoliday(Month month, int date){

        Logic logic = new Logic();
        String res = "";

        if (logic.isDateCorrect(this.leapYear, month, date)){

            int dayOfYear = logic.getDayOfYear(this.leapYear, month, date);

            res = getHoliday(dayOfYear);
        }

        return res;
    }

    public void addHoliday(Month month, int date, String name, boolean dayOff, boolean halfHoliday){
        Logic logic = new Logic();

        if (logic.isDateCorrect(this.leapYear, month, date)) {

            int dayOfYear = logic.getDayOfYear(this.leapYear, month, date);

            Holiday holiday = new Holiday(dayOfYear, name);
            holiday.setDayOff(dayOff);
            holiday.setHalfHoliday(halfHoliday);

            this.holidays = Arrays.copyOf(this.holidays, this.holidays.length + 1);
            this.holidays[this.holidays.length - 1] = holiday;
        }
    }
}
