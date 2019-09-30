import java.util.Arrays;

public class Bank {
    Account[] accounts;
    Client[] clients;
    Currency nationalCurrency;

    public Bank() {
        this.accounts = new Account[0];
        this.clients = new Client[0];
        this.nationalCurrency = Currency.BYN;
    }

    public Bank(Currency nationalCurrency){
        this.accounts = new Account[0];
        this.clients = new Client[0];
        this.nationalCurrency = nationalCurrency;
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
        return res;
    }

    public int addAccount(Account account) {
        int res;
        if (!isAccountExist(account)) {
            accounts = Arrays.copyOf(accounts, accounts.length + 1);
            accounts[accounts.length - 1] = account;
            res = 0;
        } else {
            res = 1;
        }
        return res;
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

    public boolean isClientExist(String strName) {
        boolean res = false;
        String[] name = parseName(strName);
        for (Client c : clients) {
            if (c.getFirstName().equals(name[0]) && c.getLastName().equals(name[1])) {
                res = true;
                break;
            }
        }
        return res;
    }

    public boolean isAccountExist(Account account) {
        boolean res = false;
        for (Account a : accounts) {
            if (account.equals(a)) {
                res = true;
                break;
            }
        }
        return res;
    }

    /*
    * проверяет имеется ли в этом банке
    * рассчетный счет у указанного клинта
    * */
    public boolean isPaymentExist(Client client){
        boolean res = false;
        for (Account a : accounts){
            if (a.getClient() == client &&
            a.getType() == AccountTypes.PAYMENT){
                res = true;
            }
        }
        return  res;
    }

    /*
     * проверяет имеется ли в этом банке
     * текущий счет у указанного клинта
     * */
    public boolean isCurrentExist(Client client){
        boolean res = false;
        for (Account a : accounts){
            if (a.getClient() == client &&
                    a.getType() == AccountTypes.CURRENT){
                res = true;
            }
        }
        return  res;
    }

    /*
     * ищет клиента банка по имени и фамилии
     * возвращает клиента из списка клиентов банка
     * если клиента списке банка не существует возвращает null
     * */
    public Client findClient(String firstName, String lastName) {
        Client res = null;

        for (Client c : clients) {
            if (c.getFirstName() == firstName && c.getLastName() == lastName) {
                res = c;
                break;
            }
        }
        return res;
    }

    /*
     * ищет счет в списке счетов банка
     * возвращает счет из списка
     * если счет в списке счетов банка не существует возвращает null
     * */
    public Account findAccount(String firstName, String lastName, AccountTypes type, Currency currency) {
        Account res = null;
        for (Account a : accounts) {
            if (a.getClient().getFirstName() == firstName &&
                    a.getClient().getLastName() == lastName &&
                    a.getType() == type &&
                    a.getCurrency() == currency) {
                res = a;
                break;
            }
        }
        return res;
    }

    public Account makeAccount(String firstName, String lastName, AccountTypes type, Currency currency) {
        Account res;
        res = null;
        Client client;
        Account account;
        if ((account = findAccount(firstName, lastName, type, currency)) != null) {
            res = account;
            System.out.println("такой счет уже существует");
        } else {
            client = findClient(firstName, lastName);
            if (client == null) {
                client = new Client(firstName, lastName);
                addClient(client);
                account = new Account(client,type,currency);
                addAccount(account);
            } else {
                if (type == AccountTypes.PAYMENT &&
                isCurrentExist(client)) {
                    res = null; // у одного клиента не может быть одновременно и расетный и текущий счет
                    System.out.println("у этого клиента уже есть рассчетный счет\n" +
                            "текущий счет не может быть открыт");
                } else if(type == AccountTypes.CURRENT &&
                        isPaymentExist(client)) {
                    res = null; // у одного клиента не может быть одновременно и расетный и текущий счет
                    System.out.println("у этого клиента уже есть текущий счет\n" +
                            "расчетный счет не может быть открыт");
                } else {
                    account = new Account(client, type, currency);
                    addAccount(account);
                }
            }
        }

        return res;
    }

    /*
     * разбирает полное имя клиента на имя и фамилию
     * */
    private static String[] parseName(String name) {
        String[] res = name.split("\\s");
        if (res.length < 2) {
            res = new String[1];
            res[0] = "NONAME";
        } else if (res.length > 2) {
            res = Arrays.copyOf(res, 2);
        }
        return res;
    }

    /*
     * выводит на консоль все счета банка
     * */
    public void printAllAccounts(){
        for (Account a : accounts){
            System.out.println(a);
        }
    }

    /*
    * выводит на консоль все счета указанного клиента
    * */
    public void printAllAccounts(Client client){
        for (Account a : accounts){
            if (a.getClient().equals(client)) {
                System.out.println(a);
            }
        }
    }

    /*
     * выводит на консоль всех клиентов банка
     * */
    public void printAllClients(){
        for (Client c : clients){
            System.out.println(c);
        }
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