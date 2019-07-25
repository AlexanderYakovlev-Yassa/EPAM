/*
Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали
*/

public class Exercise_2_2 {

    public static void main(String[] args) {
        double[][] matrix = {
                {11, 5, 7, 8, 4, 7},
                {6, 12, 3, 11, 12, 0},
                {47, 74, 13, 63, 35, 98},
                {1, 2, 3, 14, 28, 6},
                {9, 8, 7, 4, 15, 6},
                {6, 4, 4, 3, 9, 16}};

        printMatrix(matrix);

        printDiagonal(matrix);
    }

    public static void printDiagonal(double[][] a) {
        for (int row = 0; row < a.length; row++) {
            for (int col = 0; col < a[row].length; col++) {
                if (row == col) {
                    System.out.print("[" + a[row][col] + "]" + "\t");
                }
            }
        }
        System.out.println("");
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
