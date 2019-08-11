/*Найти все натуральные n-значные числа, цифры в которых образуют строго
 возрастающую последовательность (например, 1234, 5789).
 Для решения задачи использовать декомпозицию.*/

import java.lang.Math;
import java.util.Scanner;

public class Task_2_4_15 {
    public static void main(String[] args) {
        printAllIncreasing(insertNumber());
    }

    public static int insertNumber() {
        int k = 0;
        while ((k < 1) || (k > 9)) {
            System.out.print("Введите количество разрядов числа от 1 до 9 >");
            k = insertFromKeyBoard();
        }
        return k;
    }

    private static int insertFromKeyBoard() {
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()) {
            System.out.print("Введите целое число >");
            scan.nextLine();
        }
        int k = scan.nextInt();
        return k;

    }

    //prints all numbers that have n digits, and these digits form a strictly increasing sequence
    public static void printAllIncreasing(int n) {
        if (n < 1) {

        }
        int[] arr;
        int i = (int) Math.pow(10, n - 1);
        int k = 0;
        int c = 0;
        int exp;

        for (int j = 0; j < n; j++) {
            k += Math.pow(10, j) * (9 - j);
        }
        System.out.println("\nВсе " + n + " значные числа у которых цифры составляют строго возрастающую последовательность:");
        while (i <= k) {
            arr = arrayOfDigits(i);
            if (arr[0] <= (10 - arr.length)) {
                if (isIncreasing(arr)) {
                    if ((c % 10 == 0) && (c != 0)) {
                        System.out.println("");
                    }
                    System.out.print("[" + i + "] ");
                    c++;
                }
            } else if (i == 123456790) {
                break;
            } else {
                exp = (int) (Math.log10(i)) + 1;
                i = ((int) Math.pow(10, exp)) - 1;
            }
            i++;
        }
    }

    //checks whether members of the array are constantly increasing
    public static boolean isIncreasing(int[] array) {
        int i = 0;
        boolean flag = true;
        while (i < array.length - 1) {
            if (array[i] < array[i + 1]) {
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
}
