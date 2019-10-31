package by.epam.programming_with_classes.car.logic;

import by.epam.programming_with_classes.car.car.Car;
import by.epam.programming_with_classes.car.car.Engine;
import by.epam.programming_with_classes.car.car.Wheel;

public class Logic {

    public void startEngine(Car car) {

        if (car.getEngine() != null) {

            startEngine(car.getEngine());
        }

    }

    public void startEngine(Engine engine) {

        if (engine != null) {

            engine.setStatus(true);
        }

    }

    public void stopEngine(Engine engine) {

        if (engine != null) {

            engine.setStatus(false);
        }
    }

    public void stopEngine(Car car) {

        if (car.getEngine() != null && !car.isMoving()) {

            stopEngine(car.getEngine());
        }
    }

    public void driveCar(Car car) {

        car.setMoving((car != null) && isAllWheelInstalled(car) && car.getEngine().isStatus());
    }

    public void stopCar(Car car) {

    }

    public boolean isAllWheelInstalled(Car car) {

        boolean flag = true;

        if (car != null) {

            for (int i = 0; i < car.getWheelNumber(); i++) {

                if (car.getWheel(i) == null) {
                    flag = false;
                    break;
                }
            }
        } else {
            flag = false;
        }

        return flag;
    }

    public void removeWheel(Car car, int index){

       if (car != null) {

           if (index > 0 && index <= car.getWheelNumber()) {

               car.setWheel(null, index);
           }
       }
    }

    public void installWheel(Car car, Wheel wheel, int index){

        if (car != null) {

            if (index > 0 && index <= car.getWheelNumber()) {

                if (car.getWheel(index) == null &&
                        car.getWheelsDimension() == wheel.getDimension() &&
                        wheel.getHost() == null){

                    car.setWheel(wheel, index);
                }
            }
        }
    }

    public void changeWheels(Car car, Wheel[] wheels){

        if (car != null) {

            for (int i = 0; i < car.getWheelNumber(); i++) {

                if (car.getWheel(i) != null){

                    removeWheel(car, i);

                }

                for (Wheel w : wheels){

                    installWheel(car, w, i);

                }
            }
        }
    }
}
