/*
Даны действительные числа a[1], a[2]...a[2n] . Найти
        max(a[1]+a[2n],a[2]+a[2n-1]...a[n]+a[n+1] )
*/

public class Task_2_1_7 {

    public static void main(String[] args) {

        double[] a = {5, 6, 7, 10, 9, -5};//, -4, -3, -2, -1, 0, 89, -5, 0, 87, 87, -52, -89, 0, 0, 0, 4, -7, 32, 7, 0};

        System.out.println("The maximal sum is " + maxOf(a));
    }

    public static double maxOf(double[] a){
        double max = a[0] + a[a.length - 1];
        double summ;
        for(int i = 1; i < a.length/2; i++){
            summ = a[i] + a[a.length - i - 1];
            max = max < summ ? summ : max;
        }
        return max;
    }
}
