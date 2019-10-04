public enum Meal {
    RO("room only", "без питания"),
    BB("bed & breakfast","завтраки"),
    HB("half board","полупансион"),
    FB("full board","полный пансион"),
    AI("all inclusive","все включено"),
    UAI("ultra all inclusive","ультра все включено");
    String name;
    String rusName;
    Meal (String name, String rusName){
        this.name = name;
        this.rusName = rusName;
    }
}