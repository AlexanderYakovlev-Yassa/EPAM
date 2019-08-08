import java.util.Scanner;
import java.lang.Math;

public class Exercise_2_4_9 {

    public static void main(String[] args) {

        double[] sides = insertQuadrangleSidesLength();
        //System.out.println(areaOfRightTriangle(3,4));
        //System.out.println(areaOfTriangle(3,4,5));
        System.out.println(areaOfQuadrangle(sides));

    }

    public static double[] areaOfQuadrangle(double[] sides) {
        double[] area = new double[2];
        double p = (sides[0] + sides[1] + sides[2] + sides[3]) / 2;
        //area = Math.sqrt((p - sides[0]) * (p - sides[1]) *(p - sides[2]) *(p - sides[3]));
        double x = sides[0];
        double y = sides[1];
        double z = sides[2];
        double t = sides[3];
        double areaOf_X_Y_SidesTriangle = areaOfRightTriangle(x, y);
        double e = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));//hypotenuse of triangle X Y E
        double areaOf_Z_T_SidesTriangle = areaOfTriangle(z, t, e);
        double areaOfConvexQuadrangle = areaOf_X_Y_SidesTriangle + areaOf_Z_T_SidesTriangle;

        double areaOfSelfIntersectingQuadrangle = 0;
        double angleAlphaSinus = x / e;
        double angleBetaSinus = y / e;
        double k = Math.pow(e, 2) - Math.pow(t, 2) + Math.pow(z, 2);
        double h = Math.sqrt(Math.pow(z, 2) - Math.pow(k / (2 * e), 2));
        double angleHammaSinus = h / z;
        double angleDeltaSinus = h / t;
        if ((angleAlphaSinus > angleDeltaSinus) && (angleBetaSinus > angleHammaSinus)) {
            double areaOfNonConvexQuadrangle = areaOf_X_Y_SidesTriangle - areaOf_Z_T_SidesTriangle;
        } else if ((angleAlphaSinus < angleDeltaSinus) && (angleBetaSinus < angleHammaSinus)) {
            double areaOfNonConvexQuadrangle = areaOf_Z_T_SidesTriangle - areaOf_X_Y_SidesTriangle;
        } else if ((angleAlphaSinus > angleDeltaSinus) && (angleBetaSinus < angleHammaSinus)){
            double angleAlpfa = Math.asin(angleAlphaSinus);
            double angleDelta = Math.asin(angleDeltaSinus);
            double angleMu = angleAlpfa - angleDelta;
            double areaOfFirstTriangle = areaOfTriangleSideAndTwoAngles(y,angleMu,Math.PI/2);
            double angleNu = Math.PI/2-angleMu;
            double angleBeta = Math.asin(angleBetaSinus);
            double angleHamma = Math.asin(angleHammaSinus);
            double angleFi = angleHamma - angleBeta;
            double angleEpsilon = Math.PI - angleFi - angleNu;
            double areaOfSecondTriangle = areaOfTriangleSideAndTwoAngles(z,angleEpsilon,angleFi);
            double areaOfSelfCrossedQuadrangle = areaOfFirstTriangle + areaOfSecondTriangle;
        }

        //area = ;
        return area;
    }
    //returns area of triangle (angle-side-angle)
    public static double areaOfTriangleSideAndTwoAngles(double side, double alpha, double beta){
        double area = Math.pow(side, 2) / 2 * Math.sin(alpha) * Math.sin(beta)/ Math.sin(alpha + beta);
        return  area;
    }

    //returns the area of a right triangle (side-right angle-side)
    public static double areaOfRightTriangle(double leg_1, double leg_2) {
        double area = leg_1 * leg_2 / 2;
        return area;
    }

    //returns the area of a triangle (side-side-side)
    public static double areaOfTriangle(double side_a, double side_b, double side_c) {
        double p = (side_a + side_b + side_c) / 2;
        double area = Math.sqrt(p * (p - side_a) * (p - side_b) * (p - side_c));
        return area;
    }

    public static double[] insertQuadrangleSidesLength() {
        double[] sides = new double[4];
        double sZT;
        sides[0] = inputOneSideLength("X");
        sides[1] = inputOneSideLength("Y");
        double diagonalXY = Math.sqrt(Math.pow(sides[0], 2) + Math.pow(sides[1], 2));
        do {
            sides[2] = inputOneSideLength("Z");
            sides[3] = inputOneSideLength("T");
            sZT = sides[2] + sides[3];
            if (sZT <= diagonalXY) {
                System.out.println("Стороны Z и T в сумме должны быть больше,\n чем диагональ четырехугольника.\n" +
                        "Введите такие длины сторон Z и T,\n чтобы их сумма была больше " + diagonalXY);
            }
        } while (sZT <= diagonalXY);
        return sides;
    }

    //the check for non zero side length
    private static double inputOneSideLength(String sideName) {
        double x;
        do {
            System.out.print("Введите длину стороны " + sideName + " >");
            x = inputDouble();
            if (x <= 0) {
                System.out.println("Число должно быть больше нуля");
            }
        } while (x <= 0);
        return x;
    }

    //the input of double type variable
    private static double inputDouble() {
        Scanner scan = new Scanner(System.in);

        while (!scan.hasNextDouble()) {
            scan.next();
            System.out.print("Необходимо ввести число >");
        }
        double x = scan.nextDouble();

        return x;
    }
}