package by.epam.programming_with_classes.customer.logic;

import by.epam.programming_with_classes.customer.objects.Customer;
import by.epam.programming_with_classes.customer.objects.Customers;
import by.epam.programming_with_classes.customer.view.View;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Logic {

    public String normaliseIBAN(String str) {

        String newStr = null;

        if(str != null) {
            str = str.trim();
            Pattern p = Pattern.compile("^(\\p{Alpha}{2}\\d{2})\\s?(\\w{4})\\s?(\\d{4})\\s?(\\w{4})\\s?(\\w{4})\\s?(\\w{4})\\s?(\\w{4})$");
            Matcher m = p.matcher(str);
            if (m.find()) {
                newStr = m.group(1) + " " + m.group(2) + " " + m.group(3) + " " + m.group(4) + " " + m.group(5) + " " + m.group(6) + " " + m.group(7);
            }
        }

        return newStr;
    }

    public String normaliseCCN(String str) {

        String newStr = null;

        if(str != null) {

            str = str.trim();
            Pattern p = Pattern.compile("^(\\d{4}?)\\s*(\\d{4}?)\\s*(\\d{4}?)\\s*(\\d{4}?)\\s*$");
            Matcher m = p.matcher(str);
            if (m.find()) {
                newStr = m.group(1) + " " + m.group(2) + " " + m.group(3) + " " + m.group(4);
            }
        }
        return newStr;
    }

    public Customers selectBy(Customers customers, String min, String max){

        View view = new View();

        min = normaliseCCN(min);
        max = normaliseCCN(max);

        Customers selected = new Customers();

        if (min != null && max != null) {

            for (Customer c : customers.getCustomers()) {

                if (min.compareTo(c.getCreditCardNumber()) <= 0 &&
                        max.compareTo(c.getCreditCardNumber()) >= 0) {
                    selected.add(c);
                }

            }
        } else {
            selected = null;
        }

        return selected;
    }

    public void sortCustomers(Customers customers) {

        if(customers != null && customers.getCustomers() != null) {

            for (int i = customers.getCustomers().length - 1; i > 0; i--) {

                for (int j = 0; j < i; j++) {

                    if (compareCustomers(customers.getCustomer(j), customers.getCustomer(j + 1)) > 0) {

                        swapCustomers(customers, j, j + 1);
                    }
                }
            }
        }
    }

    private int compareCustomers(Customer customer_1, Customer customer_2) {

        if (customer_1 != null && customer_2 != null) {

            String c1 = customer_1.getLastName()+customer_1.getFirstName()+customer_1.getSecondName();
            String c2 = customer_2.getLastName()+customer_2.getFirstName()+customer_2.getSecondName();

            return c1.compareTo(c2);
        } else {
            throw new NullPointerException();
        }
    }

    private long parseCCNtoLong(String string){
        String[] pieces = string.split(" ");
        String num = pieces[3] + pieces[2] + pieces[1] + pieces[0];
        long res = Long.parseLong(num);
        return res;
    }

    private void swapCustomers(Customers customers, int index_1, int index_2) {

        if (customers != null) {

            if (index_1 < customers.getCustomers().length && index_2 < customers.getCustomers().length) {

                Customer bubble = customers.getCustomer(index_1);
                customers.setCustomer(customers.getCustomer(index_2), index_1);
                customers.setCustomer(bubble, index_2);
            } else {
                throw new IndexOutOfBoundsException();
            }
        } else {
            throw new NullPointerException();
        }
    }
}
