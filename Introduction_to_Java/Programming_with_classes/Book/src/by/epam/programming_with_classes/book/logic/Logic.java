package by.epam.programming_with_classes.book.logic;

import by.epam.programming_with_classes.book.book.Book;
import by.epam.programming_with_classes.book.book.Books;

import java.util.Arrays;

public class Logic {

    public Books findByAuthor(Books books, String author){

        Book[] findResult = new Book[0];

        for (Book b : books.getBooks()) {
            for (String a : b.getAuthors()) {
                if (author.equals(a)){
                    findResult = addBook(findResult, b);
                    break;
                }
            }
        }

        return new Books(findResult);
    }

    public Books findByPublisher(Books books, String publisher){

        Book[] findResult = new Book[0];

        for (Book b : books.getBooks()) {
            if (b.getPublisher().equals(publisher)){

                findResult = addBook(findResult, b);
            }
        }

        return new Books(findResult);
    }

    public Books findBooksYounger(Books books, int year){

        Book[] findResult = new Book[0];

        for (Book b : books.getBooks()) {
            if (b.getYear() >= year){
                findResult = addBook(findResult, b);
            }
        }

        return new Books(findResult);
    }

    public Book[] addBook(Book[] books, Book book){

        Book[] newBooks = Arrays.copyOf(books, books.length + 1);
        newBooks[newBooks.length - 1] = book;

        return newBooks;
    }
}
