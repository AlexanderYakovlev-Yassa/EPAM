public class Time {
    private int value;

    public Time() {
        this.value = 0;
    }

    public Time(int value) {
        value = value < 0 ? 0 : value;
        this.value = value % 86400;
    }

    public void setHour(int hour){
        int[] time = separateTime(value);
        time[0] = (hour <= 24) && (hour > 0) ? hour : 0;
        value = collectTime(time);
    }

    public void setMinut(int hour){
        int sec = value % 60;
        value = (hour <= 24) && (hour > 0) ? value + hour * 3600 : sec;
    }

    public String showTime(){
        int[] sTime = separateTime(value);
        String time = String.format("%02d:%02d:%02d", sTime[0], sTime[1], sTime[2]);
        return time;
    }

    //returns int[3] array where [0] - hours, [1] - minutes, [2] - seconds
    private int[] separateTime(int value){
        int[] time = new int[3];
        time[0] = value / 3600;
        time[1] = (value - time[0] * 3600) / 60;
        time[2] = value - time[0] * 3600 - time[1] * 60;
        return  time;
    }

    private int collectTime(int[] separatedTime){
        int time = separatedTime[0]*3600 + separatedTime[1]*60 + separatedTime[2];
        time = time % 86400;
        return time;
    }

    public static void main(String[] args) {
        Time t = new Time(Integer.MAX_VALUE);
        System.out.println(t.showTime());
        t.setHour(15);
        System.out.println(t.showTime());
    }


}
