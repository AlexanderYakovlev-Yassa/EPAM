package by.epam.programming_with_classes.customer.view;

import by.epam.programming_with_classes.customer.objects.Customer;
import by.epam.programming_with_classes.customer.objects.Customers;

public class View {

    public void printCustomer(Customer customer) {

        if (customer != null) {

            String name = customer.getLastName() + " " +
                    customer.getFirstName() + " " +
                    customer.getSecondName();

            System.out.println(String.format("%-35s IBAN [%s],   CCN [%s]",
                    name,
                    customer.getAccountIBAN(),
                    customer.getCreditCardNumber()));
        } else {
            System.out.println("there is no customer...");
        }
    }

    public void printCustomers(Customers customers) {

        if (customers != null && customers.getCustomers().length != 0) {
            for (Customer c : customers.getCustomers()) {
                printCustomer(c);
            }
        } else {
            System.out.println("there are no customers...");
        }
    }
}
