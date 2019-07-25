/*
Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего
*/

public class Exercise_2_1 {

    public static void main(String[] args) {
        double[][] matrix = {
                {3, 5, 7, 8, 4, 7, 55, 63},
                {6, 7, 3, 11, 12, 13, 60, 60},
                {47, 74, 58, 63, 35, 98, 44, 55},
                {1, 2, 3, 4, 5, 6, 84, 84},
                {9, 8, 7, 4, 5, 6, 66, 66},
                {6, 4, 4, 3, 9, 8, 63, 55}};

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("[" + matrix[i][j] + "]" + "\t");
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("");

        modifiedPrintingOfMatrix(matrix);
    }

    public static void modifiedPrintingOfMatrix(double[][] a) {
        for (int row = 0; row < a.length; row++) {
            for (int col = 1; col < a[row].length; col += 2) {
                if (a[0][col] > a[a.length - 1][col]) {
                    System.out.print("[" + a[row][col] + "]" + "\t");
                }
            }
            System.out.println("");
        }
    }

}
