package cl_obj.filters;


import cl_obj.library.*;
import java.util.Arrays;

/*
* Класс представляющий фильтр для выбора тур предложений.
* Фильтр содержит поля соответствующие полям тур предложения.
* В каждом полеле фильтра содержится массив соответствующих значений.
* */
public class ListFilter {
    private Type[] types;
    private Transportation[] transportation;
    private int[] hotelStars;
    private Food[] foods;
    private int minDays;
    private int maxDays;

    public ListFilter() {
        this.types = new Type[0];
        this.transportation = new Transportation[0];
        this.hotelStars = new int[0];
        this.foods = new Food[0];
        this.minDays = 1;
        this.maxDays = Integer.MAX_VALUE;
    }

    /*
    * добавляет в фильтр значение звездности отеля
    * */
    public boolean addHotelStars(int ... stars){
        boolean flag = true;
        boolean res = false;
        for (int s : stars) {
            for (int ts : this.hotelStars){
                if (s == ts){
                    flag = false;
                    break;
                }
            }
            if (flag) {
                int[] newFilter = Arrays.copyOf(this.hotelStars, this.hotelStars.length + 1);
                newFilter[newFilter.length - 1] = s;
                this.hotelStars = newFilter;
                flag = true;
                res = true;
            }
        }
        return  res;
    }

    /*
    * сбрасывает фильтр по звездности отеля
    * */
    public void resetHotelStars(){
        this.hotelStars = new int[0];
    }

    /*
     * добавляет в фильтр тип транспорта
     * */
    public boolean addTransportation(Transportation ... transportation){
        boolean flag = true;
        boolean res = false;
        for (Transportation tr : transportation) {
            for (Transportation ttr : this.transportation){
                if (tr == ttr){
                    flag = false;
                    break;
                }
            }
            if (flag) {
                Transportation[] newFilter = Arrays.copyOf(this.transportation, this.transportation.length + 1);
                newFilter[newFilter.length - 1] = tr;
                this.transportation = newFilter;
                flag = true;
                res = true;
            }
        }
        return  res;
    }

    /*
     * сбрасывает фильтр по транспорту
     * */
    public void resetTransportation(){
        this.transportation = new Transportation[0];
    }

    /*
     * добавляет в фильтр тип путевки
     * */
    public boolean addType(Type ... type){
        boolean flag = true;
        boolean res = false;
        for (Type t : type) {
            for (Type tt : this.types){
                if (t == tt){
                    flag = false;
                    break;
                }
            }
            if (flag) {
                Type[] newFilter = Arrays.copyOf(this.types, this.types.length + 1);
                newFilter[newFilter.length - 1] = t;
                this.types = newFilter;
                flag = true;
                res = true;
            }
        }
        return  res;
    }

    /*
     * сбрасывает фильтр по типу путевки
     * */
    public void resetType(){
        this.types = new Type[0];
    }


    /*
     * добавляет в фильтр тип транспорта
     * */
    public boolean addFood(Food ... food){
        boolean flag = true;
        boolean res = false;
        for (Food f : food) {
            for (Food tf : this.foods){
                if (f == tf){
                    flag = false;
                    break;
                }
            }
            if (flag) {
                Food[] newFilter = Arrays.copyOf(this.foods, this.foods.length + 1);
                newFilter[newFilter.length - 1] = f;
                this.foods = newFilter;
                flag = true;
                res = true;
            }
        }
        return  res;
    }

    /*
     * сбрасывает фильтр по транспорту
     * */
    public void resetFood(){
        this.foods = new Food[0];
    }


    public Type[] getTypes() {
        return types;
    }

    public Transportation[] getTransportation() {
        return transportation;
    }

    public int[] getHotelStars() {
        return hotelStars;
    }

    public Food[] getFoods() {
        return foods;
    }

    public int getMinDays() {
        return minDays;
    }

    public void setMinDays(int minDays) {
        this.minDays = minDays;
    }

    public int getMaxDays() {
        return maxDays;
    }

    public void setMaxDays(int maxDays) {
        this.maxDays = maxDays;
    }
}
