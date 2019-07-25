/*
Сформировать квадратную матрицу порядка n по заданному образцу(n - четное)
*/

public class Exercise_2_6 {

    public static void main(String[] args) {

        int[] [] matrix = formMatrix(8);

        printMatrix(matrix);

    }

    public static int[] [] formMatrix(int size) {

        int[][] matrix = new int[size][size];

        for (int row = 0; row < size/2; row++) {
            for (int col = 0; col < size/2; col++) {
                matrix[row][col] = row <= col ? 1 : 0;
                matrix[size - row -1][col] = row <= col ? 1 : 0;
                matrix[size - row -1][size - col - 1] = row <= col ? 1 : 0;
                matrix[row][size - col - 1] = row <= col ? 1 : 0;
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
