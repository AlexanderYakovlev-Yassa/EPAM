/*
Дана матрица. Вывести k-ю строку и p-й столбец матрицы
*/

public class Task_2_2_3 {
    public static void main(String[] args) {
        double[][] matrix = {
                {11, 5, 7, 8, 4, 7},
                {6, 12, 3, 11, 12, 0},
                {47, 74, 13, 63, 35, 98},
                {1, 2, 3, 14, 28, 6},
                {9, 8, 7, 4, 15, 6},
                {6, 4, 4, 3, 9, 16}};
        int k = 3;
        int p = 4;
        System.out.println(k + "th row:");
        for (int i = 0; i < matrix[k].length; i++){
            System.out.print("[" + matrix[k] [i] + "]  ");
        }
        System.out.println("\n"+ p + "th column:");
        for (int i = 0; i < matrix.length ; i++) {
            System.out.print("[" + matrix[i] [p] + "]  ");
        }

    }


}
