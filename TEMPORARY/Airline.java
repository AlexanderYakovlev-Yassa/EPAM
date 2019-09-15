/*10. Создать класс Airline, спецификация которого приведена ниже.
Определить конструкторы, set- и get- методы и метод toString().
Создать второй класс, агрегирующий массив типа Airline,
с подходящими конструкторами и методами.
Задать критерии выбора данных и вывести эти данные на консоль.

Airline:
- пункт назначения,
- номер рейса,
- тип самолета,
- время вылета,
- дни недели.

Найти и вывести:
a) список рейсов для заданного пункта назначения;
b) список рейсов для заданного дня недели;
c) список рейсов для заданного дня недели, время вылета для которых больше заданного.
*/

import java.util.Objects;

public class Airline {
    private int flightNumber;
    private CodeIATA destination;
    private DayOfWeek dayOfWeek;
    private Time departure;
    private Airliner airliner;

    public Airline(int flightNumber, CodeIATA destination, DayOfWeek dayOfWeek, Time departure, Airliner airliner) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.dayOfWeek = dayOfWeek;
        this.departure = departure;
        this.airliner = airliner;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public CodeIATA getDestination() {
        return destination;
    }

    public void setDestination(CodeIATA destination) {
        this.destination = destination;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Time getDeparture() {
        return departure;
    }

    public void setDeparture(Time departure) {
        this.departure = departure;
    }

    public Airliner getAirliner() {
        return airliner;
    }

    public void setAirliner(Airliner airliner) {
        this.airliner = airliner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airline airline = (Airline) o;
        return flightNumber == airline.flightNumber &&
                destination == airline.destination &&
                dayOfWeek == airline.dayOfWeek &&
                Objects.equals(departure, airline.departure) &&
                airliner == airline.airliner;
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightNumber, destination, dayOfWeek, departure, airliner);
    }

    @Override
    public String toString() {
        String destination = this.destination != null ? this.destination.getCity() : "nd";
        String dayOfWeek = this.dayOfWeek != null ?  this.dayOfWeek.getRusShort() : "nd";
        String departure = this.departure != null ? this.departure.toStringShort() : "nd";
        String airliner = this.airliner != null ? this.airliner.longName : "nd";

        String s = String.format("Рейс N %s to %s %s %s %s",
                this.flightNumber,
                destination,
                dayOfWeek,
                departure,
                airliner);
        return s;
    }


}
