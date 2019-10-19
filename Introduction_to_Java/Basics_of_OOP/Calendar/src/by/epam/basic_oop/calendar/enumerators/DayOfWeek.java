package by.epam.basic_oop.calendar.enumerators;

public enum DayOfWeek {
    MON(1, "Понедельник"),
    TUE(2, "Вторник"),
    WED(3, "Среда"),
    THU(4, "Четверг"),
    FRY(5, "Пятница"),
    SAT(6, "Суббота"),
    SUN(7, "Воскресенье");

    private int dayNom;
    private String rusName;

    DayOfWeek(int dayNom, String rusName) {
        this.dayNom = dayNom;
        this.rusName = rusName;
    }

    public int getDayNom() {
        return dayNom;
    }

    public String getRusName() {
        return rusName;
    }

    public static DayOfWeek getDayByNumber(int num) {
        DayOfWeek dw = null;

        num -= 1;
        if (num >= 0) {
            num = num % 7;
        } else {
            num = 7 + num % 7;
        }

        num += 1;

        for (DayOfWeek d : DayOfWeek.values()) {
            if (d.getDayNom() == num) {
                dw = d;
                break;
            }
        }

        return dw;
    }
}
