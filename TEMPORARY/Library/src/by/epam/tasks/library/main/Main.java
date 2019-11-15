package by.epam.tasks.library.main;

import by.epam.tasks.library.books.Books;
import by.epam.tasks.library.books.Library;
import by.epam.tasks.library.books.Users;
import by.epam.tasks.library.data.DataLogic;
import by.epam.tasks.library.user_interface.UserInterface;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();
        DataLogic dataLogic = new DataLogic();
        Books books = dataLogic.readBooks();
        Users users = new Users();//-------------------------------no users yet
        library.setBooks(books);
        library.setUsers(users);
        UserInterface userInterface = new UserInterface();

        //******************************************* TRACE **************************************

        //System.out.println(library.getBooks());
        System.out.println();
        //****************************************************************************************

        userInterface.start(library);
    }
}
