/*Сортировка обменами.
Дана последовательность чисел.Требуется переставить числа в
порядке возрастания. Для этого сравниваются два соседних числа a[i] и a[i+1]. Если a[i+1]>a[i], то делается
перестановка. Так продолжается до тех пор, пока все элементы не станут расположены в порядке возрастания.
Составить алгоритм сортировки, подсчитывая при этом количества перестановок*/

public class Task_2_3_4 {

    public static void main(String[] args) {
        double[] a = {0.0, 2.0, 1.5, 25, 63, 0.587, -58.0, 3.8, -3.6};
        printArray(a);
        System.out.println("There were " + sort(a) + " swaps to sort that array");
        printArray(a);
    }

    public static int sort(double[] array){
        boolean flag = true;
        int i = 0;
        int last = array.length - 1;
        int swaps = 0;

        while (flag){
            flag = false;
            while (i < last) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    swaps++;
                    flag = true;
                } else
                i++;
            }
            last--;
            i = 0;
        }
        return swaps;
    }

    //swap elements array[a] and array[b]
    public static void swap(double[] array, int a, int b) {
        double buble = array[a];
        array[a] = array[b];
        array[b] = buble;
    }

    //print the array "array"
    public static void printArray(double[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + array[i] + "]  ");
        }
        System.out.println("");
    }
}
