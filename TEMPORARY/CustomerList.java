//Class which forms list of customers
public class CustomerList {
    private Customer[] list;

    public CustomerList() {
        this.list = new Customer[0];
    }

    public CustomerList(Customer[] list) {
        this.list = list;
    }

    public Customer[] getList() {
        return list;
    }

    //Adds new customer to the list of the customers
    public void addToList(Customer newCustomer) {
        Customer[] newList = new Customer[this.list.length + 1];
        for (int i = 0; i < list.length; i++) {
            newList[i] = this.list[i];
        }
        newList[newList.length - 1] = newCustomer;
        this.list = newList;
    }

    //Prints the name list of all the customers ordered by alphabet
    public void printCustomersAlphabet() {
        String[] customerNames = new String[list.length];
        for (int i = 0; i < customerNames.length; i++) {
            customerNames[i] = list[i].getFirstName() + " " +
                    list[i].getSecondName() + " " +
                    list[i].getThirdName();
        }

        boolean flag;
        for (int i = 0; i < customerNames.length; i++) {
            flag = true;
            for (int j = 0; j < customerNames.length - i - 1; j++) {

                if (customerNames[j].compareTo(customerNames[j + 1]) > 0) {
                    String bubble = customerNames[j];
                    customerNames[j] = customerNames[j + 1];
                    customerNames[j + 1] = bubble;
                    flag = false;
                }
            }
            if (flag) {
                System.out.println("*** " + i);
                break;
            }
        }

        for (int i = 0; i < customerNames.length; i++) {
            System.out.println(customerNames[i]);
        }
    }

    //Prints the list of customers whose CCN is inside certain diapason
    public void printCreditCardOf(String begin, String end) {
        begin = Customer.checkCCN(begin);
        end = Customer.checkCCN(end);
        if (!begin.equalsIgnoreCase("")){//check whether 'begin' is the correct CCN
            if (!end.equalsIgnoreCase("")){//check whether 'end' is the correct CCN
                System.out.println("\nКлиенты имеющие кредитную карту с номером в диапазоне \nот " + begin + "\nдо " + end + "\n");
                for (int i = 0; i < this.list.length; i++) {
                    if((begin.compareTo(this.list[i].getCreditCardNumber()) <= 0) &&
                            (end.compareTo(this.list[i].getCreditCardNumber())>=0)){//check whether CCN inside the diapason
                        System.out.println(this.list[i].toString() + "\n");
                    }
                }
            } else {
                System.out.println("Начало диапазона не является корректным номером кредитной карты.");
            }
        } else {
            System.out.println("Начало диапазона не является корректным номером кредитной карты.");
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("Список клиентов:\n");
        for (int i = 0; i < this.list.length; i++) {
            res.append("\n" + this.list[i].toString() + "\n");
        }
        return res.toString();
    }
}