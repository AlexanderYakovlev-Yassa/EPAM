package by.epam.programming_with_classes.car.car;

import java.util.Objects;

public class Engine {

    private static int lastID;

    private int id;
    private int power;
    private Car host;
    private boolean status;

    public Engine(int power) {
        this.id = ++lastID;
        this.power = power;
        this.status = false;
        this.host = null;
    }

    public int getId() {
        return id;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Car getHost() {
        return host;
    }

    public void setHost(Car host) {
        this.host = host;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return getPower() == engine.getPower();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPower());
    }

    @Override
    public String toString() {
        return "Engine{" +
                "id=" + id +
                '}';
    }
}
