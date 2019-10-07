package cl_obj.inquiry;

import cl_obj.base.Base;
import cl_obj.filters.ListFilter;
import cl_obj.library.Transportation;
import cl_obj.tour_offers.Tour;

import java.util.Arrays;

public class Inquiry{

    public Tour[] applyFilter(Base base, ListFilter filters){
        Tour[] selectedTours = new Tour[0];
        for (Tour t : base.getTours()){
            for (Transportation tr : filters.getTransportation()){
                if (t.getTransportation() == tr){

                    selectedTours = addTour(selectedTours, t);
                }
            }
        }
        return selectedTours;
    }

    private Tour[] addTour(Tour[] tours, Tour tour){
       boolean flag = true;
        Tour[] newTours = tours;
       for (Tour t : tours){
           if (t == tour) {
               flag = false;
               break;
           }
       }

       if (flag) {
           newTours = Arrays.copyOf(newTours, newTours.length + 1);
           newTours[newTours.length - 1] = tour;
       }
       return newTours;
    }
}
