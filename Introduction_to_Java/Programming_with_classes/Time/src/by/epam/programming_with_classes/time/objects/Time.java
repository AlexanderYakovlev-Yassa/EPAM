package by.epam.programming_with_classes.time.objects;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public Time(int second) {
        this.hour = (second / 3600) % 24;
        this.minute = (second / 60) % 60;
        this.second = second % 60;
    }

    public Time() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = (hour > 0 && hour < 24) ? hour : 0;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = (minute > 0 && minute < 60) ? minute : 0;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = (second > 0 && second < 60) ? second : 0;
    }


}