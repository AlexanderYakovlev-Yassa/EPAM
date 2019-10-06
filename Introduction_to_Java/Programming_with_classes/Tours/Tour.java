import java.util.Objects;

public class Tour {
    private int id;
    private Type type;
    private Transportation transportation;
    private int hotelStars;
    private Food food;
    private int days;
    private String name;
    private static int lastID;

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

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
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
        t.append(" " + name + ":\n");
        t.append("\t" + type.rusName + "\n");
        t.append("\t" + transportation.rusName + "\n");
        t.append("\tотель ");
        for (int i = 0; i < hotelStars; i++) {
            t.append("*");
        }
        t.append("\n\t" + food.rusName + "\n");
        t.append("\t" + days + " дней\n");

        return t.toString();
    }

    /*
    * возвращает строку содержащую поля объекта отфильтрованные
    * в соответствии с принятыми параметрами
    * true - поле выводится
    * false - поле не выводится
    * */
    public String toString(boolean bID, boolean bName, boolean bType, boolean bTransportation, boolean bHotel, boolean bFood, boolean bDays) {
        StringBuilder t = new StringBuilder();
        String nextStr;
        nextStr = bID ? ("Путевка ID-" + id) : "";
        t.append(nextStr);
        nextStr = bName ? (" " + name) : "";
        t.append(nextStr);
        nextStr = bType ? (" " + type.rusName) : "";
        t.append(nextStr);
        nextStr = bTransportation ? (" " + transportation.rusName) : "";
        t.append(nextStr);
        nextStr = bHotel ? (" отель ") : "";
        t.append(nextStr);
        if (bHotel) {
            if (hotelStars == 0){
                t.append("нет");
            } else {
                for (int i = 0; i < hotelStars; i++) {
                    t.append("*");
                }
            }
        }
        nextStr = bFood ? (" " + food.rusName) : "";
        t.append(nextStr);
        nextStr = bDays ? (" " + days + " дней") : "";
        t.append(nextStr);

        return t.toString();
    }
}
