/*Написать метод(методы) для нахождения наибольшего общего делителя
и наименьшего общего кратного двух натуральных чисел:*/

public class Task_2_4_1 {

    public static void main(String[] args) {
        int a = 5;
        int b = 25;
        System.out.println(greatestCommonDivisor(a, b));
        System.out.println(leastCommonMultiple(a, b));
    }

    //returns least common multiple
    public static int leastCommonMultiple(int a, int b) {
        int lcd = a * b / greatestCommonDivisor(a, b);
        return lcd;
    }

    //returns greatest common divisor of two numbers
    public static int greatestCommonDivisor(int a, int b) {
        int gcm = -1;
        if (a == b) {
            gcm = a;
        } else if ((a == 1) || (b == 1)) {
            gcm = 1;
        } else if (a == 0) {
            gcm = b;
        } else if (b == 0) {
            gcm = a;
        } else if (a % 2 == 0) {
            if (b % 2 != 0) {
                gcm = greatestCommonDivisor(a / 2, b);                //a even, b odd
            } else {
                gcm = 2 * greatestCommonDivisor(a / 2, b / 2);    //a even, b even
            }
        } else if (b % 2 == 0) {
            if (a % 2 != 0) {
                gcm = greatestCommonDivisor(a, b / 2);               //a odd, b even
            }

        } else {
            //a odd, b odd
            if (a > b) {
                gcm = greatestCommonDivisor((a - b) / 2, b);        // a > b
            } else {
                gcm = greatestCommonDivisor(a, (b - a) / 2);        // a < b
            }
        }
        return gcm;
    }
}