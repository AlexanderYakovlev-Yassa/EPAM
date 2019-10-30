package by.epam.basic_of_oop.flower_shop.client.main;

import by.epam.basic_of_oop.flower_shop.client.bouquet.Bouquet;
import by.epam.basic_of_oop.flower_shop.server.logic.Logic;
import by.epam.basic_of_oop.flower_shop.server.view.View;

public class Main {

    public static void main(String[] args) {

        Logic logic = new Logic();
        View view = new View();

        String component;
        String color;

        String number;
        Bouquet bouquet = new Bouquet();

            //ВЫБОР ЦВЕТОВ
        //ВЫБЕРИТЕ ЦВЕТОК:
        component = "роза";//FlowerNames.ROSE;
        //ВЫБЕРИТЕ ЦВЕТ:
        color = "красная";//Color.RED;
        //ВЫБЕРИТЕ КОЛИЧЕСТВО:
        number = "3";//3;
        //ДОБАВИТЬ...

        logic.addComponentsToBouquet(bouquet, component, color, number);

            //ВЫБОР ЦВЕТОВ
        //ВЫБЕРИТЕ ЦВЕТОК:
        component = "розы";//FlowerNames.ROSE;
        //ВЫБЕРИТЕ ЦВЕТ:
        color = "белые";//Color.WHITE;
        //ВЫБЕРИТЕ КОЛИЧЕСТВО:
        number = "3";//3;
        //ДОБАВИТЬ...

        logic.addComponentsToBouquet(bouquet, component, color, number);

            //ВЫБОР ЦВЕТОВ
        //ВЫБЕРИТЕ ЦВЕТОК:
        component = "роза";//FlowerNames.ROSE;
        //ВЫБЕРИТЕ ЦВЕТ:
        color = "желтый";//Color.ORANGE;
        //ВЫБЕРИТЕ КОЛИЧЕСТВО:
        number = "3";//3;
        //ДОБАВИТЬ...

        logic.addComponentsToBouquet(bouquet, component, color, number);

            //ВЫБОР УПАКОВКИ
        //ВЫБЕРИТЕ ЦВЕТОК:
        component = "бумажная";//WrapMaterial.PAPER;
        //ВЫБЕРИТЕ ЦВЕТ УПАКОВКИ:
        color = "желтая";//Color.YELLOW;
        //ДОБАВИТЬ...

        logic.addComponentsToBouquet(bouquet, component, color, "1");

        System.out.println(view.printBouquetInfo(bouquet));

    }

}
