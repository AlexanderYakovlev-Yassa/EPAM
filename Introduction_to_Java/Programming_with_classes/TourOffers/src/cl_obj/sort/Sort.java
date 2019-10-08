package cl_obj.sort;

import cl_obj.tour_offers.Tour;

public class Sort {

    /*
     * сортирует список путевок по типу питания
     * если параметр a_z определяет направление сортировки
     * */
    public void sortByFood(Tour[] tours, boolean a_z) {
        Tour bubble;
        for (int i = tours.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                int a = tours[j].getFood().getRange();
                int b = tours[j + 1].getFood().getRange();
                if (a_z) {
                    if (a > b) {
                        bubble = tours[j];
                        tours[j] = tours[j+1];
                        tours[j+1] = bubble;
                    }
                } else {
                    if (a < b) {
                        bubble = tours[j];
                        tours[j] = tours[j+1];
                        tours[j+1] = bubble;
                    }
                }
            }
        }
    }

    /*
     * сортирует список путевок по количеству дней
     * если параметр a_z определяет направление сортировки
     * */
    public void sortByDays(Tour[] tours, boolean a_z) {
        Tour bubble;
        for (int i = tours.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                int a = tours[j].getDays();
                int b = tours[j + 1].getDays();
                if (a_z) {
                    if (a > b) {
                        bubble = tours[j];
                        tours[j] = tours[j+1];
                        tours[j+1] = bubble;
                    }
                } else {
                    if (a < b) {
                        bubble = tours[j];
                        tours[j] = tours[j+1];
                        tours[j+1] = bubble;
                    }
                }
            }
        }
    }
}
