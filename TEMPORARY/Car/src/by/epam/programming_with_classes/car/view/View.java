package by.epam.programming_with_classes.car.view;

import by.epam.programming_with_classes.car.car.Car;
import by.epam.programming_with_classes.car.car.Engine;
import by.epam.programming_with_classes.car.car.Wheel;

public class View {

    public String wheelInfo(Wheel wheel){
        return String.format("Wheel ID %-4d, dimension %-2d, installed on %s",
                wheel.getId(), wheel.getDimension(), wheel.getHost());
    }

    public String engineInfo(Engine engine){

        String statusStr = engine.isStatus() ? "started" : "stopped";

        return String.format("Engine ID %-4d, power %-4d kWt. Engine is %s",
                engine.getId(), engine.getPower(), statusStr);
    }

    public String carInfo(Car car){

        return String.format("Car ID %-4d, %s", car.getId(), car.getBrand());
    }
}
