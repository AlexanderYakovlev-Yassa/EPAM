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

    public String showTrain() {
        String res;
        res = String.format("   %-7s %-18s %s", trainNum, destination, departureTime.showTime());
        return res;
    }

    public void copyTo(Train train) {
        train.setDepartureTime(departureTime);
        train.setDestination(destination);
        train.setTrainNum(trainNum);
    }

    public int compareDepartureTime(Train train) {
        return departureTime.compare(train.departureTime);
    }

    public int compareDestinations(Train train) {
        return destination.compareTo(train.destination);
    }

    public int compareTrainNumbers(Train train) {
        return trainNum - train.trainNum;
    }

}
