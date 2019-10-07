package cl_obj.library;

public enum Food {
    RO("room only", "без питания", 5),
    BB("bed & breakfast","завтраки", 4),
    HB("half board","полупансион", 3),
    FB("full board","полный пансион", 2),
    AI("all inclusive","все включено", 1),
    UAI("ultra all inclusive","ультра все включено", 0);
    private String name;
    private String rusName;
    private int range;

    Food(String name, String rusName, int range){
        this.name = name;
        this.rusName = rusName;
        this.range = range;
    }

    public String getName() {
        return name;
    }

    public String getRusName() {
        return rusName;
    }

    public int getRange() {
        return range;
    }
}