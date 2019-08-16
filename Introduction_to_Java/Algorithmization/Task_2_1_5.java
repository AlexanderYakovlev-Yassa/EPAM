/*
Даны целые числа а1 ,а2 ,..., аn . Вывести на печать только те числа, для которых аi > i.
*/

public class Task_2_1_5 {

    public static void main(String[] args) {

        int[] a = {5, 6, 7, 0, 9, -5, -4, -3};

        for (int i = 0; i < a.length; i++) {
            System.out.print("[" + a[i] + "]   ");
            if ((i + 1) % 10 == 0) {
                System.out.println("");
            }
        }

        int[] b = biggerThanI(a);

        System.out.println("");
        System.out.println("");

        for (int i = 0; i < b.length; i++) {
            System.out.print("[" + b[i] + "]   ");
            if ((i + 1) % 10 == 0) {
                System.out.println("");
            }
        }
    }

    public static int[] biggerThanI(int[] a) {

        int count = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > i) {
                count++;
            }
        }

        int[] res = new int[count];
        count = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > i) {
                res[count] = a[i];
                count++;
            }
        }

        return res;
    }

}
