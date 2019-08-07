/*Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр.*/

public class Exercise_2_4_11 {

    public static void main(String[] args) {
        int x = 12345;
        int y = 67465000;
        int c = compareNumberOfDigits(x, y);
        if (c == 1) {
            System.out.println(x + " состоит из большего количества цифр, чем число " + y);
        } else if (c == -1) {
            System.out.println(x + " состоит из большего количества цифр, чем число " + y);
        } else {
            System.out.println(x + " и " + y + " состоят из одинакового количества цифр");
        }
    }

    //compares two numbers
    // returns 1 if number of digits x > number of digits y
    // returns -1 if number of digits x < number of digits y
    // returns 0 if number of digits x = number of digits y
    public static int compareNumberOfDigits(int x, int y) {
        int res;
        int xD = numberOfDigits(x);
        int yD = numberOfDigits(y);
        if (xD > yD) {
            res = 1;
        } else if (xD < yD) {
            res = -1;
        } else {
            res = 0;
        }
        return res;
    }

    /**
     * @param number
     * @return
     */
    //returns array of digits which are contained in "number"
    public static int[] arrayOfDigits(int number) {
        int p = (int) Math.log10(number);
        int[] digits = new int[p + 1];
        int a = (int) Math.pow(10, p);
        int i = 0;
        while (a > 0) {
            digits[i] = number / a;
            number = number - digits[i] * a;
            i++;
            a /= 10;
        }
        return digits;
    }

    //returns number of digits which is "number" consisted
    public static int numberOfDigits(int number) {
        int dig = 0;
        int[] digits = arrayOfDigits(number);
        int[] spectrum = new int[10];
        for (int i = 0; i < digits.length; i++) {
            spectrum[digits[i]] = 1;
        }
        for (int i = 0; i < spectrum.length; i++) {
            dig += spectrum[i];
        }
        return dig;
    }

}
