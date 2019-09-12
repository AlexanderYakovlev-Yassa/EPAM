import java.util.Arrays;

public class BooksLibrary {
    private Book[] books;

    public BooksLibrary() {
        this.books = new Book[0];
    }

    public int addBook(Book newBook) {

        int res = -2;

        boolean bookExists = false;

        for (int i = 0; i < this.books.length; i++) {
            if (this.books[i].equals(newBook)) {
                System.out.println("The such book is already in this library.");
                bookExists = true;
                res = -1;
                break;
            }
        }

        if (!bookExists) {
            int libraryLength = this.books.length;
            Book[] newBooks = new Book[this.books.length + 1];
            for (int i = 0; i < libraryLength; i++) {
                newBooks[i] = this.books[i];
            }
            newBooks[libraryLength] = newBook;
            this.books = newBooks;
            res = 0;
        }

        return res;
    }

    public Book[] getBooks() {
        return books;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < this.books.length; i++) {
            res.append(this.books[i].toString()+ "\n");
        }
        return res.toString();
    }

    public BooksLibrary getBookWhereAuthorIs(String author){
        BooksLibrary books = new BooksLibrary();
        for (int i = 0; i < this.books.length; i++) {
            for (int j = 0; j < this.books[i].getAutors().length; j++) {
                if (this.books[i].getAutors()[j] == author){
                    books.addBook(this.books[i]);
                    break;
                }
            }
        }
        return books;
    }

    public void printBookWhereAuthorIs(String author){
        BooksLibrary books = getBookWhereAuthorIs(author);
        if (books.books.length != 0){
            System.out.println("Books written by " + author + ":\n");
            System.out.println(books.toString());
        } else {
            System.out.println("There are no books with author " + author + ".\n");
        }
    }

    public BooksLibrary getBooksWherePublisherIs(String publisher){
        BooksLibrary books = new BooksLibrary();
        for (int i = 0; i < this.books.length; i++) {
                if (this.books[i].getPublisher() == publisher){
                    books.addBook(this.books[i]);
                }
        }
        return books;
    }

    public void printBooksWherePublisherIs(String publisher){
        BooksLibrary books = getBooksWherePublisherIs(publisher);
        if (books.books.length != 0){
            System.out.println("Books published by " + publisher + ":\n");
            System.out.println(books.toString());
        } else {
            System.out.println("There are no books published by \"" + publisher + "\".\n");
        }
    }

    public BooksLibrary getBooksPublishedAfter(int year){
        BooksLibrary books = new BooksLibrary();
        for (int i = 0; i < this.books.length; i++) {
            if (this.books[i].getYear() >= year){
                books.addBook(this.books[i]);
            }
        }
        return books;
    }

    public void printBooksPublishedAfter(int year){
        BooksLibrary books = getBooksPublishedAfter(year);
        if (books.books.length != 0){
            System.out.println("Books published after " + year + ":\n");
            System.out.println(books.toString());
        } else {
            System.out.println("There are no books published after \"" + year + "\".\n");
        }
    }

}
