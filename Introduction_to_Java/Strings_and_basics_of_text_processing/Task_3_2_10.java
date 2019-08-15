/*Строка X состоит из нескольких предложений,
 каждое из которых кончается точкой, восклицательным или вопросительным знаком.
  Определить количество предложений в строке X.*/

public class Task_3_2_10 {

    public static void main(String[] args) {
        int sentances = 0;
        String str ="Horizontal scrolling is a slow and tedious way! to view an... entire screen. Common page? layouts including fluid and left-justified may require some users to scroll horizontally if their monitor resolution or size is smaller than that used by designers.";
    for (int i = 0; i < str.length(); i++){
        if (isEndOfSentance(str, i)){
            sentances++;
        }
    }
        System.out.println("Количество предложений в строке " + sentances + ".");
    }

    public  static boolean isEndOfSentance(String str, int index){
        boolean sent = false;

        if ((str.charAt(index) == '.') ||
                (str.charAt(index) == '!') ||
                (str.charAt(index) == '?')) {
            if (index == str.length() - 1) {
                sent = true;
            } else if (str.charAt(index + 1) == ' '){
                sent = true;
            } else {
                sent = false;
            }
        } else {
            sent = false;
        }

        return sent;
    }

}
