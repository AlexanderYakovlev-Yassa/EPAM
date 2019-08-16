/*Отсортировать строки матрицы по возрастанию и убыванию значений элементов*/

public class Task_2_2_12 {

    public static void main(String[] args) {

        double[] arr = {5, 8, 16, -5.6, 11, -50, 2.2};
        //System.out.println(indexWithMax(arr, 2, 6));
        printArray(arr);
        //swith(arr, 0, 3);
        //printArray(arr);
        sortMaxToMin(arr);
        printArray(arr);
        sortMinToMax(arr);
        printArray(arr);
    }

    //sorts the array from max to min
    public static void sortMaxToMin(double[] array) {

        int b = array.length - 1;

        for (int a = 0; a < b; a++) {
            int indMax = indexWithMax(array, a + 1, b);
            if (array[indMax] > array[a]) {
                swop(array, a, indMax);
            }
        }
    }

    //sorts the array from min to max
    public static void sortMinToMax(double[] array) {

        int a = 0;
        int indMax;
        for (int b = array.length-1; b >=0; b--) {
            indMax = indexWithMax(array, a, b - 1);
            if (array[indMax] > array[b]) {
                swop(array, b, indMax);
            }
        }
    }

    //swaps the numbers with indices "a" and "b" in the array "array"
    public static void swop(double[] array, int a, int b) {
        double bubble;
        bubble = array[a];
        array[a] = array[b];
        array[b] = bubble;
    }

    //returns the index with the maximal element of the "array"
    public static int indexWithMax(double[] array, int a, int b) {
        int max = a;
        for (int i = a; i <= b; i++) {
            max = array[max] < array[i] ? i : max;
        }
        return max;
    }

    //print the array "array"
    public static void printArray(double[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + array[i] + "]  ");
        }
        System.out.println("");
    }
}
