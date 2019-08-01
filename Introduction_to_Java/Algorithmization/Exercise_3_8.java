public class Exercise_3_8 {
    public static void main(String[] args) {
        int[] fractions = {3,5,8,6,1,2,7,4,4,7,5,8,6,7,9,12,6,121};
        int numberOfFrsctions = fractions.length / 2; //количество дробей в массиве
        int numerator;   //числитель
        int denominator; //знаменатель
        int count = 0; //счетчик для определения количества простых делителей знаменателя
        int[] currentPrimeDeviders; //текущий массив для простых делителей i-го знаменателя

        printFractions(fractions);
        int[] [] primeDeviders = new int[numberOfFrsctions] [];  //определяем для каждой дроби набор простых чисел
        for (int i = 0; i < numberOfFrsctions; i++) {            // которые являются делителями знаменателей
            denominator = fractions[i * 2 + 1]; //знаменатель текущей (i-й) дроби
            for (int j = 2; j < denominator; j++){ //определяем количество простых делителей знаменателя
                if (isPrimeNumber(j)){
                    if(denominator % j == 0){
                        count++;
                    }
                }
            }
            currentPrimeDeviders = new int[count];
            count = 0;
            for (int j = 2; j < denominator; j++){  //повторяем цикл для заполнения массива
                                                    // простыми делителями знаменателя
                if (isPrimeNumber(j)){
                    if(denominator % j == 0){
                        currentPrimeDeviders[count] = j;
                        count++;
                    }
                }
            }
            primeDeviders[i] = currentPrimeDeviders.clone();
        }
        printTest(fractions, primeDeviders);
    }

    public static void printFractions(int[] array){

        for (int i = 0; i < array.length; i += 2){
            System.out.print("[" + array[i] + "/" + array[i + 1] + "]  ");
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

    public static void printTest(int[] fr, int[] [] dev){
        for (int i = 0; i < fr.length; i += 2) {
            System.out.print("[" + fr[i] + "/" + fr[i + 1] + "]    ");
            for (int j = 0; j < dev[i].length; j++){
                System.out.print(dev[i] [j] + "  ");
            }
            System.out.println("");
        }
    }
}
