//5. Дано натуральное число Т, которое представляет длительность прошедшего времени в секундах.
// Вывести данное значение длительности в часах, минутах и секундах в следующей форме:
//ННч ММмин SSc.

public class Task_1_1_5 {

    public static void main(String[] args) {
        System.out.println(time(9587));

    }

    public static String time(int sec) {
        int hours = sec / 3600;
        int minutes = (sec - hours * 3600) / 60;
        int secundes = sec - hours * 3600 - minutes * 60;
        String timeStr = hours + "ч " + minutes + "мин " + secundes + "с.";
        return timeStr;
    }
}
