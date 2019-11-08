package by.epam.programming_with_classes.tour_agency.enumerators;

public enum MealType {
    RO(0,"room only", "без питания"),
    BB(1, "bed & breakfast", "завтраки"),
    HB(2, "half board", "полупансион"),
    FB(3, "full board", "полный пансион"),
    AI(4, "all inclusive", "все включено"),
    UAI(5, "ultra all inclusive", "ультра все включено");
    String fullName;
    String rusName;
    int compareCriteria;

    MealType(int compareCriteria, String fullName, String rusName) {
        this.compareCriteria = compareCriteria;
        this.fullName = fullName;
        this.rusName = rusName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getRusName() {
        return rusName;
    }

    public int getCompareCriteria() {
        return compareCriteria;
    }
}
