package cl_obj.tour_offers;

import java.util.Objects;
import cl_obj.library.*;

/*
* класс представляет туристическое предложение
* int lastID                        последний примененный ID для тур предложения
* int id                            идентификационный номер путевки
* Type type                         тип туристического предложения
* Transportation transportation     тип транспорта
* int hotelStars                    звездность отеля
* Food food                         тип питания
* int days                          количество дней
* String name                       наименование тура
* */

public class Tour {
    private static int lastID;
    private int id;
    private Type type;
    private Transportation transportation;
    private int hotelStars;
    private Food food;
    private int days;
    private String name;

    public Tour(Type type, Transportation transportation, int hotelStars, Food food, int days, String name) {
        this.id = lastID++;
        this.type = type;
        this.transportation = transportation;
        this.hotelStars = hotelStars;
        this.food = food;
        this.days = days;
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public Transportation getTransportation() {
        return transportation;
    }

    public int getHotelStars() {
        return hotelStars;
    }

    public Food getFood() {
        return food;
    }

    public int getDays() {
        return days;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return hotelStars == tour.hotelStars &&
                days == tour.days &&
                type == tour.type &&
                transportation == tour.transportation &&
                food == tour.food;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, transportation, hotelStars, food, days);
    }

    @Override
    public String toString() {
        StringBuilder t = new StringBuilder("Путевка ID-");

        t.append(id);
        t.append(" " + name);

        return t.toString();
    }


}
