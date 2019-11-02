package by.epam.programming_with_classes.train.view;

import by.epam.programming_with_classes.train.logic.TrainLogic;
import by.epam.programming_with_classes.train.objects.Train;
import by.epam.programming_with_classes.train.objects.TrainSchedule;

import java.util.Scanner;

public class View {

    public String showTrain(Train train) {
        String res;
        res = String.format("   %-7s %-18s %s", train.getTrainNum(), train.getDestination(), train.getDepartureTime().toStringShort());
        return res;
    }

    //print the array of trains (schedule)
    public void printSchedule(TrainSchedule trainSchedule) {
        System.out.println(String.format("%-6s   %-18s %s", "N поезда", "пункт назначения", "время оправления"));
        System.out.println("_______________________________________________");
        for (Train t : trainSchedule.getTrains()) {
            System.out.println(showTrain(t));
        }
        System.out.println("_______________________________________________");
    }

    //prints the info about train. User insert number of train.
    public void trainInfoRequest(TrainSchedule trains) {
        int number;
        Train train = null;
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        System.out.print("Введите номер искомого поезда >");
        number = inputInt();
        TrainLogic trainLogic = new TrainLogic();
        train = trainLogic.searchByTrainNumber(trains, number);
        if (train != null){
            System.out.printf("\nПоезд %s следует до города %s.\nВремя отправления %s\n",
                    train.getTrainNum(),
                    train.getDestination(),
                    train.getDepartureTime().toStringShort() );
        } else {
            System.out.printf("\nИнформации о поезде N %s не найдено в рассписании.\n", number);
        }
    }

    //input of integer
    private int inputInt() {
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
}
