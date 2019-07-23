// Вычислить значение функции:

import java.lang.Math;

public class Exercise_2_5 {

    public static void main(String[] args){
        System.out.println(function_0(10));
    }

    public static double function_0(double x){
        double y = x <= 3 ? function_1(x) : function_2(x);
        return y;
    }

    public static double function_1(double x){
        double y;
        y = Math.pow(x, 2) - 3 * x + 9;
        return y;
    }

    public static double function_2(double x){
        double y;
        y = 1 / (Math.pow(x, 3) + 6);
        return y;
    }
}
