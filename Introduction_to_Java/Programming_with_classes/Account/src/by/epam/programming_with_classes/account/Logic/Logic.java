package by.epam.programming_with_classes.account.Logic;

import by.epam.programming_with_classes.account.enumerators.AccountFilter;
import by.epam.programming_with_classes.account.enumerators.AccountSortCriteria;
import by.epam.programming_with_classes.account.enumerators.AccountType;
import by.epam.programming_with_classes.account.objects.Account;
import by.epam.programming_with_classes.account.objects.Accounts;
import by.epam.programming_with_classes.account.objects.Client;

import java.util.Arrays;

public class Logic {

    public boolean addAccount(Accounts accounts, Account account) {

        boolean res;

        if (accounts != null && account != null) {

            accounts.setAccounts(Arrays.copyOf(accounts.getAccounts(), accounts.getAccounts().length + 1));
            accounts.setAccount(account, accounts.getAccounts().length - 1);
            res = true;
        } else {

            res = false;
        }

        return res;
    }

    public int compareClients(Client client_1, Client client_2) {

        if (client_1 != null && client_2 != null) {

            String c1 = client_1 != null ?
                    client_1.getLastName().toLowerCase() + client_1.getFirstName().toLowerCase() : "";
            String c2 = client_2 != null ?
                    client_2.getLastName().toLowerCase() + client_2.getFirstName().toLowerCase() : "";

            return c1.compareTo(c2);
        } else {

            throw new NullPointerException();
        }
    }

    public int compareAccount(Account account_1, Account account_2, AccountSortCriteria criteria) {

        int res;

        if (account_1 != null && account_2 != null) {

            switch (criteria) {
                case CLIENT_A_Z: {
                    res = compareClients(account_1.getClient(), account_2.getClient());
                    break;
                }
                case CLIENT_Z_A: {
                    res = -compareClients(account_1.getClient(), account_2.getClient());
                    break;
                }
                case TYPE: {
                    res = account_1.getType().name().compareTo(account_2.getType().name());
                    break;
                }
                case STATUS: {
                    int a1 = account_1.getStatus() ? 1 : 0;
                    int a2 = account_2.getStatus() ? 1 : 0;
                    res = a1 - a2;
                    break;
                }
                case BALANCE: {
                    res = (int) ((account_1.getBalance() * 100) - (int) (account_2.getBalance() * 100));
                    break;
                }
                default: {

                    throw new EnumConstantNotPresentException(AccountSortCriteria.class, criteria.name());
                }
            }
            return res;
        } else {
            throw new NullPointerException();
        }
    }

    public Accounts filterByClient(Accounts accounts, String lastName, String firstName) {

        Accounts newAccounts = new Accounts();

        if (lastName != null && firstName != null) {

            for (Account a : accounts.getAccounts()) {

                if (lastName.toLowerCase().equals(a.getClient().getLastName().toLowerCase()) &&
                        firstName.toLowerCase().equals(a.getClient().getFirstName().toLowerCase())) {
                    addAccount(newAccounts, a);
                }
            }
        }

        return newAccounts;
    }

    public Accounts filter(Accounts accounts, AccountFilter filter) {

        Accounts newAccounts = new Accounts();

        if (accounts != null) {

            for (Account a : accounts.getAccounts()) {

                switch (filter) {

                    case BALANCE_POSITIVE: {
                        if (a.getBalance() >= 0) {
                            addAccount(newAccounts, a);
                        }
                        break;
                    }
                    case BALANCE_NEGATIVE: {
                        if (a.getBalance() < 0) {
                            addAccount(newAccounts, a);
                        }
                        break;
                    }
                    case ACCOUNT_TYPE_CARD: {
                        if (a.getType() == AccountType.CARD) {
                            addAccount(newAccounts, a);
                        }
                        break;
                    }
                    case ACCOUNT_TYPE_CURRENT: {
                        if (a.getType() == AccountType.CURRENT) {
                            addAccount(newAccounts, a);
                        }
                        break;
                    }
                    case STATUS_ACTIVE: {
                        if (a.getStatus()) {
                            addAccount(newAccounts, a);
                        }
                        break;
                    }
                    case STATUS_BLOCKED: {
                        if (!a.getStatus()) {
                            addAccount(newAccounts, a);
                        }
                        break;
                    }
                }
            }
        }

        return newAccounts;
    }

    public void sortAccounts(Accounts accounts, AccountSortCriteria criteria) {

        try {

            for (int i = accounts.getAccounts().length - 1; i > 0; i--) {

                for (int j = 0; j < i; j++) {

                    if (compareAccount(accounts.getAccount(j), accounts.getAccount(j + 1), criteria) > 0) {

                        swapAccounts(accounts, j, j + 1);
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public float totalBalance(Accounts accounts) {

        float balance = 0f;

        if (accounts != null) {

            for (Account a : accounts.getAccounts()) {
                balance += a.getBalance();
            }
        }

        return balance;
    }

    private void swapAccounts(Accounts accounts, int index_1, int index_2) {

        if (accounts != null) {

            if (index_1 < accounts.getAccounts().length && index_2 < accounts.getAccounts().length) {

                Account bubble = accounts.getAccount(index_1);
                accounts.setAccount(accounts.getAccount(index_2), index_1);
                accounts.setAccount(bubble, index_2);
            } else {

                throw new IndexOutOfBoundsException();
            }
        } else {

            throw new NullPointerException();
        }
    }
}
