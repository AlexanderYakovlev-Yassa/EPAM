/*Даны два числа. Определить цифры, входящие в запись как первого так и второго числа.

    Вводим числа для сравнения с клавиатуры
На этапе ввода с клавиатуры проверяется корректность введенных чисел
(числа должны соответствовать типу double)
    Целые числа конвертируются в тип int чтобы избежать сравнения
незначащего нуля после десятичной точки.
    Для каждого числа вычисляется "спектр" - целое число у которого
в бинарном виде разряды равные 1 показывают наличие
соответствующей цифры в данном числе.
например для числа 92,5:
   X9876543210 шкала
 0b11000100100 спектр
 11-й разряд всегда равен 1, добавлен для удобства визуального сравнения при отладке.
    Далее спектры чисел сравниваются (определяется пересечение спектров)
В результирующем спектре единица в соответствующем разряде показывает наличие
цифры в обоих сравниваемых числах.
    Результат сравнения выводится на консоль.
 */

import java.util.Scanner;
import java.lang.Math;

public class Task_1_3_8 {
    public static void main(String[] args) {

        compare();
    }


    public static void compare() {
        //Ввод данных с клавиатуры и приведение к виду без незначащих нулей после запятой
        System.out.print("Введите первое число");
        double[] x = insert();
        String digits1 = (x[0] == (int) x[0]) ? Integer.toString((int) x[0]) : Double.toString(x[0]);//Если число целое конвертируем его в int
        String digits2 = (x[1] == (int) x[1]) ? Integer.toString((int) x[1]) : Double.toString(x[1]);//чтобы убрать незначащий ноль

        //определение спектров чисел и спектра их пересечения
        int spectrumOfFirstNumber = bDigitSpectrum(digits1);
        int spectrumOfSecondNumber = bDigitSpectrum(digits2);
        int crossOfSpectrums = spectrumOfFirstNumber & spectrumOfSecondNumber;

        //вывод результатов в консоль
        if (crossOfSpectrums > 0b10000000000) { //проверяем есть ли совпадающие цифры (нулевой спектр равен 0b10000000000)
            System.out.println("В записи чисел " + digits1 + " и " + digits2 + " есть одинаковые цифры: ");


            String matchingDigits = "";
            for (int i = 0; i < 10; i++) {
                if ((crossOfSpectrums / (int)Math.pow(2, i))%2 != 0) { //выделяем совпадающие цифры из спектра
                    matchingDigits += i + " ";
                }
            }
            System.out.println(matchingDigits);
        } else {
            System.out.println("В записи чисел " + digits1 + " и " + digits2 + " нет совпадающих цифр");
        }
    }

    //Метод обеспечивает ввод пользователем числа
    public static double[] insert() {

        double[] e = new double[2];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                System.out.print("Введите первое сравниваемое число");
            } else {
                System.out.print("Введите второе сравниваемое число");
            }
            System.out.print(" >");
            while (!scanner.hasNextDouble()) {
                System.out.print("Ваш ввод не корректный. Введите число >");
                scanner.next();
            }

            e[i] = scanner.nextDouble();
        }


        return e;
    }

    //Метод возвращает спектр строки number в бинарном виде
    // например для числа 925:
    //   X9876543210 шкала
    // 0b11000100100 спектр
    public static int bDigitSpectrum(String number) {

        int exp;
        int spectrum = 0b10000000000; //добавлен 1 старший бит для удобства визуального сравнения результатов

        for (int i = 0; i < number.length(); i++) {
            if (Character.isDigit(number.charAt(i))) {
                exp = (int) number.charAt(i) - (int) ('0');
                spectrum |= (int) Math.pow(2, exp);
            }
        }

        return spectrum;
    }


}
