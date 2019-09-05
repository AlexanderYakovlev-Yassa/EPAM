import java.lang.Math;

public class Triangle_1 {
    private double xA;
    private double yA;
    private double xB;
    private double yB;
    private double xC;
    private double yC;
    private boolean exist;

    public Triangle_1(double xA, double yA, double xB, double yB, double xC, double yC) {
        this.xA = xA;
        this.yA = yA;
        this.xB = xB;
        this.yB = yB;
        this.xC = xC;
        this.yC = yC;
        this.exist = isTriangleExist(xA, yA, xB, yB, xC, yC);
    }

    public static void main(String[] args) {
        double x = Double.NaN;//
        double y = Double.MAX_VALUE;//0;

        Triangle_1 t = new Triangle_1(5, 0, -95, 100, 105, 100);
        System.out.println(t.exist);
        System.out.println(t.perimeter());
        System.out.println(t.area());
        double[] mid = midPoint(t.xA, t.yA, t.xB, t.yB);
        System.out.println(mid[0] + "  " + mid[1]);
        double[] mI = t.mediansIntersection();
        System.out.println(mI[0] + "  " + mI[1]);
    }

    private static boolean isEachPointsExist(double xA, double yA, double xB, double yB, double xC, double yC) {//checked
        return (!Double.isNaN(xA) && !Double.isInfinite(xA)) && (!Double.isNaN(yA) && !Double.isInfinite(yA)) &&
                (!Double.isNaN(xB) && !Double.isInfinite(xB)) && (!Double.isNaN(yB) && !Double.isInfinite(yB)) &&
                (!Double.isNaN(xC) && !Double.isInfinite(xC)) && (!Double.isNaN(yC) && !Double.isInfinite(yC));
    }

    private static boolean isEachPointUnique(double xA, double yA, double xB, double yB, double xC, double yC) {//checked
        return !((xA == xB) && (yA == yB)) &&
                !((xA == xC) && (yA == yC)) &&
                !((xB == xC) && (yB == yC));
    }

    private static boolean isPointsNotInSameLine(double xA, double yA, double xB, double yB, double xC, double yC) {//checked
        double tgAB = (yA - yB) / (xA - xB);
        double tgAC = (yA - yC) / (xA - xC);
        return tgAB != tgAC;
    }

    private static boolean isTriangleExist(double xA, double yA, double xB, double yB, double xC, double yC) {//checked
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

    public double perimeter() {//checked
        if (exist) {
            double lengthAB = lineLength(xA, yA, xB, yB);
            double lengthBC = lineLength(xB, yB, xC, yC);
            double lengthAC = lineLength(xA, yA, xC, yC);
            return lengthAB + lengthAC + lengthBC;
        } else {
            return -1;
        }
    }

    public double area() {//checked
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

    private static double[] midPoint(double xA, double yA, double xB, double yB) {//checked
        double[] m = new double[2];
        m[0] = xA + (xB - xA) / 2;
        m[1] = yA + (yB - yA) / 2;
        return m;
    }

    private static double[] lineKoeff(double xA, double yA, double xB, double yB){
        double[] koeff = new double[2];
        if (xA == xB){
            koeff[0] = Double.NaN;
            koeff[1] = Double.NaN;
        } else {
            koeff[0] = (yA - yB) / (xA - xB);
            koeff[1] = yA - koeff[0] * xA;
        }
        return koeff;
    }

    public double[] mediansIntersection() {
        double i[] = new double[2];
        double[] kA = new double[2];
        double[] kB = new double[2];
        if (exist) {
            double[] mBC = midPoint(xB, yB, xC, yC);//mBC ... A
            double[] mAC = midPoint(xA, yA, xC, yC);//mAC ... B
            double xMA = mBC[0];
            double yMA = mBC[1];
            double xMB = mAC[0];
            double yMB = mAC[1];
                if(xA == xMA){
                    i[0] = xA;
                    kB = lineKoeff(xMB,yMB,xB,yB);
                    i[1] = kB[0] * i[0] + kB[1];
                } else if (xB == xMB) {
                    i[0] = xB;
                    kA = lineKoeff(xMA,yMA,xA,yA);
                    i[1] = kA[0] * i[0] + kA[1];
                } else {
                    kB = lineKoeff(xMB,yMB,xB,yB);
                    kA = lineKoeff(xMA,yMA,xA,yA);
                    i[1] = (kB[1] - kA[1])/(kA[0] - kB[0]);
                    i[0] = kA[0] * i[1] + kA[1];
                }
        } else {
            i[0] = Double.NaN;
            i[1] = Double.NaN;
        }
        return i;
    }
}
