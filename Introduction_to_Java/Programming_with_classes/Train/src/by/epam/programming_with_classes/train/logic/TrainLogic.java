package by.epam.programming_with_classes.train.logic;

import by.epam.programming_with_classes.train.objects.Train;
import by.epam.programming_with_classes.train.objects.TrainSchedule;

public class TrainLogic {

    public Train searchByTrainNumber(TrainSchedule trains, int searchedNum){

        int i = 0;
        Train train = null;

        while (i < trains.getTrains().length){

            if (trains.getTrains()[i].getTrainNum() == searchedNum){
                train = trains.getTrain(i);
                break;
            }
            i++;
        }
        return train;
    }

    //sorts schedule by numbers of trains
    public void sortByTrainNumber(TrainSchedule trains) {
        int min;
        boolean flag;
        for (int i = 0; i < trains.getTrains().length; i++) {
            min = i;
            flag = false;
            for (int j = i + 1; j < trains.getTrains().length; j++) {
                if (trains.getTrains()[j].getTrainNum() < trains.getTrains()[min].getTrainNum()) {
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
    public static void sortByDestination(TrainSchedule trains) {
        int min;
        boolean flag;
        for (int i = 0; i < trains.getTrains().length; i++) {
            min = i;
            flag = false;
            for (int j = i + 1; j < trains.getTrains().length; j++) {
                if (trains.getTrain(j).getDestination().compareTo(trains.getTrain(min).getDestination()) < 0) {
                    min = j;
                    flag = true;
                } else if (trains.getTrain(j).getDestination().compareTo(trains.getTrain(min).getDestination()) == 0) {
                    if (trains.getTrain(j).getDepartureTime().compare(trains.getTrain(min).getDepartureTime()) < 0) {
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
    private static void swapTrain(TrainSchedule trainSchedule, int first, int second) {
        Train bubble = trainSchedule.getTrain(first);
        trainSchedule.setTrain(trainSchedule.getTrain(second), first);
        trainSchedule.setTrain(bubble, second);
    }
}
