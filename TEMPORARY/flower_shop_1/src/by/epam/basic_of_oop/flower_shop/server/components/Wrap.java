package by.epam.basic_of_oop.flower_shop.server.components;

import by.epam.basic_of_oop.flower_shop.server.enumerators.Color;
import by.epam.basic_of_oop.flower_shop.server.enumerators.WrapMaterial;

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
    public String getComponentType() {
        return "wrap";
    }
}
