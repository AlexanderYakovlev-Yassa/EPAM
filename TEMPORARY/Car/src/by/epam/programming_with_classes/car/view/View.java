package by.epam.programming_with_classes.car.view;

import by.epam.programming_with_classes.car.car.Car;
import by.epam.programming_with_classes.car.car.Engine;
import by.epam.programming_with_classes.car.car.Wheel;

public class View {

    public String wheelInfo(Wheel wheel){

        String installed = wheel.getHost() == null ? "not installed" : "installed on car";

        return String.format("Wheel ID %4d, dimension %2d, %s",
                wheel.getId(), wheel.getDimension(), installed);
    }

    public String engineInfo(Engine engine){

        String statusStr = engine.isStatus() ? "started" : "stopped";

        return String.format("Engine ID %4d, power %4d kWt. Engine is %s",
                engine.getId(), engine.getPower(), statusStr);
    }

    public String carInfo(Car car){

        String engineInfo = car.getEngine() == null ? "engine is not installed" : engineInfo(car.getEngine());
        StringBuilder wheelsInfo = new StringBuilder();
        String wheelInfo;

        for (Wheel w: car.getWheels()){
            wheelInfo = w == null ? "wheel not installed" : wheelInfo(w);
            wheelsInfo.append("\n" + wheelInfo);
        }
        return String.format("\nCar ID %4d, %s:\n\tengine:\n%s\n\twheels:%s",
                car.getId(),
                car.getBrand(),
                engineInfo,
                wheelsInfo.toString());
    }
}
