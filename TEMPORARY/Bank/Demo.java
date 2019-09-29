public class Demo {
    public static void main(String[] args) {
        //создаем банк
        Bank bankNB = new Bank();

        //набираем базу клиентов банка
        Client tmpClient = new Client("Иван", "Иванов");
        System.out.println(bankNB.addClient(tmpClient));
        System.out.println(bankNB.addClient(new Client("Петр", "Петров")));
        System.out.println(bankNB.addClient(new Client("Яков", "Яковлев")));
        System.out.println(bankNB.addClient(new Client("Сидор", "Сидоров")));
        System.out.println(bankNB.addClient(new Client("Ирина", "Иринова")));
        System.out.println(bankNB.addClient(new Client("Ольга", "Ольгина")));

        //заводим счета для клиентов
        //Account tmpAccount = new Account();


    }
}
