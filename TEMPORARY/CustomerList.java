import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

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

    public void addToList(Customer newCustomer) {
        Customer[] newList = new Customer[this.list.length + 1];
        for (int i = 0; i < list.length; i++) {
            newList[i] = this.list[i];
        }
        newList[newList.length - 1] = newCustomer;
        this.list = newList;
    }

    public void printCustomersAlphabet() {
        String[] customerNames = new String[list.length];
        for (int i = 0; i < customerNames.length; i++) {
            customerNames[i] = list[i].getFirstName() + " " +
                    list[i].getSecondName() + " " +
                    list[i].getThirdName();
        }
        //********сортировка пузырьком по алфавиту***********
        boolean flag;
        for (int i = 0; i < customerNames.length; i++) {
            flag = true;
            for (int j = 0; j < customerNames.length - i -1; j++) {

                if (customerNames[j].compareTo(customerNames[j + 1]) > 0){
                    String bubble = customerNames[j];
                    customerNames[j] = customerNames[j + 1];
                    customerNames[j + 1] = bubble;
                    flag = false;
                }
            }
            if (flag){
                System.out.println("*** " + i);
                break;
            }
        }
        //***************************************************

        for (int i = 0; i < customerNames.length; i++) {
            System.out.println(customerNames[i]);
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