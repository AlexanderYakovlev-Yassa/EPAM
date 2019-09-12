public enum DayOfWeek {
    SUN("Sunday", "Воскресенье", "вс."),
    MON("Monday", "Понедельник", "пн."),
    TUE("Tuesday", "Вторник", "вт."),
    WED("Wednesday", "Среда", "ср."),
    THU("Thursday", "Четверг", "чт."),
    FRI("Friday", "Пятница", "пт."),
    SAT("Saturday", "Суббота", "сб.");
    private String angShort;
    private String angLong;
    private String rusShort;
    private String rusLong;

    DayOfWeek(String ang, String rus, String rusShort) {
        this.angLong = ang;
        this.angShort = ang.substring(0, 3);
        this.rusLong = rus;
        this.rusShort = rusShort;
    }

    public String getAngShort() {
        return angShort;
    }

    public String getAngLong() {
        return angLong;
    }

    public String getRusShort() {
        return rusShort;
    }

    public String getRusLong() {
        return rusLong;
    }

    @Override
    public String toString() {
        return angLong;
    }
}
