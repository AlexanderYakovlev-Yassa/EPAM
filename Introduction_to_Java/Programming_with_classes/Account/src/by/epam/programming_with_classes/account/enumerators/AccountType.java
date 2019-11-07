package by.epam.programming_with_classes.account.enumerators;

public enum AccountType {
    CURRENT("текущий", true), //может быть только один в группе счетов Accounts
    CARD("карточный", true);

    String rusName;
    boolean multiple;
    AccountType(String rusName, boolean multiple){
        this.rusName = rusName;
        this.multiple = multiple;

    }
}
