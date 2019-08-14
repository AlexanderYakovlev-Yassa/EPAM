/*Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем.*/

public class Task_3_2_1 {

    public static void main(String[] args) {
        String str = " The average Wall Street   salary rose      13 percent last year to    its highest level   since 2008, when    Lehman Brothers Holdings Inc.  collapsed.";
        System.out.println("В строке:\n" + str + "\n"  + "максимальное количество пробелов идущих подряд равно " + maxSpacesValue(str) + ".");
    }

    public static int maxSpacesValue(String str) {
        int spaces = 0;
        int maxSpaces = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ' '){
                spaces++;
                maxSpaces = maxSpaces >= spaces ? maxSpaces : spaces;
            } else {
                spaces = 0;
            }
        }
    return maxSpaces;
    }
}
