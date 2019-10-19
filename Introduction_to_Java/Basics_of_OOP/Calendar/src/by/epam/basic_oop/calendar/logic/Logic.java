package by.epam.basic_oop.calendar.logic;

import by.epam.basic_oop.calendar.enumerators.DayOfWeek;
import by.epam.basic_oop.calendar.enumerators.Month;
import by.epam.basic_oop.calendar.objects.Calendar;

public class Logic {

    public int getDayOfYear(boolean leapYear, Month month, int date){
        int dayOfYear = 0;
        int febDays = leapYear ? 29 : 28;

        if (isDateCorrect(leapYear, month, date)) {

            switch (month) {
                case JAN: {
                    dayOfYear = date;
                    break;
                }
                case FEB: {
                    dayOfYear = 31 + date;
                    break;
                }
                case MAR: {
                    dayOfYear = 31 + febDays + date;
                    break;
                }
                case APR: {
                    dayOfYear = 62 + febDays + date;
                    break;
                }
                case MAY: {
                    dayOfYear = 92 + febDays + date;
                    break;
                }
                case JUN: {
                    dayOfYear = 123 + febDays + date;
                    break;
                }
                case JUL: {
                    dayOfYear = 153 + febDays + date;
                    break;
                }
                case AUG: {
                    dayOfYear = 184 + febDays + date;
                    break;
                }
                case SEP: {
                    dayOfYear = 215 + febDays + date;
                    break;
                }
                case OCT: {
                    dayOfYear = 245 + febDays + date;
                    break;
                }
                case NOV: {
                    dayOfYear = 276 + febDays + date;
                    break;
                }
                case DES: {
                    dayOfYear = 306 + febDays + date;
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

    public boolean isDateCorrect(boolean leapYear, int dayOfYear){

        boolean res;
        int extraDay = leapYear ? 1 : 0;

        if (dayOfYear > 0 && dayOfYear <= 365 + extraDay){
            res = true;
        } else {
            res = false;
        }

        return res;
    }

    public Month month(boolean leapYear, int dayOfYear){

        Month month = null;
        int extraDay = leapYear ? 1 : 0;

        if (dayOfYear > 0) {
            if (dayOfYear <= 31){
                month = Month.JAN;
            } else if (dayOfYear > 31 && dayOfYear <= (59 + extraDay)) {
                month = Month.FEB;
            } else if (dayOfYear > (59 + extraDay) && dayOfYear <= (90 + extraDay)) {
                month = Month.MAR;
            } else if (dayOfYear > (90 + extraDay) && dayOfYear <= (120 + extraDay)) {
                month = Month.APR;
            } else if (dayOfYear > (120 + extraDay) && dayOfYear <= (151 + extraDay)) {
                month = Month.MAY;
            } else if (dayOfYear > (151 + extraDay) && dayOfYear <= (181 + extraDay)) {
                month = Month.JUN;
            } else if (dayOfYear > (181 + extraDay) && dayOfYear <= (212 + extraDay)) {
                month = Month.JUL;
            } else if (dayOfYear > (212 + extraDay) && dayOfYear <= (243 + extraDay)) {
                month = Month.AUG;
            } else if (dayOfYear > (243 + extraDay) && dayOfYear <= (273 + extraDay)) {
                month = Month.SEP;
            } else if (dayOfYear > (273 + extraDay) && dayOfYear <= (304 + extraDay)) {
                month = Month.OCT;
            } else if (dayOfYear > (304 + extraDay) && dayOfYear <= (334 + extraDay)) {
                month = Month.NOV;
            } else if (dayOfYear > (334 + extraDay) && dayOfYear <= (365 + extraDay)) {
                month = Month.DES;
            }
        }

        return month;
    }

    public int date(boolean leapYear, int dayOfYear){

        int day = 0;
        int extraDay = leapYear ? 1 : 0;

        if (dayOfYear > 0) {
            if (dayOfYear <= 31){
                day = dayOfYear;
            } else if (dayOfYear > 31 && dayOfYear <= (59 + extraDay)) {
                day = dayOfYear - 31;
            } else if (dayOfYear > (59 + extraDay) && dayOfYear <= (90 + extraDay)) {
                day = dayOfYear - 59 - extraDay;
            } else if (dayOfYear > (90 + extraDay) && dayOfYear <= (120 + extraDay)) {
                day = dayOfYear - 90 -extraDay;
            } else if (dayOfYear > (120 + extraDay) && dayOfYear <= (151 + extraDay)) {
                day = dayOfYear - 120 -extraDay;
            } else if (dayOfYear > (151 + extraDay) && dayOfYear <= (181 + extraDay)) {
                day = dayOfYear - 151 -extraDay;
            } else if (dayOfYear > (181 + extraDay) && dayOfYear <= (212 + extraDay)) {
                day = dayOfYear - 181 -extraDay;
            } else if (dayOfYear > (212 + extraDay) && dayOfYear <= (243 + extraDay)) {
                day = dayOfYear - 212 -extraDay;
            } else if (dayOfYear > (243 + extraDay) && dayOfYear <= (273 + extraDay)) {
                day = dayOfYear - 243 -extraDay;
            } else if (dayOfYear > (273 + extraDay) && dayOfYear <= (304 + extraDay)) {
                day = dayOfYear - 273 -extraDay;
            } else if (dayOfYear > (304 + extraDay) && dayOfYear <= (334 + extraDay)) {
                day = dayOfYear - 304 -extraDay;
            } else if (dayOfYear > (334 + extraDay) && dayOfYear <= (365 + extraDay)) {
                day = dayOfYear - 334 -extraDay;
            }
        }

        return  day;
    }

    public DayOfWeek dayOfWeek(Calendar calendar,int dayOfYear){
        DayOfWeek dW = null;
        int maxDays = calendar.isLeapYear() ? 366 : 365;

        if (dayOfYear > 0 && dayOfYear <= maxDays) {
            int nWD = (dayOfYear + calendar.getFirstDay().getDayNom() - 1) % 7;
            nWD = nWD == 0 ? 7 : nWD;
            dW = DayOfWeek.getDayByNumber(nWD);
        }

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
