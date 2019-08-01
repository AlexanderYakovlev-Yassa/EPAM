import java.lang.reflect.Array;

public class Exercise_3_5_r {
    public static void main(String[] args) {
        double[] array = {0,-15, 1100, 7,-2.3, -1, -10, 0.1e-200,2,7,  5, 6,    7, 15, 200.2, 7,};
        printArray(array);
        double[] orderedArray = orderArray(array);
        printArray(orderedArray);
    }


    public static double[] orderArray(double[] array){
        double[] orderedArray = new double[0];
        double[] newArray;
        for (int i = 0; i < array.length; i++){
            newArray = addToArray(orderedArray,array[i]);
            orderedArray = newArray.clone();
        }
        return orderedArray;
    }

    public static double[] addToArray(double[] array, double key) {
        double[] newArray = new double[array.length + 1];
        if (array.length == 0) {
            newArray[0] = key;
        } else {
            int pos = binarSearch(array, key);
            for (int i = 0; i < newArray.length; i++) {
                if (i < pos) {
                    newArray[i] = array[i];
                } else if (i == pos) {
                    newArray[i] = key;
                } else {
                    newArray[i] = array[i - 1];
                }
            }
        }
        return newArray;
    }

    public static int binarSearch(double[] array, double key) {
        int pos;
        if (array[0] >= key) {
            pos = 0;
        } else if (array[array.length - 1] < key) {
            pos = array.length;
        } else if (array[array.length - 1] == key) {
            pos = array.length - 1;
        } else {
            pos = subBinarSearch(array, 0, array.length - 1, key);
        }
        return pos;
    }

    public static int subBinarSearch(double[] array, int left, int right, double key) {
        int pos;
        int center = left + (right - left) / 2;

        if (array[center] == key) {
            pos = center + 1;
        } else if (right - left == 1) {
            pos = right;
        } else if (array[center] < key) {
            pos = subBinarSearch(array, center, right, key);
        } else {
            pos = subBinarSearch(array, left, center, key);
        }
        return pos;
    }

    //print the array "array"
    public static void printArray(double[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + array[i] + "]  ");
        }
        System.out.println("");
    }
}
