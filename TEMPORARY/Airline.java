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
    public String toString() {
        String s = String.format("Рейс N %s%s to %s %s %s %s",
                this.destination,
                this.flightNumber,
                this.destination.getLongName(),
                this.dayOfWeek.getRusShort(),
                this.departure.toStringShort(),
                this.airliner);
        return s;
    }
}
