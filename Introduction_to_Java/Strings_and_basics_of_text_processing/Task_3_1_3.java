/*В строке найти количество цифр*/

public class Task_3_1_3 {

    public static void main(String[] args) {
        String str = "The average Wall Street salary rose 13 percent last year to its highest level since 2008, when Lehman Brothers Holdings Inc. collapsed." +
                " ... Salaries gained as pretax profits rose 42 percent to $24.5 billion last year. In the first half of 2018, the earnings totaled $13.7 billion, " +
                "up 11 percent from a year earlier, he said.";
        System.out.println(numberOfDigits(str));
    }

    public  static int numberOfDigits(String str){
        char[] chars = str.toCharArray();

        int digits = 0;
        for (int i = 0; i < chars.length; i++){
            digits = Character.isDigit(chars[i]) ? digits + 1 : digits;
        }

        return digits;
    }
}
