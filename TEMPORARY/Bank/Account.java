import java.util.Objects;

public class Account {
    private AccountTypes type;
    private Client client;
    private Currency currency;
    private double balance;
    private AccountStatus status;
    private static boolean log = true;

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
                Objects.equals(client, account.client) &&
                currency == account.currency;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s", client, type.rusName, currency);
    }
}
