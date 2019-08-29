public class Train {
    private String destination;
    private int trainNum;
    private  Time departureTime;

    public Train(int trainNum, String destination, Time departureTime) {
        this.destination = destination;
        this.trainNum = trainNum;
        this.departureTime = departureTime;
    }

    public String showTrain(){
        String res;
        res = "N " + trainNum + "to: " + destination + " " + departureTime.showTime();
        return res;
    }

}
