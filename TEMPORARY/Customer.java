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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public Customer() {
        this.firstName = "";
        this.secondName = "";
        this.thirdName = "";
        this.address = "";
        this.creditCardNumber = "";
        this.accountIBAN = "";
        this.id = ++lastID;
    }

    public Customer(String firstName, String secondName, String thirdName, String address, String creditCardNumber, String accountIBAN) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.address = address;
        this.creditCardNumber = checkCCN(creditCardNumber);
        this.accountIBAN = checkIBAN(accountIBAN);
        this.id = ++lastID;
    }

    private static String checkIBAN(String str){
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

    private static String checkCCN(String str) {
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
        this.creditCardNumber = checkCCN(creditCardNumber);
    }

    public String getAccountIBAN() {
        return accountIBAN;
    }

    public void setAccountIBAN(String accountIBAN) {
        this.accountIBAN = checkIBAN(accountIBAN);
    }

    public int getId() {
        return id;
    }

    public static int getLastID() {
        return lastID;
    }

    @Override
    public String toString() {
        return "id  " + id + "\n" +
                firstName + " " + secondName + " " + thirdName + "\n" +
                "address  " + address + "\n" +
                "CCN  " + creditCardNumber + "\n" +
                "IBAN  " + accountIBAN;
    }
}
