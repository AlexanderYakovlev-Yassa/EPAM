import java.io.FileWriter;
import java.io.IOException;

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

    public void addToList(Customer newCustomer){
        Customer[] newList = new Customer[this.list.length + 1];
        for (int i = 0; i < list.length; i++) {
            newList[i] = this.list[i];
        }
        newList[newList.length-1] = newCustomer;
        this.list = newList;
    }

    public static void main(String[] args) throws IOException {

        String file = "D:\\Temp\\untitled\\src\\Clients.txt";
        FileWriter fileWriter = new FileWriter(file);

    }
}
