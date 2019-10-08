package cl_obj.selection;

import cl_obj.base.Base;
import cl_obj.filters.ListFilter;
import cl_obj.library.Food;
import cl_obj.library.Transportation;
import cl_obj.library.Type;
import cl_obj.tour_offers.Tour;

import java.util.Arrays;

public class Selection {

    /*
    * возвращает список тур предложений отфильтрованных
    * в соответствии с фильтром filters
    * */
    public Tour[] applyFilter(Base base, ListFilter filters) {
        Tour[] selectedTours = new Tour[0];

        for (Tour t : base.getTours()) {
            if (isTransportation(t, filters) &&
                    isDays(t, filters) &&
                    isFood(t, filters) &&
                    isHotelStars(t, filters) &&
                    isType(t, filters)) {
                selectedTours = addTour(selectedTours, t);
            }
        }
        return selectedTours;
    }

    /*
     * проверяет соответствует ли поле турпредложения transportation фильтру
     * */
    private boolean isTransportation(Tour tour, ListFilter filter) {
        boolean res = false;
        if (filter.getTransportation().length == 0) {
            res = true;
        } else {
            for (Transportation tr : filter.getTransportation()) {
                if (tour.getTransportation() == tr) {
                    res = true;
                    break;
                }
            }
        }
        return res;
    }

    /*
     * проверяет соответствует ли поле турпредложения food фильтру
     * */
    private boolean isFood(Tour tour, ListFilter filter) {
        boolean res = false;
        if (filter.getFoods().length == 0) {
            res = true;
        } else {
            for (Food f : filter.getFoods()) {
                if (tour.getFood() == f) {
                    res = true;
                    break;
                }
            }
        }
        return res;
    }

    /*
     * проверяет соответствует ли поле турпредложения type фильтру
     * */
    private boolean isType(Tour tour, ListFilter filter) {
        boolean res = false;
        if (filter.getTypes().length == 0) {
            res = true;
        } else {
            for (Type t : filter.getTypes()) {
                if (tour.getType() == t) {
                    res = true;
                    break;
                }
            }
        }
        return res;
    }

    /*
     * проверяет соответствует ли поле турпредложения days фильтру
     * */
    private boolean isDays(Tour tour, ListFilter filter) {
        boolean res = false;
        if (tour.getDays() >= filter.getMinDays() && tour.getDays() <= filter.getMaxDays()) {
            res = true;
        }

        return res;
    }

    /*
     * проверяет соответствует ли поле турпредложения hotelStars фильтру
     * */
    private boolean isHotelStars(Tour tour, ListFilter filter) {
        boolean res = false;
        if (filter.getHotelStars().length == 0) {
            res = true;
        } else {
            for (int s : filter.getHotelStars()) {
                if (tour.getHotelStars() == s) {
                    res = true;
                    break;
                }
            }
        }
        return res;
    }

    /*
     * добавляет tour в выборку tours
     * */
    private Tour[] addTour(Tour[] tours, Tour tour) {
        boolean flag = true;
        Tour[] newTours = tours;
        for (Tour t : tours) {
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

    /*
     * удаляет элемент с индексом index выборки tours
     * */
    private Tour[] removeTour(Tour[] tours, int index) {
        Tour[] newTours = new Tour[tours.length - 1];
        for (int i = 0; i < tours.length; i++) {
            if (i < index) {
                newTours[i] = tours[i];
            } else if (i > index) {
                newTours[i] = tours[i - 1];
            }
        }
        return newTours;
    }

    private void log(Object o){
        System.out.println(o);
    }
}
