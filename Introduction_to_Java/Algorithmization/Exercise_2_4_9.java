import java.util.Scanner;
import java.lang.Math;

public class Exercise_2_4_9 {

    public static void main(String[] args) {

        double[] sides = insertQuadrangleSidesLength();
        //System.out.println(areaOfRightTriangle(3,4));
        //System.out.println(areaOfTriangle(3,4,5));
        System.out.println(areaOfQuadrangle(sides));

    }

    public static double areaOfQuadrangle(double[] sides){
        double area = 0;
        double p = (sides[0] + sides[1] + sides[2] + sides[3]) / 2;
        area = Math.sqrt((p - sides[0]) * (p - sides[1]) *(p - sides[2]) *(p - sides[3]));
        return area;
    }

    //returns the area of a right triangle in two legs
    public static double areaOfRightTriangle(double leg_1, double leg_2) {
        double area = leg_1 * leg_2 / 2;
        return area;
    }

    //returns the area of a triangle on three sides
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
