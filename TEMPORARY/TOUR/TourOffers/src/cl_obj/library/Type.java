package cl_obj.library;

public enum Type {
    VACATION("отпуск"),
    EXCURSION("экскурсия"),
    TREATMENT("оздоровление"),
    SHOPPING("за покупками"),
    CRUISE("круиз");
    private String rusName;

    Type(String rusName) {
        this.rusName = rusName;
    }

    public String getRusName() {
        return rusName;
    }
}