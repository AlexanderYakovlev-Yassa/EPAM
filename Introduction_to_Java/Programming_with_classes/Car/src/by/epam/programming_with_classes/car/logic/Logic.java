package by.epam.programming_with_classes.car.logic;

import by.epam.programming_with_classes.car.car.Car;
import by.epam.programming_with_classes.car.car.Engine;
import by.epam.programming_with_classes.car.car.Wheel;

public class Logic {

    public void startEngine(Car car) {

        if (isCarExists(car) && isEngineInstalled(car) && hasCarFuel(car)) {

            car.getEngine().setStatus(true);
        }

    }

    public void stopEngine(Engine engine) {

        if (isEngineExists(engine)) {

            engine.setStatus(false);
        }
    }

    public void stopEngine(Car car) {

        if (isCarExists(car) && isEngineInstalled(car) && !car.isMoving()) {

            car.getEngine().setStatus(false);
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

    public boolean installWheel(Car car, Wheel wheel, int index) {

        boolean res = false;

        if (isCarExists(car) &&
                isWheelIndexCorrect(car, index) &&
                !isWheelInstalled(car, index) &&
                isWheelExists(wheel) &&
                !hasWheelHost(wheel) &&
                isWheelMeetsRequirements(car, wheel)) {

            car.setWheel(wheel, index);
            wheel.setHost(car);
            res = true;
        }

        return  res;
    }

    public boolean changeWheel(Car car, Wheel wheel, int index) {

        boolean res = false;

        if (isCarExists(car) &&
        isWheelIndexCorrect(car, index) &&
        isWheelExists(wheel) &&
        !hasWheelHost(wheel)){

            if (isWheelInstalled(car, index)){
                removeWheel(car,index);
            }

            res = installWheel(car, wheel, index);
        }

        return res;
    }

    public void changeWheels(Car car, Wheel[] wheels){

        if (isCarExists(car) &&
        wheels != null) {

            for (int i = 0; i < car.getWheelNumber(); i++) {

                if (isWheelInstalled(car, i)){
                    removeWheel(car,i);
                }

                int j = 0;
                while (j < wheels.length){

                    if (changeWheel(car, wheels[j], i)){
                        break;
                    }

                    j++;
                }
            }
        }
    }

    //returns amount of surplus fuel after the refuel of the car
    public double refuelCar(Car car, double fuel){

        double surplusFuel = 0;

        if(isCarExists(car) && hasCarTank(car)){
            if (fuel > 0){
                surplusFuel = fuel - car.getTank().getValue() + car.getTank().getFuelAmount();
                if (surplusFuel >= 0) {
                    car.getTank().setFuelAmount(car.getTank().getValue());
                } else {
                    car.getTank().setFuelAmount(car.getTank().getFuelAmount() + fuel);
                    surplusFuel = 0;
                }
            }
        }

        return surplusFuel;
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

    private boolean hasCarTank(Car car){
        return car.getTank() != null;
    }

    private boolean hasCarFuel(Car car){
        if (hasCarTank(car)){
            return car.getTank().getFuelAmount() > 0;
        } else {
            return false;
        }
    }
}
