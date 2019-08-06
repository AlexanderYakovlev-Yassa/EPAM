/*Вычислить площадь правильного шестиугольника со стороной а,
 используя метод вычисления площади треугольника.*/

import java.lang.Math;

public class Exercise_2_4_3 {

    public static void main(String[] args) {
        System.out.println(equilateralHexagonArea(1));
    }


    public static double equilateralHexagonArea(double a) {
        double s = equilateralTriangleAria(a) * 6;
        return s;
    }

    public static double equilateralTriangleAria(double a) {
        final double K = 0.4330127018922193; //Math.sqrt(3) / 4;
        double s = a * a * K;
        return s;
    }
}
