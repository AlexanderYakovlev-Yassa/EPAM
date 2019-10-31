package by.epam.programming_with_classes.car.car;

import java.util.Objects;

public class Wheel {

    private static int lastID;

    private int id;
    private int dimension;
    private Car host;

    public Wheel(int dimension) {
        this.id = ++lastID;
        this.dimension = dimension;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public int getId() {
        return id;
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
        Wheel wheel = (Wheel) o;
        return getDimension() == wheel.getDimension();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDimension());
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "id=" + id +
                ", dimension=" + dimension +
                '}';
    }
}
