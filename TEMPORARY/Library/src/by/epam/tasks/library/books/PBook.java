package by.epam.tasks.library.books;

import java.util.ArrayList;
import java.util.Objects;

public class PBook extends Book{

    private int pages;

    public PBook(String name, ArrayList<String> authors, String publisher, int year, int pages) {
        super(name, authors, publisher, year);
        this.pages = pages;
    }

    public PBook() {
        super();
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PBook)) return false;
        if (!super.equals(o)) return false;
        PBook pBook = (PBook) o;
        return getPages() == pBook.getPages();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPages());
    }
}
