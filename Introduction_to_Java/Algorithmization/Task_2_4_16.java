/*Написать программу, определяющую сумму
n - значных чисел, содержащих только нечетные цифры.
Определить также, сколько четных цифр в найденной сумме.
Для решения задачи использовать декомпозицию*/

import java.lang.Math;
import java.util.Scanner;

public class Task_2_4_16 {
    public static void main(String[] args) {

        int n = insertNumber();
        int[] odd = allNumbersWithOddDigits(n);
        int summOfOdd = summ(odd);
        System.out.println("");
        System.out.println("The sum of all the numbers which have " + n + " digits \nand all those digits are odd is " + summOfOdd);
        int numberOfEven = numberOfEven(summOfOdd);
        if (numberOfEven == 0){
            System.out.println("This sum doesn't have even numbers.");
        } else if (numberOfEven == 1){
            System.out.println("This sum has one even number.");
        } else {
            System.out.println("This sum has " + numberOfEven + " even numbers.");
        }
    }

    public static int numberOfEven(int n){
        int[] arrOfDigits = arrayOfDigits(n);
        int evens = 0;
        for (int i = 0; i < arrOfDigits.length; i++) {
            if (arrOfDigits[i] % 2 == 0){
                evens++;
            }
        }
        return evens;
    }

    public static int summ(int[] numbers){
        int summ = 0;
        for (int i = 0; i < numbers.length; i++){
            summ = summ + numbers[i];
        }
        return summ;
    }

    public static int insertNumber() {
        int k = 0;
        while ((k < 1) || (k > 9)) {
            System.out.print("Insert a number of digits from 1 to 9 >");
            k = insertFromKeyBoard();
        }
        return k;
    }

    //provides an input of an integer number from the keyboard
    private static int insertFromKeyBoard() {
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()) {
            System.out.print("Insert an integer number >");
            scan.nextLine();
        }
        int k = scan.nextInt();
        return k;
    }

    //returns array of all numbers which have n digits and all these digits are odd
    public static int[] allNumbersWithOddDigits(int n) {

        int[] arr = new int[0];
        int[] res = new int[0];
        int i = (int) Math.pow(10, n - 1);
        int k = (int) Math.pow(10, n) - 1;

        while (i <= k) {

            arr = arrayOfDigits(i);
            if (isAllDigitsOdd(arr)) {
                res = appendToArray(res, i);
            }
            i++;
        }
        return res;
    }

    //checks whether members of the array are odd numbers
    public static boolean isAllDigitsOdd(int[] array) {
        int i = 0;
        boolean flag = true;
        while (i < array.length) {
            if (array[i] % 2 != 0) {
                i++;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    //returns array of digits which are contained in "number"
    public static int[] arrayOfDigits(int number) {
        int p;
        if (number == 0) {
            p = 0;
        } else {
            p = (int) Math.log10(number);
        }
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

    //appends number(member) to the array and returns the new array
    private static int[] appendToArray(int[] array, int number) {
        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[newArray.length - 1] = number;
        return newArray;
    }
}