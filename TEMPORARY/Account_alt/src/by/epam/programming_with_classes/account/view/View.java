package by.epam.programming_with_classes.account.view;

import by.epam.programming_with_classes.account.objects.Account;
import by.epam.programming_with_classes.account.objects.Accounts;

public class View {

    public void printAccountInfo(Account account){

        if(account != null){

            String status = account.getStatus() ? "ACTIVE" : "BLOCKED";

            System.out.println(String.format("%-25s type %-10s balance=%-12.2f status %s",
                    account.getClient().getLastName() + " " + account.getClient().getFirstName(),
                    account.getType().name(),
                    account.getBalance(),
                    status));
        } else {

            System.out.println("There is no account");
        }
    }

    public void printAccounts(Accounts accounts){

        if (accounts != null && accounts.getAccounts() != null && accounts.getAccounts().length != 0){

            for (Account a : accounts.getAccounts()){

                printAccountInfo(a);
            }
        } else {

            System.out.println("There are no accounts");
        }
    }
}
