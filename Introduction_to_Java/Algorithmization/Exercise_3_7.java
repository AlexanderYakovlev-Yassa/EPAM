public class Exercise_3_7 {

    public static void main(String[] args) {
        double[] arrayA = {-15, -10, -2.3, -1, 0, 0.1e-200, 2, 5, 6, 7, 7, 7, 7, 15, 101, 200};
        double[] arrayB = {-20, 0, 5, 9, 7, 100, 200, 700, 6500, 33620, 100000};
        printArray(arrayA);
        printArray(arrayB);
        positions(arrayA, arrayB);

    }

    public static void positions(double[] a, double[] b) {
        String what = "Элемент ";
        String sB = "";
        String where = "";
        int position = -2;

        for (int i = 0; i < b.length; i++) {
            position = binarSearch(a, b[i]);
            if (position == 0) {
                where = " перед лементом a[" + position + "].";
            } else if (position == a.length) {
                where = " после элемента a[" + position + "].";
            } else {
                where = " между элементами a[" + (position - 1) + "] и [" + position + "].";
            }
            sB = "b[" + i + "]";
            System.out.println(what + sB + " нужно вставить " + where);
        }
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
