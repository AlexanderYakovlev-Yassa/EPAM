package by.epam.basic_of_oop.flower_shop.server.enumerators;

public enum FlowerNames {

    ROSE("роз", "роза"),
    TULIP("тюльпан", "тюльпан"),
    LILY("лили", "лилия"),
    CARNATION("гвоздик", "гвоздика"),
    ASTER("астр", "астра");

    String rusRoot;
    String rusName;

    FlowerNames(String rusRoot, String rusName) {
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
