/*Написать метод(методы), проверяющий, являются ли данные три числа взаимно простыми.*/

public class Task_2_4_6 {

    public static void main(String[] args) {
        int a = 5;
        int b = 3;
        int c = 32;

        System.out.println(isCoPrime(a, b, c));
    }

    //checks whether n1, n2 and n3 are co prime
    public static boolean isCoPrime(int n1, int n2, int n3){
        boolean c;
        c =     (greatestCommonDivisor(n1, n2) == 1) &&
                (greatestCommonDivisor(n2, n3) == 1) &&
                (greatestCommonDivisor(n1, n3) == 1);
        return c;
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
