/*В строке найти количество чисел.*/

public class Task_3_1_4 {
    public static void main(String[] args) {
        String str = "The average Wall Street salary rose 13 percent last year to its highest level since 2008, when Lehman Brothers Holdings Inc. collapsed." +
                " ... Salaries gained as pretax profits rose 42 percent to $24.5 billion last year. In the first half of 2018, the earnings totaled $13.7 billion, " +
                "up 11 percent from a year earlier, he said.";
        System.out.println(numberOfNumbers(str));
    }

    public static int numberOfNumbers(String str) {
        char[] chars = str.toCharArray();

        int numbers = 0;
        int i = 0;
        boolean firstPoint = false;
        boolean isNumber = false;
        while (i < chars.length) {
            if (Character.isDigit(chars[i])) {
                if (!isNumber) {
                    isNumber = true;
                    numbers++;
                }                
            } else {
                if (chars[i] == '.'){
                    if (!firstPoint && isNumber){
                        firstPoint = true;
                    } else if (firstPoint && isNumber){
                        firstPoint = false;
                        isNumber = false;
                    }
                } else {
                    isNumber = false;
                }
            }
            i++;
        }

        return numbers;
    }
}
