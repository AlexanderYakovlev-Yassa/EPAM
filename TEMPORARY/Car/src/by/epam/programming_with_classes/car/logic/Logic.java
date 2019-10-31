package by.epam.programming_with_classes.car.logic;

import by.epam.programming_with_classes.car.car.Car;
import by.epam.programming_with_classes.car.car.Engine;
import by.epam.programming_with_classes.car.car.Wheel;

public class Logic {

    public void startEngine(Car car) {

        if (isEngineInstalled(car)) {

            startEngine(car.getEngine());
        }

    }

    public void startEngine(Engine engine) {

        if (isEngineExists(engine)) {

            engine.setStatus(true);
        }

    }

    public void stopEngine(Engine engine) {

        if (isEngineExists(engine)) {

            engine.setStatus(false);
        }
    }

    public void stopEngine(Car car) {

        if (isCarExists(car) && isEngineInstalled(car) && !car.isMoving()) {

            stopEngine(car.getEngine());
        }
    }

    public void driveCar(Car car) {

        car.setMoving(isCarExists(car) && isAllWheelInstalled(car) && car.getEngine().isStatus());
    }

    public void stopCar(Car car) {
        if (isCarExists(car) && car.isMoving()){
            car.setMoving(false);
        }
    }

    public boolean isAllWheelInstalled(Car car) {

        boolean flag = true;

        if (isCarExists(car)) {

            for (int i = 0; i < car.getWheelNumber(); i++) {

                if (!isWheelInstalled(car, i)) {
                    flag = false;
                    break;
                }
            }
        } else {
            flag = false;
        }

        return flag;
    }

    public void removeWheel(Car car, int index) {

        if (isCarExists(car) &&
                isWheelIndexCorrect(car, index) &&
                isWheelInstalled(car, index)) {

            car.getWheel(index).setHost(null);
            car.setWheel(null, index);
        }
    }

    public void installWheel(Car car, Wheel wheel, int index) {
        if (isCarExists(car) &&
                isWheelIndexCorrect(car, index) &&
                !isWheelInstalled(car, index) &&
                isWheelExists(wheel) &&
                !hasWheelHost(wheel) &&
                isWheelMeetsRequirements(car, wheel)) {

            car.setWheel(wheel, index);
            wheel.setHost(car);
        }

    }

    public void changeWheel(Car car, Wheel wheel, int index) {

        if (isCarExists(car) &&
        isWheelIndexCorrect(car, index) &&
        isWheelExists(wheel) &&
        !hasWheelHost(wheel)){

            if (isWheelInstalled(car, index)){
                removeWheel(car,index);
            }

            installWheel(car, wheel, index);
        }
    }

    private boolean isWheelMeetsRequirements(Car car, Wheel wheel) {
        return car.getWheelsDimension() == wheel.getDimension();
    }

    private boolean isWheelIndexCorrect(Car car, int index) {
        return index >= 0 && index < car.getWheelNumber();
    }

    private boolean isWheelInstalled(Car car, int index) {
        return car.getWheel(index) != null;
    }

    private boolean hasWheelHost(Wheel wheel) {
        return wheel.getHost() != null;
    }

    private boolean isCarExists(Car car) {
        return car != null;
    }

    private boolean isWheelExists(Wheel wheel){
        return wheel != null;
    }

    private boolean isEngineInstalled(Car car){
        return car.getEngine() != null;
    }

    private boolean isEngineExists(Engine engine){
        return engine != null;
    }
}
