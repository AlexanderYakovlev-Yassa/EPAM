package by.epam.basic_of_oop.flower_shop.server.logic;

import by.epam.basic_of_oop.flower_shop.server.components.IBouquetComponent;

public interface IFactory {

    public IBouquetComponent create(String type, String color);
}
