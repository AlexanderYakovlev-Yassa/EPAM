/*4. Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов массива
по номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми пунктами
назначения должны быть упорядочены по времени отправления.*/

import java.util.Scanner;

public class TrainScheduel {

    public static void main(String[] args) {
        Train[] trains = new Train[5];
        trains[0] = new Train(2586, "Петербург", new Time("12:30:00"));
        trains[1] = new Train(2594, "Киев", new Time("18:50:00"));
        trains[2] = new Train(2536, "София", new Time("22:10:00"));
        trains[3] = new Train(2599, "Варшава", new Time("21:00:00"));
        trains[4] = new Train(2535, "София", new Time("10:10:00"));

        System.out.println("\nИсходное рассписание:\n");
        printSchedule(trains);
        System.out.println("\nСортировка по номерам поездов:\n");
        sortByTrainNumber(trains);
        printSchedule(trains);
        System.out.println("\nСортировка по месту назначения:\n");
        sortByDestination(trains);
        printSchedule(trains);
        System.out.println("\nИнформация о поезде по запросу пользователя:\n");
        trainInfoRequest(trains);
    }

    //print the array of trains (schedule)
    public static void printSchedule(Train[] trains) {
        System.out.println(String.format("%-6s   %-18s %s", "N поезда", "пункт назначения", "время оправления"));
        System.out.println("_______________________________________________");
        for (int i = 0; i < trains.length; i++) {
            System.out.println(trains[i].showTrain());
        }
        System.out.println("_______________________________________________");
    }

    //prints the info about train. User insert number of train.
    public static void trainInfoRequest(Train[] trains) {
        int number;
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        System.out.print("Введите номер искомого поезда >");
        number = inptuInt();
        int index = searchByTrainNumber(trains, number);
        if (index >= 0){
            System.out.printf("\nПоезд %s следует до города %s.\nВремя отправления %s\n",
                    trains[index].getTrainNum(),
                    trains[index].getDestination(),
                    trains[index].getDepartureTime().showTime() );
        } else {
            System.out.printf("\nИнформации о поезде N %s не найдено в рассписании.\n", number);
        }
    }

    //input of integer
    private static int inptuInt() {
        int res = -1;
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            if (scan.hasNextInt()) {
                res = scan.nextInt();
                flag = false;
            } else {
                scan.nextLine();
                System.out.print("\nВведенная строка не является номером, повторите ввод >");
            }
        }
        return res;
    }

    //returns index of the array row (schedule) which contains searched info
    private static int searchByTrainNumber(Train[] trains, int searchedNum){
        int i = 0;
        int index = -1;
        boolean flag = true;
        while (i < trains.length){
            if (trains[i].getTrainNum() == searchedNum){
                index = i;
                flag = false;
                break;
            }
            i++;
        }
        return index;
    }

    //sorts schedule by numbers of trains
    public static void sortByTrainNumber(Train[] trains) {
        int min;
        boolean flag;
        for (int i = 0; i < trains.length; i++) {
            min = i;
            flag = false;
            for (int j = i + 1; j < trains.length; j++) {
                if (trains[j].compareTrainNumbers(trains[min]) < 0) {
                    min = j;
                    flag = true;
                }
            }
            if (flag) {
                swapTrain(trains, i, min);
            }
        }
    }

    //sorts schedule by destination
    public static void sortByDestination(Train[] trains) {
        int min;
        boolean flag;
        for (int i = 0; i < trains.length; i++) {
            min = i;
            flag = false;
            for (int j = i + 1; j < trains.length; j++) {
                if (trains[j].compareDestinations(trains[min]) < 0) {
                    min = j;
                    flag = true;
                } else if (trains[j].compareDestinations(trains[min]) == 0) {
                    if (trains[j].compareDepartureTime(trains[min]) < 0) {
                        swapTrain(trains, j, min);
                    }
                }
            }
            if (flag) {
                swapTrain(trains, i, min);
            }
        }
    }

    //swaps picked rows in the schedule
    private static void swapTrain(Train[] trains, int first, int second) {
        Train bubble = new Train();
        trains[first].copyTo(bubble);
        trains[second].copyTo(trains[first]);
        bubble.copyTo(trains[second]);
    }
}
