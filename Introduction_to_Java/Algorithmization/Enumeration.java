package com.company;

import java.lang.Math;

public class Enumeration {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        printArray(array);
        boolean flag = true;

        while (flag) {
            flag = next(array);
            if(isMagic(array)){
                printArray(array);
            }
        }
        //printArray(array);

    }

    public static boolean isMagic(int[] array) {
        int order = (int) (Math.sqrt(array.length));
        int[][] matrix = new int[order][order];
        int[] summs = new int[order * 2 + 2];
        for (int row = 0; row < order; row++) {
            for (int col = 0; col < order; col++) {
                matrix[row] [col] = array[row * order + col];
            }
        }
        for (int i = 0; i < order; i++){
            for (int j = 0; j < order; j++){
                summs[i] += matrix[i] [j];
                summs[order + i] += matrix[j] [i];
            }
            summs[order * 2] += matrix[i] [i];
            summs[order *2 +1] += matrix[i] [order - i - 1];
        }
        //int k = summs[0];
        int counter = 1;
        boolean flag = true;
        while (counter < summs.length){
            if (summs[0] != summs[counter]){
                flag = false;
                break;
            }
            counter++;
        }

        //printMatrix(matrix);
        printArray(summs);

        //for (int row = 0;  )
        return flag;
    }

    public static boolean next(int[] array) {
        //int en[] = new int[array.length];
        //int l = array.length;
        int[] back = array.clone();
        boolean flag = false;
        boolean fl2 = true;
        while (!flag) {
            fl2 = digitNext(array, 1);
            if (fl2) {
                flag = isGood(array);
            } else {
                flag = fl2;
                for (int i = 0; i < array.length; i++) {
                    array[i] = back[i];
                }
                break;
            }
        }
        return flag;
    }

    public static boolean isGood(int[] array) {
        boolean flag = true;
        int i = 0;
        int j = 1;
        while (i < array.length - 1) {
            j = i + 1;
            while (j < array.length) {
                if (array[i] == array[j]) {
                    flag = false;
                    break;
                }
                j++;
            }
            if (!flag) {
                break;
            }
            i++;
        }
        return flag;
    }

    public static boolean digitNext(int[] array, int digitNumber) { //digitNumber - разряд который нужно увеличить
        int l = array.length;
        int d = digitNumber;
        boolean flag = true;

        if (array[l - d] < l) {
            array[l - d]++;
        } else if (d == l) {
            System.out.println("end of enumeration");
            flag = false;
        } else {
            flag = digitNext(array, d + 1);
            if (flag) {
                array[l - d] = 1;
            }
        }
        //System.out.println(flag);
        return flag;

    }

    //print the array "array"
    public static void printArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + array[i] + "]  ");
        }
        System.out.println("");
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
