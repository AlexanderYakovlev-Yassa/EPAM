package by.epam.programming_with_classes.state.main;

import by.epam.programming_with_classes.state.data.Data;
import by.epam.programming_with_classes.state.state.State;
import by.epam.programming_with_classes.state.view.View;

public class Main {

    public static void main(String[] args) {

        View view = new View();
        Data data = new Data();
        State state = data.readStateFromFle("src\\by\\epam\\programming_with_classes\\state\\data\\Belarus.xml");

        view.printName(state);
        view.printCapital(state);
        view.printRegionCount(state);
        view.printRegionCenters(state);
        view.printStateArea(state);
    }
}
