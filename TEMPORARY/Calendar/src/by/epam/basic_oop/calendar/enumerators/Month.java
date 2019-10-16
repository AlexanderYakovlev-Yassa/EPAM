package by.epam.basic_oop.calendar.enumerators;

public enum Month {
    JAN(1, "Январь"),
    FEB(2, "Февраль"),
    MAR(3, "Март"),
    APR(4, "Апрель"),
    MAY(5, "Май"),
    JUN(6, "Июнь"),
    JUL(7, "Июль"),
    AUG(8, "Август"),
    SEP(9, "Сентябрь"),
    OCT(10, "Октябрь"),
    NOV(11, "Ноябрь"),
    DES(12, "Декабрь");

    private int monthNum;
    private String rusName;

    Month(int monthNom, String rusName){
        this.monthNum = monthNom;
        this.rusName = rusName;
    }
}
