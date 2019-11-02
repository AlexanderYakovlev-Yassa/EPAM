package by.epam.programming_with_classes.triangle.objects;

import java.util.Objects;

public class Line {
    private double coeffA;
    private double coeffB;

    public Line(double coeffA, double coeffB) {
        this.coeffA = coeffA;
        this.coeffB = coeffB;
    }

    public Line() {
        this.coeffA = 0;
        this.coeffB = 0;
    }

    public double getCoeffA() {
        return coeffA;
    }

    public void setCoeffA(double coeffA) {
        this.coeffA = coeffA;
    }

    public double getCoeffB() {
        return coeffB;
    }

    public void setCoeffB(double coeffB) {
        this.coeffB = coeffB;
    }
}
