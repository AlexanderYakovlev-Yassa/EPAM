/*Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы. Например, если было введено "abc cde def", то должно быть выведено "abcdef".*/

import java.util.Scanner;

public class Task_3_2_7 {
    public static void main(String[] args) {
        System.out.println(refine(userInput()));
    }

    public static String userInput() {
        Scanner scan = new Scanner(System.in);
        StringBuilder strB = new StringBuilder(0);
        System.out.print("Введите строку >");
        strB.append(scan.nextLine());

        String str = strB.toString().trim();
        return str;
    }

    public static String refine(String str) {
        StringBuilder strB = new StringBuilder(0);
        strB.append(str.charAt(0));
        int i = 0;
        boolean flag = true;

        for (int j = 0; j < str.length(); j++) {
            i = 0;
            flag = true;
            while (i < strB.length()) {
                if ((strB.charAt(i) == str.charAt(j)) || (str.charAt(j) == ' ')) {
                    flag = false;
                    break;
                }
                i++;
            }
            if (flag) {
                strB.append(str.charAt(j));
            }
        }
        String res = strB.toString();
        return res;
    }
}
