/*Составить программу нахождения произведения квадратов первых двухсот чисел.

примитивного типа данных Long недостаточно для решения задачи,
поэтому в решении используем объект BigInteger
 */

import java.math.BigInteger;

public class Task_1_3_4 {

    public static void main(String[] args){
        System.out.println("Multiplying of first 100 numbers in power of 2 is " + function_3_4());
    }

    public static BigInteger function_3_4(){
        BigInteger mult = BigInteger.valueOf(1L);
        for (int i = 1; i <= 100; i++){
            mult = mult.multiply(BigInteger.valueOf(i * i));
        }
        return mult;
    }
}
