// Найдите значение функции: z = ( (a – 3 ) * b / 2) + c.

public class Task_1_1_1 {
    public static void main(String[] args) {
        System.out.println(zFunction(5, 3, 58));
    }

    public static double zFunction(double a, double b, double c) {
        double z = ((a - 3) * b / 2) + c;
        return z;
    }
}
