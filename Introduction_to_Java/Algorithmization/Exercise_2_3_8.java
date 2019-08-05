
import java.lang.Math;

public class Exercise_2_3_8 {

    public static void main(String[] args) {
        //printArray(spectrum(1));
        int[] array = {2, 3, 5, 2, 2, 9, 5, 8, 8, 11, 1, 2, 7, 11};
        printFraction(array);
        int[] dividers = new int[array.length / 2];

        for (int i = 0; i < array.length; i += 2) {
            dividers[i / 2] = array[i + 1];
        }
        //printArray(dividers);
        int s = smallestCommonX(dividers);
        //System.out.println(s);
        int[] array0 = new int[array.length];
        int[] array1 = new int[array.length/2];
        int multiplier;
        for (int i = 0; i < array.length; i += 2) {
            multiplier = s / array[i + 1];
            array0[i] = array[i] * multiplier;
            array0[i + 1] = s;
        }
        for (int i = 0; i < array.length; i += 2) {
            multiplier = s / array[i + 1];
            array1[i/2] = array[i] * multiplier;
        }
        printArray(array1);
        int maxX = max(array1);
        System.out.println("the max fraction is " + maxX + "/" + s);
    }


    public static int smallestCommonX(int[] array) {
        int[] spectrum = allPrimeDividersForAllNumbers(array);
        int num = 1;
        //printArray(spectrum);
        for (int i = 0; i < spectrum.length; i++) {

            num = spectrum[i] != 0 ? num * powInt(primeNumbersByIndex(i), spectrum[i]) : num; //num * primeNumbersByIndex(spectrum[i]) : num;
            //System.out.println(num);
        }
        return num;
    }

    public static int powInt(int a, int b) {
        int x = 1;
        for (int i = 0; i < b; i++) {
            x *= a;
        }
        return x;
    }

    public static int primeNumbersByIndex(int index) {
        int prime = 2;
        int currentIndex = 0;
        int counter = 2;
        if (index == 0) {
            prime = 2;
        } else {
            while (currentIndex <= index) {
                if (isPrimeNumber(counter)) {
                    prime = counter;
                    currentIndex++;
                }
                counter++;
            }
        }
        return prime;
    }

    //collects prime dividers of all the numbers that are required
    // to calculate of the Smallest Common Multiple
    public static int[] allPrimeDividersForAllNumbers(int[] numbers) {
        //System.out.println("*");
        int[] allDividers = new int[0];
        int[] spectrumOfParticularNumber;
        int[] spectrumOfAllNumbers = new int[0];
        boolean[] checkList;
        int j = 0; //counter for the loop
        int k = 0; //counter for the loop


        for (int i = 0; i < numbers.length; i++) { //iterate over all the numbers of the array
            spectrumOfParticularNumber = spectrum(numbers[i]);
            spectrumOfAllNumbers = additionOfSpectrums(spectrumOfAllNumbers, spectrumOfParticularNumber);
        }
        return spectrumOfAllNumbers;
    }

    public static int[] additionOfSpectrums(int[] spectrumOfAll, int[] spectrum) {
        int spLength = spectrumOfAll.length > spectrum.length ? spectrumOfAll.length : spectrum.length;
        int[] sp = new int[spLength];
        //System.out.println("sp len " + sp.length);
        //System.out.println("s all len " + spectrumOfAll.length);
        //System.out.println("s len " + spectrum.length);
        for (int i = 0; i < spLength; i++) {
            if ((i < spectrumOfAll.length) && (i < spectrum.length)) {
                sp[i] = (spectrumOfAll[i] > spectrum[i]) ? spectrumOfAll[i] : spectrum[i];
            } else {
                sp[i] = (spectrumOfAll.length > spectrum.length) ? spectrumOfAll[i] : spectrum[i];
            }
        }
        return sp;
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

    /*public static int[] primeDividersSpectrum(int a) {
        int[] primeNumbers = primeNumbers(a);
        int maxIndex = maxIndex(primeNumbers);
        System.out.println("send");
        printArray(primeNumbers);
        System.out.println(maxIndex);
        int[] spectrum = new int[maxIndex];
        int prNumCounter = 0;
        int k = a;
        if (isPrimeNumber(a)) {
            spectrum[primeNumbers.length]++;
        } else {
            while ((k > 1) && (primeNumbers[prNumCounter] <= k)) {
                if (k % primeNumbers[prNumCounter] == 0) {
                    k = k / primeNumbers[prNumCounter];
                    spectrum[prNumCounter]++;
                } else {
                    prNumCounter++;
                }
            }
        }
        return spectrum;
    }*/

    public static int[] spectrum(int number) {
        int[] allPrDiv = allPrimeDividers(number);
        int max = maxIndex(allPrDiv);
        int[] spectrum = new int[max];
        //System.out.println("max  " + max);
        //System.out.println("allPrDiv.length = " + allPrDiv.length);
        for (int i = 0; i < allPrDiv.length; i++) {
            spectrum[index(allPrDiv[i])]++;
            //System.out.println("indices " + index(allPrDiv[i]));
        }
        return spectrum;
    }

    public static int index(int primeNumber) {
        int[] primeNumbers = primeNumbers(primeNumber);
        //System.out.println("prnb" + primeNumber);
        //printArray(primeNumbers);
        int index = primeNumbers.length - 1;
        return index;
    }

    //returns the index of the max prime number from the "numbers"
    public static int maxIndex(int[] numbers) {
        int max = 0;
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            max = max < numbers[i] ? numbers[i] : max;
        }
        //System.out.println("max" + max);
        for (int i = 2; i <= max; i++) {
            index = isPrimeNumber(i) ? index + 1 : index;
        }

        return index;
    }

    //returns the  max of "numbers"
    public static int max(int[] numbers) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            max = max < numbers[i] ? numbers[i] : max;
        }

        return max;
    }
    //returns the array of the prime numbers from 2 to maxNumber
    public static int[] primeNumbers(int maxNumber) {
        int[] prime = new int[0];
        for (int i = 2; i <= maxNumber; i++) {
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

    public static void printFraction(int[] array) {
        for (int i = 0; i < array.length; i += 2) {
            System.out.print("[" + array[i] + "/" + array[i + 1] + "]  ");
        }
        System.out.println("");
    }
}