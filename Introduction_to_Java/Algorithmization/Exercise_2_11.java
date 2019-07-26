/*Матрицу 10x20 заполнить случайными числами от 0 до 15. Вывести на экран саму матрицу и номера строк, в
которых число 5 встречается три и более раз
*/

import java.lang.Math;

public class Exercise_2_11 {

    public static void main(String[] args) {
        int[][] matrix = new int[10][20];
        fillInMatrixWithRandom(matrix);
        System.out.println("The matrix which fill in with random numbers:");
        printMatrix(matrix);
        int[] indices = rowsWithFives(matrix);
        String str = indices.length == 0 ?
                "There are no rows which contain three or more fives" :
                "Indices of rows which contain three or more fives is:";
        System.out.println(str);
        printMatrix1d(indices);
    }

    public static void fillInMatrixWithRandom(int[][] matrix) {
        int random;
        int count = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                random = (int) (Math.random() * 15);
                if (random == 5) {
                    count++;
                }
                matrix[row][col] = random;
            }
        }
    }

    public static int[] rowsWithFives(int[] [] matrix){
        int count = 0;
        int count_1 = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row] [col] == 5){
                    count++;
                }
            }
            if (count >= 3) {
                count_1++;
            }
            count = 0;
        }
        int[] rowIndexes = new int[count_1];
        count_1 = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row] [col] == 5){
                    count++;
                }
            }
            if (count >= 3) {
                rowIndexes[count_1] = row;
                count_1++;
            }
            count = 0;
        }
        return rowIndexes;
    }

    public static void printMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("[" + matrix[i][j] + "]  ");

            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static void printMatrix1d(int[] matrix) {

        for (int i = 0; i < matrix.length; i++) {
                System.out.print("[" + matrix[i] + "]  ");
        }
        System.out.println("");
    }
}
