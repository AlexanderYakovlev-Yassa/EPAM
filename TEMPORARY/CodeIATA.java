public enum CodeIATA {
    BOJ("Bourgas, Болгария, Бургас"),
    CDG("Charles De Gaulle, Франция, Париж"),
    JRB("Downtown Manhattan H/p, США, New York, NY"),
    LAX("Los Angeles International, США, Los Angeles, Ca"),
    LED("Пулково, Россия, Санкт-Петербург"),
    MSQ("Национальный аэропорт Минск, Беларусь, Минск"),
    SVO("Шереметьево, Россия, Москва"),
    VAR("Варна, Болгария, Варна");

    private String longName;

    CodeIATA(String code){
        this.longName = code;
    }

    public String getLongName() {
        return longName;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
