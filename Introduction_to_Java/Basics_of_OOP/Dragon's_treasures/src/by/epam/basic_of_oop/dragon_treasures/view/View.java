package by.epam.basic_of_oop.dragon_treasures.view;

import by.epam.basic_of_oop.dragon_treasures.logic.Logic;
import by.epam.basic_of_oop.dragon_treasures.menu.Menu;
import by.epam.basic_of_oop.dragon_treasures.menu.Option;
import by.epam.basic_of_oop.dragon_treasures.tresure.Treasure;
import by.epam.basic_of_oop.dragon_treasures.tresure.Treasures;

import java.util.Scanner;

public class View {

    public void printTreasureShort(Treasure treasure){
        System.out.println("\"" + treasure.getName()+ "\"" + " стоимость " + treasure.getCost());
    }

    public void printTreasureComplete(Treasure treasure){
        System.out.println(treasure.getName() + "\n" + treasure.getDescription()+ "\nстоимость " + treasure.getCost());
    }

    public void printTreasures(Treasures treasures){

        for (Treasure tr : treasures.getTreasures()){

            printTreasureShort(tr);
        }
    }

    public void printMenu(Menu menu){
        System.out.print("\n\t" + menu.getName());

        for (int i = 0; i < menu.getOptions().length; i++) {

            printOption(menu.getOption(i), i);
        }
    }

    public void printOption(Option option, int index){
        System.out.print(String.format("\n%-35s  [%d]", option.getName(), index));
    }

    public int chooseOption(int optionsNumber){

        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        int choice = -1;



        while (flag) {

            System.out.print("\nваш выбор >");

            if (scan.hasNextInt()) {
                choice = scan.nextInt();
                scan.nextLine();

                if (choice >= 0 && choice < optionsNumber) {
                    flag = false;
                } else {
                    System.out.println("нет такой опции...");
                }
            } else {
                scan.nextLine();
                System.out.println("нет такой опции...");
            }

        }
        return choice;
    }

    public int chooseMaxCost(){

        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        int choice = -1;

        while (flag) {

            System.out.print("\nвведите сумму >");

            if (scan.hasNextInt()) {
                choice = scan.nextInt();
                scan.nextLine();

                if (choice >= 0) {
                    flag = false;
                } else {
                    System.out.println("ошибка, повторите ввод...");
                }
            } else {
                scan.nextLine();
                System.out.println("ошибка, повторите ввод...");
            }

        }
        return choice;
    }

    public void showMainMenu(Treasures treasures){

        Logic logic = new Logic();
        Menu mainMenu = new Menu("\n\tГлавное меню");
        //View view = new View();

        mainMenu.add(new Option("Показать все сокровища") {
            @Override
            public void action() {
                System.out.println("Все вокровища дракона");
                printTreasures(treasures);
                showMainMenu(treasures);
            }
        });
        mainMenu.add(new Option("Посмотреть доступные") {
            @Override
            public void action() {
                System.out.println("\nВведите сумму которой вы распологаете");
                printTreasures(logic.cheapTreasures(treasures,chooseMaxCost()));
                showMainMenu(treasures);
            }
        });
        mainMenu.add(new Option("Показать самое дорогое сокровище") {
            @Override
            public void action() {
                System.out.println("\nСамое дорогое сокровище");
                printTreasureShort(logic.mostExpensiveTreasure(treasures));
                showMainMenu(treasures);
            }
        });
        mainMenu.add(new Option("Выход") {
            @Override
            public void action() {
                System.out.println("\nДо свидания !!!");
            }
        });

        printMenu(mainMenu);
        int choice = chooseOption(mainMenu.getOptions().length);

        mainMenu.getOption(choice).action();
    }



}
