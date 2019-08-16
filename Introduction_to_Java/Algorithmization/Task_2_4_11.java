/*Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр.*/

import java.lang.Math;
public class Task_2_4_11 {
    public static void main(String[] args) {
        int a = 65289;
        int b = 21900;
        int res = compareNumberOfDigits(a, b);
        if (res == 1) {
            System.out.println("В числе " + a + " больше цифр чем в числе " + b + ".");
        } else if (res == -1) {
            System.out.println("В числе " + a + " меньше цифр чем в числе " + b + ".");
        } else if (res == 0) {
            System.out.println("В числах " + a + " и " + b + " одинаковое количество цифр.");
        } else {
            System.out.println("Что-то пошло не так!!!");
        }
        //System.out.println(compareNumberOfDigits(a, b));
    }

    //compare number of digits of two numbers
    //returns 1 if first number has more digits than second number
    //returns -1 if first number has fewer digits than second number
    //returns 0 if first and second numbers has same number of digits
    public static int compareNumberOfDigits(int n_1, int n_2){
        int res;
        int dig_1 = numberOfDigits(n_1);
        int dig_2 = numberOfDigits(n_2);

        if (dig_1 > dig_2){
            res = 1;
        } else if (dig_1 < dig_2) {
            res = -1;
        } else {
            res = 0;
        }
        return res;
    }

    //returns number of digits in the number n
    public static int numberOfDigits(int n){
        n = Math.abs(n);
        int num = 0;
        if (n == 0) {
            num = 1;
        } else {
            num = (int) Math.log10(n) + 1;
        }
        return num;
    }
}