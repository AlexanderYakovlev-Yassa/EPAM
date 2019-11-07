package by.epam.programming_with_classes.account.test;

import by.epam.programming_with_classes.account.Logic.Logic;
import by.epam.programming_with_classes.account.data.Data;
import by.epam.programming_with_classes.account.enumerators.AccountFilter;
import by.epam.programming_with_classes.account.enumerators.AccountSortCriteria;
import by.epam.programming_with_classes.account.enumerators.AccountType;
import by.epam.programming_with_classes.account.objects.Account;
import by.epam.programming_with_classes.account.objects.Accounts;
import by.epam.programming_with_classes.account.objects.Client;
import by.epam.programming_with_classes.account.view.View;

public class Test {

    public static void main(String[] args) {

        Client cl_0 = new Client("Яковлев", "Александр");
        Client cl_1 = new Client("Иванов", "Иван");

        Logic logic = new Logic();
        View view = new View();

        System.out.println("compare clients " + logic.compareClients(cl_0,cl_1));

        Account ac_1 = new Account(AccountType.CURRENT, cl_0);
        ac_1.setBalance(1000.25f);
        ac_1.setStatus(true);

        Account ac_2 = new Account(AccountType.CARD, cl_0);
        ac_2.setBalance(2000f);
        ac_2.setStatus(true);

        Account ac_3 = new Account(AccountType.CARD, cl_0);
        ac_3.setBalance(0f);
        ac_3.setStatus(true);

        Account ac_4 = new Account(AccountType.CURRENT, cl_1);
        ac_4.setBalance(-500.256f);
        ac_4.setStatus(true);

        Account ac_5 = new Account(AccountType.CARD, cl_1);
        ac_5.setBalance(600f);
        ac_5.setStatus(true);

        Account ac_6 = new Account(AccountType.CARD, cl_1);
        ac_6.setBalance(100f);
        ac_6.setStatus(true);

        System.out.println("compare accounts " + logic.compareAccount(ac_1, ac_4, AccountSortCriteria.TYPE));

        Data data = new Data();
        Accounts accounts = data.readAccounts();

        System.out.println("addAccount " + logic.addAccount(accounts, ac_1));
        System.out.println("addAccount " + logic.addAccount(accounts, ac_2));
        System.out.println("addAccount " + logic.addAccount(accounts, ac_3));
        System.out.println("addAccount " + logic.addAccount(accounts, ac_4));
        System.out.println("addAccount " + logic.addAccount(accounts, ac_5));
        System.out.println("addAccount " + logic.addAccount(accounts, ac_6));



        logic.sortAccounts(accounts, AccountSortCriteria.CLIENT_A_Z);
        view.printAccountInfo(ac_1);

        System.out.println();

        view.printAccounts(logic.filter(accounts, AccountFilter.BALANCE_NEGATIVE));

        System.out.println();

        view.printAccounts(logic.filterByClient(accounts, "яковлев", "АЛександР"));

        System.out.println();

        System.out.println(logic.totalBalance(
                logic.filterByClient(accounts, "яковлев", "АЛександР")));
    }
}
