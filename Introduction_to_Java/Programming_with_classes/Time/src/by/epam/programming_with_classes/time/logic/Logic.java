package by.epam.programming_with_classes.time.logic;

import by.epam.programming_with_classes.time.objects.Time;

public class Logic {

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
}
