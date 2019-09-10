import java.io.FileWriter;
import java.io.IOException;

public class testCustomerList {
    public static void main(String[] args) throws IOException {

        CustomerList thisBankList = new CustomerList();

        String fN = "Яковлев";
        String sN = "Яков";
        String thN = "Яковлевич";
        String address = "Минск Асаналиева 32";
        String ccn = "1111  2222    33335639";
        String iban = "BY39 8022 4134 5W53 F456 35NC 0197";

        Customer a = new Customer(fN, sN, thN, address,ccn, iban);
        thisBankList.addToList(a);

        fN = "Яровцев";
        sN = "Иван";
        thN = "Иванович";
        address = "Минск Жилуновича 8";
        ccn = "1111 2222 3333 5896";
        iban = "BY47 8411 6554 005I 1498 7251 74J3";

        a = new Customer(fN, sN, thN, address,ccn, iban);
        thisBankList.addToList(a);

        fN = "Федоров";
        sN = "Федор";
        thN = "Федорович";
        address = "Минск Бельского 51";
        ccn = "1111 2222 3333 7896";
        iban = "BY48 60H5 6404 0348 3324 0934 C939";

        a = new Customer(fN, sN, thN, address,ccn, iban);
        thisBankList.addToList(a);

        fN = "Семенов";
        sN = "Семен";
        thN = "Семенович";
        address = "Минск Притыцкого 36";
        ccn = "1111 2222 3333 7776";
        iban = "BY74 65O1 3533 7X48 4386 3T58 V477";

        a = new Customer(fN, sN, thN, address,ccn, iban);
        thisBankList.addToList(a);

        fN = "Кирилов";
        sN = "Кирилл";
        thN = "Кириллович";
        address = "Минск Масюковщина 67";
        ccn = "1111 2222 3333 7555";
        iban = "BY95 2172 1586 C189 27Y8 A141 2327";

        a = new Customer(fN, sN, thN, address,ccn, iban);
        thisBankList.addToList(a);

        fN = "Михайлов";
        sN = "Михаил";
        thN = "Михайлович";
        address = "Минск Ржавецкая 27";
        ccn = "1111 2222 3333 7796";
        iban = "BY42 921N 2281 118A H970 7V64 4468";

        a = new Customer(fN, sN, thN, address,ccn, iban);
        thisBankList.addToList(a);

        fN = "Петров";
        sN = "Петр";
        thN = "Петрович";
        address = "Минск Кольцова 87";
        ccn = "1111 2222 3333 7335";
        iban = "BY55 4744 2025 065O 8587 0073 6283";

        a = new Customer(fN, sN, thN, address,ccn, iban);
        thisBankList.addToList(a);

        fN = "Андреев";
        sN = "Андрей";
        thN = "Андреевич";
        address = "Минск Уручье 3";
        ccn = "1111 2222 3333 7584";
        iban = "BY80 1346 1824 01M2 7990 4684 905L";

        a = new Customer(fN, sN, thN, address,ccn, iban);
        thisBankList.addToList(a);

        fN = "Лаврентьев";
        sN = "Лаврентий";
        thN = "Лаврентьевич";
        address = "Минск Автозаводская 58";
        ccn = "1111222233337587";
        iban = "BY52 591L 9982 OWF5 7222 75B4 0978";

        a = new Customer(fN, sN, thN, address,ccn, iban);
        thisBankList.addToList(a);

        fN = "Григорьев";
        sN = "Григорий";
        thN = "Григорьевич";
        address = "Минск Лобанка 91";
        ccn = "1111222233337876";
        iban = "BY40 7705 6734 K8S8 97VL 8082 B41P";

        a = new Customer(fN, sN, thN, address,ccn, iban);
        thisBankList.addToList(a);

        System.out.println("");
        System.out.println(thisBankList.toString());

        thisBankList.printCustomersAlphabet();
        /*String file = "D:\\Temp\\untitled\\src\\Clients.txt";
        FileWriter fileWriter = new FileWriter(file);
        String divider = ", ";
        String fileContent = fN + divider + sN + divider + thN +divider + address + divider + ccn + divider + iban;
        fileWriter.write(fileContent);
        fileWriter.close();
        System.out.println(fileContent);*/
    }

}
