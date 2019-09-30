import java.util.Objects;

public class Account {
    private AccountTypes type;
    private Client client;
    private Currency currency;
    private double balance;
    private AccountStatus status;

    Account(Client client, AccountTypes type, Currency currency){
        this.type = type;
        this.client = client;
        this.currency = currency;
        this.status = AccountStatus.ACTIVE;
        this.balance = 0.0;
    }

    public AccountTypes getType() {
        return type;
    }

    public void setType(AccountTypes type) {
        this.type = type;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return type == account.type &&
                Objects.equals(client, account.client) &&
                currency == account.currency;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s", client, type.rusName, currency);
    }
}
