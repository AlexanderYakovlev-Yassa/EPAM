/*Дано натуральное число N. Написать метод(методы)
для формирования массива, элементами которого являются цифры числа N.*/

import java.lang.Math;

public class Exercise_2_4_10 {

    public static void main(String[] args) {
        int n = 0;
        printArray(arrayOfDigits(-152));

    }

    //returns array of digits which are contained in "number"
    public static int[] arrayOfDigits(int number) {
        number = Math.abs(number);
        int p = number == 0 ? 1 : (int) Math.log10(number) + 1;
        int[] digits = new int[p];
        int a = (int) Math.pow(10, p - 1);
        int i = 0;
        while (a > 0) {
            digits[i] = number / a;
            number = number - digits[i] * a;
            i++;
            a /= 10;
        }
        return digits;
    }

    //print the array "array"
    public static void printArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + array[i] + "]  ");
        }
        System.out.println("");
    }
}
