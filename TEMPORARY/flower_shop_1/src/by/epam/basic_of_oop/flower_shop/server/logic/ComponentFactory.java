package by.epam.basic_of_oop.flower_shop.server.logic;

import by.epam.basic_of_oop.flower_shop.server.components.IBouquetComponent;
import by.epam.basic_of_oop.flower_shop.server.enumerators.Color;
import by.epam.basic_of_oop.flower_shop.server.components.Flower;
import by.epam.basic_of_oop.flower_shop.server.enumerators.FlowerNames;
import by.epam.basic_of_oop.flower_shop.server.components.Wrap;
import by.epam.basic_of_oop.flower_shop.server.enumerators.WrapMaterial;

public class ComponentFactory implements IFactory {

    @Override
    public IBouquetComponent create(String type, String color) {

        Logic logic = new Logic();

        IBouquetComponent component = null;
        Color componentColor = logic.checkColor(color);
        FlowerNames flowerNames = logic.checkFlower(type);
        WrapMaterial wrapMaterial = logic.checkWrapMaterial(type);
        //System.out.println(type + "  " + color);//***********************************************************************
        //System.out.println(wrapMaterial);//********************************************************
        if (componentColor != null) {
            if (flowerNames != null) {

                component = new Flower(flowerNames, componentColor);

            } else if (wrapMaterial != null){

                component = new Wrap(wrapMaterial, componentColor);
            }
        }

        return component;
    }
}
