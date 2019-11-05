package by.epam.programming_with_classes.account.objects;

import by.epam.programming_with_classes.account.enumerators.AccountStatus;
import by.epam.programming_with_classes.account.enumerators.AccountTypes;

import java.util.Objects;

public class Account {

    private AccountTypes type;
    private AccountStatus status;
    private Client client;
    private float balance;

    public Account(AccountTypes type, Client client) {
        this.type = type;
        this.status = AccountStatus.ACTIVE;
        this.client = client;
        this.balance = 0f;
    }

    enum compareCriteria{
        
    }

    public AccountTypes getType() {
        return type;
    }

    public void setType(AccountTypes type) {
        this.type = type;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public int compare(Account account_1, Account account_2){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return getType() == account.getType() &&
                getClient().equals(account.getClient());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getClient());
    }

    @Override
    public String toString() {
        return "Account{" +
                "type=" + type +
                ", status=" + status +
                ", client=" + client +
                ", balance=" + balance +
                '}';
    }
}
