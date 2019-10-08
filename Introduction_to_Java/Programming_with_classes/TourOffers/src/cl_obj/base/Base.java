package cl_obj.base;

import cl_obj.tour_offers.Tour;
import java.util.Arrays;

public class Base {
    private Tour[] tours;

    public Base() {
        this.tours = new Tour[0];
    }

    public Tour[] getTours() {
        return tours;
    }

    public void addTour(Tour tour) {
        Tour[] newTours = Arrays.copyOf(this.tours, this.tours.length + 1);
        newTours[newTours.length - 1] = tour;
        tours = newTours;
    }
}
