/*Даны натуральные числа К и N. Написать метод(методы) формирования массива А,
 элементами которого являются числа, сумма цифр которых равна К и которые не большее N.*/

public class Exercise_2_4_12 {

    public static void main(String[] args) {
        printArray(arrayA(34, 100000));
    }

    public static int[] arrayA(int k, int n){
        int[] res = new int[0];
        int[] numbers;
        int sum = 0;
        for (int i = 1; i <=n; i++){
            numbers = arrayOfDigits(i);
            for (int j = 0; j < numbers.length; j++){
                sum += numbers[j];
            }
            if (sum == k){
                res = addToArray(res, i);
            }
            sum = 0;
        }
        return res;
    }

    //public static int summ

    //returns array of digits which are contained in "number"
    public static int[] arrayOfDigits(int number) {
        int p = (int) Math.log10(number);
        int[] digits = new int[p + 1];
        int a = (int) Math.pow(10, p);
        int i = 0;
        while (a > 0) {
            digits[i] = number / a;
            number = number - digits[i] * a;
            i++;
            a /= 10;
        }
        return digits;
    }

    public static int[] addToArray(int[] array, int nextMember){
        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < array.length; i++){
            newArray[i] = array[i];
        }
        newArray[newArray.length - 1] = nextMember;
        return newArray;
    }

    //print the array "array"
    public static void printArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + array[i] + "]  ");
            if ((i + 1) % 10 == 0){
                System.out.println("");
            }
        }
        System.out.println("");
    }
}
