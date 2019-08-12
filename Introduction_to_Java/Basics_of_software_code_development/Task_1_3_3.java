
//Найти сумму квадратов первых ста чисел.

public class Task_1_3_3 {

    public static void main(String[] args){
        System.out.println("Summ of first 100 numbers in power 2 is " + function_3_3());
    }

    public static int function_3_3(){
        int summ = 0;
        for (int i = 1; i <= 100; i++){
            summ += i * i;
        }
        return summ;
    }
}
