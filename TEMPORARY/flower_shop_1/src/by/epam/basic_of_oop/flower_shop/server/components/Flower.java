package by.epam.basic_of_oop.flower_shop.server.components;

import by.epam.basic_of_oop.flower_shop.server.enumerators.Color;
import by.epam.basic_of_oop.flower_shop.server.enumerators.FlowerNames;

public class Flower implements IBouquetComponent {

    FlowerNames name;
    Color color;

    public Flower(FlowerNames name, Color color) {
        this.name = name;
        this.color = color;
    }

    public FlowerNames getName() {
        return name;
    }

    public void setName(FlowerNames name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String getComponentType() {
        return "flower";
    }
}
