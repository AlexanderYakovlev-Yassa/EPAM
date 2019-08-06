/*Задан массив D. Определить следующие суммы:
D[l] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] +D[5] +D[6].
Пояснение. Составить метод(методы) для вычисления суммы
трех последовательно расположенных элементов массива с номерами от k до m.*/

public class Exercise_2_4_8 {

    public static void main(String[] args) {
        double[] array_D = {1, 2, 3,4,5,6,7,8,9,10};
        double[] arrayOfSumm = arrayOfTripleSums(array_D);
        printArray(array_D);
        printArray(arrayOfSumm);
    }

    //returns the array of the triple sum of numbers[]
    public static double[] arrayOfTripleSums(double[] numbers) {
        double[] array = new double[numbers.length - 2];
        for (int i = 0; i < numbers.length - 2; i++) {
            array[i] = sumOfThreeInARow(numbers, i);
        }
        return array;
    }

    //returns sum of three numbers in a row from startIndex
    public static double sumOfThreeInARow(double[] numbers, int startIndex) {
        double sum = 0;
        for (int i = startIndex; i < startIndex + 3; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    //print the array "array"
    public static void printArray(double[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + array[i] + "]  ");
        }
        System.out.println("");
    }
}
