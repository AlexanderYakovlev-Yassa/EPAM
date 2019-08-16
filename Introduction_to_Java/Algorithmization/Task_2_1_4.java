/*Даны действительные числа а1 ,а2 ,..., аn . Поменять местами наибольший и наименьший элементы*/

public class Task_2_1_4 {

    public static void main(String[] args) {

        double[] a = {5, 6, 7, 0, 9, -5, -4, -3};


        for (int i = 0; i < a.length; i++) {
            System.out.print("[" + a[i] + "]   ");
            if ((i + 1) % 10 == 0) {
                System.out.println("");
            }
        }

        change(a);

        System.out.println("");

        for (int i = 0; i < a.length; i++) {
            System.out.print("[" + a[i] + "]   ");
            if ((i + 1) % 10 == 0) {
                System.out.println("");
            }
        }
    }

    public static void change(double[] a) {

        int max = 0; //max number index
        int min = 0; //min number index
        double bubble;

        for (int i = 1; i < a.length; i++) {
            max = a[i] > a[max] ? i : max;
            min = a[i] < a[min] ? i : min;
        }

        bubble = a[max];
        a[max] = a[min];
        a[min] = bubble;

    }
}
