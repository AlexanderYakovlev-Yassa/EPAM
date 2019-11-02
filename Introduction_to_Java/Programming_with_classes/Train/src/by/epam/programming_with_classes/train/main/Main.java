package by.epam.programming_with_classes.train.main;

/*4. Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов массива
по номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми пунктами
назначения должны быть упорядочены по времени отправления.*/

import by.epam.programming_with_classes.train.logic.TrainLogic;
import by.epam.programming_with_classes.train.objects.Time;
import by.epam.programming_with_classes.train.objects.Train;
import by.epam.programming_with_classes.train.objects.TrainSchedule;
import by.epam.programming_with_classes.train.view.View;

public class Main {

    public static void main(String[] args) {
        Train[] trains = new Train[5];
        trains[0] = new Train(2586, "Петербург", new Time("12:30:00"));
        trains[1] = new Train(2594, "Киев", new Time("18:50:00"));
        trains[2] = new Train(2535, "София", new Time("22:10:00"));
        trains[3] = new Train(2599, "Варшава", new Time("21:00:00"));
        trains[4] = new Train(2536, "София", new Time("10:10:00"));

        TrainSchedule trainSchedule = new TrainSchedule(trains);
        View view = new View();

        System.out.println("\nИсходное рассписание:\n");
        view.printSchedule(trainSchedule);

        TrainLogic trainLogic = new TrainLogic();

        System.out.println("\nСортировка по номерам поездов:\n");
        trainLogic.sortByTrainNumber(trainSchedule);
        view.printSchedule(trainSchedule);

        System.out.println("\nСортировка по месту назначения:\n");
        trainLogic.sortByDestination(trainSchedule);
        view.printSchedule(trainSchedule);

        System.out.println("\nИнформация о поезде по запросу пользователя:\n");
        view.trainInfoRequest(trainSchedule);
    }
}