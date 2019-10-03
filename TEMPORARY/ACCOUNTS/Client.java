import java.util.Arrays;
import java.util.Objects;

public class Client {
    private String firstName;
    private String lastName;

    public Client(String lastName, String firstName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /*
     * возвращает сортированный в алфавитном порядке список клиентов
     * */
    public static Client[] sortClientsList(Client[] list) {
        Client[] sorted = Arrays.copyOf(list, list.length);
        String n1;
        String n2;
        for (int i = sorted.length; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                n1 = sorted[j].getLastName() + sorted[j].getFirstName();
                n2 = sorted[j + 1].getLastName() + sorted[j + 1].getFirstName();
                if ((n1.compareTo(n2)) > 0) {
                    swap(sorted, j, j + 1);
                }
            }
        }
        return  sorted;
    }

    /*
     * меняет местами клиентов с индексами
     * c1 и c2 в списке клиентов list
     * */
    private static void swap(Client[] list, int c1, int c2) {
        Client buble = list[c1];
        list[c1] = list[c2];
        list[c2] = buble;
    }

    /*
     * ищет и возвращает объект типа Client
     * по имени из списка клиентов.
     * если клиент не найден возвращает null
     * */
    public static Client searchByName(Client[] list, String lastName, String firstName){
        Client client = null;
        for (Client c : list){
            if (c.lastName.equals(lastName) && c.firstName.equals(firstName)){
                client = c;
                break;
            }
        }
        return client;
    }

    /*
     * выводит на консоль список клиентов банка
     * */
    public static void printClientsList(Client[] list) {
        for (Client c : list) {
            System.out.println(c);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(firstName, client.firstName) &&
                Objects.equals(lastName, client.lastName);
    }

    @Override
    public String toString() {
        return lastName + " " + firstName;
    }
}