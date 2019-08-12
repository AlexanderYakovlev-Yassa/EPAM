/*Замените в строке все вхождения 'word' на 'letter'.*/

public class Task_3_1_2 {

    public static void main(String[] args) {
        String str = "The word rocket itself means firing arrow. He spoke those words three years ago.";
        String newStr = str.replace("word", "letter");
        System.out.println(str + "\n" + newStr);
    }
}


