package by.epam.tasks.library.test;

import by.epam.tasks.library.books.Books;
import by.epam.tasks.library.books.PBook;
import by.epam.tasks.library.data.DataLogic;
import by.epam.tasks.library.util.util;
import by.epam.tasks.library.view.View;

import java.io.IOException;
import java.util.ArrayList;

public class Test {

    public static void main(String[] args) throws IOException {

        View view = new View();
        DataLogic dataLogic = new DataLogic();
        util util = new util();

        //Books books = readTestLibrary();
        //System.out.println(books.size());

        //books = dataLogic.readLibrary();



        /*StringBuilder sb = view.printBooks(books);
        String fileName = "src\\by\\epam\\tasks\\library\\data\\test.txt";
        util.addToTextFile(fileName, sb, false);*/

        /*StringBuilder sb1 = util.readTextFile(fileName);
        System.out.println("\n\tfile content:\n");
        System.out.println(sb1.toString());*/

        //dataLogic.saveLibrary(books);
        Books books = dataLogic.readLibrary();
        System.out.println(view.printBooks(books));
        dataLogic.saveLibrary(books);

        /*Book book = dataLogic.parseRecord("type: PaperBook\nname: Scam Me If You Can: Simple Strategies to Outsmart Today's Rip-off Artists\n" +
                "author: Mike Meyers\n" +
                "publisher: McGraw-Hill Education\n" +
                "year: 2019\n" +
                "pages: 352");

        System.out.println(view.printBook(book));*/
    }

    private static Books readTestLibrary(){

        String name = "Think Java: How to Think Like a Computer Scientist";
        ArrayList<String> authors = new ArrayList<String>();
        authors.add("Allen B. Downey");
        authors.add("Chris Mayfield");
        String publisher = "O'Reilly Media";
        int year = 2016;
        int pages = 252;

        PBook book = new PBook(name, authors, publisher, year, pages);

        Books books = new Books();
        books.add(book);

        name = "Scam Me If You Can: Simple Strategies to Outsmart Today's Rip-off Artists";
        authors.clear();
        authors.add("Mike Meyers");
        publisher = "McGraw-Hill Education";
        year = 2019;
        pages = 352;

        book = new PBook(name, authors, publisher, year, pages);
        books.add(book);

        name = "CompTIA A+ Certification All-in-One Exam Guide, Tenth Edition (Exams 220-1001 & 220-1002)";
        authors.clear();
        authors.add("Frank Abagnale");
        publisher = "Portfolio";
        year = 2019;
        pages = 1568;
        book = new PBook(name, authors, publisher, year, pages);
        books.add(book);

        name = "Adobe Photoshop CC Classroom in a by.epam.programming_with_classes.book.book.Book (2019 Release) ";
        authors.clear();
        authors.add("Andrew Faulkner");
        authors.add("Conrad Chavez");
        publisher = "Adobe Press";
        year = 2018;
        pages = 416;

        book = new PBook(name, authors, publisher, year, pages);
        books.add(book);

        name = "Gone with the Wind";
        authors.clear();
        authors.add("Margaret Mitchell");
        authors.add("Pat Conroy");
        publisher = "Scribner";
        year = 2011;
        pages = 960;

        book = new PBook(name, authors, publisher, year, pages);
        books.add(book);

        return books;
    }
}
