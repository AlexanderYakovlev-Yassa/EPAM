/*
Дана матрица. Вывести k-ю строку и p-й столбец матрицы
*/

public class Exercise_2_3 {
    public static void main(String[] args) {
        double[][] matrix = {
                {11, 5, 7, 8, 4, 7},
                {6, 12, 3, 11, 12, 0},
                {47, 74, 13, 63, 35, 98},
                {1, 2, 3, 14, 28, 6},
                {9, 8, 7, 4, 15, 6},
                {6, 4, 4, 3, 9, 16}};

        printMatrix(matrix);

        printElementOfMatrix(matrix, 5, 2);
    }

    public static void printElementOfMatrix(double[][] a, int k, int p) {

                    System.out.println("row=" + k + "  colomn=" + p + "  element=" + "[" + a[k][p] + "]");

    }

    public static void printMatrix(double[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("[" + matrix[i][j] + "]" + "\t");
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("");
    }
}
