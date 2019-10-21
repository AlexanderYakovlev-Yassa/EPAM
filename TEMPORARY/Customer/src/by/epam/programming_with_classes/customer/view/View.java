package by.epam.programming_with_classes.customer.view;

import by.epam.programming_with_classes.customer.logic.Logic;
import by.epam.programming_with_classes.customer.objects.Customer;
import by.epam.programming_with_classes.customer.objects.Customers;

public class View {

    //Prints the name list of all the customers ordered by alphabet
    public void printCustomersAlphabet(Customers customers) {
        String[] customerNames = new String[customers.getCustomers().length];
        for (int i = 0; i < customerNames.length; i++) {
            customerNames[i] = customers.getCustomers()[i].getFirstName() + " " +
                    customers.getCustomers()[i].getSecondName() + " " +
                    customers.getCustomers()[i].getLastName();
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

        for (String s : customerNames) {
            System.out.println(s);
        }
    }

    //Prints the list of customers whose CCN is inside certain diapason
    public void printCreditCardOf(Customers customers, String begin, String end) {

        Logic logic = new Logic();

        begin = logic.checkCCN(begin);
        end = logic.checkCCN(end);

        if (!begin.equalsIgnoreCase("")){

            if (!end.equalsIgnoreCase("")){

                System.out.println("\nКлиенты имеющие кредитную карту с номером в диапазоне \nот " + begin + "\nдо " + end + "\n");

                for (Customer c : customers.getCustomers()) {

                    if((begin.compareTo(c.getCreditCardNumber()) <= 0) &&
                            (end.compareTo(c.getCreditCardNumber())>=0)){
                        System.out.println(c.toString() + "\n");
                    }
                }

            } else {

                System.out.println("Начало диапазона не является корректным номером кредитной карты.");
            }

        } else {

            System.out.println("Начало диапазона не является корректным номером кредитной карты.");
        }
    }
}
