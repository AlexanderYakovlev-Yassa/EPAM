package by.epam.programming_with_classes.book.view;

import by.epam.programming_with_classes.book.book.Book;
import by.epam.programming_with_classes.book.book.Books;

public class View {

    public void printBookInfo(Book book){
        StringBuilder sb = new StringBuilder();
        sb.append("\"" + book.getName() + "\"");

        for (String a : book.getAuthors()){
            sb.append(" " + a + ",");
        }
        sb.append("\b.");

        sb.append("\npublished by \"" + book.getPublisher() + "\"");
        sb.append(" (" + book.getYear() + ")");
        System.out.println(sb.toString());
    }

    public void printBooks(Books books){

        if (books != null && books.getBooks().length != 0) {

            for (Book b : books.getBooks()) {
                printBookInfo(b);
            }
        } else {
            System.out.println("there are no books");
        }
    }
}
