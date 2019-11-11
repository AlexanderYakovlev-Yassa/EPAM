package by.epam.tasks.library.books;

import java.util.ArrayList;
import java.util.Objects;

public class EBook extends Book {
    String fileName;

    public EBook(String name, ArrayList<String> authors, String publisher, int year, String fileName) {
        super(name, authors, publisher, year);
        this.fileName = fileName;
    }

    public EBook() {
        super();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EBook)) return false;
        if (!super.equals(o)) return false;
        EBook eBook = (EBook) o;
        return Objects.equals(fileName, eBook.fileName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fileName);
    }
}
