import java.util.Arrays;

public class Bank {
    private Account[] accounts;
    private Client[] clients;
    private Currency nationalCurrency;

    private static boolean log = true;

    public Bank() {
        this.accounts = new Account[0];
        this.clients = new Client[0];
        this.nationalCurrency = Currency.BYN;
    }

    public Bank(Currency nationalCurrency) {
        this.accounts = new Account[0];
        this.clients = new Client[0];
        this.nationalCurrency = nationalCurrency;
    }

    private int addClient(Client client) {

        printLog(client.toString());

        int res;
        if (!isClientExist(client)) {
            clients = Arrays.copyOf(clients, clients.length + 1);
            clients[clients.length - 1] = client;
            res = 0;
            printLog("\t","клиент добавлен");
        } else {
            res = 1;
            printLog("\t","такой клиент уже есть в базе");
        }
        return res;
    }

    private int addAccount(Account account) {
        printLog(account.toString());
        int res;
        if (!isAccountExist(account)) {
            accounts = Arrays.copyOf(accounts, accounts.length + 1);
            accounts[accounts.length - 1] = account;
            res = 0;
            printLog("\t","счет добавлен");
        } else {
            res = 1;
            printLog("\t","такой счет уже есть в базе");
        }
        return res;
    }

    public boolean isClientExist(Client client) {
        printLog(client.toString());
        boolean res = false;
        for (Client c : clients) {
            if (client.equals(c)) {
                res = true;
                break;
            }
        }
        printLog("\t","результат " + res);
        return res;
    }

    public boolean isClientExist(String strName) {
        printLog(strName);
        boolean res = false;
        String[] name = parseName(strName);
        for (Client c : clients) {
            if (c.getFirstName().equals(name[0]) && c.getLastName().equals(name[1])) {
                res = true;
                break;
            }
        }

        printLog("\t","результат " + res);
        return res;
    }

    public boolean isAccountExist(Account account) {
        printLog(account.toString());
        boolean res = false;
        for (Account a : accounts) {
            if (account.equals(a)) {
                res = true;
                break;
            }
        }

        printLog("\t","результат " + res);
        return res;
    }

    /*
     * ищет клиента банка по имени и фамилии
     * возвращает клиента из списка клиентов банка
     * если клиента списке банка не существует возвращает null
     * */
    public Client findClient(String firstName, String lastName) {
        printLog("" + firstName + " / " + lastName);
        Client res = null;

        for (Client c : clients) {
            if (c.getFirstName() == firstName && c.getLastName() == lastName) {
                res = c;
                break;
            }
        }

        printLog("\t","результат " + res);
        return res;
    }

    /*
     * ищет счет в списке счетов банка
     * возвращает счет из списка
     * если счет в списке счетов банка не существует возвращает null
     * */
    public Account findAccount(String firstName, String lastName, AccountTypes type, Currency currency) {
        printLog();
        Account account = null;
        for (Account a : accounts) {
            if (a.getClient().getFirstName() == firstName &&
                    a.getClient().getLastName() == lastName &&
                    a.getType() == type &&
                    a.getCurrency() == currency) {
                account = a;
                break;
            }
        }
        printLog("\t", "результат " + account);
        return account;
    }

    /*
     * открывает текущий счет в банке для указанного клиента
     * при наличии такого счета в банке возвращает на него ссылку
     * при невозможности открытия счета возвращает null (предусмотрено на будущее)
     * */
    public Account openCurrentAccount(String firstName, String lastName) {
        printLog(firstName,lastName);
        Account account;
        AccountTypes type = AccountTypes.CURRENT;
        Currency currency = nationalCurrency;
        Client client;

        printLog("\t","попытка открыть счет", type.rusName);
        account = findAccount(firstName, lastName, type, currency);
        if ((account) != null) {                                                    //если такой счет существует;                                                              //возвращаем существующий счет
            printLog("\t", "такой счет уже существует");                              //и бросаем сообщение в лог
        } else {                                                                    //есл не существует
            client = findClient(firstName, lastName);
            if (client == null) {                                                       //если такого клиента нет
                client = new Client(firstName, lastName);                                   //создаем клиента
                addClient(client);                                                          //вносим в базу
                account = new Account(client, type, currency);                              //создаем счет
                addAccount(account);                                                        //вносим в базу
            } else {                                                                    //если клиент есть в базе
                account = new Account(client, type, currency);                          //создаем счет
                addAccount(account);                                                    //вносим в базу
            }
        }
        return account;
    }

