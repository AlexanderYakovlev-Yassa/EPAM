/*Сортировка Шелла*/

public class Task_2_3_6 {
    public static void main(String[] args) {
        double[] array = {0,-15, 1100, 7,-2.3, -1, -10, 0.1e-200,2,7,  5, 6,    7, 15, 200.2, 7,};
        printArray(array);
        sortByShell(array);
        printArray(array);
    }

    public static void sortByShell(double[] array) {
        int i = 0;
        while (i < array.length - 1) {
            if (array[i] <= array[i + 1]){
                i++;
            } else {
                swap(array, i, i+1);
                if (i > 0){
                    i--;
                } else {
                    i++;
                }
            }
        }
    }


    public static void swap(double[] array, int a, int b) {
        if ((a >= 0 && b >= 0) && (a < array.length && b < array.length)) {
            double bubble = array[a];
            array[a] = array[b];
            array[b] = bubble;
        } else {
            System.out.println("swap - indices is out of bound");
        }
    }

    //print the array "array"
    public static void printArray(double[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + array[i] + "]  ");
        }
        System.out.println("");
    }
}
