package cl_obj.filters;


import cl_obj.library.*;

import java.util.Arrays;


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
        this.minDays = Integer.MAX_VALUE;
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

    public int getMaxDays() {
        return maxDays;
    }

    public void print(){
        System.out.println("***");
        for (Transportation t : this.transportation){
            System.out.println(t.getRusName());
        }
    }
}
