public enum Type {
    VACATION("отпуск"),
    EXCURSION("экскурсия"),
    TREATMENT("оздоровление"),
    SHOPPING("за покупками"),
    CRUISE("круиз");
    String rusName;

    Type(String rusName) {
        this.rusName = rusName;
    }
}