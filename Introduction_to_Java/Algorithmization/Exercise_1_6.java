/*
Задана последовательность N вещественных чисел. Вычислить сумму чисел, порядковые номера которых
являются простыми числами.
*/

import java.sql.SQLOutput;

public class Exercise_1_6 {

    public static void main(String[] args) {

        double[] a = {5.6, 6, 1, 1, 9, 1, 4.32, 1};

        for (int i = 0; i < a.length; i++) {
            System.out.print("[" + a[i] + "]   ");
        }
        double summ = summOfNumbers(a);
        System.out.println("");
        System.out.println("Summa of numbers which have an index equal of prime number is " + summ);

    }

    public static double summOfNumbers(double[] a) {

        double summ = 0;

        for (int i = 0; i < a.length; i++) {

            if (isPrimeNumber(i)) {
                summ += a[i];
            }
        }
        return summ;
    }

    //Метод определяет является ли целое число простым
    public static boolean isPrimeNumber(int num) {
        boolean flag = true;
        if ((num == 0) || (num == 1)){
            flag = false;
        }
        for (int i = 2; i < num; i++) {
            if (((num % i) == 0)) {
                flag = false;
                //System.out.println("Num=" + num);
            }
        }
        return flag;
    }
}
