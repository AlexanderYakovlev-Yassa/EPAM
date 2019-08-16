/*Дан массив действительных чисел, размерность которого N. Подсчитать, сколько в нем отрицательных,
положительных и нулевых элементов.*/

import java.util.Scanner;

public class Task_2_1_3 {


    public static void main(String[] args) {
        //double[] a = insert(25);
        double[] a = {5, 6, 7, 8, 9, -5, -4, -3, -2, -1, 0, 89, -5, 0, 87, 87, -52, -89, 0, 0, 0, 4, -7, 32, 7};

        System.out.println("");

        for (int i = 0; i < a.length; i++) {
            System.out.print("[" + a[i] + "]   ");
            if((i+1)%10 == 0){
                System.out.println("");
            }
        }

        System.out.println("");
        System.out.println("");
        System.out.println("This array contains:");
        int[] b = select(a);
        System.out.println(b[0] + " - positive numbers;");
        System.out.println(b[1] + " - negative numbers;");
        System.out.println(b[2] + " - zeroes;");
    }

    public static double[] insert(int n) {

        double[] a = new double[n];
        Scanner scan = new Scanner(System.in);
        System.out.println("Insert members of the array,");
        System.out.println("each member must be a real number");
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = >");
            while (!scan.hasNextDouble()) {
                System.out.print("Invalid input! It must be a real number " + "a[" + i + "] = >");
                scan.next();
            }
            a[i] = scan.nextDouble();
        }

        return a;
    }

    public static int[] select(double[] a) {
        int[] res = new int[3]; //res[0] - positive numbers
        //res[1] - negative numbers
        //res[3] - zero numbers

        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                res[0]++;
            } else if (a[i] < 0) {
                res[1]++;
            } else {
                res[2]++;
            }
        }

        return res;
    }
}

