import java.util.Arrays;

public class Accounts {
    private Account[] accounts;
    private static boolean log = false;

    public Accounts(Account[] accounts) {
        this.accounts = accounts;
    }

    public Accounts() {
        this.accounts = new Account[0];
    }

    /*
     * включает вывод лога операций в консоль
     * */
    public static void logOff() {
        log = false;
    }

    /*
     * отключает вывод лога операций в консоль
     * */
    public static void logOn() {
        log = true;
    }

    /*
    * добавляет счет account в список счетов
    * */
    private void addAccount(Account account) {
        printLog(account.toString());
        try {
            accounts = Arrays.copyOf(accounts, accounts.length + 1);
            accounts[accounts.length - 1] = account;
            printLog("\t", "счет добавлен");
        } catch (Exception e) {
            printLog("\t", "счет не добавлен");
        }
    }

    /*
     * ищет счет в списке счетов банка
     * возвращает счет из списка
     * если счет в списке счетов банка не существует возвращает null
     * */
    public Account searchAccount(String lastName, String firstName, AccountTypes type) {
        printLog();
        Account account = null;
        for (Account a : accounts) {
            if (a.getClient().getFirstName() == firstName &&
                    a.getClient().getLastName() == lastName &&
                    a.getType() == type) {
                account = a;
                break;
            }
        }
        printLog("\t", "результат " + account);
        return account;
    }

    /*
     * ищет и возвращает объект типа Client
     * по имени из списка счетов.
     * если клиент не найден возвращает null
     * */
    public Client searchClient(String lastName, String firstName){
        Client client = null;
        for (Account a : accounts){
            if (a.getClient().getLastName().equals(lastName) && a.getClient().getFirstName().equals(firstName)){
                client = a.getClient();
                break;
            }
        }
        return client;
    }

    /*
     * открывает текущий счет в банке для указанного клиента
     * и возвращает на него ссылку
     * при наличии такого счета в банке возвращает на него ссылку
     * */
    public Account openCurrentAccount(String lastName, String firstName) {
        printLog(lastName, firstName);
        Account account;
        AccountTypes type = AccountTypes.CURRENT;
        Client client;

        printLog("\t", "попытка открыть счет", type.rusName);
        account = searchAccount(lastName, firstName, type);
        if ((account) != null) {                                                    //если такой счет существует;                                                              //возвращаем существующий счет
            printLog("\t", "такой счет уже существует");                           //бросаем сообщение в лог
        } else {                                                                    //есл не существует
            client = searchClient(lastName, firstName);                                 //ищем клиента в списке счетов
            if (client == null) {                                                       //если такого клиента нет
                client = new Client(lastName, firstName);                                   //создаем клиента
                account = new Account(client, type);                                        //создаем счет
                addAccount(account);                                                        //вносим в базу
            } else {                                                                    //если клиент есть в базе
                account = new Account(client, type);                                        //создаем счет
                addAccount(account);                                                        //вносим в базу
            }
        }
        return account;
    }

    /*
     * открывает карт счет в банке для указанного клиента
     * и возвращает на него ссылку
     * */
    public Account openCardAccount(String lastName, String firstName) {
        printLog(lastName, firstName);
        Account account;
        AccountTypes type = AccountTypes.CARD;
        Client client;

        printLog("\t", "попытка открыть счет", type.rusName);
            client = searchClient(lastName, firstName);                                 //ищем клиента в списке счетов
            if (client == null) {                                                       //если такого клиента нет
                client = new Client(lastName, firstName);                                   //создаем клиента
                account = new Account(client, type);                                        //создаем счет
                addAccount(account);                                                        //вносим в базу
            } else {                                                                    //если клиент есть в базе
                account = new Account(client, type);                                        //создаем счет
                addAccount(account);                                                        //вносим в базу
            }
        return account;
    }

    /*
    * возвращает список всех счетов
    * */
    public Account[] getAllAccounts(){
        return accounts;
    }

    /*
     * возвращает список счетов с положительным (или нулевым) балансом
     * */
    public Accounts getPositiveBalanceAccounts(){
        Accounts list = new Accounts();
        for (Account a : accounts){
            if (a.getBalance() >= 0){
                list.addAccount(a);
            }
        }
        return list;
    }

    /*
     * возвращает список счетов с отрицательным балансом
     * */
    public Accounts getNegativeBalanceAccounts(){
        Accounts list = new Accounts();
        for (Account a : accounts){
            if (a.getBalance() < 0){
                list.addAccount(a);
            }
        }
        return list;
    }

    /*
     * возвращает список всех клиентов
     * */
    public Client[] getAllClients(){
        Client[] clients = new Client[0];
        for (Account a : accounts){
            clients = Arrays.copyOf(clients, clients.length + 1);
            clients[clients.length - 1] = a.getClient();
        }
        return clients;
    }

    /*
     * возвращает список счетов указанного клиента
     * */
    public Accounts getByClient(Client client){
        Accounts list = new Accounts();
        for (Account a : accounts){
            if (a.getClient().equals(client)){
                list.addAccount(a);
            }
        }
        return list;
    }

    /*
     * возвращает список счетов указанного типа
     * */
    public Accounts getByType(AccountTypes type){
        Accounts list = new Accounts();
        for (Account a : accounts){
            if (a.getType().equals(type)){
                list.addAccount(a);
            }
        }
        return list;
    }

    /*
     * возвращает общую сумму по всем счетам
     * */
    public double getSumAmount(){
        double sum = 0;
        for (Account a : accounts){
            sum += a.getBalance();
        }
        return sum;
    }

    /*
     * возвращает общую сумму по всем счетам
     * с положительным балансом
     * */
    public double getSumPositiveBalances(){
        double sum = 0;
        for (Account a : accounts){
            if (a.getBalance() > 0) {
                sum += a.getBalance();
            }
        }
        return sum;
    }

    /*
     * возвращает общую сумму по всем счетам
     * с отрицательным балансом
     * */
    public double getSumNegativeBalances(){
        double sum = 0;
        for (Account a : accounts){
            if (a.getBalance() < 0) {
                sum += a.getBalance();
            }
        }
        return sum;
    }

    /*
     * возвращает сортированный в алфавитном порядке имен клиентов список счетов
     * */
    public Accounts sortAccountsByClients(){
        Account[] sorted = Arrays.copyOf(accounts, accounts.length);
        String n1;
        String n2;
        for (int i = sorted.length; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                n1 = sorted[j].getClient().getLastName() + sorted[j].getClient().getFirstName();
                n2 = sorted[j + 1].getClient().getLastName() + sorted[j + 1].getClient().getFirstName();
                if ((n1.compareTo(n2)) > 0) {
                    swap(sorted, j, j + 1);
                }
            }
        }
        Accounts list = new Accounts(sorted);
        return  list;
    }

    /*
     * меняет местами клиентов с индексами
     * a1 и a2 в списке счетов list
     * */
    private static void swap(Account[] list, int a1, int a2) {
        Account buble = list[a1];
        list[a1] = list[a2];
        list[a2] = buble;
    }

    /*
     * печатает в консоль лог операций
     * если атрибут класса log = true
     * */
    private static void printLog(String... str) {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        if (log) {
            if (str.length > 0 && str[0] == "\t") {
                System.out.print("\t");
            }
            System.out.print("[" + stackTraceElements[2].getMethodName() + "] ");

            for (String s : str) {
                if (s != "\t") {
                    System.out.print(s + " ");
                }
            }

            System.out.println("");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Account a : accounts){
            sb.append(a.toString() + "\n");
        }
        sb.append("\b");
        return sb.toString();
    }
}
