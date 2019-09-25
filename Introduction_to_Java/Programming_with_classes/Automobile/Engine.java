public class Engine {
    private int id;
    private static int nextID;
    private Automobile installedIn;
    private boolean started; //false - двигатель заглушенб true - двигатель заведен.

    public Engine() {
        this.id = nextID;
        nextID++;
        this.started = false;
    }

    public Automobile getInstalledIn() {
        return installedIn;
    }

    public void setInstalledIn(Automobile installedIn) {
        this.installedIn = installedIn;
    }

    public boolean isStarted() {
        return started;
    }

    public int getId() {
        return id;
    }

    /*
     * запускает двигатель
     * */
    public void startEngine() {
        this.started = true;
    }

    /*
     * останавливает двигатель
     */
    public void stopEngine() {
                this.started = false;
    }

    @Override
    public String toString() {
        String status = this.started ? "заведен" : "остановлен";
        return "Двигатель ID " + id +
                " " + status;
    }
}
