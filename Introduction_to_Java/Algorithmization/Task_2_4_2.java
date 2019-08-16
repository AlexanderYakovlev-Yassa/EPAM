/*Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел*/

public class Task_2_4_2 {

    public static void main(String[] args) {
        int[] numbers = {5, 15, 25, 6};
        //System.out.println(greatCommonMultiple(5, 25));
        System.out.println(greatCommonMultipleForMoreThanTwo(numbers));
    }

    public  static int greatCommonMultipleForMoreThanTwo(int[] numbers){
        int gcm = greatCommonMultiple(numbers[0], numbers[1]);
        for (int i = 2; i<numbers.length-1; i++){
            gcm = greatCommonMultiple(gcm, numbers[i]);
        }
        return gcm;
    }

    //returns great common multiple of two numbers
    public static int greatCommonMultiple(int a, int b) {
        int gcm = -1;
        if (a == b) {
            gcm = a;
        } else if ((a == 1) || (b == 1)) {
            gcm = 1;
        } else if (a == 0) {
            gcm = b;
        } else if (b == 0) {
            gcm = a;
        } else if (a % 2 == 0) {
            if (b % 2 != 0) {
                gcm = greatCommonMultiple(a / 2, b);                //a even, b odd
            } else {
                gcm = 2 * greatCommonMultiple(a / 2, b / 2);    //a even, b even
            }
        } else if (b % 2 == 0) {
            if (a % 2 != 0) {
                gcm = greatCommonMultiple(a, b / 2);               //a odd, b even
            }

        } else {
            //a odd, b odd
            if (a > b) {
                gcm = greatCommonMultiple((a - b) / 2, b);        // a > b
            } else {
                gcm = greatCommonMultiple(a, (b - a) / 2);        // a < b
            }
        }
        return gcm;
    }
}