package by.epam.basic_oop.calendar.logic;

import by.epam.basic_oop.calendar.enumerators.DayOfWeek;
import by.epam.basic_oop.calendar.enumerators.Month;
import by.epam.basic_oop.calendar.objects.Calendar;

public class Logic {

    public int getDayOfYear(boolean leapYear, Month month, int day){
        int dayOfYear = 0;
        int febDays = leapYear ? 29 : 28;

        if (isDateCorrect(leapYear, month, day)) {

            switch (month) {
                case JAN: {
                    dayOfYear += day;
                    break;
                }
                case FEB: {
                    dayOfYear = 31 + day;
                    break;
                }
                case MAR: {
                    dayOfYear = 31 + febDays + day;
                    break;
                }
                case APR: {
                    dayOfYear = 62 + febDays + day;
                    break;
                }
                case MAY: {
                    dayOfYear = 92 + febDays + day;
                    break;
                }
                case JUN: {
                    dayOfYear = 123 + febDays + day;
                    break;
                }
                case JUL: {
                    dayOfYear = 153 + febDays + day;
                    break;
                }
                case AUG: {
                    dayOfYear = 184 + febDays + day;
                    break;
                }
                case SEP: {
                    dayOfYear = 215 + febDays + day;
                    break;
                }
                case OCT: {
                    dayOfYear = 245 + febDays + day;
                    break;
                }
                case NOV: {
                    dayOfYear = 276 + febDays + day;
                    break;
                }
                case DES: {
                    dayOfYear = 306 + febDays + day;
                    break;
                }
            }
        }
        return dayOfYear;
    }

    public boolean isDateCorrect(boolean leapYear, Month month, int day){

        boolean res = false;
        int febDays = leapYear ? 29 : 28;

        switch (month) {
            case JAN:
            case MAR:
            case MAY:
            case JUL:
            case AUG:
            case OCT:
            case DES:{
                res = (day > 0 && day <= 31);
                break;
            }
            case FEB: {
                res = (day > 0 && day <= febDays);
                break;
            }
            case APR:
            case JUN:
            case SEP:
            case NOV:{
                res = (day > 0 && day <= 30);
                break;
            }


        }
        return res;
    }

    public DayOfWeek dayOfWeek(Calendar calendar,int dayOfYear){
        DayOfWeek dW;
        int maxDays = calendar.isLeapYear() ? 366 : 365;

        int nWD = (dayOfYear + calendar.getFirstDay().getDayNom() - 1)%7;
        dW = DayOfWeek.getDayByNumber(nWD);

        return dW;
    }

    public DayOfWeek dayOfWeek(Calendar calendar, Month month, int day){

        DayOfWeek dW = null;

        if (isDateCorrect(calendar.isLeapYear(),month,day)) {
            int dayOfYear = getDayOfYear(calendar.isLeapYear(), month, day);
            dW = dayOfWeek(calendar, dayOfYear);
        }

        return dW;
    }
}
