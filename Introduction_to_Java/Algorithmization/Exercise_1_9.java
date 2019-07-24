/*
В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число. Если таких
чисел несколько, то определить наименьшее из них
*/

public class Exercise_1_9 {

    public static void main(String[] args) {

        int[] a = {0, 12, 3, 23, 22, 18, 28, 8, 2, 38, 0};

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }
        System.out.println("");
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
                        //System.out.println("XXXX " + i + "  " + j + " " + currRepeats);
                        //prinArrayInLine(checked);
                        flag = true;
                        currNumber = a[i];
                    }
                }
            }
            if (currRepeats == maxRepeats) {
                maxNumber = maxNumber > a[i] ? a[i] : maxNumber;
                //System.out.println("111");
            } else if (currRepeats > maxRepeats) {
                maxRepeats = currRepeats;
                maxNumber = currNumber;
                //System.out.println("222");
            }
            currRepeats = 1;
        }
        if (flag) {
            System.out.println("number = " + maxNumber);
            System.out.println("times of repeats = " + maxRepeats);
        } else {
            System.out.println("There are no repeated numbers in this array");
        }
        //prinArrayInLine(checked);
    }

    public static void prinArrayInLine(boolean[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i]) {
                System.out.print("X ");
            } else {
                System.out.print("O ");
            }
        }
        System.out.println("");
    }
}
