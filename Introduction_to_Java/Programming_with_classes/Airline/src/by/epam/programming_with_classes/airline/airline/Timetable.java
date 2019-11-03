package by.epam.programming_with_classes.airline.airline;

import java.util.Arrays;

public class Timetable {
    Flight[] flights;

    public Timetable(Flight[] flights) {
        System.out.println("***" + flights.length);
        this.flights = flights;
    }

    public Timetable() {
        this.flights = new Flight[0];
    }

    public Flight[] getFlights() {
        return flights;
    }

    public Flight getFlight(int index) {
        return flights[index];
    }

    public void setFlights(Flight[] flights) {
        this.flights = flights;
    }

    public void setFlight(Flight flight, int index) {
        this.flights[index] = flight;
    }

    public void add(Flight flight){

        if (flight != null) {

            setFlights(Arrays.copyOf(getFlights(), getFlights().length + 1));
            setFlight(flight, getFlights().length - 1);
        }
    }
}
