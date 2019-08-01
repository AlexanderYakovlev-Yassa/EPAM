public class Exercise_2_3_8 {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        int testNumber = 17;
        printArray(allPrimeDividers(testNumber));
    }

    public static int[] allPrimeDividers(int a) {
        int[] dividers = new int[0];
        int[] primeNumbers = primeNumbers(a);
        int prNumCounter = 0;
        int k = a;

        if (isPrimeNumber(a)) {
            dividers = addToArray(dividers, a);
        } else {
            while((k > 1) && (primeNumbers[prNumCounter] <= k)) {
                if (k % primeNumbers[prNumCounter] == 0) {
                    k = k / primeNumbers[prNumCounter];
                    dividers = addToArray(dividers, primeNumbers[prNumCounter]);
                } else {
                    prNumCounter++;
                }
            }
        }
        return dividers;
    }

    //returns the array of the prime numbers from 2 to maxNumber
    public static int[] primeNumbers(int maxNumber) {
        int[] prime = new int[0];
        for (int i = 2; i < maxNumber; i++) {
            if (isPrimeNumber(i)) {
                prime = addToArray(prime, i);
            }
        }
        return prime;
    }

    //returns the array which is contains "array" and number "a" at the end of it
    public static int[] addToArray(int[] array, int a) {
        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[newArray.length - 1] = a;
        return newArray;
    }

    //print the array "array"
    public static void printArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + array[i] + "]  ");
        }
        System.out.println("");
    }

    //Метод определяет является ли целое число простым
    public static boolean isPrimeNumber(int Num) {
        boolean flag = true;
        for (int i = 2; i < Num; i++) {
            if ((Num % i) == 0) {
                flag = false;
            }
        }
        return flag;
    }
}
