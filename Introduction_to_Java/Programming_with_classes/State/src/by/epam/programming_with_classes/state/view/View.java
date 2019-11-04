package by.epam.programming_with_classes.state.view;

import by.epam.programming_with_classes.state.logic.Logic;
import by.epam.programming_with_classes.state.state.Region;
import by.epam.programming_with_classes.state.state.State;

public class View {

    public void printCapital(State state) {

        if (state != null) {
            System.out.println("Столица государства город " + state.getCapital());
        } else {
            System.out.println("Такого государства нет в базе.");
        }
    }

    public void printRegionCount(State state) {

        if (state != null) {
            System.out.println("Количество областей государства " + state.getRegions().length);
        } else {
            System.out.println("Такого государства нет в базе.");
        }
    }

    public void printStateArea(State state) {

        Logic logic = new Logic();

        if (state != null) {
            System.out.println("Площадь государства " + logic.stateArea(state) + " кв.км");
        } else {
            System.out.println("Такого государства нет в базе.");
        }
    }

    public void printRegionCenters(State state){

        if (state != null) {

            System.out.println("Областные цетры:");
            for (Region r: state.getRegions()){

                System.out.println("город " + r.getCapital());
            }
        } else {

            System.out.println("Такого государства нет в базе.");
        }
    }

    public void printName(State state){

        if (state != null) {

                System.out.println("Государство " + state.getName());

        } else {

            System.out.println("Такого государства нет в базе.");
        }
    }
}
