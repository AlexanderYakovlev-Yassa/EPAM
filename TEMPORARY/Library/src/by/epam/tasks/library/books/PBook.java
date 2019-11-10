package by.epam.tasks.library.books;

import java.util.ArrayList;
import java.util.Objects;

public class PBook extends Book{
    private String publisher;
    private int year;
    private int pages;

    public PBook(String name, ArrayList<String> authors, String publisher, int year, int pages) {
        super(name, authors);
        this.publisher = publisher;
        this.year = year;
        this.pages = pages;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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
        return year == pBook.year &&
                pages == pBook.pages &&
                Objects.equals(publisher, pBook.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), publisher, year, pages);
    }
}
