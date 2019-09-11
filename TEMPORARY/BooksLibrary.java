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
            res.append(this.books[i].toStringShort()+ "\n");
        }
        return res.toString();
    }
}
