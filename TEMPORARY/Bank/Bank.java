import java.util.Arrays;

public class Bank {
    Account[] accounts;
    Client[] clients;

    public Bank() {
        this.accounts = new Account[0];
        this.clients = new Client[0];
    }

    public int addClient(Client client) {
        int res;
        if (!isClientExist(client)) {
            clients = Arrays.copyOf(clients, clients.length + 1);
            clients[clients.length - 1] = client;
            res = 0;
        } else {
            res = 1;
        }
        return  res;
    }

    public int addAccount(Account account){
        int res;
        if (!isAccountExist(account)) {
            accounts = Arrays.copyOf(accounts, accounts.length + 1);
            accounts[accounts.length - 1] = account;
            res = 0;
        } else {
            res = 1;
        }
        return  res;
    }

    public boolean isClientExist(Client client) {
        boolean res = false;
        for (Client c : clients) {
            if (client.equals(c)) {
                res = true;
                break;
            }
        }
        return res;
    }

    public boolean isClientExist(String strName){
        boolean res = false;
        String[] name = parseName(strName);
        for (Client c : clients) {
            if (c.getFirstName().equals(name[0]) && c.getLastName().equals(name[1])) {
                res = true;
                break;
            }
        }
    }

    public boolean isAccountExist(Account account){
        boolean res = false;
        for (Account a : accounts){
            if (account.equals(a)){
                res = true;
                break;
            }
        }
        return  res;
    }

    public int makeAccount(String name, AccountTypes type, Currency currency){
        int res;
        res = 0;

        if (!isClientExist(name)){

        }

        return res;
    }

    private static String[] parseName(String name){
        String[] res = name.split("\\s");
        if (res.length < 2) {
            res = new String[1];
            res[0] = "NONAME";
        } else if (res.length > 2){
            res = Arrays.copyOf(res, 2);
        }
        return res;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Arrays.equals(accounts, bank.accounts) &&
                Arrays.equals(clients, bank.clients);
    }
}
