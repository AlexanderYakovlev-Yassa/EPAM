package by.epam.programming_with_classes.triangle.logic;

import by.epam.programming_with_classes.triangle.objects.Line;
import by.epam.programming_with_classes.triangle.objects.Point;
import by.epam.programming_with_classes.triangle.objects.Triangle;

public class Logic {

    private boolean isEachPointUnique(Point a, Point b, Point c) {
        return !(a.equals(b)) &&
                !(a.equals(c)) &&
                !(b.equals(c));
    }

    private boolean isPointsNotInSameLine(Point a, Point b, Point c) {

        boolean res;

        if (isEachPointUnique(a, b, c)) {
            if (a.getX() == b.getX()) {
                if (a.getX() == c.getX()) {
                    res = false;// a and b are vertical a and c are not
                } else {
                    res = true;// a, b and c are vertical
                }
            } else {
                if (a.getX() == c.getX()) {
                    res = true; //a and c are vertical a and b are not
                } else {
                    res = tgXY(a, b) == tgXY(a, c);// a, b and c are not vertical
                }
            }
        } else {
            res = false;
        }

        return res;
    }

    private boolean isTriangleExist(Triangle triangle) {

        boolean res;

        if (triangle.getA() != null && triangle.getB() != null && triangle.getC() != null) {

            res = isPointsNotInSameLine(triangle.getA(), triangle.getB(), triangle.getC());
        } else {

            res = false;
        }

        return  res;
    }

    public double perimeter(Triangle triangle) {

        if (isTriangleExist(triangle)) {
            double lengthAB = lineLength(triangle.getA(), triangle.getB());
            double lengthBC = lineLength(triangle.getB(), triangle.getC());
            double lengthAC = lineLength(triangle.getA(), triangle.getC());
            return lengthAB + lengthAC + lengthBC;
        } else {
            return -1;
        }
    }

    private static double lineLength(Point a, Point b) {
        int dX = a.getX() - b.getX();
        int dY = a.getY() - b.getY();
        double lineLength = Math.sqrt(dX * dX + dY * dY);
        return lineLength;
    }

    public double area(Triangle triangle) {
        if (isTriangleExist(triangle)) {
            double lengthAB = lineLength(triangle.getA(), triangle.getB());
            double lengthBC = lineLength(triangle.getB(), triangle.getC());
            double lengthAC = lineLength(triangle.getA(), triangle.getC());
            double p = perimeter(triangle) / 2;
            return Math.sqrt(p * (p - lengthAB) * (p - lengthBC) * (p - lengthAC));
        } else {
            return -1;
        }
    }

    public Point mediansIntersection(Triangle triangle) {

        Point i = new Point();
        Line kA;
        Line kB;

        if (isTriangleExist(triangle)) {
            Point ma = midPoint(triangle.getB(), triangle.getC());
            Point mb = midPoint(triangle.getA(), triangle.getC());

            if (triangle.getA().getX() == mb.getX()) { //to avoid division by zero. The median is vertical line.
                i.setX(triangle.getA().getX());
                kB = takeLine(mb, triangle.getB());
                i.setY((int) (kB.getCoeffA() * i.getX() + kB.getCoeffB()));
            } else if (triangle.getB().getX() == mb.getX()) { //to avoid division by zero. The median is vertical line.
                i.setX(triangle.getB().getX());
                kA = takeLine(ma, triangle.getA());
                i.setY(ma.getX() * i.getX() + ma.getY());
            } else {
                kB = takeLine(mb, triangle.getB());
                kA = takeLine(ma, triangle.getA());
                i.setY((int) ((kB.getCoeffB() - kA.getCoeffB()) / (kA.getCoeffA() - kB.getCoeffA())));
                i.setX((int) (kA.getCoeffA() * i.getY() + kA.getCoeffB()));
            }
        } else {
            i = null;
        }
        return i;
    }

    private static Line takeLine(Point a, Point b) {
        Line line = new Line();

        line.setCoeffA((a.getY() - b.getY()) / (a.getX() - b.getX()));
        line.setCoeffB(a.getY() - line.getCoeffA() * a.getX());

        return line;
    }

    private Point midPoint(Point a, Point b) {
        Point m = null;

        if (a != null && a != null) {
            m = new Point();
            m.setX(a.getX() + (b.getX() - a.getX()) / 2);
            m.setY(a.getY() + (b.getY() - a.getY()) / 2);
        }

        return m;
    }

    private double tgXY(Point x, Point y){
        return (x.getY() - y.getY()) / (x.getX() - y.getX());
    }
}
