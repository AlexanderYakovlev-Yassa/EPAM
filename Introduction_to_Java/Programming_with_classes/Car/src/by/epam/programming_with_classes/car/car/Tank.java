package by.epam.programming_with_classes.car.car;

public class Tank {

    private double value;
    private double fuelAmount;

    public Tank(double value) {
        this.value = value;
        this.fuelAmount = 0;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }
}
