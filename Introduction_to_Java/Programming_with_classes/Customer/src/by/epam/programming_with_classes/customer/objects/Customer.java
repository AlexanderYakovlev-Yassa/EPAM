package by.epam.programming_with_classes.customer.objects;

import by.epam.programming_with_classes.customer.logic.Logic;

import java.util.Objects;

public class Customer {
    private int id;
    private String firstName;
    private String secondName;
    private String lastName;
    private String address;
    private String creditCardNumber;
    private String accountIBAN;
    private static int lastID;


    static {
        lastID = 1234;//Assume that some records is already existed
    }

    public Customer() {
        this.firstName = "";
        this.secondName = "";
        this.lastName = "";
        this.address = "";
        this.creditCardNumber = "";
        this.accountIBAN = "";
        this.id = ++lastID;
    }

    public Customer(String lastName, String firstName, String secondName){
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.address = "";
        this.creditCardNumber = "";
        this.accountIBAN = "";
        this.id = ++lastID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        Logic logic = new Logic();
        this.creditCardNumber = logic.normaliseCCN(creditCardNumber);
    }

    public String getAccountIBAN() {
        return accountIBAN;
    }

    public void setAccountIBAN(String accountIBAN) {
        Logic logic = new Logic();
        this.accountIBAN = logic.normaliseIBAN(accountIBAN);
    }

    public int getId() {
        return id;
    }

    public static int getLastID() {
        return lastID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return firstName.equals(customer.firstName) &&
                Objects.equals(secondName, customer.secondName) &&
                lastName.equals(customer.lastName) &&
                Objects.equals(creditCardNumber, customer.creditCardNumber) &&
                Objects.equals(accountIBAN, customer.accountIBAN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, lastName, creditCardNumber, accountIBAN);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", accountIBAN='" + accountIBAN + '\'' +
                '}';
    }
}