package by.epam.programming_with_classes.train.objects;

public class TrainSchedule {

    Train[] trains;

    public TrainSchedule() {
        this.trains = new Train[0];
    }

    public TrainSchedule(Train[] trains) {
        this.trains = trains;
    }

    public Train[] getTrains() {
        return trains;
    }

    public Train getTrain(int index) {
        return trains[index];
    }

    public void setTrains(Train[] trains) {
        this.trains = trains;
    }

    public void setTrain(Train train, int index) {
        this.trains[index] = train;
    }
}
