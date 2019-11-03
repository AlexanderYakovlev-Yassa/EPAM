package by.epam.programming_with_classes.airline.airline;

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

    public int compare(Time time) {

        int res = -1;

        if (this.hour > time.hour) {
            res = 1;
        } else if (this.hour == time.hour) {

            if (this.minute > time.minute) {
                res = 1;
            } else if (this.minute == time.minute){
                if (this.second > time.second) {
                    res = 1;
                } else if (this.second == time.second){
                    res = 0;
                }
            }
        }

        return  res;
    }

    public String toStringShort(){
        return String.format("%02d:%02d", this.getHour(), this.getMinute());
    }
}