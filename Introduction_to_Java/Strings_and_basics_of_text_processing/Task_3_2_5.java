/*Подсчитать, сколько раз среди символов заданной строки встречается буква “а”.*/

public class Task_3_2_5 {

    public static void main(String[] args) {
        String str = "The average Wall Street salary rose.";

        System.out.println("В строку [" + str + "] буква [a] входит " + numberOfLetter(str, 'a') + " раз.");
    }

    public static int numberOfLetter(String str, char ch){
        int startIndex = 0;
        int res = 0;

        while (startIndex >= 0) {
            startIndex = str.indexOf(ch, startIndex + 1);
            res = startIndex == -1 ? res : res + 1;
        }
        return res;
    }

}
