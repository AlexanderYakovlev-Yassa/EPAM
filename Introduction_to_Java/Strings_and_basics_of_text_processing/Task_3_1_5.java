/*Удалить в строке все лишние пробелы,
то есть серии подряд идущих пробелов заменить на одиночные пробелы.
Крайние пробелы в строке удалить.*/

public class Task_3_1_5 {

    public static void main(String[] args) {
        String str = " The average Wall Street   salary rose 13 percent last year to    its highest level   since 2008, when    Lehman Brothers Holdings Inc.  collapsed.      ";
        System.out.println(str);
        System.out.println(sleanSpaces(str));
    }

    public static String sleanSpaces(String str) {
        str = str.trim();
        int excessSpaces = 0;
        char[] chars = str.toCharArray();

        //counts the excess spaces
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] == ' ') && (chars[i - 1] == ' ')) {
                excessSpaces++;
            }
        }

        char[] newChars = new char[chars.length - excessSpaces];//the new char array
        int j = 0; //index of the new char array

        //forms the new char array
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] == ' ') && (chars[i - 1] == ' ')) {
                //does nothing
            } else {
                newChars[j] = chars[i];
                j++;
            }
        }

        str = String.copyValueOf(newChars);

        return str;
    }
}
