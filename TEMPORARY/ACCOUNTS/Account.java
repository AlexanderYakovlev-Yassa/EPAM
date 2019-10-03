import java.util.Arrays;
import java.util.Objects;

public class Account {
    private AccountTypes type;
    private Client client;
    //private Currency currency;
    private double balance;
    private AccountStatus status;
    private static boolean log = true;
    private int id;
    private static int lastID;

    Account(Client client, AccountTypes type){
        this.type = type;
        this.client = client;
        //this.currency = currency;
        this.status = AccountStatus.ACTIVE;
        this.balance = 0.0;
        this.id = lastID + 1;
        lastID = this.id;
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

   /* public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }*/

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public int getID() {
        return id;
    }

    public void blockAccount(){
        printLog();
        status = AccountStatus.BLOCKED;
        printLog("\t", status.toString());
    }

    public void unBlockAccount(){
        printLog();
        status = AccountStatus.ACTIVE;
        printLog("\t", status.toString());
    }

    /*
     * проводит транзакцию со счетом
     * */
    public void transaction(double amount) {

        printLog(String.format("попытка проведения транзакции на сумму %.2f", amount));
        if (getStatus() == AccountStatus.ACTIVE) {
            //account.setBalance(account.getBalance() + amount);
            balance += amount;
            printLog("\t", "транзакция прошла успешно");
        } else {
            printLog("\t", "транзакция невозможна");
        }
        printLog("\t", String.format("текущий баланс %.2f", balance));
    }


    /*
     * ищет и возвращает все счета клиента
     * из списка счетов
     * */
    public static Account[] searchAccountsOfClients(Account[] accounts, Client client) {
        Account[] list = new Account[0];
        for (Account a : accounts) {
            if (a.getClient().equals(client)) {
                list = Arrays.copyOf(list, list.length + 1);
                list[list.length - 1] = a;
            }
        }
        return list;
    }

    /*
     * выводит на консоль список счетов
     * */
    public static void printList(Account[] list) {
        for (Account a : list) {
            System.out.println(a);
        }
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





    public static double sumAmount(Account[] accounts){
        int sum = 0;
        for (Account a : accounts){
            sum += a.getBalance();
        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return type == account.type &&
                Objects.equals(client, account.client);
    }

    @Override
    public String toString() {
        return String.format("ID %s %s - %s баланс %.2f", id, client, type.rusName, balance);
    }
}