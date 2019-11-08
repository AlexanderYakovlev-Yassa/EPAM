package by.epam.programming_with_classes.tour_agency.View;

import by.epam.programming_with_classes.tour_agency.enumerators.TourType;
import by.epam.programming_with_classes.tour_agency.enumerators.Transportation;
import by.epam.programming_with_classes.tour_agency.objects.Tour;
import by.epam.programming_with_classes.tour_agency.objects.Tours;

public class View {

    public void printTour(Tour tour){

        StringBuilder stars = new StringBuilder();

        if (tour != null){
            //Tour(TourType type, Transportation transportation, int hotelStars, MealType meal, int days, String name)

            for (int i = 0; i < tour.getHotelStars(); i++) {
                stars.append("*");
            }
            System.out.println(String.format("%-10s %-6s %-5s %-8s %-3d-days, %8.2f р. \"%s\"",
                    tour.getType().name(),
                    tour.getTransportation().name(),
                    stars.toString(),
                    tour.getMeal().name(),
                    tour.getDays(),
                    tour.getCost(),
                    tour.getName()));
        } else {
            System.out.println("there is no tour");
        }
    }

    public void printTours(Tours tours){

        if (tours != null){

            for (Tour t : tours){
                printTour(t);
            }
        } else {
            System.out.println("there are no tours");
        }
    }
}
