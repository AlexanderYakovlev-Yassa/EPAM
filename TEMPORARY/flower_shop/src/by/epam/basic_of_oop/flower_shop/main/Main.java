package by.epam.basic_of_oop.flower_shop.main;

import by.epam.basic_of_oop.flower_shop.flower.Color;
import by.epam.basic_of_oop.flower_shop.flower.Flower;
import by.epam.basic_of_oop.flower_shop.flower.FlowerFactory;
import by.epam.basic_of_oop.flower_shop.flower.FlowerType;

import java.io.FileWriter;

public class Main {

    public static void main(String[] args) {
        FlowerFactory flowerFactory = new FlowerFactory();

        Flower flower = flowerFactory.createFlower("роза", "белая");
        Flower flower1 = flowerFactory.createFlower("тюльпан", "белый");

        flower.whatKindOfFlower();
        flower1.whatKindOfFlower();
    }

}
