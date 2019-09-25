public class Wheel {
    private int id;
    private static int nextID;
    private int mountType;
    private Automobile mountedIn;

    public Wheel(int mountType){
        this.id = nextID;
        nextID++;
        this.mountType = mountType;
        mountedIn = null;
    }

    public Automobile getMountedIn() {
        return mountedIn;
    }

    public void setMountedIn(Automobile mountedIn) {
        this.mountedIn = mountedIn;
    }

    public int getId() {
        return id;
    }

    public int getMountType() {
        return mountType;
    }

    public void setMountType(int mountType) {
        this.mountType = mountType;
    }

    //возвращает расширенную информацию о колесе
    public String getExtInfo(){
        StringBuilder res = new StringBuilder();
        res.append("Колесо ID " + id + "\nмонтажный размер " + mountType + "\n");
        String install = mountedIn == null ? "не установлено на автомобиль" : ("установлено на " + mountedIn);
        res.append(install);
        return res.toString();
    }

    @Override
    public String toString() {
        return "Колесо ID " + id + " размер " + mountType;
    }
}
