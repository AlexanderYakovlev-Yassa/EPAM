/*Проверить, является ли заданное слово палиндромом.*/

public class Task_3_2_3 {

    public static void main(String[] args) {
        String str = "Abba ";
        System.out.println(isPalindrome(str));
    }

    public static boolean isPalindrome(String str){
        str = str.trim();
        boolean res = true;
        int i = 0;

        while ( i < str.length()/2){
            if (Character.toLowerCase(str.charAt(i)) != Character.toLowerCase(str.charAt(str.length()-i-1))){
                res = false;
                break;
            }
            i++;
        }
        return res;
    }
}
