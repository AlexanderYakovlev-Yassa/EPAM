package by.epam.tasks.library.test;

import by.epam.tasks.library.books.Books;
import by.epam.tasks.library.books.PBook;
import by.epam.tasks.library.data.DataLogic;
import by.epam.tasks.library.util.TextFileRW;
import by.epam.tasks.library.view.View;

import java.io.IOException;
import java.util.ArrayList;

public class Test {

    public static void main(String[] args) throws IOException {

        View view = new View();
        DataLogic dataLogic = new DataLogic();
        TextFileRW textFileRW = new TextFileRW();

        //Books books = readTestLibrary();
        //System.out.println(books.size());

        //books = dataLogic.readLibrary();



        /*StringBuilder sb = view.printBooks(books);
        String fileName = "src\\by\\epam\\tasks\\library\\data\\test.txt";
        textFileRW.addToTextFile(fileName, sb, false);*/

        /*StringBuilder sb1 = textFileRW.readTextFile(fileName);
        System.out.println("\n\tfile content:\n");
        System.out.println(sb1.toString());*/

        //dataLogic.saveLibrary(books);

        dataLogic.parseRecord("name: Scam Me If You Can: Simple Strategies to Outsmart Today's Rip-off Artists\n" +
                "author: Mike Meyers\n" +
                "publisher: McGraw-Hill Education\n" +
                "year: 2019\n" +
                "pages: 352");
    }

    /*private static Books readTestLibrary(){

        String name = "Think Java: How to Think Like a Computer Scientist";
        ArrayList autors = {"Allen B. Downey", "Chris Mayfield"};
        String publisher = "O'Reilly Media";
        int year = 2016;
        int pages = 252;

        PBook book = new PBook(name, autors, publisher, year, pages);

        Books books = new Books();
        books.add(book);

        name = "Scam Me If You Can: Simple Strategies to Outsmart Today's Rip-off Artists";
        autors = new String[1];
        autors[0] = "Mike Meyers";
        publisher = "McGraw-Hill Education";
        year = 2019;
        pages = 352;

        book = new PBook(name, autors, publisher, year, pages);
        books.add(book);

        name = "CompTIA A+ Certification All-in-One Exam Guide, Tenth Edition (Exams 220-1001 & 220-1002)";
        autors = new String[1];
        autors[0] = "Frank Abagnale";
        publisher = "Portfolio";
        year = 2019;
        pages = 1568;
        book = new PBook(name, autors, publisher, year, pages);
        books.add(book);

        name = "Adobe Photoshop CC Classroom in a by.epam.programming_with_classes.book.book.Book (2019 Release) ";
        autors = new String[2];
        autors[0] = "Andrew Faulkner";
        autors[1] = "Conrad Chavez";
        publisher = "Adobe Press";
        year = 2018;
        pages = 416;

        book = new PBook(name, autors, publisher, year, pages);
        books.add(book);

        name = "Gone with the Wind";
        autors = new String[2];
        autors[0] = "Margaret Mitchell";
        autors[1] = "Pat Conroy";
        publisher = "Scribner";
        year = 2011;
        pages = 960;

        book = new PBook(name, autors, publisher, year, pages);
        books.add(book);

        return books;
    }*/
}
