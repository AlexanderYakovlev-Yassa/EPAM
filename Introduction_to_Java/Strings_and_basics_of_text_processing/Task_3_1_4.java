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

        numbers = isNumber('x', 'x',chars[0]) ? numbers + 1 : numbers;
        numbers = isNumber('x', chars[0], chars[1]) ? numbers + 1 : numbers;

        for (int i = 0; i < chars.length-2; i++){
            if (isNumber(chars[i], chars[i + 1], chars[i + 2])){
                numbers++;
            }
        }

        return numbers;
    }

    private static boolean isNumber(char first, char second, char third){
        boolean res;

        if (Character.isDigit(third)){
            if (Character.isDigit(second)){
                res = false;
            } else if (second == '.' || second == ','){
                if (Character.isDigit(first)){
                    res = false;
                } else {
                    res = true;
                }
            } else {
                res = true;
            }
        } else {
            res = false;
        }

        return res;
    }
}