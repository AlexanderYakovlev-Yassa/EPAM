import java.util.Scanner;
import java.lang.Math;

public class Task_2_4_9 {

    public static void main(String[] args) {

        double[] sides = insertQuadrangleSidesLength();

        double[] quadrangle = areaOfQuadrangle(sides);
        if ((quadrangle[0] > 0) && (quadrangle[2] > 0)) {
            System.out.println("Для данного набора длинн сторон существует два типа четыречугольников:");
            if (quadrangle[0] == 1) {
                System.out.println("Выпуклый четырехугольник с площадью " + quadrangle[1] + " квадратных единиц.");
            } else {
                System.out.println("Невыпуклый четырехугольник с площадью " + quadrangle[1] + " квадратных единиц.");
            }
            if (quadrangle[2] == 2){
                System.out.println("Невыпуклый четырехугольник с площадью " + quadrangle[3] + " квадратных единиц.");
            } else {
                System.out.println("Самопересекающийся четырехугольник с площадью " + quadrangle[3] + " квадратных единиц.");
            }
        } else if ((quadrangle[2] == 0) && (quadrangle[0] == 1)){
            System.out.println("Для данного набора длинн сторон существует выпуклый четыречугольник \n с площадью " + quadrangle[1] + " квадратных единиц.");
        } else if ((quadrangle[2] == 0) && (quadrangle[0] == 2)) {
            System.out.println("Для данного набора длинн сторон существует невыпуклый четыречугольник \n с площадью " + quadrangle[1] + " квадратных единиц.");
        } else if ((quadrangle[2] == 2) && (quadrangle[0] == 0)) {
            System.out.println("Для данного набора длинн сторон существует невыпуклый четыречугольник \n с площадью " + quadrangle[3] + " квадратных единиц.");
        } else if ((quadrangle[2] == 3) && (quadrangle[0] == 0)) {
            System.out.println("Для данного набора длинн сторон существует самопересекающийся четыречугольник \n с площадью " + quadrangle[3] + " квадратных единиц.");
        }
    }

    //returns the array of double which members are:
    //[0] - first quadrangle type
    //[1] - first quadrangle area
    //[2] - second quadrangle type
    //[3] - second quadrangle area
    public static double[] areaOfQuadrangle(double[] sides) {

        double[] area = new double[4];
        double areaOfFirstQuadrangle = 0;
        double firstQuadrangleType = 0;//type of quadrangle 0 - doesn't exist, 1 - convex, 2 - non convex
        double secondQuadrangleType = 0;//type of quadrangle 0 - doesn't exist, 2 - non convex, 3 - self-intersecting
        double p = (sides[0] + sides[1] + sides[2] + sides[3]) / 2;

        double x = sides[0];
        double y = sides[1];
        double z = sides[2];
        double t = sides[3];

        double e = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));//hypotenuse of triangle X Y E
        double angleZE = angleOfTriangleThreeSide(z, e, t);
        double angleTE = angleOfTriangleThreeSide(t, e, z);
        double angleYE = Math.acos(y / e);
        double angleXE = Math.acos(x / e);
        double areaOf_X_Y_SidesTriangle = areaOfRightTriangle(x, y);
        double areaOf_Z_T_SidesTriangle = areaOfTriangle(z, t, e);
        System.out.println(areaOf_Z_T_SidesTriangle);

        if ((Math.PI != (angleYE + angleZE)) && (Math.PI != (angleXE + angleTE))) {
            areaOfFirstQuadrangle = areaOf_X_Y_SidesTriangle + areaOf_Z_T_SidesTriangle;

            if ((Math.PI < (angleYE + angleZE)) || (Math.PI < (angleXE + angleTE))) {
                firstQuadrangleType = 2;
            } else {
                firstQuadrangleType = 1;
            }
        } else {
            firstQuadrangleType = 0;
        }

        double angleYZ = 0;
        double angleXT = 0;
        double areaOfFirstTriangle = 0;
        double areaOfSecondTriangle = 0;

        double areaOfSecondQuadrangle = 0;


        if ((angleYE > angleZE) && (angleXE > angleTE)) {
            areaOfSecondQuadrangle = areaOf_X_Y_SidesTriangle - areaOf_Z_T_SidesTriangle;
            secondQuadrangleType = 2;

        } else if ((angleYE < angleZE) && (angleXE < angleTE)) {
            areaOfSecondQuadrangle = areaOf_Z_T_SidesTriangle - areaOf_X_Y_SidesTriangle;
            secondQuadrangleType = 2;

        } else if ((angleYE > angleZE) && (angleXE < angleTE)) {
            angleYZ = angleYE - angleZE;
            angleXT = angleTE - angleXE;
            double angleZT = Math.PI - angleZE - angleTE;
            System.out.println("xt=" + angleXT + "  zt=" + angleZT);
            areaOfFirstTriangle = areaOfTriangleSideAndTwoAngles(y, angleYZ, Math.PI / 2);
            areaOfSecondTriangle = areaOfTriangleSideAndTwoAngles(t, angleXT, angleZT);
            areaOfSecondQuadrangle = areaOfFirstTriangle + areaOfSecondTriangle;
            secondQuadrangleType = 3;
        } else if ((angleYE < angleZE) && (angleXE > angleTE)) {
            angleYZ = angleZE - angleYE;
            angleXT = angleXE - angleTE;
            double angleZT = Math.PI / 2 - angleYZ + angleXT;
            areaOfFirstTriangle = areaOfTriangleSideAndTwoAngles(x, angleXT, Math.PI / 2);
            areaOfSecondTriangle = areaOfTriangleSideAndTwoAngles(z, angleYZ, angleZT);
            areaOfSecondQuadrangle = areaOfFirstTriangle + areaOfSecondTriangle;
            secondQuadrangleType = 3;
        } else {
            secondQuadrangleType = 0;
        }

        area[0] = firstQuadrangleType;
        area[1] = areaOfFirstQuadrangle;
        area[2] = secondQuadrangleType;
        area[3] = areaOfSecondQuadrangle;

        return area;
    }

    //returns area of triangle (side-side-side)
    public static double angleOfTriangleThreeSide(double adjasentSide_1, double adjasentSide_2, double oppositeSide) {
        double angle = Math.acos((Math.pow(adjasentSide_1, 2) + Math.pow(adjasentSide_2, 2) - Math.pow(oppositeSide, 2)) / (2 * adjasentSide_1 * adjasentSide_2));
        return angle;
    }

    //returns area of triangle (angle-side-angle)
    public static double areaOfTriangleSideAndTwoAngles(double side, double alpha, double beta) {
        double area = Math.pow(side, 2) / 2 * Math.sin(alpha) * Math.sin(beta) / Math.sin(alpha + beta);
        return area;
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