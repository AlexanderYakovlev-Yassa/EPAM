package by.epam.programming_with_classes.tour_agency.objects;

import by.epam.programming_with_classes.tour_agency.enumerators.MealType;
import by.epam.programming_with_classes.tour_agency.enumerators.TourType;
import by.epam.programming_with_classes.tour_agency.enumerators.Transportation;

import java.util.Objects;

public class Tour {
    private TourType type;
    private Transportation transportation;
    private int hotelStars;
    private MealType meal;
    private int days;
    private String name;
    private float cost;

    public Tour(TourType type, Transportation transportation, int hotelStars, MealType meal, int days, String name, float cost) {
        this.type = type;
        this.transportation = transportation;
        this.hotelStars = hotelStars;
        this.meal = meal;
        this.days = days;
        this.name = name;
        this.cost = cost;
    }

    public TourType getType() {
        return type;
    }

    public void setType(TourType type) {
        this.type = type;
    }

    public Transportation getTransportation() {
        return transportation;
    }

    public void setTransportation(Transportation transportation) {
        this.transportation = transportation;
    }

    public int getHotelStars() {
        return hotelStars;
    }

    public void setHotelStars(int hotelStars) {
        this.hotelStars = hotelStars;
    }

    public MealType getMeal() {
        return meal;
    }

    public void setMeal(MealType meal) {
        this.meal = meal;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tour)) return false;
        Tour tour = (Tour) o;
        return hotelStars == tour.hotelStars &&
                days == tour.days &&
                type == tour.type &&
                transportation == tour.transportation &&
                meal == tour.meal &&
                Objects.equals(name, tour.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, transportation, hotelStars, meal, days, name);
    }
}
