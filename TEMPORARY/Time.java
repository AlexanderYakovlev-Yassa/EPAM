import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Time {
    private int value;

    public Time() {
        this.value = 0;
    }

    public Time(int value) {
        value = value < 0 ? 0 : value;
        this.value = value % 86400;
    }

    /*public Time(String strTime) {
        Pattern p = Pattern.compile("((^[\\d]{2})[:]([\\d]{2})[:]([\\d]{2}$))");
        Matcher m = p.matcher(strTime);
        int[] time = new int[3];
        time[0] = Integer.valueOf(m.group(1));
        time[1] = Integer.valueOf(m.group(2));
        time[2] = Integer.valueOf(m.group(3));
        value = collectTime(time);
    }*/

    public void setHours(int hour) {
        int[] time = separateTime(value);
        time[0] = (hour <= 24) && (hour > 0) ? hour : 0;
        value = collectTime(time);
    }

    public void setMinuts(int minutes) {
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
        time[0] += minutes/60;
        time[1] += minutes % 60;
        value = collectTime(time);
    }

    public void addSeconds(int seconds) {
        int[] time = separateTime(value);
        time[1] += seconds/60;
        time[2] += seconds % 60;
        value = collectTime(time);
    }

    public String showTime() {
        int[] sTime = separateTime(value);
        String time = String.format("%02d:%02d:%02d", sTime[0], sTime[1], sTime[2]);
        return time;
    }

    //returns int[3] array where [0] - hours, [1] - minutes, [2] - seconds
    private int[] separateTime(int value) {
        int[] time = new int[3];
        time[0] = value / 3600;
        time[1] = (value - time[0] * 3600) / 60;
        time[2] = value - time[0] * 3600 - time[1] * 60;
        return time;
    }

    private int collectTime(int[] separatedTime) {
        separatedTime[0] = (separatedTime[0] % 24 + (separatedTime[1] / 60) + (separatedTime[2] / 3600)) % 24;
        separatedTime[1] = (separatedTime[1] % 60 + (separatedTime[2] / 60)) % 60;
        separatedTime[2] = separatedTime[2] % 60;
        int time = (separatedTime[0] % 24) * 3600 + (separatedTime[1] % 60) * 60 + separatedTime[2];
        time = time % 86400;
        time = time < 0 ? 86400 + time : time;
        return time;
    }

    public static void main(String[] args) {
        Time t = new Time();
        System.out.println(t.showTime());
        t.setHours(1);
        System.out.println(t.showTime());
        t.setMinuts(55);
        System.out.println(t.showTime());
        t.setSeconds(58);
        System.out.println(t.showTime());
        t.addHours(2);
        System.out.println(t.showTime());
        t.addMinutes(5);
        System.out.println(t.showTime());
        t.addSeconds(-59);
        System.out.println(t.showTime());
        //Time tt = new Time("12:54:03");
        //System.out.println(tt.showTime());
    }


}
