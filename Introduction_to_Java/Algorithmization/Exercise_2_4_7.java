/*Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9.*/

public class Exercise_2_4_7 {

    public static void main(String[] args) {
        //int a = -100;
        System.out.println(sum());
    }

    //returns sum of factorials of odd numbers from 1 to 9
    public static int sum(){
        int s = 0;
        for (int i = 1; i <= 9; i += 2){
            s += factorial(i);
            System.out.println(factorial(i));
        }
        return s;
    }

    //returns factorial of the number a
    //if a < 0 the metod returns -1
    public static int factorial(int a) {
        int f = 2;

        if (a < 0) {
            f = -1;
        } else if (a == 0 || a == 1) {
            f = 1;
        } else if (a > 2) {
            for (int i = 3; i <= a; i++) {
                f = f * i;
            }
        } else {
        }

        return f;
    }
}
