package by.epam.programming_with_classes.airline.airline;

import by.epam.programming_with_classes.airline.enumerators.Airliner;
import by.epam.programming_with_classes.airline.enumerators.CodeIATA;
import by.epam.programming_with_classes.airline.enumerators.DayOfWeek;

import java.util.Objects;

public class Flight {
    private int flightNumber;
    private CodeIATA destination;
    private DayOfWeek dayOfWeek;
    private Time departure;
    private Airliner airliner;

    public Flight(int flightNumber, CodeIATA destination, DayOfWeek dayOfWeek, Time departure, Airliner airliner) {
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
        if (!(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return flightNumber == flight.flightNumber &&
                destination == flight.destination &&
                dayOfWeek == flight.dayOfWeek &&
                Objects.equals(departure, flight.departure) &&
                airliner == flight.airliner;
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightNumber, destination, dayOfWeek, departure, airliner);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber=" + flightNumber +
                ", destination=" + destination +
                ", dayOfWeek=" + dayOfWeek +
                ", departure=" + departure +
                ", airliner=" + airliner +
                '}';
    }
}
