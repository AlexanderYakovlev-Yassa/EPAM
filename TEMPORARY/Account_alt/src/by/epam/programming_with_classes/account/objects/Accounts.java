package by.epam.programming_with_classes.account.objects;

public class Accounts {

    Account[] accounts;

    public Accounts(Account[] accounts) {
        this.accounts = accounts;
    }

    public Accounts() {
        this.accounts = new Account[0];
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public Account getAccount(int index) {
        return accounts[index];
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    public void setAccount(Account account, int index) {
        this.accounts[index] = account;
    }


}
