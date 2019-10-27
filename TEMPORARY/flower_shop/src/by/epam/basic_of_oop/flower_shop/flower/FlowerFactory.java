package by.epam.basic_of_oop.flower_shop.flower;

import by.epam.basic_of_oop.flower_shop.logic.Logic;

public class FlowerFactory implements IFactory{

    @Override
    public Flower createFlower(String type, String color) {

        Flower flower = null;
        Logic logic = new Logic();
        FlowerType flowerType = logic.checkFlower(type);
        Color colorN = logic.checkColor(color);

        switch (flowerType.name()){
            case ("ROSE"):{
                flower = new Rose(colorN);
                break;
            }
            case ("TULIP"):{
                flower = new Tulip(colorN);
                break;
            }
        }

        return flower;
    }
}
