package by.epam.programming_with_classes.book.main;

import by.epam.programming_with_classes.book.book.Books;
import by.epam.programming_with_classes.book.logic.Library;
import by.epam.programming_with_classes.book.logic.Logic;
import by.epam.programming_with_classes.book.view.View;

public class Demo {


    public static void main(String[] args) {


        Logic logic = new Logic();
        Library library = new Library();
        View view = new View();

        Books books = new Books(library.readLibrary());

        System.out.println("All the books in the library:\n");
        view.printBooks(books);

        String author = "Margaret Mitchell";
        System.out.println("\nAll the books in the library which written by \"" + author + "\"\n");
        view.printBooks(logic.findByAuthor(books, author));

        String publisher = "Adobe Press";
        System.out.println("\nAll the books in the library which published by \"" + publisher + "\"\n");
        view.printBooks(logic.findByPublisher(books, publisher));

        int year = 2018;
        System.out.println("\nAll the books in the library which published after \"" + year + "\"\n");
        view.printBooks(logic.findBooksYounger(books, year));
    }
}
