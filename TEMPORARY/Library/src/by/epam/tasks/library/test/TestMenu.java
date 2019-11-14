package by.epam.tasks.library.test;

import by.epam.tasks.library.ui.Command;
import by.epam.tasks.library.ui.Menu;
import by.epam.tasks.library.ui.MenuItem;
import by.epam.tasks.library.view.View;

public class TestMenu {

    public static void main(String[] args) {

        Menu menu = new Menu();


        menu.add(new MenuItem("Menu 1", Command.SAVE_CATALOG));
        menu.add(new MenuItem("Menu 2", Command.SHOW_CATALOG));
        menu.add(new MenuItem("Menu 3", Command.EXIT));

        View view = new View();

        view.printMenu(menu);
    }
}
