/*Дана последовательность чисел.Требуется переставить элементы так,
чтобы они были расположены по убыванию. Для этого в массиве, начиная с первого, выбирается наибольший
элемент и ставится на первое место, а первый - на место наибольшего. Затем, начиная со второго, эта процедура
повторяется. Написать алгоритм сортировки выбором.*/

public class Task_2_3_3 {

    public static void main(String[] args) {
        double[] a = {0.0, 2.0, 1.5, 25, 63, 0.587, -58.0, 3.8, -3.6};
        System.out.println(max(a,0));
    }



    //the search the max starts from the element with index f and returns index of it;
    public static int max(double[] array, int f) {
        int max = f;
        for (int i = f + 1; i < array.length; i++) {
            max = array[max] < array[i] ? i : max;
        }
        return max;
    }
}
