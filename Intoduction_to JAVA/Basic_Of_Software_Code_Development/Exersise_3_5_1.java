public class Exersise_3_5_1 {

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

