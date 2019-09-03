/*7. Описать класс, представляющий треугольник.
Предусмотреть методы для создания объектов,
вычисления площади, периметра и точки пересечения медиан.*/

import java.lang.Math;
import java.util.Objects;

public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    //Returns a perimeter of the triangle
    public double perimeter() {
        double perimeter = 0;
        if (isTriangleExist()) {
            double sideABLength = Point.distance(a, b);
            double sideBCLength = Point.distance(b, c);
            double sideACLength = Point.distance(a, c);
            perimeter = sideABLength + sideBCLength + sideACLength;
        }
        perimeter = (Double.isNaN(perimeter) || Double.isInfinite(perimeter)) ? -1 : perimeter;

        return perimeter;
    }

    //Returns an area of the triangle.
    public double area() {
        double area = 0;
        if (isTriangleExist()) {
            double sideABLength = Point.distance(a, b);
            double sideBCLength = Point.distance(b, c);
            double sideACLength = Point.distance(a, c);
            double halfPerimeter = perimeter() / 2;
            area = Math.sqrt(halfPerimeter * (halfPerimeter - sideABLength) * (halfPerimeter - sideBCLength) * (halfPerimeter - sideACLength));
        }
        return area;
    }


    //Determines whether or not the triangle is existing.
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

    //Determines whether or not the points have same coordinates.
    private boolean isSamePoints() {
        boolean res = false;
        if (a.equals(b) ||
                b.equals(c) ||
                a.equals(c)) {
            res = true;
        }
        return res;
    }

    //Determines whether or not the points are on the one line.
    private boolean isInSameLine() {
        double dX1 = a.getX() - b.getX();
        double dX2 = a.getX() - c.getX();
        double dY1 = a.getY() - b.getY();
        double dY2 = a.getY() - c.getY();
        boolean res = false;
        double tg1 = dY1 / dX1;
        double tg2 = dY2 / dX2;
        if (tg1 == tg2) {
            res = true;
        }
        return res;
    }

    //The intersection point of the medians of the triangle.
    public Point mediansIntersection() {
        Point mA = Point.midPoint(b, c);
        Point mB = Point.midPoint(a, c);
        Line median1 = new Line(a, mA);
        Line median2 = new Line(b, mB);
        Point cross = Line.intersection(median1, median2);
        return cross;
    }
}