import java.util.Objects;

public class Account {
    private AccountTypes type;
    private Client client;
    private double balance;
    private AccountStatus status;
    private static boolean log = true;
    private int id;
    private static int lastID;

    Account(Client client, AccountTypes type){
        this.type = type;
        this.client = client;
        this.status = AccountStatus.ACTIVE;
        this.balance = 0.0;
        this.id = lastID++;
    }

    public AccountTypes getType() {
        return type;
    }

    public Client getClient() {
        return client;
    }

    public double getBalance() {
        return balance;
    }

    public double setBalance(double amount) {
        return balance;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public int getID() {
        return id;
    }

    /*
    * блокирует аккаунт
    * */
    public void blockAccount(){
        printLog();
        status = AccountStatus.BLOCKED;
        printLog("\t", status.toString());
    }

    /*
     * разблокирует аккаунт
     * */
    public void unBlockAccount(){
        printLog();
        status = AccountStatus.ACTIVE;
        printLog("\t", status.toString());
    }

    /*
     * добавляет указанную сумму к балансу на щету
     * */
    public void addAmount(double amount) {

        printLog(String.format("попытка проведения транзакции на сумму %.2f", amount));
        if (getStatus() == AccountStatus.ACTIVE) {
            balance += amount;
            printLog("\t", "транзакция прошла успешно");
        } else {
            printLog("\t", "транзакция невозможна");
        }
        printLog("\t", String.format("текущий баланс %.2f", balance));
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
        Account account = (Account) o;
        return type == account.type &&
                Objects.equals(client, account.client);
    }

    @Override
    public String toString() {
        return String.format("ID %s %s - %s баланс %.2f", id, client, type.rusName, balance);
    }
}