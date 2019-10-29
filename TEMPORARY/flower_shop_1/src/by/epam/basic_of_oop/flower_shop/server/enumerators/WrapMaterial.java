package by.epam.basic_of_oop.flower_shop.server.enumerators;

public enum WrapMaterial {
    PAPER("бума", "бумажная упаковка"),
    CELLOPHANE("целлофан", "целлофановая упаковка"),
    FABRIC("ткан", "тканевая упаковка");

    String rusRoot;
    String rusName;

    WrapMaterial(String rusRoot, String rusName) {
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
