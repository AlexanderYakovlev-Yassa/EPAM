public class Demo {
    public static void main(String[] args) {
        //создаем банк
        Bank bankNB = new Bank();

        //открываем текущий счет в банке для Ивана Иванова
        Account a1 = bankNB.openCurrentAccount("Иван", "Иванов");

        //зачисляем на счет 5000 BYN
        bankNB.transaction(a1, 5000);

        //открываем текущий счет в банке для Ивана Иванова
        Account a2 = bankNB.openCurrentAccount("Петр", "Петров");
        //зачисляем на счет 3000 BYN
        bankNB.transaction(a2, 3000);
        //снимаем со щета 3500
        bankNB.transaction(a2, -3500);

        Bank.logOff();

        //наполняем базу счетов
        Account a3 = bankNB.openCurrentAccount("Мария", "Петрова");
        bankNB.transaction(a3, 3000);
        Account a4 = bankNB.openCurrentAccount("Ольга", "Суворова");
        bankNB.transaction(a4, 6000);
        Account a5 = bankNB.openCurrentAccount("Сергей", "Сергеев");
        bankNB.transaction(a5, 2000);
        Account a6 = bankNB.openForeignCurrencyAccount("Сергей", "Сергеев", Currency.EUR);
        bankNB.transaction(a6, 2000);
        Account a7 = bankNB.openCardAccount("Сергей", "Сергеев", Currency.BYN);
        bankNB.transaction(a7, 2000);
        Account a8 = bankNB.openCurrentAccount("Яков", "Яковлев");
        bankNB.transaction(a8, 5000);
        Account a9 = bankNB.openCurrentAccount("Василий", "Васильев");
        bankNB.transaction(a9, 5000);
        Bank.logOn();
        a9.blockAccount();
        bankNB.transaction(a9, 200);
        a9.unBlockAccount();
        bankNB.transaction(a9, 200);
    }
}
