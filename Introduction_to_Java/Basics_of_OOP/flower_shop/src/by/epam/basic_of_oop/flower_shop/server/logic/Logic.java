package by.epam.basic_of_oop.flower_shop.server.logic;

import by.epam.basic_of_oop.flower_shop.client.bouquet.Bouquet;
import by.epam.basic_of_oop.flower_shop.server.components.IBouquetComponent;
import by.epam.basic_of_oop.flower_shop.server.enumerators.Color;
import by.epam.basic_of_oop.flower_shop.server.enumerators.FlowerNames;
import by.epam.basic_of_oop.flower_shop.server.enumerators.WrapMaterial;

public class Logic {

    public FlowerNames checkFlower(String string){

        string = string.toLowerCase();
        FlowerNames flowerNames = null;

        for (FlowerNames fl: FlowerNames.values()){
            if (string.contains(fl.getRusRoot())){
                flowerNames = fl;
            }
        }

        return flowerNames;
    }

    public WrapMaterial checkWrapMaterial(String string){

        string = string.toLowerCase();
        WrapMaterial wrapMaterial = null;

        for (WrapMaterial w: WrapMaterial.values()){

            if (string.contains(w.getRusRoot())){

                wrapMaterial = w;

            }
        }

        return wrapMaterial;
    }

    public Color checkColor(String string){

        string = string.toLowerCase();
        Color color = null;

        for (Color c: Color.values()){
            if (string.contains(c.getRusRoot())){
                color = c;
            }
        }

        return color;
    }

    public void addComponentsToBouquet(Bouquet bouquet, String name, String color, String number){

        ComponentFactory componentFactory = new ComponentFactory();
        int componentNumber;

        try {
            componentNumber = Integer.parseInt(number);

        } catch (NumberFormatException e){
            componentNumber = 0;
        }

        IBouquetComponent component = componentFactory.create(name, color);

        if (component != null && componentNumber > 0){

            for (int i = 0; i < componentNumber; i++) {

                bouquet.add(component);
            }
        }
    }
}
