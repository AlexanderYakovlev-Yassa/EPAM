package by.epam.basic_of_oop.flower_shop.server.view;

import by.epam.basic_of_oop.flower_shop.client.bouquet.Bouquet;
import by.epam.basic_of_oop.flower_shop.server.components.Flower;
import by.epam.basic_of_oop.flower_shop.server.components.IBouquetComponent;
import by.epam.basic_of_oop.flower_shop.server.components.Wrap;

public class View {

    public String printBouquetInfo(Bouquet bouquet) {

        StringBuilder sb = new StringBuilder("\tсостав цветочной композиции:");

        for (IBouquetComponent comp : bouquet.getComponents()) {

            if (comp.getComponentType() == "flower" ) {
                sb.append("\n" + ((Flower)comp).getColor() + " ");
                sb.append(((Flower)comp).getName());
                // sb.append(comp.)
            } else if (comp.getComponentType() == "wrap" ){
                sb.append("\n" + ((Wrap)comp).getColor() + " ");
                sb.append(((Wrap)comp).getWrapType());
            }
        }

        return sb.toString();
    }
}
