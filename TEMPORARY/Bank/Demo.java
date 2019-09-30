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

        //
        bankNB.makeAccount("Петр", "Петров", AccountTypes.CURRENT, Currency.BYN);
        bankNB.makeAccount("Петр", "Петров", AccountTypes.DEPOSIT, Currency.BYN);
        bankNB.makeAccount("Петр", "Петров", AccountTypes.CARD, Currency.BYN);
        bankNB.makeAccount("Петр", "Петров", AccountTypes.FOREIGN_CURRENCY, Currency.EUR);
        bankNB.makeAccount("Петр", "Петров", AccountTypes.PAYMENT, Currency.BYN);

        bankNB.makeAccount("Яков", "Яковлев", AccountTypes.CURRENT, Currency.BYN);
        bankNB.makeAccount("Сидор", "Сидоров", AccountTypes.CURRENT, Currency.BYN);
        bankNB.makeAccount("Ирина", "Иринова", AccountTypes.CURRENT, Currency.BYN);
        bankNB.makeAccount("Ольга", "Ольгина", AccountTypes.CURRENT, Currency.BYN);
        bankNB.makeAccount("Ольга", "Ольгина", AccountTypes.CURRENT, Currency.BYN);

        bankNB.makeAccount("Федор", "Федоров", AccountTypes.CURRENT, Currency.BYN);


        bankNB.printAllClients();

        System.out.println("");

        bankNB.printAllAccounts();
        //заводим счета для клиентов
        //Account tmpAccount = new Account();


    }
}
