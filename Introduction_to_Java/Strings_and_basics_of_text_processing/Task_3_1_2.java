/*Замените в строке все вхождения 'word' на 'letter'.*/

public class Task_3_1_2 {

    public static void main(String[] args) {
        String str = "The word rocket itself means firing arrow. He spoke those words three years ago.";
        String newStr = str.replace("word", "letter");
        String myNewStr = replace(str, "word", "letter");

        System.out.println("Origin      - " + str);
        System.out.println("JAVA method - " + newStr);
        System.out.println("My method   - " + myNewStr);
    }

    //changes in the origin all the words str1 to words str2
    public static String replace(String origin, String str1, String str2) {
        char[] charsOrigin = origin.toCharArray();
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        char[] res = new char[0];
        int firstLetterIndex = 0;

        char[] firstPart;
        char[] secondPart;

        for (int i = 0; i < charsOrigin.length; i++) {
            if (charsOrigin[i] == chars1[0]) {
                if (equal(charsFrom(charsOrigin, i, chars1.length), chars1)) {
                    secondPart = charsFrom(charsOrigin, firstLetterIndex, i - firstLetterIndex);
                    firstPart = concat(res, secondPart);
                    res = concat(firstPart, chars2);
                    firstLetterIndex = i + chars1.length;
                }
            }
        }
        res = concat(res, charsFrom(charsOrigin, firstLetterIndex, origin.length()  - firstLetterIndex));

        return String.copyValueOf(res);
    }

    //checks identity of char1 and char2
    private static boolean equal(char[] char1, char[] char2) {
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

    //returns the fragment of source begining from start and take length characters
    private static char[] charsFrom(char[] source, int start, int length) {

        length = (source.length - start - length > 0) ? length : source.length - start;
        char[] res = new char[length];
        for (int i = 0; i < res.length; i++) {
            res[i] = source[i + start];
        }

        return res;
    }

    //concates two char arrays
    private static char[] concat(char[] fr1, char[] fr2){
        char[] res = new char[fr1.length + fr2.length];
        for (int i = 0; i < res.length; i++){
            if ( i < fr1.length) {
                res[i] = fr1[i];
            } else {
                res[i] = fr2[i - fr1.length];
            }
        }
        return res;
    }
}


