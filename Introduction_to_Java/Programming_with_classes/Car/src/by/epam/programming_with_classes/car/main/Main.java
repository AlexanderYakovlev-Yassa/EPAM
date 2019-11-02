package by.epam.programming_with_classes.car.main;

import by.epam.programming_with_classes.car.car.Car;
import by.epam.programming_with_classes.car.car.Engine;
import by.epam.programming_with_classes.car.car.Tank;
import by.epam.programming_with_classes.car.car.Wheel;
import by.epam.programming_with_classes.car.logic.Logic;
import by.epam.programming_with_classes.car.view.View;

public class Main {

    public static void main(String[] args) {

        Logic logic = new Logic();
        View view = new View();

        Car car = new Car("Mercedes", 4, 21);

        Wheel[] wheelsSet_21_1 = new Wheel[4];
        for (int i = 0; i < 4; i++) {
            wheelsSet_21_1[i] = new Wheel(21);
        }

        for (int i = 0; i < 4; i++) {
            logic.installWheel(car, wheelsSet_21_1[i], i);
        }

        Engine engine = new Engine(500);
        car.setEngine(engine);

        Tank tank = new Tank(90);
        car.setTank(tank);

        System.out.println("\nCar info after creating:");
        System.out.println(view.carInfo(car));

        logic.refuelCar(car, 50);

        Wheel newWheel = new Wheel(21);

        logic.changeWheel(car, newWheel, 1);

        System.out.println("\nCar info after refuel and change one wheel:");
        System.out.println(view.carInfo(car));

        logic.startEngine(car);
        logic.driveCar(car);

        System.out.println("\nCar info after start of engine and begin moving");
        System.out.println(view.carInfo(car));

        logic.stopCar(car);
        logic.startEngine(car);
    }
}
