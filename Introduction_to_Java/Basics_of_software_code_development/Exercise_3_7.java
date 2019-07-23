/*
 Для каждого натурального числа в промежутке от m до n вывести все делители, кроме единицы и самого числа.
m и n вводятся с клавиатуры.

    Вводим данные с клавиатуры                                                          (insert()).
    Находим все простые числа от 2 до n(конец диапазона)                                (primeArray(max))
    Перебираем все числа заданного диапазона.
    Для всех чисел не являющихся простыми находим все простые делители.                 (primeDividers(i, primes))
    Перебираем все комбинации простых делителей и находим все делители данного числа.   (optionOfMultiply(primeDividers))
    Из получившегося ряда убираем все повторяющиеся делители.
    Выводим результат в консоль.

*/

import java.lang.Math;
import java.util.Scanner;

public class Exercise_3_7 {

    public static void main(String[] args) {
        allDevidersOfEachNumber();
    }


    public static void allDevidersOfEachNumber() {
        int[] range = new int[2];
        range = insert();
        while (range[0] >= range[1]) {
            System.out.println("Начало диапазона не может быть меньше либо равно концу диапазона!!!");
            System.out.println("Повторите ввод:");
            range = insert();
        }
        int min = range[0];
        int max = range[1];
        int[] primes = primeArray(max);//вычисляем все простые числа от 2 до max

        for (int i = min; i <= max; i++) { //перебераем все числа заданного диапазона

            if (isPrimeNumber(i)) {        //проверяем является ли число простым
                System.out.println("Число " + i + " простое.");
            } else {
                int[] primeDividers = primeDividers(i, primes);//вычисляем ряд простых чисел делителей
                int[] allDeviders = optionOfMultiply(primeDividers);//вычисляем ряд всех делителей
                int[] normalise = normalise(allDeviders);//убираем из ряда делителей повторяющиеся
                System.out.println("Все делители числа " + i + ":");
                for (int j = 0; j < normalise.length; j++) {
                    System.out.print(normalise[j] + "  ");
                }
                System.out.println("");
            }
        }
    }

    //Метод обеспечивает ввод данных с клавиатуры
    public static int[] insert() {

        int[] e = new int[2];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                System.out.print("Введите целое число - начало диапазона");
            } else {
                System.out.print("Введите целое число - конец диапазона");
            }
            System.out.print(" >");
            while (!scanner.hasNextInt()) {
                System.out.print("Ваш ввод не корректный. Введите целое число число >");
                scanner.next();
            }

            e[i] = scanner.nextInt();
        }

        //scanner.close();
        return e;
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
    public static int[] primeDividers(int num, int[] primeNumbers) {
        //int[] primeNumbers = primeArray(num);
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

    //Меттод возвращает массив всех возможных произведенй m чисел
    //из массива чисел a
    //ряд простых чисел делителей индексируем и не меняем положение элементов
    //далее перебираем варианты отмечая элемент участвующий в произведении
    //еденицей, а не участвующие нулем. Получаем ряд типа
    //01011, что можно представить как число в бинарном виде.
    //например все возможные варианты перебора для ряда из 5 чисел соответствуют
    //простому перечислению от 00001 до 11110.
    public static int[] optionOfMultiply(int[] a) {
        int n = a.length; //количество чисел в ряду
        int num = (int) Math.pow(2, n) - 2; //максимальное число для перебора например для ряда из 5 чисел 0b11110 (2^5-2 = 30)
        int[] mult = new int[num]; //объявляем массив в котором будут содержаться все варианты произведений
        int m = 1;
        int[] exp = new int[n];

        for (int i = 0; i < n; i++) {
            exp[i] = (int) Math.pow(2, i);
        }

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < n; j++) {
                if ((i + 1) / exp[j] % 2 != 0) {
                    m *= a[j];
                }
            }
            mult[i] = m;
            m = 1;
        }
        return mult;
    }

    //Метод чистит исходный массив от повторяющихся элементов
    public static int[] normalise(int[] a) {
        int newLength = a.length;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if ((a[i] == a[j]) && a[i] != 0) {
                    a[j] = 0;
                    newLength -= 1;
                }
            }
        }
        int[] res = new int[newLength];
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                res[count] = a[i];
                count++;
            }
        }
        return res;
    }


}