package by.epam.basic_of_oop.dragon_treasures.main;

import by.epam.basic_of_oop.dragon_treasures.logic.Logic;
import by.epam.basic_of_oop.dragon_treasures.tresure.Treasures;
import by.epam.basic_of_oop.dragon_treasures.view.View;

public class Main {
    public static void main(String[] args) {

        Logic logic = new Logic();
        View view = new View();

        Treasures dragonTreasures = logic.readFromDataFile();

        view.showMainMenu(dragonTreasures);
    }

}
