package by.epam.programming_with_classes.car.car;

import java.util.Objects;

public class Car {

    private static int lastID;

    private int id;
    private String brand;
    private int wheelNumber;
    private int wheelsDimension;
    private Wheel[] wheels;
    private Engine engine;
    private Tank tank;
    private boolean moving;

    public Car(String brand, int wheelNumber, int wheelsDimension) {

        this.id = ++lastID;
        this.brand = brand;
        this.wheelNumber = wheelNumber;
        this.wheelsDimension = wheelsDimension;
        this.wheels = new Wheel[this.wheelNumber];
        this.engine = null;
        this.moving = false;
    }

    public Car() {

        this.id = ++lastID;
        this.brand = null;
        this.wheelNumber = 4;
        this.wheelsDimension = 12;
        this.wheels = new Wheel[this.wheelNumber];
        this.engine = null;
        this.moving = false;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWheelNumber() {
        return wheelNumber;
    }

    public void setWheelNumber(int wheelNumber) {
        this.wheelNumber = wheelNumber;
    }

    public int getWheelsDimension() {
        return wheelsDimension;
    }

    public void setWheelsDimension(int wheelsDimension) {
        this.wheelsDimension = wheelsDimension;
    }

    public Wheel[] getWheels() {
        return wheels;
    }

    public Wheel getWheel(int index) {
        return wheels[index];
    }

    public void setWheels(Wheel[] wheels) {
        this.wheels = wheels;
    }

    public void setWheel(Wheel wheel, int index) {
        this.wheels[index] = wheel;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return getWheelNumber() == car.getWheelNumber() &&
                getWheelsDimension() == car.getWheelsDimension() &&
                Objects.equals(getBrand(), car.getBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getWheelNumber(), getWheelsDimension());
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", wheelNumber=" + wheelNumber +
                ", wheelsDimension=" + wheelsDimension +
                '}';
    }
}
