/*Замените в строке все вхождения 'word' на 'letter'.*/

public class Task_3_1_2 {

    public static void main(String[] args) {
        String str = "The word rocket itself means firing arrow. He spoke those words three years ago.";
        String newStr = str.replace("word", "letter");
        System.out.println(str + "\n" + newStr);
        char[] chars1 = {'w', 'o', 'r', 'd'};
        char[] chars2 = str.toCharArray();
        System.out.println(charsFrom(chars2, 4, 4));
    }

    //changes is the origin all the words str1 to words str2
    public static String replace(String origin, String str1, String str2) {
        char[] charsOrigin = origin.toCharArray();
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        for (int i = 0; i < charsOrigin.length; i++) {
            if (charsOrigin[i] == chars1[0]) {

            }
        }
        return "her";
    }

    //checks identity of char1 and char2
    private static boolean ident(char[] char1, char[] char2) {
        boolean flag = true;
        int i = 0;
        if (char1.length == char2.length) {
            while (i < char1.length) {
                if (char1[i] != char2[i]) {
                    flag = false;
                    break;
                }
                i++;
            }
        } else {
            flag = false;
        }
        return flag;
    }

   /* //returns the fragment of source begining from start and take length characters
    private static char[] charsFrom(char[] source, int start, int length){

        length = (source.length - start - length >0)
            char[] res = new char[length];
            for (int i = 0; i < res.length; i++) {
                res[i] = source[i + start];
            }

        return res;
    }*/
}


