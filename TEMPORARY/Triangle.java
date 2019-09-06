/*7. Описать класс, представляющий треугольник.
Предусмотреть методы для создания объектов,
вычисления площади, периметра и точки пересечения медиан.*/

import java.lang.Math;
import java.util.Objects;

/*
 * class represents triangle with vertices A(xA, yA) B(xB, yB) C(xC, yC)
 * */
public class Triangle {
    private double xA;
    private double yA;
    private double xB;
    private double yB;
    private double xC;
    private double yC;
    private boolean exist;

    public Triangle(double xA, double yA, double xB, double yB, double xC, double yC) {
        this.xA = xA;
        this.yA = yA;
        this.xB = xB;
        this.yB = yB;
        this.xC = xC;
        this.yC = yC;
        this.exist = isTriangleExist(xA, yA, xB, yB, xC, yC);
    }

    private static boolean isEachPointsExist(double xA, double yA, double xB, double yB, double xC, double yC) {
        return (!Double.isNaN(xA) && !Double.isInfinite(xA)) && (!Double.isNaN(yA) && !Double.isInfinite(yA)) &&
                (!Double.isNaN(xB) && !Double.isInfinite(xB)) && (!Double.isNaN(yB) && !Double.isInfinite(yB)) &&
                (!Double.isNaN(xC) && !Double.isInfinite(xC)) && (!Double.isNaN(yC) && !Double.isInfinite(yC));
    }

    private static boolean isEachPointUnique(double xA, double yA, double xB, double yB, double xC, double yC) {
        return !((xA == xB) && (yA == yB)) &&
                !((xA == xC) && (yA == yC)) &&
                !((xB == xC) && (yB == yC));
    }

    private static boolean isPointsNotInSameLine(double xA, double yA, double xB, double yB, double xC, double yC) {
        double tgAB = (yA - yB) / (xA - xB);
        double tgAC = (yA - yC) / (xA - xC);
        return tgAB != tgAC;
    }

    private static boolean isTriangleExist(double xA, double yA, double xB, double yB, double xC, double yC) {
        return isEachPointsExist(xA, yA, xB, yB, xC, yC) &&
                isEachPointUnique(xA, yA, xB, yB, xC, yC) &&
                isPointsNotInSameLine(xA, yA, xB, yB, xC, yC);
    }

    public double getxA() {
        return xA;
    }

    public double getyA() {
        return yA;
    }

    public double getxB() {
        return xB;
    }

    public double getyB() {
        return yB;
    }

    public double getxC() {
        return xC;
    }

    public double getyC() {
        return yC;
    }

    public boolean isExist() {
        return exist;
    }

    private static double lineLength(double xA, double yA, double xB, double yB) {
        double dX = xA - xB;
        double dY = yA - yB;
        double lineLength = Math.sqrt(dX * dX + dY * dY);
        return lineLength;
    }

    public double perimeter() {
        if (exist) {
            double lengthAB = lineLength(xA, yA, xB, yB);
            double lengthBC = lineLength(xB, yB, xC, yC);
            double lengthAC = lineLength(xA, yA, xC, yC);
            return lengthAB + lengthAC + lengthBC;
        } else {
            return -1;
        }
    }

    public double area() {
        if (exist) {
            double lengthAB = lineLength(xA, yA, xB, yB);
            double lengthBC = lineLength(xB, yB, xC, yC);
            double lengthAC = lineLength(xA, yA, xC, yC);
            double p = this.perimeter() / 2;
            return Math.sqrt(p * (p - lengthAB) * (p - lengthBC) * (p - lengthAC));
        } else {
            return -1;
        }
    }

    //Returns the middle point between A and B
    private static double[] midPoint(double xA, double yA, double xB, double yB) {
        double[] m = new double[2];
        m[0] = xA + (xB - xA) / 2;
        m[1] = yA + (yB - yA) / 2;
        return m;
    }

    //Returns the coefficients of an equation of line (Y = A*X + B) [0] = A, [1] = B
    private static double[] lineCoeff(double xA, double yA, double xB, double yB) {
        double[] koeff = new double[2];

            koeff[0] = (yA - yB) / (xA - xB);
            koeff[1] = yA - koeff[0] * xA;

        return koeff;
    }

    public double[] mediansIntersection() {
        double i[] = new double[2];
        double[] kA = new double[2];
        double[] kB = new double[2];
        if (exist) {
            double[] mBC = midPoint(xB, yB, xC, yC);//middle point of the edge BC [0] = X, [1] = Y
            double[] mAC = midPoint(xA, yA, xC, yC);//middle point of the edge AC [0] = X, [1] = Y
            double xMA = mBC[0];
            double yMA = mBC[1];
            double xMB = mAC[0];
            double yMB = mAC[1];
            if (xA == xMA) { //to avoid division by zero. The median is vertical line.
                i[0] = xA;
                kB = lineCoeff(xMB, yMB, xB, yB);
                i[1] = kB[0] * i[0] + kB[1];
            } else if (xB == xMB) { //to avoid division by zero. The median is vertical line.
                i[0] = xB;
                kA = lineCoeff(xMA, yMA, xA, yA);
                i[1] = kA[0] * i[0] + kA[1];
            } else {
                kB = lineCoeff(xMB, yMB, xB, yB);
                kA = lineCoeff(xMA, yMA, xA, yA);
                i[1] = (kB[1] - kA[1]) / (kA[0] - kB[0]);
                i[0] = kA[0] * i[1] + kA[1];
            }
        } else {
            i[0] = Double.NaN;
            i[1] = Double.NaN;
        }
        return i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle that = (Triangle) o;
        return Double.compare(that.xA, xA) == 0 &&
                Double.compare(that.yA, yA) == 0 &&
                Double.compare(that.xB, xB) == 0 &&
                Double.compare(that.yB, yB) == 0 &&
                Double.compare(that.xC, xC) == 0 &&
                Double.compare(that.yC, yC) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xA, yA, xB, yB, xC, yC);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "A(" + xA +
                ", " + yA +
                "); B(" + xB +
                ", " + yB +
                "); C(" + xC +
                ", " + yC +
                "); exist=" + exist +
                '}';
    }
}
