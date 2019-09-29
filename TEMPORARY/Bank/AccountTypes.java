public enum AccountTypes {
    PAYMENT("рассчетный", false),
    CURRENT("текущий", true),
    LOAN("ссудный", true),
    FOREIGN_CURRENCY("в иностранной валюте", true),
    DEPOSIT("кредитный", true),
    PERSONAL("лицевой", false),
    CARD("карточный", true),
    SPECIAL("специальный", true);
    String rusName;
    boolean multiple;
    AccountTypes(String rusName, boolean multiple){
        this.rusName = rusName;
        this.multiple = multiple;

    }
}
