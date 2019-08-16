/*
В массив A [N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К.
*/


public class Task_2_1_1 {

    public static void main(String[] args) {

        int[] arrayOfReal = {1, 2, 56, 25, 4, 8, 10, 12, 3, 154};
        int k = 3;

        System.out.println("Sum of numbers which is multiply of " + k + " equal " + summOfRealNumbers(arrayOfReal,k));
    }

    public static int summOfRealNumbers(int[] realNumbers, int k) {

        int summ = 0;

        for (int i = 0; i < realNumbers.length; i++) {
            if (realNumbers[i] % k == 0) {
                summ += realNumbers[i];
            }
        }

        return summ;
    }
}