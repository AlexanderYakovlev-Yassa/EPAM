package by.epam.programming_with_classes.tour_agency.logic;

import by.epam.programming_with_classes.tour_agency.enumerators.MealType;
import by.epam.programming_with_classes.tour_agency.enumerators.TourType;
import by.epam.programming_with_classes.tour_agency.enumerators.Transportation;
import by.epam.programming_with_classes.tour_agency.objects.Tour;
import by.epam.programming_with_classes.tour_agency.objects.Tours;

public class Logic {

   public Tours selectToursByType(Tours tours, TourType type){

       if(tours == null){
           return  null;
       }

       Tours selection = new Tours();

       for(Tour t : tours) {
            if(t != null) {
                if(t.getType() == type){
                    selection.add(t);
                }
            }
       }

       return selection;
   }

    public Tours selectToursByMeal(Tours tours, MealType meal){

       if(tours == null){
           return null;
       }

       Tours selection = new Tours();

       for(Tour t : tours) {

           if(t != null) {
               if(t.getMeal() == meal){
                   selection.add(t);
               }
           }
       }
       return selection;
    }

    public Tours selectTourByTransportation(Tours tours, Transportation transportation){

       if(tours == null){
           return null;
       }

        Tours selection = new Tours();

       for(Tour t : tours){

           if(t != null) {
               if(t.getTransportation() == transportation){
                   selection.add(t);
               }
           }
       }
       return selection;
    }

    public Tours selectToursByHotelStars(Tours tours, int min, int max){

       if(tours == null){
           return  null;
       }

       Tours selection = new Tours();

       for (Tour t : tours){

           if (t.getHotelStars() >= min && t.getHotelStars() <= max){
               selection.add(t);
           }
       }
       return selection;
    }

    public Tours selectToursByDays(Tours tours, int min, int max){

        if(tours == null){
            return  null;
        }

        Tours selection = new Tours();

        for (Tour t : tours){

            if (t.getDays() >= min && t.getDays() <= max){
                selection.add(t);
            }
        }
        return selection;
    }

    public Tours selectToursByCost(Tours tours, int min, int max){

        if(tours == null){
            return  null;
        }

        Tours selection = new Tours();

        for (Tour t : tours){

            if (t.getCost() >= min && t.getCost() <= max){
                selection.add(t);
            }
        }
        return selection;
    }
}
