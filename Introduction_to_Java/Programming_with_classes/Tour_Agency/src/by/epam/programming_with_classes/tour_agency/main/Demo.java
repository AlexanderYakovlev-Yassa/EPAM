package by.epam.programming_with_classes.tour_agency.main;

import by.epam.programming_with_classes.tour_agency.View.View;
import by.epam.programming_with_classes.tour_agency.data.Data;
import by.epam.programming_with_classes.tour_agency.enumerators.MealType;
import by.epam.programming_with_classes.tour_agency.enumerators.SortCriteria;
import by.epam.programming_with_classes.tour_agency.enumerators.TourType;
import by.epam.programming_with_classes.tour_agency.logic.Logic;
import by.epam.programming_with_classes.tour_agency.logic.TourComparator;
import by.epam.programming_with_classes.tour_agency.objects.Tours;

public class Demo {

    public static void main(String[] args) {

        View view = new View();
        Logic logic = new Logic();
        Data data = new Data();

        Tours tours = new Tours();

        System.out.println("\nAll the tours sorted by prise:\n");
        tours = data.readTours();
        tours.sort(new TourComparator(SortCriteria.COST));
        view.printTours(tours);

        System.out.println("\nAll treatment tours sorted by days:\n");
        tours.sort(new TourComparator(SortCriteria.DAYS ));
        view.printTours(logic.selectToursByType(tours, TourType.TREATMENT));

        System.out.println("\nAll tours which have meal type \"bed & breakfast\" sorted by days:\n");
        tours.sort(new TourComparator(SortCriteria.HOTEL ));
        view.printTours(logic.selectToursByMeal(tours, MealType.BB));

        System.out.println("\nAll tours from 10 to 14 days sorted by prise:\n");
        tours.sort(new TourComparator(SortCriteria.COST ));
        view.printTours(logic.selectToursByDays(tours, 10, 14));
    }
}
