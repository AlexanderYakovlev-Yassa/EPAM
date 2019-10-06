import java.util.Arrays;

public class Base {
    private Tour[] tours;

    public Base() {
        this.tours = new Tour[0];
    }

    public Tour[] getTours() {
        return tours;
    }

    public void setTours(Tour[] tours) {
        this.tours = tours;
    }

    public void addTour(Tour tour) {
        Tour[] newTours = Arrays.copyOf(this.tours, this.tours.length + 1);
        newTours[newTours.length - 1] = tour;
        tours = newTours;
    }

    /*
     * сортирует список путевок по типу питания
     * если параметр a_z определяет направление сортировки
     * */
    public void sortByFood(boolean a_z) {
        for (int i = tours.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                int a = tours[j].getFood().range;
                int b = tours[j + 1].getFood().range;
                if (a_z) {
                    if (a > b) {
                        swap(j, j + 1);
                    }
                } else {
                    if (a < b) {
                        swap(j, j + 1);
                    }
                }
            }
        }
    }

    /*
     * сортирует список путевок по количеству дней
     * если параметр a_z определяет направление сортировки
     * */
    public void sortByDays(boolean a_z) {
        for (int i = tours.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                int a = tours[j].getDays();
                int b = tours[j + 1].getDays();
                if (a_z) {
                    if (a > b) {
                        swap(j, j + 1);
                    }
                } else {
                    if (a < b) {
                        swap(j, j + 1);
                    }
                }
            }
        }
    }

    /*
     * сортирует список путевок по количеству звезд у отеля
     * если параметр a_z определяет направление сортировки
     * */
    public void sortByHotelStars(boolean a_z) {
        for (int i = tours.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                int a = tours[j].getHotelStars();
                int b = tours[j + 1].getHotelStars();
                if (a_z) {
                    if (a > b) {
                        swap(j, j + 1);
                    }
                } else {
                    if (a < b) {
                        swap(j, j + 1);
                    }
                }
            }
        }
    }

    /*
    * меняет местами путевки с указанными индексами
    * в списке путевок
    * (используется для сортировки элементов списка)
    * */
    private void swap(int i1, int i2) {
        Tour bubble = tours[i1];
        tours[i1] = tours[i2];
        tours[i2] = bubble;
    }

    /*
     * возвращает список путевок отфильтрованный по виду транспорта+
     ** в параметрах указываются типы которые останутся в списке
     * */
    public Base filterByTransportation(Transportation... transportation) {
        Base newBase = new Base();
        for (Tour t : tours) {
            for (Transportation tr : transportation) {
                if (t.getTransportation() == tr) {
                    newBase.addTour(t);
                }
            }
        }
        return newBase;
    }

    /*
     * возвращает список путевок отфильтрованный по типу тура
     * в параметрах указываются типы которые останутся в списке
     * */
    public Base filterByType(Type... type) {
        Base newBase = new Base();
        for (Tour t : tours) {
            for (Type ty : type) {
                if (t.getType() == ty) {
                    newBase.addTour(t);
                }
            }
        }
        return newBase;
    }

    /*
     * возвращает список путевок отфильтрованный по количеству дней
     * параметр min - минимальное количество дней
     * параметр max - максимальное количество дней
     * */
    public Base filterByDays(int min, int max) {
        Base newBase = new Base();
        for (Tour t : tours) {
            if (t.getDays() >= min && t.getDays() <= max) {
                newBase.addTour(t);
            }
        }
        return newBase;
    }

    @Override
    public String toString() {
        StringBuilder tl = new StringBuilder("Список путевок:\n");
        for (Tour t : tours) {
            tl.append("\t" + t.toString() + "\n");
        }
        return tl.toString();
    }

    public String toString(boolean bID, boolean bName, boolean bType, boolean bTransportation, boolean bHotel, boolean bFood, boolean bDays) {
        StringBuilder tl = new StringBuilder("Список путевок:\n");
        for (Tour t : tours) {
            tl.append("\t" + t.toString(bID, bName, bType, bTransportation, bHotel, bFood, bDays) + "\n");
        }
        return tl.toString();
    }
}
