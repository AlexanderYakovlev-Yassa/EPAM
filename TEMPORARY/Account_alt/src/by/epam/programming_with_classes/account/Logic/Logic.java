package by.epam.programming_with_classes.account.Logic;

import by.epam.programming_with_classes.account.objects.Client;

public class Logic {

    public int compareClients(Client client_1, Client client_2){

        String c1 = client_1 != null ? client_1.getLastName() + client_1.getFirstName() : "";
        String c2 = client_2 != null ? client_2.getLastName() + client_2.getFirstName() : "";

        return c1.compareTo(c2);
    }


}
