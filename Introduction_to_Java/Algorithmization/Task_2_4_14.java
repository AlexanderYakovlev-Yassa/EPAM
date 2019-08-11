/*Натуральное число, в записи которого n цифр, называется числом Армстронга,
 если сумма его цифр, возведенная (очевидна опечатка "возведенных") в степень n, равна самому числу.
 Найти все числа Армстронга от 1 до k. Для решения задачи использовать декомпозицию*/

import java.lang.Math;
public class Task_2_4_14 {

    public static void main(String[] args) {
        int k = 500;
        printArmstrongNumbers(k);
    }

    //prints armstrong numbers from 1 to k (but k can't be bigger than 2147483647)
    public  static void printArmstrongNumbers(int k){
        for (int i = 1; i <= k; i++) {
            if (isArmstrongNumber(i)){
                System.out.println(i);
            }
        }
    }
    //checks whether the number is the Armstrong's number
    public static boolean isArmstrongNumber(int n) {
        boolean res = false;
        int[] digits = arrayOfDigits(n);
        int exp = digits.length;
        int a = 0;

        for (int i = 0; i < digits.length; i++) {
            a += Math.pow(digits[i], exp);
        }
        if (n == a) {
            res = true;
        }

        return res;
    }

    //returns array of digits which are contained in "number"
    public static int[] arrayOfDigits(int number) {
        int p = (int) Math.log10(number);
        int[] digits = new int[p + 1];
        int a = (int) Math.pow(10, p);
        int i = 0;
        while (a > 0) {
            digits[i] = number / a;
            number = number - digits[i] * a;
            i++;
            a /= 10;
        }
        return digits;
    }
}
