/*
Сформировать квадратную матрицу порядка N по правилу
*/

import java.lang.Math;

public class Exercise_2_7 {
    public static void main(String[] args) {

        double[] [] matrix = formMatrix(8);

        printMatrix(matrix);

        System.out.println(posiveElements(matrix));

    }

    public static double[] [] formMatrix(int size) {

        double[][] matrix = new double[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = Math.sin((Math.pow(i,2)-Math.pow(j,2))/size);

            }
        }
        return matrix;
    }

    public static int posiveElements(double[] [] matrix){
        int number = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
               if (matrix[i] [j] > 0){
                   number++;
               }
            }
        }
        return number;
    }

    public static void printMatrix(double[][] matrix) {
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
