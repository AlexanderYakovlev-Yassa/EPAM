package by.epam.programming_with_classes.book.book;

import by.epam.programming_with_classes.book.logic.Logic;

public class Books {
    private Book[] books;

    public Books() {
        this.books = new Book[0];
    }

    public Books(Book[] books) {
        this.books = books;
    }

    public boolean addBook(Book newBook) {

        boolean res = false;
        boolean bookExists = false;
        Logic logic = new Logic();


        for (int i = 0; i < this.books.length; i++) {

            if (this.books[i].equals(newBook)) {

                bookExists = true;
                break;
            }
        }

        if (!bookExists) {

            this.books = logic.addBook(this.books, newBook);
            res = true;
        }

        return res;
    }

    public Book[] getBooks() {
        return books;
    }

    public Book getBook(int index) {
        return books[index];
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public void setBook(Book book, int index) {
        this.books[index] = book;
    }
}
