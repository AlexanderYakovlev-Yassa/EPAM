import java.io.FileWriter;
import java.io.IOException;

public class testCustomerList {
    public static void main(String[] args) throws IOException {
        String fN = "Яковлев";
        String sN = "Александр";
        String thN = "Васильевич";
        String address = "Минск Асаналиева 32 20";
        String ccn = "1111 2222 3333 5639";
        String iban = "BY123436889";

        Customer a = new Customer(fN, sN, thN, address,ccn, iban);
        String file = "D:\\Temp\\untitled\\src\\Clients.txt";
        FileWriter fileWriter = new FileWriter(file);
        String divider = ", ";
        String fileContent = fN + divider + sN + divider + thN +divider + address + divider + ccn + divider + iban;
        fileWriter.write(fileContent);
        fileWriter.close();
        System.out.println(fileContent);
    }

}
