package by.epam.programming_with_classes.airline.logic;

import by.epam.programming_with_classes.airline.airline.Time;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeLogic {

    public void addHour(Time time, int hour){
        hour += time.getHour();

        time.setHour(hour % 24);
    }

    public void addMinute(Time time, int minute) {
        minute += time.getMinute();
        int hour = minute / 60;
        addHour(time, hour);

        time.setMinute(minute % 60);
    }

    public void addSecond(Time time, int second) {
        second += time.getSecond();
        int minute = second / 60;
        addMinute(time, minute);

        time.setSecond(second % 60);
    }

    public int totalSeconds(Time time){
        return time.getHour() * 3600 + time.getMinute() * 60 + time.getSecond();
    }

    public Time parseToTime(String strTime) {
        Pattern p = Pattern.compile("^(\\d\\d?):(\\d\\d?):(\\d\\d?)$");
        Matcher m = p.matcher(strTime);
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        if (m.find()) {
            hours = Integer.valueOf(m.group(1));
            minutes = Integer.valueOf(m.group(2));
            seconds = Integer.valueOf(m.group(3));
        } else {
            throw new IllegalArgumentException();
        }

        return new Time(hours, minutes, seconds);
    }
}