    /*
     * открывает счет в иностранной валюте в банке для указанного клиента
     * возвращает ссылку на открытый счет
     * при наличии такого счета в банке возвращает на него ссылку
     * при невозможности открытия счета возвращает null (предусмотрено на будущее)
     * */
    public Account openForeignCurrencyAccount(String firstName, String lastName, Currency currency) {
        printLog();
        Account account;
        AccountTypes type = AccountTypes.FOREIGN_CURRENCY;
        Client client;

        printLog("\t","попытка открыть счет", type.rusName);
        account = findAccount(firstName, lastName, type, currency);
        if ((account) != null) {                                                    //если такой счет существует                                                            //возвращаем существующий счет
            printLog("\t", "такой счет уже существует");                            //бросаем сообщение в лог
        } else {                                                                    //есл не существует
            client = findClient(firstName, lastName);
            if (client == null) {                                                       //если такого клиента нет
                client = new Client(firstName, lastName);                                   //создаем клиента
                addClient(client);                                                          //вносим в базу
                account = new Account(client, type, currency);                              //создаем счет
                addAccount(account);                                                        //вносим в базу
            } else {                                                                    //если клиент есть в базе
                account = new Account(client, type, currency);                          //создаем счет
                addAccount(account);                                                    //вносим в базу
            }
        }
        return account;
    }

    /*
     * открывает счет в иностранной валюте в банке для указанного клиента
     * возвращает ссылку на открытый счет
     * при наличии такого счета в банке возвращает на него ссылку
     * при невозможности открытия счета возвращает null (предусмотрено на будущее)
     * */
    public Account openCardAccount(String firstName, String lastName, Currency currency) {
        printLog();
        Account account;
        AccountTypes type = AccountTypes.CARD;
        Client client;

        printLog("\t", "попытка открыть счет", type.rusName);
        account = findAccount(firstName, lastName, type, currency);
        if ((account) != null) {                                                    //если такой счет существует                                                              //возвращаем существующий счет
            printLog("\t", "такой счет уже существует");                              //и бросаем сообщение в лог
        } else {                                                                    //если не существует
            client = findClient(firstName, lastName);
            if (client == null) {                                                       //если такого клиента нет
                client = new Client(firstName, lastName);                                   //создаем клиента
                addClient(client);                                                          //вносим в базу
                account = new Account(client, type, currency);                                //создаем счет
                addAccount(account);                                                        //вносим в базу
            } else {                                                                    //если клиент есть в базе
                account = new Account(client, type, currency);                          //создаем счет
                addAccount(account);                                                    //вносим в базу
            }
        }
        return account;
    }

    /*
     * проводит транзакцию со счетом
     * */
    public void transaction(String firstName, String lastName, AccountTypes type, Currency currency, double amount) {
        Account account = findAccount(firstName, lastName, type, currency);
        printLog(String.format("попытка проведения транзакции\n\tаккаунт %s\n\tсумма %s", account, amount));
        if (account != null && account.getStatus() == AccountStatus.ACTIVE) {
            account.setBalance(account.getBalance() + amount);
            printLog("\t", "транзакция прошла успешно");
        } else {
            printLog("\t", "транзакция невозможна");
        }
        printLog("\t", String.format("текущий баланс %s", account.getBalance()));
    }

    /*
     * проводит транзакцию со счетом
     * */
    public void transaction(Account account, double amount) {

        printLog(String.format("попытка проведения транзакции\n\tаккаунт %s\n\tсумма %s", account, amount));
        if (isAccountExist(account) && account.getStatus() == AccountStatus.ACTIVE) {
            account.setBalance(account.getBalance() + amount);
            printLog("\t", "транзакция прошла успешно");
        } else {
            printLog("\t", "транзакция невозможна");
        }
        printLog("\t", String.format("текущий баланс %s", account.getBalance()));
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
    public void printAllAccounts() {
        for (Account a : accounts) {
            System.out.println(a);
        }
    }

    /*
     * выводит на консоль все счета указанного клиента
     * */
    public void printAllAccounts(Client client) {
        printLog("\t", "список всех cчетов банка:");
        for (Account a : accounts) {
            if (a.getClient().equals(client)) {
                System.out.println(a);
            }
        }
    }

    /*
     * выводит на консоль всех клиентов банка
     * */
    public void printAllClients() {
        printLog("\t", "список всех клиентов банка:");
        for (Client c : clients) {
            System.out.println(c);
        }
    }

    /*
     * включает вывод лога операций в консоль
     * */
    public static void logOff(){
        log = false;
    }

    /*
     * отключает вывод лога операций в консоль
     * */
    public static void logOn(){
        log = true;
    }

    /*
     * печатает в консоль лог операций
     * если атрибут класса log = true
     * */
    private static void printLog(String... str){
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        if (log){
            if(str.length > 0 && str[0] == "\t"){
                System.out.print("\t");
            }
            System.out.print("[" + stackTraceElements[2].getMethodName() + "] ");

            for (String s : str) {
                if(s != "\t") {
                    System.out.print(s + " ");
                }
            }

            System.out.println("");
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