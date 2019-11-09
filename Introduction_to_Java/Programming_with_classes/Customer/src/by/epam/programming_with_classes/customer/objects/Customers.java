package by.epam.programming_with_classes.customer.objects;

import java.util.Arrays;

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

    public Customer getCustomer(int index) {
        return customers[index];
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    public void setCustomer(Customer customer, int index) {
        this.customers[index] = customer;
    }

    public void add(Customer customer){
        if(customer != null){
            setCustomers(Arrays.copyOf(getCustomers(), getCustomers().length + 1));
            setCustomer(customer, getCustomers().length - 1);
        }
    }

    @Override
    public String toString() {
        return "Customers{" +
                "customers=" + Arrays.toString(customers) +
                '}';
    }
}