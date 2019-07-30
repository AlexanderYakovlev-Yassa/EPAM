/*Даны две последовательности a1<=a2<=a3<=...<=an  и  b1<=b2<=b3<=...<=bn. Образовать из них новую последовательность
чисел так, чтобы она тоже была неубывающей. Примечание. Дополнительный массив не использовать.*/

public class Exercise_3_2 {

    public static void main(String[] args) {
        int[] a = {1,2,5,6,9,9,10,12,15};
        int[] b = {2,3,4,5,7,8,8,8,12,13,15,16};
        int[] c = newSortedArray(a, b);
        printArray(c);
    }

    public static int[] newSortedArray(int[] a, int[] b){
        int[] c = new int[a.length + b.length];
        int counterA = 0;
        int counterB = 0;
        for( int i = 0; i < c.length; i++){
            if (((counterA < a.length) || (counterB >= b.length)) && (a[counterA] < b[counterB])) {
                c[i] = a[counterA];
                counterA++;

            } else {
                c[i] = b[counterB];
                counterB++;
            }
        }
        return c;
    }

    //print the array "array"
    public static void printArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + array[i] + "]  ");
        }
        System.out.println("");
    }
}
