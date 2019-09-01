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

    public double perimeter() {
        double sideABLength = sideLength(aX, aY, bX, bY);
        double sideBCLength = sideLength(bX, bY, cX, cY);
        double sideACLength = sideLength(aX, aY, cX, cY);
        double perimeter = sideABLength + sideBCLength + sideACLength;
        return perimeter;
    }

    public double area() {
        double sideABLength = sideLength(aX, aY, bX, bY);
        double sideBCLength = sideLength(bX, bY, cX, cY);
        double sideACLength = sideLength(aX, aY, cX, cY);
        double halfPerimeter = perimeter() / 2;
        double area = Math.sqrt(halfPerimeter * (halfPerimeter - sideABLength) * (halfPerimeter - sideBCLength) * (halfPerimeter - sideACLength));
        return area;
    }

    public boolean isInSameLine() {
        //double tolerance = 0.0001;
        double dX1 = aX - bX;
        double dX2 = aX - cX;
        double dY1 = aY - bY;
        double dY2 = aY - cY;

        boolean res;
        if ((dX1 == 0) || (dX2 == 0)) {                                       //
            if (((dX1 == 0) && (dY1 == 0)) || ((dX2 == 0) && (dY2 == 0))) {   // this part is for avoid
                res = true;                                                   //   division by zero
            } else {                                                          //
                res = false;                                                  //
            }
        } else {
            double tg1 = (double) dY1 / (double) dX1;
            double tg2 = (double) dY2 / (double) dX2;
            if (tg1 == tg2) {
                res = true;
            } else {
                res = false;
            }
        }
        return res;
    }
}
