package by.epam.tasks.library.books;

import java.util.ArrayList;
import java.util.Objects;

public class Book {
    private int id;
    private String name;
    private ArrayList<String> authors;
    private String publisher;
    private int year;
    private static int lastID = 0;

    public Book() {
        this.name = "";
        this.authors = new ArrayList<String>();
        this.id = ++lastID;
    }

    public Book(String name, ArrayList<String> authors, String publisher, int year) {
        this.name = name;
        this.authors = authors;
        this.publisher = publisher;
        this.year = year;
        this.id = ++lastID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public String getAuthor(int index) {
        return authors.get(index);
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public int getId() {
        return id;
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

    public void addAuthor(String author){
        authors.add(author);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getYear() == book.getYear() &&
                Objects.equals(getName(), book.getName()) &&
                Objects.equals(getAuthors(), book.getAuthors()) &&
                Objects.equals(getPublisher(), book.getPublisher());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAuthors(), getPublisher(), getYear());
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                '}';
    }
}