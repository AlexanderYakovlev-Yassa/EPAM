/*Дано натуральное число N. Написать метод(методы)
для формирования массива, элементами которого являются цифры числа N.*/

import java.lang.Math;

public class Exercise_2_4_10 {

    public static void main(String[] args) {
        int n = 1234567890;
        printArray(arrayOfDigits(n));

    }

    //returns array of digits which are contained in "number"
    public static int[] arrayOfDigits(int number){
        int p = (int)Math.log10(number);
        int[] digits = new int[p + 1];
        int a = (int)Math.pow(10,p);
        int i = 0;
        while (a > 0){
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
