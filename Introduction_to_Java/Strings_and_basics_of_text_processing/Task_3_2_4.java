/*С помощью функции копирования и операции конкатенации составить из частей слова “информатика” слово “торт”*/

public class Task_3_2_4 {
    public static void main(String[] args) {
        String str = "информатика";

        String newStr = str.substring(7, 8).concat(str.substring(3, 5)).concat(str.substring(7, 8));

        String newStr1 = Character.toString(str.charAt(7)).
                concat(Character.toString(str.charAt(3))).
                concat(Character.toString(str.charAt(4))).
                concat(Character.toString(str.charAt(7)));

        System.out.println(str);
        System.out.println(newStr);
        System.out.println(newStr1);
    }
}
