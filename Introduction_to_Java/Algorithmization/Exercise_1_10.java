/*
Дан целочисленный массив с количеством элементов п. Сжать массив, выбросив из него каждый второй
элемент (освободившиеся элементы заполнить нулями). Примечание. Дополнительный массив не использовать
*/

public class Exercise_1_10 {

    public static void main(String[] args) {

        int[] a = {0, 12, 3, 23, 22, 18, 28, 8, 2, 38, 0};

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t\t");
        }
        System.out.println("");
        compression(a);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "\t\t");
        }
    }

    public static void compression(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = i % 2 != 0 ? a[i] = 0 : a[i];
        }
    }
}