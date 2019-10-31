package by.epam.programming_with_classes.car.main;

import by.epam.programming_with_classes.car.car.Car;
import by.epam.programming_with_classes.car.car.Engine;
import by.epam.programming_with_classes.car.car.Wheel;
import by.epam.programming_with_classes.car.logic.Logic;
import by.epam.programming_with_classes.car.view.View;

public class Main {

    public static void main(String[] args) {

        //creating two engines
        Engine engine_1 = new Engine(100);
        Engine engine_2 = new Engine(200);

        //viewing info about creating engines
        View view = new View();

        System.out.println(view.engineInfo(engine_1));
        System.out.println(view.engineInfo(engine_2));

        //creating two cars
        Car car_1 = new Car("Mercedes", 4, 21);
        Car car_2 = new Car();
        car_2.setBrand("Ford");
        car_2.setWheelsDimension(19);

        System.out.println();

        //viewing info about creating cars
        System.out.println(view.carInfo(car_1));
        System.out.println(view.carInfo(car_2));

        //creating different wheels
        Wheel[] wheelsSet_21_1 = new Wheel[4];
        Wheel[] wheelsSet_19_1 = new Wheel[4];
        Wheel[] wheelsSet_21_2 = new Wheel[4];
        Wheel[] wheelsSet_19_2 = new Wheel[4];
        Wheel[] wheelsSet_14_1 = new Wheel[4];

        for (int i = 0; i < 4; i++) {
            wheelsSet_19_1[i] = new Wheel(19);
            wheelsSet_19_2[i] = new Wheel(19);
            wheelsSet_21_1[i] = new Wheel(21);
            wheelsSet_21_2[i] = new Wheel(21);
            wheelsSet_14_1[i] = new Wheel(14);
        }

        Logic logic = new Logic();



        //install engines to cars
        car_1.setEngine(engine_1);
        car_2.setEngine(engine_2);

        //install wheels on cars
        //logic.changeWheels(car_1,wheelsSet_21_1);

        //trying to start engine of the first car
        logic.startEngine(car_1);
        System.out.println(view.carInfo(car_1));
        System.out.println(view.carInfo(car_2));


    }
}
