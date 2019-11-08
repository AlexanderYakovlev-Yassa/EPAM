package by.epam.programming_with_classes.tour_agency.logic;

import by.epam.programming_with_classes.tour_agency.enumerators.SortCriteria;
import by.epam.programming_with_classes.tour_agency.objects.Tour;

import java.util.Comparator;

public class TourComparator implements Comparator<Tour> {

    private SortCriteria criteria;

    public TourComparator(SortCriteria criteria) {
        this.criteria = criteria;
    }

    public final void setCriteria(SortCriteria criteria) {
        if (criteria == null) {
            throw new IllegalArgumentException();
        }
        this.criteria = criteria;
    }
    public SortCriteria getSortingIndex() {
        return criteria;
    }

    @Override
    public int compare(Tour tour_1, Tour tour_2) {

        switch (criteria){
            case TRANSPORTATION:{
                return tour_1.getTransportation().getCompareCriteria() - tour_2.getTransportation().getCompareCriteria();
            }
            case DAYS:{
                return tour_1.getDays() - tour_2.getDays();
            }
            case HOTEL:{

                return tour_1.getHotelStars() - tour_2.getHotelStars();
            }
            case TOUR:{
                return tour_1.getType().getRusName().compareTo(tour_2.getType().getRusName());
            }
            case MEAL:{
                return tour_1.getMeal().getCompareCriteria() - tour_2.getMeal().getCompareCriteria();
            }
            case COST:{
                return (int)(tour_1.getCost() * 100 - tour_2.getCost() * 100);
            }
            default:{
                throw new EnumConstantNotPresentException(SortCriteria.class, criteria.name());
            }
        }
    }
}
