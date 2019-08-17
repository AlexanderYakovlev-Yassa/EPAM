/*
Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
*/

public class Task_2_2_4 {

    public static void main(String[] args) {

        int[] [] matrix = formMatrix(6);

        printMatrix(matrix);

    }

    public static int[] [] formMatrix(int size) {

        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = row % 2 == 0 ? col + 1 : size - col;
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
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
