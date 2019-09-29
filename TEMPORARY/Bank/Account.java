import java.util.Objects;

public class Account {
    private AccountTypes type;
    private Client client;
    private Currency currency;

    Account(AccountTypes type, Client client, Currency currency){
        this.type = type;
        this.client = client;
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
}
