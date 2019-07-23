/*Даны числовой ряд и некоторое число е.
 Найти сумму тех членов ряда, модуль которых больше или равен
заданному е. Общий член ряда имеет вид:
       -n    -n
a[n]= 2   + 3


*/

import java.lang.Math;
import java.util.Scanner;


public class Exercise_3_5 {

    public static void main(String[] args){
        double e = 0.01;
        double summ = summ(insert());
        System.out.println(summ);
    }

    //метод находит сумму согласно условию задачи
    public static double summ(double e) {

        double summ = 0;    //искомая сумма
        int x = 1;          //начальный индекс ряда (имеет смысл в диапазоне от -646 до 1074)
        double fX = fX(x);  //значение члена ряда

        if (e < 0) {  //определение модуля заданного числа e
            e = -e;
        }

        while ((fX >= e) && (fX > 0)) {
            summ += fX;
            x++;
            fX = fX(x);
        }

        return summ;
    }

    //Метод реализует ввод пользователем действительного числа
    public static double insert(){

        System.out.print("Введите действительное число E >");
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextDouble()){
            System.out.print("Ваш ввод некорректный. Введите действительное число E >");
            scan.nextLine();
        }
        double e = scan.nextDouble();
        return e;
    }

    //Метод вычисляет значение данной функции F(X) для аргумента X
    public static double fX(int x) {
        double y = Math.pow(2, -x) + Math.pow(3, -x);
        return y;
    }


//***********************************************************************
//  Далее вспомогательные методы которые использовались для анализа данной функции

    public static void row() {
        for (int i = 0; i < 1100; i++) {
            System.out.println("x=" + i + "  f(x)=" + fX(i));
        }
    }

    public static void row1() {
        for (int i = 1074; i > -650; i--) {
            System.out.println("x=" + i + "  f(x)=" + fX(i) + "  summ(x)=" + summX(i));
        }
    }

    public static double summX(int start) {
        double sX = 0;
        for (int i = start; i < 1074; i++) {
            sX += fX(i);
        }
        return sX;
    }
}
