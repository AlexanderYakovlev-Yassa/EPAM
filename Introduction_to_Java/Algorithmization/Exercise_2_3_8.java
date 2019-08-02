public class Exercise_2_3_8 {

    public static void main(String[] args) {
        int[] array = {256, 32};
        /*int testNumber = 256;
        printArray(allPrimeDividers(testNumber));*/

        printArray(allPrimeDividersForAllNumbers(array));

    }

    //collects prime dividers of all the numbers that are required
    // to calculate of the Smallest Common Multiple
    public static int[] allPrimeDividersForAllNumbers(int[] numbers) {
        //System.out.println("*");
        int[] allDividers = new int[0];
        int[] dividersOfParticularNumber;
        boolean[] checkList;
        int j = 0; //counter for the loop
        int k = 0; //counter for the loop


        for (int i = 0; i < numbers.length; i++) { //iterate over all the numbers of the array
            dividersOfParticularNumber = allPrimeDividers(numbers[i]);
            checkList = new boolean[dividersOfParticularNumber.length];

            //D E B U G G I N G
            System.out.println();
            System.out.println("i=" + i + "  number " + numbers[i]);
            printArray(dividersOfParticularNumber);
            System.out.println();
            //*****************

            j = 0;
            while (j < allDividers.length)  {
                k = 0;
                while (k < dividersOfParticularNumber.length) {

                    if ((allDividers.length == 0) || (allDividers[j] == dividersOfParticularNumber[k]) && !checkList[k]) {
                        checkList[k] = true;
                        j++;
                        System.out.println("***");
                        break;
                    } else {
                        k++;
                    }
                }
                j++;
            }
            //printArray(prDivOfPartNumberCheck);
            for (int m = 0; m < dividersOfParticularNumber.length; m++) {
                if (!checkList[m]) {
                    allDividers = addToPrimeDividers(allDividers, dividersOfParticularNumber[m]);
                }
            }
        }
        return allDividers;
    }

    //adds "anotherDivider" to "primeDividers", so that it stays constantly increasing
    public static int[] addToPrimeDividers(int[] primeDividers, int anotherDivider) {
        int[] newDividers = new int[primeDividers.length + 1];
        boolean flag = true;

        if (newDividers.length == 1) {
            newDividers[0] = anotherDivider;
        } else {
            for (int i = 0; i < newDividers.length; i++) {
                if (flag) {
                    if ((i == newDividers.length - 1) || (anotherDivider <= primeDividers[i])) {
                        newDividers[i] = anotherDivider;
                        flag = false;
                    } else {
                        newDividers[i] = primeDividers[i];
                    }
                } else {
                    newDividers[i] = primeDividers[i - 1];
                }
            }
        }
        return newDividers;
    }

    //returns all prime numbers which is dividers of "a"
    public static int[] allPrimeDividers(int a) {
        int[] dividers = new int[0];
        int[] primeNumbers = primeNumbers(a);
        int prNumCounter = 0;
        int k = a;

        if (isPrimeNumber(a)) {
            dividers = addToArray(dividers, a);//spectrum[primeNumbers.length]++
        } else {
            while ((k > 1) && (primeNumbers[prNumCounter] <= k)) {
                if (k % primeNumbers[prNumCounter] == 0) {
                    k = k / primeNumbers[prNumCounter];
                    dividers = addToArray(dividers, primeNumbers[prNumCounter]);//spectrum[prNumCounter]++
                } else {
                    prNumCounter++;
                }
            }
        }
        return dividers;//spectrum
    }

   /* public static int[] primeDividersSpectrum(int a) {
        int[] primeNumbers = primeNumbers(a);
        int max = max(primeNumbers);
        int[] spectrum = new int[a];
        int prNumCounter = 0;
        int k = a;

        if (isPrimeNumber(a)) {
            spectrum[a]++;
        } else {
            while ((k > 1) && (primeNumbers[prNumCounter] <= k)) {
                if (k % primeNumbers[prNumCounter] == 0) {
                    k = k / primeNumbers[prNumCounter];
                    dividers = addToArray(dividers, primeNumbers[prNumCounter]);
                } else {
                    prNumCounter++;
                }
            }
        }
        return spectrum;
    }*/

//returns the max number from the "numbers"
    public static int max(int[] numbers){
        int max = 0;
        for (int i = 0; i < numbers.length; i++){
            max = max < numbers[i] ? numbers[i] : max;
        }

        return max;
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

   /* public static int[] addToArray(int[] firstArray, int[] secondArray) {
        int[] newArray = new int[firstArray.length + secondArray.length]
    }*/

    //print the array "array"
    public static void printArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + array[i] + "]  ");
        }
        System.out.println("");
    }

    public static void printArray(boolean[] array) {

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