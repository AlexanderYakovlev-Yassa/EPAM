/*Составить программу, которая в массиве A[N] находит второе по величине число
(вывести на печать число, которое меньше максимального элемента массива,
но больше всех других элементов)*/

public class Task_2_4_5 {

    public static void main(String[] args) {
        double[] numbers = {-45, 0, 12, 15, -5, -99, 44, -102, -1358, -658};
        //System.out.println("max is " + numbers[indexOfMaxMember(numbers)]);
        System.out.println("second is " + numbers[indexOfSecondValueMember(numbers)]);
    }

    //returns index of the member with the maximal value
    public static int indexOfMaxMember(double[] numbers) {
        int indexOfMax = 0;
        for (int i = 1; i < numbers.length; i++) {
            indexOfMax = numbers[indexOfMax] < numbers[i] ? i : indexOfMax;
        }
        return indexOfMax;
    }

    //returns index of the member with the second after the maximal value
    public static int indexOfSecondValueMember(double[] numbers){
        int indexOfMax = indexOfMaxMember(numbers);
        int indexOfSecond = 0;
        for (int i = 0; i < numbers.length; i++) {
            indexOfSecond = (numbers[indexOfMax] > numbers[i]) && (numbers[indexOfSecond] < numbers[i]) ? i : indexOfSecond;
        }
        return indexOfSecond;
    }

}
