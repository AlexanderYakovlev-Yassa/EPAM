package by.epam.basic_of_oop.flower_shop.server.components;

import by.epam.basic_of_oop.flower_shop.server.enumerators.Color;
import by.epam.basic_of_oop.flower_shop.server.enumerators.FlowerNames;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flower flower = (Flower) o;
        return getName() == flower.getName() &&
                getColor() == flower.getColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getColor());
    }

    @Override
    public String getComponentType() {
        return "flower";
    }

    @Override
    public String toString() {
        return "Flower{" +
                "name " + name +
                ", color " + color +
                '}';
    }
}
