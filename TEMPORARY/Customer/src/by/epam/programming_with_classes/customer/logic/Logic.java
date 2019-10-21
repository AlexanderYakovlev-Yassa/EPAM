package by.epam.programming_with_classes.customer.logic;

import by.epam.programming_with_classes.customer.objects.Customer;
import by.epam.programming_with_classes.customer.objects.Customers;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Logic {

    //Checks whether IBAN is correct and returns IBAN as seven  groups of symbols.
    // If IBAN doesn't meet requirements, returns the empty string.
    public String checkIBAN(String str){
        str = str.trim();
        String newStr;
        Pattern p = Pattern.compile("^(\\p{Alpha}{2}\\d{2})\\s?(\\w{4})\\s?(\\d{4})\\s?(\\w{4})\\s?(\\w{4})\\s?(\\w{4})\\s?(\\w{4})$");
        Matcher m = p.matcher(str);
        if(m.find()){
            newStr = m.group(1) + " " + m.group(2) + " " + m.group(3) + " " + m.group(4) + " " + m.group(5) + " " + m.group(6) + " " + m.group(7);
        } else {
            newStr = "*";
        }
        return newStr;
    }

    //Checks whether CCN is correct and returns CCN as four  groups of digits.
    // If CCN doesn't meet requirements, returns the empty string.
    public String checkCCN(String str) {
        str = str.trim();
        String newStr;
        Pattern p = Pattern.compile("^(\\d{4}?)\\s*(\\d{4}?)\\s*(\\d{4}?)\\s*(\\d{4}?)\\s*$");
        Matcher m = p.matcher(str);
        if(m.find()){
            newStr = m.group(1) + " " + m.group(2) + " " + m.group(3) + " " + m.group(4);
        } else {
            newStr = "";
        }
        return newStr;
    }

    //Adds new customer to the list of the customers
    public void addToList(Customers customers, Customer newCustomer) {

        Customer[] newCustumers = Arrays.copyOf(customers.getCustomers(), customers.getCustomers().length + 1);
        newCustumers[newCustumers.length - 1] = newCustomer;
        customers.setCustomers(newCustumers);
    }
}
