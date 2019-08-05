/*Даны дроби (числитель и знаменатель натуральные). Составить программу, которая приводит эти дроби к общему
знаменателю и упорядочивает их в порядке возрастания.*/

public class Exercise_2_3_8 {

    public static void main(String[] args) {

        //source array of fractions. Odd members are fraction numerator,
        // even are fraction denominator.
        int[] sourceFractions = {2, 1, 5, 2, 2, 9, 5, 8, 8, 11, 1, 2, 7, 11};
        System.out.println("Source fractions is:");
        printFraction(sourceFractions);
        System.out.println("");

        int[] denominators = new int[sourceFractions.length / 2];

        for (int i = 0; i < sourceFractions.length; i += 2) {
            denominators[i / 2] = sourceFractions[i + 1];
        }

        int l_c_m = leastCommonMultiple(denominators);
        int[] reducedFractions = new int[sourceFractions.length];
        int factor;

        //reducing of fractions to the common denominator
        for (int i = 0; i < sourceFractions.length; i += 2) {
            factor = l_c_m / sourceFractions[i + 1];
            reducedFractions[i] = sourceFractions[i] * factor;
            reducedFractions[i + 1] = l_c_m;
        }
        System.out.println("The fractions which are reduced to common denominator:");
        printFraction(reducedFractions);
        System.out.println("");
        sortByShellForFractions(sourceFractions, reducedFractions);
        System.out.println("Source and reduced fractions sorted from min to max:");
        printFraction(sourceFractions);
        printFraction(reducedFractions);
    }

    //calculates the least common multiple
    public static int leastCommonMultiple(int[] array) {
        int[] spectrum = allPrimeDividersForAllNumbers(array);
        int num = 1;
        //printArray(spectrum);
        for (int i = 0; i < spectrum.length; i++) {

            num = spectrum[i] != 0 ? num * powInt(primeNumbersByIndex(i), spectrum[i]) : num; //num * primeNumbersByIndex(spectrum[i]) : num;
            //System.out.println(num);
        }
        return num;
    }

    //returns "a" raised to the power of "b"
    public static int powInt(int a, int b) {
        int x = 1;
        for (int i = 0; i < b; i++) {
            x *= a;
        }
        return x;
    }

    //returns prime number by index in array
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
    // to calculate of the Least Common Multiple
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

    //addition of spectrums according to the rule
    public static int[] additionOfSpectrums(int[] spectrumOfAll, int[] spectrum) {
        int spLength = spectrumOfAll.length > spectrum.length ? spectrumOfAll.length : spectrum.length;
        int[] sp = new int[spLength];

        for (int i = 0; i < spLength; i++) {
            if ((i < spectrumOfAll.length) && (i < spectrum.length)) {
                sp[i] = (spectrumOfAll[i] > spectrum[i]) ? spectrumOfAll[i] : spectrum[i];
            } else {
                sp[i] = (spectrumOfAll.length > spectrum.length) ? spectrumOfAll[i] : spectrum[i];
            }
        }
        return sp;
    }


    //returns all prime numbers which is dividers of "a"
    public static int[] allPrimeDividers(int a) {
        int[] dividers = new int[0];
        int[] primeNumbers = primeNumbers(a);
        int prNumCounter = 0;
        int k = a;

        if (isPrimeNumber(a)) {
            dividers = addToArray(dividers, a);
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
        return dividers;
    }

    //returns the spectrum of prime dividers of the number
    public static int[] spectrum(int number) {
        int[] spectrum = {0};
        if (number != 1) {
            int[] allPrDiv = allPrimeDividers(number);
            int max = maxIndex(allPrDiv);
            spectrum = new int[max];

            for (int i = 0; i < allPrDiv.length; i++) {
                spectrum[index(allPrDiv[i])]++;
            }
        }
        return spectrum;
    }

    //returns index of prime number
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
        for (int i = 2; i <= max; i++) {
            index = isPrimeNumber(i) ? index + 1 : index;
        }

        return index;
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

    //returns the array which is contains source array and number "a" at the end of it
    public static int[] addToArray(int[] array, int a) {
        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[newArray.length - 1] = a;
        return newArray;
    }

    //sorts reduced and source arrays of fractions from min to max
    public static void sortByShellForFractions(int[] sourceFractions, int[] reducedFractions) {
        int i = 0;
        while (i < reducedFractions.length - 2) {
            if (reducedFractions[i] <= reducedFractions[i + 2]) {
                i += 2;
            } else {
                swap(reducedFractions, i, i + 2);
                swap(reducedFractions, i + 1, i + 3);
                swap(sourceFractions, i, i + 2);
                swap(sourceFractions, i + 1, i + 3);
                if (i > 0) {
                    i -= 2;
                } else {
                    i += 2;
                }
            }
        }
    }

    //swaps picked elements of the array
    public static void swap(int[] array, int a, int b) {
        if ((a >= 0 && b >= 0) && (a < array.length && b < array.length)) {
            int bubble = array[a];
            array[a] = array[b];
            array[b] = bubble;
        } else {
            System.out.println("swap - indices is out of bound");
        }
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

    //printa array as a set of fractions
    public static void printFraction(int[] array) {
        for (int i = 0; i < array.length; i += 2) {
            System.out.print("[" + array[i] + "/" + array[i + 1] + "]  ");
        }
        System.out.println("");
    }
}