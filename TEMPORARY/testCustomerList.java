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
        String iban = "BY123436889";

        Customer a = new Customer(fN, sN, thN, address,ccn, iban);
        thisBankList.addToList(a);

        fN = "Иванов";
        sN = "Иван";
        thN = "Иванович";
        address = "Минск Жилуновича 8";
        ccn = "1111 2222 3333 5896";
        iban = "BY123438521";

        a = new Customer(fN, sN, thN, address,ccn, iban);
        thisBankList.addToList(a);

        fN = "Федоров";
        sN = "Федор";
        thN = "Федорович";
        address = "Минск Бельского 51";
        ccn = "1111 2222 3333 7896";
        iban = "BY123452361";

        a = new Customer(fN, sN, thN, address,ccn, iban);
        thisBankList.addToList(a);

        fN = "Семенов";
        sN = "Семен";
        thN = "Семенович";
        address = "Минск Притыцкого 36";
        ccn = "1111 2222 3333 7776";
        iban = "BY123452385";

        a = new Customer(fN, sN, thN, address,ccn, iban);
        thisBankList.addToList(a);

        fN = "Кирилов";
        sN = "Кирилл";
        thN = "Кириллович";
        address = "Минск Масюковщина 67";
        ccn = "1111 2222 3333 7555";
        iban = "BY123433361";

        a = new Customer(fN, sN, thN, address,ccn, iban);
        thisBankList.addToList(a);

        fN = "Михайлов";
        sN = "Михаил";
        thN = "Михайлович";
        address = "Минск Ржавецкая 27";
        ccn = "1111 2222 3333 7796";
        iban = "BY123452561";

        a = new Customer(fN, sN, thN, address,ccn, iban);
        thisBankList.addToList(a);

        fN = "Петров";
        sN = "Петр";
        thN = "Петрович";
        address = "Минск Кольцова 87";
        ccn = "1111 2222 3333 7866";
        iban = "BY123452351";

        a = new Customer(fN, sN, thN, address,ccn, iban);
        thisBankList.addToList(a);

        fN = "Андреев";
        sN = "Андрей";
        thN = "Андреевич";
        address = "Минск Уручье 3";
        ccn = "1111 2222 3333 7586";
        iban = "BY123452261";

        a = new Customer(fN, sN, thN, address,ccn, iban);
        thisBankList.addToList(a);

        fN = "Лаврентьев";
        sN = "Лаврентий";
        thN = "Лаврентьевич";
        address = "Минск Автозаводская 58";
        ccn = "1111 2222 3333 7877";
        iban = "BY123452366";

        a = new Customer(fN, sN, thN, address,ccn, iban);
        thisBankList.addToList(a);

        fN = "Григорьев";
        sN = "Григорий";
        thN = "Григорьевич";
        address = "Минск Лобанка 91";
        ccn = "1111222233337876";
        iban = "BY33 SOMA 3334 МB00 0002 0200 0007";

        a = new Customer(fN, sN, thN, address,ccn, iban);
        thisBankList.addToList(a);

        System.out.println(thisBankList.getList()[5].toString());
        System.out.println("");
        System.out.println(thisBankList.toString());
        /*String file = "D:\\Temp\\untitled\\src\\Clients.txt";
        FileWriter fileWriter = new FileWriter(file);
        String divider = ", ";
        String fileContent = fN + divider + sN + divider + thN +divider + address + divider + ccn + divider + iban;
        fileWriter.write(fileContent);
        fileWriter.close();
        System.out.println(fileContent);*/
    }

}
