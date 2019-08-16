/*
Дана последовательность действительных чисел а1 ,а2 ,..., ап.
Заменить все ее члены, большие данного Z,
этим числом. Подсчитать количество замен.
*/

public class Task_2_1_2 {

    public static void main(String[] args) {

        double[] arrayOfReal = {1, 2, 56.2, 25, -4, 8, 10, 12, -3.258, 154, 0};
        double z = 10;
        int numberOfReplacements;

        System.out.println("The array of real before replacements:");

        for (int i = 0; i < arrayOfReal.length; i++) {

            System.out.print(arrayOfReal[i] + "\t\t");
        }
        System.out.println("");

        numberOfReplacements = replaceNumbers(arrayOfReal, z);

        System.out.println("The array of real after replacements:");

        for (int i = 0; i < arrayOfReal.length; i++) {

            System.out.print(arrayOfReal[i] + "\t\t");
        }
        System.out.println("");
        System.out.println("Number of replacements is: " + numberOfReplacements);
    }

    public static int replaceNumbers(double[] numbers, double z) {

        int counter = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > z) {
                numbers[i] = z;
                counter++;
            }
        }

        return counter;
    }
}
