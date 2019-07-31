import java.lang.Math;
import java.lang.reflect.Array;

public class BinSearch {
    public static void main(String[] args) {
//                          0    1     2   3  4      5     6  7  8  9  10 11 12 13     14       15
        double[] array = {-15, -10, -2.3, -1, 0, 0.1e-200, 2, 5, 6, 7, 7, 7, 7, 15, 2.23e10, 3.2e200};
        double key = -15;
        key -= Math.ulp(key);
        //int position = binarSearch(array, 0, array.length - 1, key- Math.ulp(key));
        //System.out.println("position = " + position);
        printArray(array);
        double[] newArray = addToArray(array, key);
        array = new double[array.length+1];
        //array = addToArray(array, key);
        printArray(newArray);

    }

    public static double[] addToArray(double[] array, double key){
        double[] newArray = new double[array.length + 1];
        int pos = binarSearch(array, 0, array.length-1,key);
        for (int i = 0; i < newArray.length; i++){
            if (i < pos){
                newArray[i] = array[i];
            } else if (i == pos){
                newArray[i] = key;
            } else {
                newArray[i] = array[i - 1];
            }
        }
        return newArray;
    }

    public static int binarSearch(double[] array, int left, int right, double key) {
        int pos = -1;
        int center = left + (right - left) / 2;
        //System.out.println("center " + center + "  left " + left + "  right " + right);
        //boolean find = false;
        if (key <= array[left]) {
            pos = 0;
        } else if (key > array[right]){
            pos = right + 1;
        } else if (array[center] == key) {
            pos = center + 1;
            //System.out.println("***");
        } else if (left == center) {
            pos = left + 1;
            //System.out.println(pos);
        } else {

            if (array[center] <= key) {
                pos = binarSearch(array, center, right, key);
            } else {
                pos = binarSearch(array, left, center - 1, key);
            }

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
