/*Из заданного числа вычли сумму его цифр.
Из результата вновь вычли сумму его цифр и т.д.
Сколько таких действий надо произвести, чтобы получился нуль?
Для решения задачи использовать декомпозицию.*/

import java.lang.Math;

public class Task_2_4_17 {

    public static void main(String[] args) {
        int num = -500;
        System.out.println("Исходное число: " + num);
        System.out.print("Количество необходимых трансформаций равно " );
        System.out.println(numberOfAvailableTransformations(num));

    }

    public static int numberOfAvailableTransformations(int number){
        int count = 0;
        number = Math.abs(number);
        while (number > 0){
            number = transformation(number);
            count++;
        }
        return count;
    }

    public static int transformation(int sourseNumber){
        int result;
        int sum = 0;
        int[] digits = arrayOfDigits(sourseNumber);
        for (int i = 0; i < digits.length; i++){
            sum += digits[i];
        }
        result = sourseNumber - sum;
        return result;
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
