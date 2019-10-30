package by.epam.basic_of_oop.flower_shop.server.enumerators;

public enum Color {
    WHITE("бел", "белый"),
    RED("красн", "красный"),
    YELLOW("желт", "желтый"),
    ORANGE("оранж", "оранжевый");

    String rusRoot;
    String rusName;

    Color(String rusRoot, String rusName) {
        this.rusRoot = rusRoot;
        this.rusName = rusName;
    }

    public String getRusRoot() {
        return rusRoot;
    }

    public String getRusName() {
        return rusName;
    }
}
