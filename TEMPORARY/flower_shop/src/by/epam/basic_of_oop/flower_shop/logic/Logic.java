package by.epam.basic_of_oop.flower_shop.logic;

import by.epam.basic_of_oop.flower_shop.flower.Color;
import by.epam.basic_of_oop.flower_shop.flower.FlowerType;

public class Logic {

    public Color checkColor(String color){
        Color selectedColor = null;
        color = color.toLowerCase();
        switch (color){
            case "белый":
            case "белая":
            case "белое":{
                selectedColor = Color.WHITE;
            }
            case "красный":
            case "красная":
            case "красное":{
                selectedColor = Color.RED;
                break;
            }
            case "желтый":
            case "желтая":
            case "желтое":{
                selectedColor = Color.YELLOW;
                break;
            }
            case "фиолетовый":
            case "фиолетовая":
            case "фиолетовое":{
                selectedColor = Color.PURPLE;
                break;
            }
        }

        return selectedColor;
    }

    public FlowerType checkFlower(String flower){
        FlowerType selectedFlower = null;
        flower = flower.toLowerCase();
        switch (flower){
            case "роза":{
                selectedFlower = FlowerType.ROSE;
            }
            case "тюльпан":{
                selectedFlower = FlowerType.TULIP;
                break;
            }
        }

        return selectedFlower;
    }
}
