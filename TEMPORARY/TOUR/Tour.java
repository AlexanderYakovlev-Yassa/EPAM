import java.util.Objects;

public class Tour {
    private Type type;
    private Transportation transportation;
    private int hotelStars;
    private Meal meal;
    private int days;
    private String name;

    public Tour(Type type, Transportation transportation, int hotelStars, Meal meal, int days, String name) {
        this.type = type;
        this.transportation = transportation;
        this.hotelStars = hotelStars;
        this.meal = meal;
        this.days = days;
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
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

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
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
                meal == tour.meal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, transportation, hotelStars, meal, days);
    }
}
