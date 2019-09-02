/*7. Описать класс, представляющий треугольник.
Предусмотреть методы для создания объектов,
вычисления площади, периметра и точки пересечения медиан.*/

import java.lang.Math;

public class Triangle {
    private double aX;
    private double aY;
    private double bX;
    private double bY;
    private double cX;
    private double cY;

    public Triangle(double aX, double aY, double bX, double bY, double cX, double cY) {
        this.aX = aX;
        this.aY = aY;
        this.bX = bX;
        this.bY = bY;
        this.cX = cX;
        this.cY = cY;
    }

    private double sideLength(double x1, double y1, double x2, double y2) {
        double dx = x1 - x2;
        double dy = y1 - y2;
        double length = Math.sqrt(dx * dx + dy * dy);
        return length;
    }

    //returns a perimeter of triangle or
    // 0 - if the triangle is not existing,
    // -1 - if the perimeter can't be calculated
    public double perimeter() {
        double perimeter = 0;
        if (isTriangleExist()) {
            double sideABLength = sideLength(aX, aY, bX, bY);
            double sideBCLength = sideLength(bX, bY, cX, cY);
            double sideACLength = sideLength(aX, aY, cX, cY);
            perimeter = sideABLength + sideBCLength + sideACLength;
        }
        perimeter = (Double.isNaN(perimeter) || Double.isInfinite(perimeter)) ? -1 : perimeter;

        return perimeter;
    }

    //returns an area of triangle or
    // 0 - if the triangle is not existing,
    // -1 - if the area can't be calculated
    public double area() {
        double area = 0;
        if (isTriangleExist()) {
            double sideABLength = sideLength(aX, aY, bX, bY);
            double sideBCLength = sideLength(bX, bY, cX, cY);
            double sideACLength = sideLength(aX, aY, cX, cY);
            double halfPerimeter = perimeter() / 2;
            area = Math.sqrt(halfPerimeter * (halfPerimeter - sideABLength) * (halfPerimeter - sideBCLength) * (halfPerimeter - sideACLength));
        }
        area = (Double.isNaN(area) || Double.isInfinite(area)) ? -1 : area;
        return area;
    }


    //determines whether the triangle is existing
    public boolean isTriangleExist() {
        boolean res = true;
        if (isSamePoints()) {
            res = false;
        } else {
            if (isInSameLine()) {
                res = false;
            }
        }
        return res;
    }

    private boolean isSamePoints() {
        boolean res = false;
        if (((aX == bX) && (aY == bY)) ||
                ((bX == cX) && (bY == cY)) ||
                ((aX == cX) && (aY == cY))) {
            res = true;
        }
        return res;
    }

    private boolean isInSameLine() {
        double dX1 = aX - bX;
        double dX2 = aX - cX;
        double dY1 = aY - bY;
        double dY2 = aY - cY;
        boolean res = false;
        double tg1 = dY1 / dX1;
        double tg2 = dY2 / dX2;
        if (tg1 == tg2) {
            res = true;
        }
        return res;
    }
}
