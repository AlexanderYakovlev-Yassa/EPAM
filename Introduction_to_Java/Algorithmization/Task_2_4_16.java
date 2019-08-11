import java.lang.Math;
import java.util.Scanner;

public class Task_2_4_16 {
    public static void main(String[] args) {

        printAllNumbersWithOddDigits(insertNumber());
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

    //prints all numbers which have n digits and all these digits are odd
    public static void printAllNumbersWithOddDigits(int n) {

        int[] arr;
        int i = (int) Math.pow(10, n - 1);
        int k = (int) Math.pow(10, n) - 1;
        int c = 0;
        int exp;

        while (i <= k) {
            //System.out.println(i);
            arr = arrayOfDigits(i);
            if (isAllDigitsOdd(arr)) {
                if ((c % 10 == 0) && (c != 0)) {
                    System.out.println("");
                }
                System.out.print("[" + i + "] ");
                c++;

            }
            i++;
        }
    }

    //checks whether members of the array are odd numbers
    public static boolean isAllDigitsOdd(int[] array) {
        int i = 0;
        boolean flag = true;
        while (i < array.length) {
            //System.out.print(array[i] + " ");
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
}
