package by.epam.programming_with_classes.customer.main;

import by.epam.programming_with_classes.customer.data.Data;
import by.epam.programming_with_classes.customer.logic.Logic;
import by.epam.programming_with_classes.customer.objects.Customers;
import by.epam.programming_with_classes.customer.view.View;

public class Demo {

    public static void main(String[] args) {

        Data data = new Data();
        Logic logic = new Logic();
        View view = new View();

        Customers customers = data.getCustomers();

        System.out.println("\n\tсписок всех клиентов:\n");
        view.printCustomers(customers);

        System.out.println("\n\tсортированный список всех клиентов:\n");
        logic.sortCustomers(customers);
        view.printCustomers(customers);


        String min = "1111 2222 3333 7500";
        String max = "1111 2222 3333 7800";
        System.out.println("\n\tсписок клиентов у которых номера карточек в диапазоне");
        System.out.println("\tот " + min);
        System.out.println("\tдо " + max + "\n");

        view.printCustomers(logic.selectBy(customers, min, max));



    }
}
