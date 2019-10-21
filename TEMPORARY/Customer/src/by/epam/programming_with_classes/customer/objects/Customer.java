package by.epam.programming_with_classes.customer.objects;

/*
 * Создать класс Customer, спецификация которого приведена ниже.
 * Определить конструкторы, set- и get- методы и метод toString().
 * Создать второй класс, агрегирующий массив типа Customer,
 * с подходящими конструкторами и методами.
 * Задать критерии выбора данных и вывести эти данные на консоль.
 *
 *        Класс Customer:
 * - id,
 * - фамилия,
 * - имя,
 * - отчество,
 * - адрес,
 * - номер кредитной карточки,
 * - номер банковского счета.
 *
 *       Найти и вывести:
 *a) список покупателей в алфавитном порядке;
 *b) список покупателей, у которых номер кредитной карточки находится в заданном интервале*/

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

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.secondName = "";
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
        this.creditCardNumber = logic.checkCCN(creditCardNumber);
    }

    public String getAccountIBAN() {
        return accountIBAN;
    }

    public void setAccountIBAN(String accountIBAN) {
        Logic logic = new Logic();
        this.accountIBAN = logic.checkIBAN(accountIBAN);
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
}