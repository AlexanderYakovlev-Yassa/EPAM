package by.epam.programming_with_classes.train.objects;

public class Train {
    private String destination;
    private int trainNum;
    private Time departureTime;

    public Train(int trainNum, String destination, Time departureTime) {
        this.destination = destination;
        this.trainNum = trainNum;
        this.departureTime = departureTime;
    }

    public Train() {
        this.destination = "";
        this.trainNum = 0;
        this.departureTime = new Time();
    }

    public int getTrainNum() {
        return trainNum;
    }

    public String getDestination() {
        return destination;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setTrainNum(int trainNum) {
        this.trainNum = trainNum;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }
}
