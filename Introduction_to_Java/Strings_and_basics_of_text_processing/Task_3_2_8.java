/*Вводится строка слов, разделенных пробелами.
Найти самое длинное слово и вывести его на экран.
Случай, когда самых длинных слов может быть несколько, не обрабатывать*/

import java.util.Scanner;

public class Task_3_2_8 {
    public static void main(String[] args) {
        String str = "Many users return to the homepage to begin a new task or to start a task over again.";
        String[] a = new String[0];
        /*a = appendToArray(a, "first");
        a = appendToArray(a, "second");
        MyUtils.printArray(a);*/
        String[] arr = textToWords(str);
        //MyUtils.printArray(arr);
        System.out.println(str);
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + "*");
        }
        //System.out.println(refine(userInput()));
    }

    public static String userInput() {
        Scanner scan = new Scanner(System.in);
        StringBuilder strB = new StringBuilder(0);
        System.out.print("Введите строку >");
        strB.append(scan.nextLine());

        String str = strB.toString().trim();
        return str;
    }

    public static String[] textToWords(String str){
        str = cleanSpaces(str);
        String[] strArray = new String[0];
        char[] chars = str.toCharArray();
        String nextStr  = new String();
        int nextPos = 0;
        int prevPos = 0;
        System.out.println(str.length());
        boolean flag = true;
        while (flag){
            nextPos = str.indexOf(' ', nextPos + 1);
            if (nextPos == -1){
                nextPos = str.length();
                flag = false;
            }
            
            strArray = appendToArray(strArray, str.substring(prevPos, nextPos));
            prevPos = nextPos + 1;
        }

        return strArray;
    }

    public static String theLongestWord(String[] str){
        String lWord = "";
        return lWord;
    }

    //cleans up from the excess spaces
    public static String cleanSpaces(String str) {
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


    private static String[] appendToArray(String[] array, String str){
        String[] newArray = new String[array.length + 1];
        for(int i = 0; i < array.length; i++){
            newArray[i] = array[i];
        }
        newArray[newArray.length - 1] = str;
        return  newArray;
    }
}
