package by.epam.programming_with_classes.airline.enumerators;

public enum CodeIATA {
    BOJ("Bourgas, Болгария, Бургас", "Бургас"),
    CDG("Charles De Gaulle, Франция, Париж", "Париж"),
    JRB("Downtown Manhattan H/p, США, New York, NY", "НЬю-Йорк"),
    LAX("Los Angeles International, США, Los Angeles, Ca", "Лос Анджелес"),
    LED("Пулково, Россия, Санкт-Петербург", "Санкт-Петербург"),
    MSQ("Национальный аэропорт Минск, Беларусь, Минск", "Минск"),
    SVO("Шереметьево, Россия, Москва", "Москва"),
    VAR("Варна, Болгария, Варна", "Варна");

    private String longName;
    private String city;

    CodeIATA(String longName, String city){
        this.longName = longName;
        this.city = city;
    }

    public String getLongName() {
        return longName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
