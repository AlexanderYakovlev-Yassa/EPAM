package by.epam.programming_with_classes.tour_agency.enumerators;

public enum TourType {

    VACATION("отпуск"),
    EXCURSION("экскурсия"),
    TREATMENT("оздоровление"),
    SHOPPING("за покупками"),
    CRUISE("круиз");

    private String rusName;

    TourType(String rusName) {
        this.rusName = rusName;
    }

    public String getRusName() {
        return rusName;
    }

}
