package by.epam.programming_with_classes.account.main;

import by.epam.programming_with_classes.account.Logic.Logic;
import by.epam.programming_with_classes.account.data.Data;
import by.epam.programming_with_classes.account.enumerators.AccountFilter;
import by.epam.programming_with_classes.account.enumerators.AccountSortCriteria;
import by.epam.programming_with_classes.account.objects.Account;
import by.epam.programming_with_classes.account.objects.Accounts;
import by.epam.programming_with_classes.account.view.View;

public class Demo {

    public static void main(String[] args) {


        Logic logic = new Logic();
        View view = new View();
        Data data = new Data();

        Accounts accounts = data.readAccounts();

        System.out.println("\nAll the accounts:\n");
        view.printAccounts(accounts);

        System.out.println("\nAll the accounts sorted by clients name:\n");
        logic.sortAccounts(accounts, AccountSortCriteria.CLIENT_A_Z);
        view.printAccounts(accounts);

        System.out.println("\nAll the accounts sorted by accounts balance:\n");
        logic.sortAccounts(accounts, AccountSortCriteria.BALANCE);
        view.printAccounts(accounts);

        System.out.println("\nBlock all the accounts which have negative balance:\n");

        for (Account a : logic.filter(accounts, AccountFilter.BALANCE_NEGATIVE).getAccounts()){
            a.setStatus(false);
        }

        logic.sortAccounts(accounts, AccountSortCriteria.BALANCE);
        view.printAccounts(accounts);

        System.out.println("\nTotal balance of all the accounts which have positive balance:\n");

        System.out.println(logic.totalBalance(logic.filter(accounts, AccountFilter.BALANCE_POSITIVE)));

        System.out.println("\nTotal balance of all the accounts which have negative balance:\n");

        System.out.println(logic.totalBalance(logic.filter(accounts, AccountFilter.BALANCE_NEGATIVE)));

        System.out.println("\nAll the accounts of \"Леонард Эйлер\" sorted by balance:\n");
        logic.sortAccounts(accounts, AccountSortCriteria.BALANCE);
        view.printAccounts(logic.filterByClient(accounts, "Эйлер", "Леонард"));

        System.out.println("\nTotal balance of all the accounts of \"Леонард Эйлер\":\n");

        System.out.println(logic.totalBalance(logic.filterByClient(accounts, "Эйлер", "Леонард")));
    }
}
