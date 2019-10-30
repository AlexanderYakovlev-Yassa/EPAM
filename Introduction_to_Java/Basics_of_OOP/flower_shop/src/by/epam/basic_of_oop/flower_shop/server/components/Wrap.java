package by.epam.basic_of_oop.flower_shop.server.components;

import by.epam.basic_of_oop.flower_shop.server.enumerators.Color;
import by.epam.basic_of_oop.flower_shop.server.enumerators.WrapMaterial;

import java.util.Objects;

public class  Wrap implements IBouquetComponent {
    WrapMaterial wrapType;
    Color color;

    public Wrap(WrapMaterial wrapType, Color color) {
        this.wrapType = wrapType;
        this.color = color;
    }

    public WrapMaterial getWrapType() {
        return wrapType;
    }

    public void setWrapType(WrapMaterial wrapType) {
        this.wrapType = wrapType;
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
        Wrap wrap = (Wrap) o;
        return getWrapType() == wrap.getWrapType() &&
                getColor() == wrap.getColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWrapType(), getColor());
    }

    @Override
    public String getComponentType() {
        return "wrap";
    }

    @Override
    public String toString() {
        return "Wrap{" +
                "wrapType " + wrapType +
                ", color " + color +
                '}';
    }
}
