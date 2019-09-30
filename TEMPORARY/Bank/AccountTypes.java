public enum AccountTypes {
    PAYMENT("рассчетный", false), //только если нет текущего
    CURRENT("текущий", true), //только если нет расчетного
    LOAN("ссудный", true),
    FOREIGN_CURRENCY("в иностранной валюте", true), //только в валюте отличной от национальной
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
