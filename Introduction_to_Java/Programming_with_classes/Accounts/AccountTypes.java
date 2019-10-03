
public enum AccountTypes {
    CURRENT("текущий", true), //может быть только один в группе счетов Accounts
    CARD("карточный", true);

    String rusName;
    boolean multiple;
    AccountTypes(String rusName, boolean multiple){
        this.rusName = rusName;
        this.multiple = multiple;

    }
}
