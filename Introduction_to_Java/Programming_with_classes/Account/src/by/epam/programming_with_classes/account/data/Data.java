package by.epam.programming_with_classes.account.data;

import by.epam.programming_with_classes.account.Logic.Logic;
import by.epam.programming_with_classes.account.enumerators.AccountType;
import by.epam.programming_with_classes.account.objects.Account;
import by.epam.programming_with_classes.account.objects.Accounts;
import by.epam.programming_with_classes.account.objects.Client;

public class Data {

    public Account readAccount(String string) {

        String[] fields = string.split(", ");
        Logic logic = new Logic();
        Account account = null;
        Client client = null;
        AccountType type = null;
        boolean status = true;
        boolean flag = true;
        float balance = 0f;

        try {
            client = new Client(fields[0], fields[1]);
        } catch (NullPointerException e) {
            flag = false;
        }

        try {
            type = logic.stringToAccountType(fields[2]);
        } catch (NullPointerException e) {
            flag = false;
        } catch (EnumConstantNotPresentException e) {
            flag = false;
        }

        switch (fields[3].toLowerCase()) {
            case "true": {
                status = true;
                break;
            }
            case "false": {
                status = false;
                break;
            }
            default: {
                flag = false;
            }

        }

        try {
            balance = Float.parseFloat(fields[4]);
        } catch (NullPointerException e) {
            flag = false;
        } catch (NumberFormatException e) {
            flag = false;
        }

        if (flag) {
            account = new Account(type, client);
            account.setStatus(status);
            account.setBalance(balance);
        }

        return account;
    }

    public Accounts readAccounts() {


        Logic logic = new Logic();
        Accounts accounts = new Accounts();
        String[] records = null;

        try {
            records = read().split("\n");

            for (String r : records) {
                try {
                    logic.addAccount(accounts, readAccount(r));
                } catch (NullPointerException e) {
                }
            }
        } catch (NullPointerException e) {
            accounts = null;
        }

        return accounts;
    }

    public String read() {
        return "Александров, Александр, CURRENT, true, 1000\n" +
                "Александров, Александр, CARD, true, 1000\n" +
                "Александров, Александр, CARD, true, 1000\n" +
                "Петров, Петр, CARD, true, 1000\n" +
                "Суворов, Александр, CARD, true, 1000\n" +
                "Толстой, Алексей, CARD, true, 1000\n" +
                "Пушкин, Александр, CARD, true, 1000\n" +
                "Быков, Василий, CARD, true, 1000\n" +
                "Лермонтов, Михаил, CARD, true, 1000\n" +
                "Боярский, Михаил, CARD, true, 1000\n" +
                "da Vinci, Leonardo, CARD, true, 1000\n" +
                "Newton, Isaak, CARD, true, 1000\n" +
                "Khayyam, Omar, CARD, true, 1000\n" +
                "Хаям, Омар, CURRENT, true, 1000\n" +
                "Хаям, Омар, CARD, true, 2000\n" +
                "Хаям, Омар, CARD, true, 25.52\n" +
                "Бернулли, Якоб, CURRENT, true, 0\n" +
                "Бернулли, Якоб, CARD, true, 1000\n" +
                "Бернулли, Якоб, CARD, true, -100\n" +
                "Эйлер, Леонард, CARD, true, 500\n" +
                "Эйлер, Леонард, CARD, true, 1000.36\n" +
                "Эйлер, Леонард, CARD, true, 20.85\n" +
                "Фромм, Эрих, CURRENT, true, 1000\n" +
                "Фромм, Эрих, CARD, true, -65.65\n";
    }
}
