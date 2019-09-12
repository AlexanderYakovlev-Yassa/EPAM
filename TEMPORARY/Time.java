import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Time {
    private int value;

    public Time() {
        this.value = 0;
    }

    public Time(int value) {
        value = value % 86400;
        this.value = value < 0 ? 86400 + value : value;
    }

    public Time(int hours, int minutes, int seconds) {
        this.setTime(hours, minutes, seconds);
    }

    public Time(String strTime) {
        setTime(strTime);
    }

    public void setTime(int hours, int minutes, int seconds) {
        this.setHours(hours);
        this.setMinutes(minutes);
        this.setSeconds(seconds);
    }

    public void setTime(String strTime) {
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

        }
        this.setHours(hours);
        this.setMinutes(minutes);
        this.setSeconds(seconds);
    }

    public void setHours(int hour) {
        int[] time = separateTime(value);
        time[0] = (hour <= 24) && (hour > 0) ? hour : 0;
        value = collectTime(time);
    }

    public void setMinutes(int minutes) {
        int[] time = separateTime(value);
        time[1] = (minutes < 60) && (minutes > 0) ? minutes : 0;
        value = collectTime(time);
    }

    public void setSeconds(int seconds) {
        int[] time = separateTime(value);
        time[2] = (seconds < 60) && (seconds > 0) ? seconds : 0;
        value = collectTime(time);
    }

    public void addHours(int hours) {
        int[] time = separateTime(value);
        time[0] += hours % 24;
        value = collectTime(time);
    }

    public void addMinutes(int minutes) {
        int[] time = separateTime(value);
        time[1] += minutes % 1440;
        value = collectTime(time);
    }

    public void addSeconds(int seconds) {
        int[] time = separateTime(value);
        time[2] += seconds % 86400;
        value = collectTime(time);
    }

    public String toString() {
        int[] sTime = separateTime(value);
        String time = String.format("%02d:%02d:%02d", sTime[0], sTime[1], sTime[2]);
        return time;
    }

    public String toStringShort() {
        int[] sTime = separateTime(value);
        String time = String.format("%02d:%02d", sTime[0], sTime[1]);
        return time;
    }


    //returns int[3] array where [0] - hours, [1] - minutes, [2] - seconds
    private int[] separateTime(int value) {
        int[] time = new int[3];
        time[0] = value / 3600;
        time[1] = value % 3600 / 60;
        time[2] = value % 60;
        return time;
    }

    private int collectTime(int[] separatedTime) {
        int time = separatedTime[0] * 3600 + separatedTime[1] * 60 + separatedTime[2];
        time = time % 86400;
        time = time < 0 ? 86400 + time : time;
        return time;
    }

    public int compare(Time time) {
        int res;
        if (this.value > time.value) {
            res = 1;
        } else if (this.value < time.value) {
            res = -1;
        } else {
            res = 0;
        }
        return res;
    }

    public static void main(String[] args) {
        Time t = new Time();
        System.out.println(t.toString());
        t.addHours(-5);
        System.out.println(t.toString());
        Time t1 = new Time("12:58:57");
        Time t2 = new Time("00:00:00");
        System.out.println(t1.toString() + "\n" + t2.toString() + "\n" + t1.compare(t2));
        t.setTime("12:15:52");
        System.out.println(t.toString());
    }


}