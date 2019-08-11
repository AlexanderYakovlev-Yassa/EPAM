/*Два простых числа называются «близнецами», если они отличаются друг от друга на 2 (например, 41 и 43).
Найти и напечатать все пары «близнецов» из отрезка [n,2n], где n - заданное натуральное число больше 2.
Для решения задачи использовать декомпозицию*/

public class Task_2_4_13 {

    public static void main(String[] args) {
        printTwins(50000);
    }

    public static void printTwins(int n){
        int[] array = arrayByTheRule(n);
        if (array.length == 1) {
            System.out.println("n должно быть в диапазоне от 2 до " + Integer.MAX_VALUE/2);
        } else {
            for (int i = 0; i < array.length - 2; i++){
                if(i % 10 != 0) {
                    System.out.print("[" + array[i] + " - " + array[i + 2] + "] ");
                } else {
                    System.out.println("");
                }
            }
        }
    }

    public static int[] arrayByTheRule(int n) {
        int k; //number of members of the returning array
        if ((n < 2) || (n > Integer.MAX_VALUE/2)) { // if this method can't to generate the array according to the rule than returns array with one member and its value equals -1
            k = 1;
        } else {
            k = n * 2 - n + 1;
        }
        int[] array = new int[k];
        if (k == 1) {
            array[0] = -1;
        } else {
            for (int i = 0; i < array.length; i++) {
                array[i] = i + n;
            }
        }
        return array;
    }
}
