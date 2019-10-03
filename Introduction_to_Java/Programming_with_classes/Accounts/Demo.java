public class Demo {
    public static void main(String[] args) {
        //создаем группу счетов
        Accounts bankNB = new Accounts();
        Accounts.logOn();

        //открываем текущий счет в банке для Ивана Иванова
        Account a1 = bankNB.openCurrentAccount("Иванов", "Иван");

        //зачисляем на счет 5000 BYN
        a1.addAmount(5000);

        //открываем текущий счет в банке для Петра Петрова
        Account a2 = bankNB.openCurrentAccount("Петров", "Петр");
        //зачисляем на счет 3000 BYN
        a2.addAmount(3000);
        //снимаем со щета 3500
        a2.addAmount(-3500);

        //наполняем базу счетов
        Account a3 = bankNB.openCurrentAccount("Петрова", "Мария");
        a3.addAmount(3000);
        Account a4 = bankNB.openCurrentAccount("Суворова", "Ольга");
        a4.addAmount(-500);
        Account a5 = bankNB.openCurrentAccount("Сергеев", "Сергей");
        a5.addAmount(2000);
        Account a6 = bankNB.openCardAccount("Сергеев", "Сергей");
        a6.addAmount(2000);
        Account a7 = bankNB.openCardAccount("Сергеев", "Сергей");
        a7.addAmount(500);
        Account a8 = bankNB.openCurrentAccount("Яковлев", "Яков");
        a8.addAmount(5000);
        Account a9 = bankNB.openCurrentAccount("Васильев", "Василий");
        a9.addAmount(5000);

        a9.blockAccount();
        a9.addAmount(200);
        a9.unBlockAccount();
        a9.addAmount(200);
        System.out.println("");

        Accounts.logOff();

        System.out.println("\tсписок счетов клиета (Сергеев Сергей):");
        Client c = bankNB.searchClient("Сергеев","Сергей" );
        System.out.println(bankNB.getByClient(c));

        System.out.println("\tсписок текущих счетов:");
        System.out.println(bankNB.getByType(AccountTypes.CURRENT));

        System.out.println("\tсписок карточных счетов:");
        System.out.println(bankNB.getByType(AccountTypes.CARD));

        System.out.println("\tсписок счетов с положительным (нулевым) балансом:");
        System.out.println(bankNB.getPositiveBalanceAccounts());

        System.out.println("\tсписок счетов с отрицательным балансом:");
        System.out.println(bankNB.getNegativeBalanceAccounts());

        System.out.println("\tсортированный по именам клиентов список счетов");
        System.out.println(bankNB.sortAccountsByClients());

        System.out.println("\tсумма по всем счетам");
        System.out.println(bankNB.getSumAmount());
        System.out.println("");

        System.out.println("\tсумма по всем счетам с положительным балансом");
        System.out.println(bankNB.getSumPositiveBalances());
        System.out.println("");

        System.out.println("\tсумма по всем счетам с отрицательным балансом");
        System.out.println(bankNB.getSumNegativeBalances());
        System.out.println("");


    }
}