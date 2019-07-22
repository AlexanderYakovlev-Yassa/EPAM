package com.company;

import java.util.Scanner;
import java.lang.Math;

public class Exercise_3_8 {

    public static void main(String[] args) {
        /*boolean[] b = digitDiagramm(256.9);
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " - " + b[i] + "; ");
        }*/

        //compare();
        String a = "255552227";
        String b = "335777";
        System.out.println(a);
        System.out.println(b);
        System.out.println("X9876543210");
        System.out.println(Integer.toBinaryString(bDigitSpectrum(a)));
        System.out.println(Integer.toBinaryString(bDigitSpectrum(b)));
        System.out.println(Integer.toBinaryString(bCompare(bDigitSpectrum(a), bDigitSpectrum(b))));

    }

    public static void compare() {
        String res;
        System.out.print("Введите первое число");
        double x1 = insert();
        String digits1 = (x1 == (int) x1) ? Integer.toString((int) x1) : Double.toString(x1);
        System.out.println("");
        System.out.print("Введите второе число");
        double x2 = insert();
        String digits2 = (x2 == (int) x2) ? Integer.toString((int) x2) : Double.toString(x2);
        System.out.println("");

        boolean[] firstSpectrum = digitSpectrum(digits1);
        boolean[] secondSpectrum = digitSpectrum(digits2);

        System.out.println("В записи чисел " + digits1 + " и " + digits2 + " есть одинаковые цифры: ");


        for (int i = 0; i < 10; i++) {
            if (firstSpectrum[i] && secondSpectrum[i]) {
                System.out.print(i + "  ");
            }
        }


        //return "";
    }

    //Метод получает число double и возвращает диаграмму входящих в него цифр
    public static boolean[] digitSpectrum(String digits) {

        //String digits = (a == (int)a) ? Integer.toString((int)a) : Double.toString(a);

        int digit = 0;
        boolean[] res = new boolean[10];
        for (int i = 0; i < 10; i++) {
            res[i] = false;
        }
        for (int i = 0; i < digits.length(); i++) {

            if (Character.isDigit(digits.charAt(i))) {
                digit = (int) digits.charAt(i) - (int) ('0');
                res[digit] = true;
                //System.out.println(i + " " + digit);
            }
        }
        return res;

    }

    //Метод возвращает спектр строки number в бинарном виде
    // например для числа 925:
    // X9876543210 шкала
    // 11000100100 спектр
    public static int bDigitSpectrum(String number) {
        int exp;
        int spectrum = 0;
        for (int i = 0; i < number.length(); i++) {
            if (Character.isDigit(number.charAt(i))) {
                exp = (int) number.charAt(i) - (int) ('0');
                spectrum |= (int) Math.pow(2, exp);
            }
        }
        spectrum |= (int) Math.pow(2, 10); //добавлен 1 старший бит для удобства визуального сравнения результатов
        return spectrum;
    }

    public static int bDigitSpectrum(int a) {
        int spectrum = 1024;
        
        return spectrum;
    }

    public static int bCompare(int a, int b) {
        int res = a & b;
        return res;
    }


    //Метод обеспечивает ввод пользователем действительного числа
    public static double insert() {

        double e;
        Scanner scanner = new Scanner(System.in);

        System.out.print(" >");

        while (!scanner.hasNextDouble()) {
            System.out.print("Ваш ввод ошибочный. Введите число >");
            scanner.next();
        }

        e = scanner.nextDouble();

        //scanner.close();

        return e;
    }
}
