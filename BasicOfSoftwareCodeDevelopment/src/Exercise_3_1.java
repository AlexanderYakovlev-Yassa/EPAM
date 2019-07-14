import java.util.Scanner;

//1. Напишите программу, где пользователь вводит любое целое положительное число.
// А программа суммирует все числа от 1 до введенного пользователем числа.
public class Exercise_3_1 {

    public static void main(String[] args){
        userFunc();
    }

    public static void userFunc(){
        Scanner in = new Scanner(System.in);
        System.out.print("Incert any positiv number bigger than one >");
        int x = in.nextInt();
        if (x > 1) {
            System.out.println("The summ of numbers from 1 to " + x + " is " + summa(x));
        } else {
            System.out.println("you must insert number bigger than 1 ");
        }
    }

    public static long summa(int x){
        long summ = 0;
        for (long i = 1; i <= x; i++){
            summ += i;
        }
        return summ;
    }
}
