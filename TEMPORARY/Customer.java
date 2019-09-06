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

public class Customer {
    private int id;
    private String firstName;
    private String secondName;
    private String thirdName;
    private String address;
    private String creditCardNumber;
    private String accountIBAN;
    private static int lastID;


    static {
        lastID = 1234;
    }

    public Customer(String firstName, String secondName, String thirdName, String address, String creditCardNumber, String accountIBAN) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.accountIBAN = accountIBAN;
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

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
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
        this.creditCardNumber = creditCardNumber;
    }

    public String getAccountIBAN() {
        return accountIBAN;
    }

    public void setAccountIBAN(String accountIBAN) {
        this.accountIBAN = accountIBAN;
    }

    public int getId() {
        return id;
    }

    public static int getLastID() {
        return lastID;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", thirdName='" + thirdName + '\'' +
                ", address='" + address + '\'' +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", accountIBAN='" + accountIBAN + '\'' +
                '}';
    }
}
