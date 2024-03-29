/*
В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число. Если таких
чисел несколько, то определить наименьшее из них
*/

public class Task_2_1_9 {

    public static void main(String[] args) {

        int[] a = {0, 12, 3, 3, 22, 2, 2, 2, 18, 28, 8, 3, 38, 0};

        findTheMostRepeatedNumber(a);
    }

    public static void findTheMostRepeatedNumber(int[] a) {
        boolean[] checked = new boolean[a.length];//the array that indicates whether the corresponding element of array A was checked
        int currRepeats = 1; //current number of repeats
        int maxRepeats = 0; //maximal number of repeats
        int currNumber = a[0]; //current number that repeats
        int maxNumber = a[0]; //number which repeats maximal times
        boolean flag = false; //the flag which is false while there are no repeats

        for (int i = 0; i < a.length; i++) {
            checked[i] = true;
            for (int j = 0; j < a.length; j++) {
                if (!checked[j]) {
                    if (a[i] == a[j]) {
                        checked[j] = true;
                        currRepeats++;
                        flag = true;
                        currNumber = a[i];
                    }
                }
            }
            if (currRepeats == maxRepeats) {
                maxNumber = maxNumber > a[i] ? a[i] : maxNumber;
            } else if (currRepeats > maxRepeats) {
                maxRepeats = currRepeats;
                maxNumber = currNumber;
            }
            currRepeats = 1;
        }
        if (flag) {
            System.out.println("number = " + maxNumber);
            //System.out.println("times of repeats = " + maxRepeats);
        } else {
            System.out.println("There are no repeated numbers in this array");
        }

    }
}
