package by.epam.tasks.library.books;

import java.util.ArrayList;
import java.util.Objects;

public class Book {
    private int id;
    private String name;
    private ArrayList<String> authors;
    private static int lastID = 0;

    public Book() {
        this.name = "";
        this.authors = new ArrayList<String>();
        this.id = ++lastID;
    }

    public Book(String name, ArrayList<String> authors) {
        this.name = name;
        this.authors = authors;
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

    /*public void setAuthor(int index, String author) {
        this.authors.set(index, author);
    }*/

    public void addAuthor(String author){
        authors.add(author);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name) &&
                Objects.equals(authors, book.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, authors);
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                '}';
    }
}