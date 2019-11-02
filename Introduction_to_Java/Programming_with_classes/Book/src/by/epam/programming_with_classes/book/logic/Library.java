package by.epam.programming_with_classes.book.logic;

import by.epam.programming_with_classes.book.book.Book;

public class Library {

    public Book[] readLibrary(){

        Logic logic = new Logic();

        String name = "Think Java: How to Think Like a Computer Scientist";
        String[] autors = {"Allen B. Downey", "Chris Mayfield"};
        String publisher = "O'Reilly Media";
        int year = 2016;
        int pages = 252;
        int price = 200;
        String binding = "soft";

        Book book = new Book(name, autors, publisher, year, pages, price, binding);

        Book[] library = new Book[0];

        library = logic.addBook(library, book);

        name = "Scam Me If You Can: Simple Strategies to Outsmart Today's Rip-off Artists";
        autors = new String[1];
        autors[0] = "Mike Meyers";
        publisher = "McGraw-Hill Education";
        year = 2019;
        pages = 352;
        price = 200;
        binding = "paperback";
        book = new Book(name, autors, publisher, year, pages, price, binding);

        library = logic.addBook(library, book);

        name = "CompTIA A+ Certification All-in-One Exam Guide, Tenth Edition (Exams 220-1001 & 220-1002)";
        autors = new String[1];
        autors[0] = "Frank Abagnale";
        publisher = "Portfolio";
        year = 2019;
        pages = 1568;
        price = 500;
        binding = "hardcover";
        book = new Book(name, autors, publisher, year, pages, price, binding);

        library = logic.addBook(library, book);

        name = "Adobe Photoshop CC Classroom in a by.epam.programming_with_classes.book.book.Book (2019 Release) ";
        autors = new String[2];
        autors[0] = "Andrew Faulkner";
        autors[1] = "Conrad Chavez";
        publisher = "Adobe Press";
        year = 2018;
        pages = 416;
        price = 180;
        binding = "paperback";
        book = new Book(name, autors, publisher, year, pages, price, binding);

        library = logic.addBook(library, book);

        name = "Gone with the Wind";
        autors = new String[2];
        autors[0] = "Margaret Mitchell";
        autors[1] = "Pat Conroy";
        publisher = "Scribner";
        year = 2011;
        pages = 960;
        price = 100;
        binding = "paperback";
        book = new Book(name, autors, publisher, year, pages, price, binding);

        library = logic.addBook(library, book);

        return library;
    }
}
