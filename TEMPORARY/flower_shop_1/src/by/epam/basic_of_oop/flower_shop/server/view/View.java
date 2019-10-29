package by.epam.basic_of_oop.flower_shop.server.view;

import by.epam.basic_of_oop.flower_shop.client.bouquet.Bouquet;
import by.epam.basic_of_oop.flower_shop.server.components.IBouquetComponent;

public class View {

    public String printBouquetInfo(Bouquet bouquet) {

        StringBuilder sb = new StringBuilder("\tсостав цветочной композиции:");

        for (IBouquetComponent comp : bouquet.getComponents()) {

            if (comp.getComponentType() == "flower" ) {
               // sb.append(comp.)
            } else if (comp.getComponentType() == "wrap" ){

            }
        }

        return sb.toString();
    }
}
