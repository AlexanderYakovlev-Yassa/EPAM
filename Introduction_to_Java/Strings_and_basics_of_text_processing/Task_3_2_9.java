/*Посчитать количество строчных (маленьких) и прописных (больших) букв
 в введенной строке. Учитывать только английские буквы.*/

import java.util.Scanner;

public class Task_3_2_9 {

    public static void main(String[] args) {

        char ch;
        char[] chars = userInput().toCharArray();

        int lowCase = 0;
        int upCase = 0;

        for (int i = 0; i < chars.length; i++){
            ch = chars[i];
            if (((int)ch >= 97) && ((int)ch <= 122)){
                lowCase++;
            } else if (((int)ch >= 65) && ((int)ch <= 90)){
                upCase++;
            }
        }

        System.out.println(lowCase +" букв в нижнем регистре и "+ upCase +  " букв в верхнем регистре." );
    }

    //provides an user input
    public static String userInput() {
        Scanner scan = new Scanner(System.in);
        StringBuilder strB = new StringBuilder(0);
        System.out.print("Введите строку >");
        strB.append(scan.nextLine());

        String str = strB.toString().trim();
        return str;
    }
}
