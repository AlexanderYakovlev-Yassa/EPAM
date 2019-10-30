package by.epam.basic_of_oop.flower_shop.client.bouquet;

import by.epam.basic_of_oop.flower_shop.server.components.IBouquetComponent;

import java.util.Arrays;

public class Bouquet {
    IBouquetComponent[] components;

    public Bouquet(IBouquetComponent[] components) {
        this.components = components;
    }

    public Bouquet() {
        this.components = new IBouquetComponent[0];
    }

    public IBouquetComponent[] getComponents() {
        return components;
    }

    public IBouquetComponent getComponent(int index) {
        return components[index];
    }

    public void setComponents(IBouquetComponent[] components) {
        this.components = components;
    }

    public void setComponent(IBouquetComponent components, int index) {
        this.components[index] = components;
    }

    public void add(IBouquetComponent component){

        if (component != null) {
            components = Arrays.copyOf(components, components.length + 1);
            setComponent(component, components.length - 1);
        }
    }
}
