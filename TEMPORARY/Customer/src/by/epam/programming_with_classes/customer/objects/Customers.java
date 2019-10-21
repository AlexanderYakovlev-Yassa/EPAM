package by.epam.programming_with_classes.customer.objects;

//Class which forms list of customers
public class Customers {

    private Customer[] customers;

    public Customers() {
        this.customers = new Customer[0];
    }

    public Customers(Customer[] customers) {
        this.customers = customers;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }




    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("Список клиентов:\n");
        for (int i = 0; i < this.customers.length; i++) {
            res.append("\n" + this.customers[i].toString() + "\n");
        }
        return res.toString();
    }
}