package by.epam.programming_with_classes.tour_agency.enumerators;

public enum Transportation {
    AIR(1, "", ""),
    BUS(1, "", ""),
    TRAIN(1, "", ""),
    SHIP(1, "", "");

    String fullName;
    String rusName;
    int compareCriteria;

    Transportation(int compareCriteria, String fullName, String rusName) {
        this.fullName = fullName;
        this.rusName = rusName;
        this.compareCriteria = compareCriteria;
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
