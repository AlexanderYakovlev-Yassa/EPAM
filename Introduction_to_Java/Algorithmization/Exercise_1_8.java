/*Дана последовательность целых чисел . Образовать новую последовательность, выбросив из
исходной те члены, которые равны min.
*/

public class Exercise_1_8 {

    public static void main(String[] args) {

        int[] a = {1, 2, -56, 25, -4, 8, 10, 12, 3, 154, 0};
        int[] b = withoutMin(a);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }
        System.out.println("");
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + "  ");
        }
    }

    public static int[] withoutMin(int[] a) {
        int[] res = new int[a.length - 1];
        int min = 0; //min number index
        int counter = 0;

        for (int i = 0; i < a.length; i++) {
            min = a[i] < a[min] ? i : min;
        }
        for (int i = 0; i < a.length; i++) {
            if (i != min) {
                res[counter] = a[i];
                counter++;
            }
        }
        return res;
    }

}
