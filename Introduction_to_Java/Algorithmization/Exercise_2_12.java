public class Exercise_2_12 {

    public static void main(String[] args) {

        double[] arr = {5, 8, 16, -5.6, 11, -50, 2.2};
        //System.out.println(indexWithMax(arr, 2, 6));
        printArray(arr);
        //swith(arr, 0, 3);
        //printArray(arr);
        sort(arr);
        printArray(arr);

    }


    public static void sort(double[] array) {

        int b = array.length - 1;

        for (int a = 0; a < b; a++) {
            int indMax = indexWithMax(array, a + 1, b);
            if (array[indMax] > array[a]) {
                swith(array, a, indMax);
            }
        }
    }

    //swaps the numbers with indices "a" and "b" in the array "array"
    public static void swith(double[] array, int a, int b) {
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
