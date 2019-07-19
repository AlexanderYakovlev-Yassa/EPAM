package com.company;

import java.lang.Math;

public class primeNumbers {

    public static void main(String[] args) {
        /*int[] prDev = primeDividers(140);
        for (int i = 0; i < prDev.length; i++) {
            System.out.println(prDev[i]);
        }*/
        int s = 6;
        int[] arr = {5,2};
        int[] arr1 = f(arr);
        for (int i = 0; (i < arr1.length); i++) {
            System.out.println(arr1[i]);
        }
    }

    //Метод определяет является ли целое число простым
    public static boolean isPrimeNumber(int Num) {
        boolean flag = true;
        for (int i = 2; i < Num; i++) {
            if ((Num % i) == 0) {
                flag = false;
            }
        }
        return flag;
    }

    //Метод формирует массив содержащий все простые числа
    //меньшие чем max
    public static int[] primeArray(int max) {
        int counter = 0;
        for (int i = 2; i <= max; i++) {
            if (isPrimeNumber(i)) {
                counter++;
            }
        }
        int[] array = new int[counter];
        int j = 0;

        for (int i = 2; i <= max; i++) {
            if (isPrimeNumber(i)) {
                array[j] = i;
                j++;
            }
        }

        return array;
    }

    //Метод формирует массив со всеми
    //простыми делителями числа num
    public static int[] primeDividers(int num) {
        int[] primeNumbers = primeArray(num);
        int primeCounter = 0;
        int quotient = num;
        int count = 0;
        int[] prD;

        if (!isPrimeNumber(num)) {

            while (primeCounter < primeNumbers.length) {
                if (quotient % primeNumbers[primeCounter] == 0) {
                    quotient = quotient / primeNumbers[primeCounter];
                    count++;
                } else {
                    primeCounter++;
                }
            }

            prD = new int[count];
            count = 0;
            primeCounter = 0;
            quotient = num;

            while (primeCounter < primeNumbers.length) {
                if (quotient % primeNumbers[primeCounter] == 0) {
                    quotient = quotient / primeNumbers[primeCounter];
                    prD[count] = primeNumbers[primeCounter];
                    count++;
                } else {
                    primeCounter++;
                }
            }

        } else {
            prD = new int[1];
            prD[0] = num;
        }
        return prD;
    }

    public static int factorial(int arg) {
        int f = 1;

        for (int i = 1; i <= arg; i++) {
            f *= i;
        }
        return f;
    }

    public static int[] allDeviders(int[] primeDividers) {
        int s = primeDividers.length;
        int numOfOptions = factorial(s) / (factorial(s - 2) * 2);
        int[] allOptions = new int[numOfOptions];

        return allOptions;
    }

    public static int[] f(int[] a) {
        int[] b = new int[a.length];
        int m = 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < (a.length); j++) {
                if (i != j) {
                    m *= a[j];
                }
            }
            b[i] = m;
            m = 1;
        }
        return b;
    }

    //Метод перемножает все члены массива
    public static int mult(int[] c) {
        int m = 1;
        for (int i = 0; i < c.length; i++) {
            m *= c[i];
        }
        return m;
    }
}
