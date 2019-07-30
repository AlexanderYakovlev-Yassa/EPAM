/*Заданы два одномерных массива с различным количеством элементов и натуральное число k. Объединить их в
один массив, включив второй массив между k-м и (k+1) - м элементами первого, при этом не используя
дополнительный массив*/

public class Exercise_3_1 {

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] b = {11, 12, 13, 14, 15};
        int k = 5;
        int[] c = newArray(a, b, k);
        printArray(c);
    }

    public static int[] newArray(int[] a, int[] b, int k) {
        int[] c = new int[a.length + b.length];
        for (int i = 0; i < c.length; i++) {
            if (i <= k) {
                c[i] = a[i];
            } else if (i <= k + b.length) {
                c[i] = b[i - k - 1];
            } else {
                c[i] = a[i - b.length];
            }
        }
        return c;
    }

    //print the array "array"
    public static void printArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + array[i] + "]  ");
        }
        System.out.println("");
    }
}
