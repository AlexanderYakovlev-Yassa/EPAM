package by.epam.programming_with_classes.book.book;

import java.util.Arrays;
import java.util.Objects;

public class Book {
    private int id;
    private String name;
    private String[] authors;
    private String publisher;
    private int year;
    private int pages;
    private int price;
    private String binding;
    private static int lastID = 100;

    public Book() {
        this.name = "";
        this.authors = new String[0];
        this.publisher = "";
        this.year = 0;
        this.pages = 0;
        this.price = 0;
        this.binding = "";
        this.id = ++lastID;
    }

    public Book(String name, String[] authors, String publisher, int year, int paperback, int price, String binding) {
        this.name = name;
        this.authors = authors;
        this.publisher = publisher;
        this.year = year;
        this.pages = paperback;
        this.price = price;
        this.binding = binding;
        this.id = ++lastID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getAuthors() {
        return authors;
    }

    public String getAuthor(int index) {
        return authors[index];
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public void setAuthor(String author, int index) {
        this.authors[index] = author;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year &&
                pages == book.pages &&
                price == book.price &&
                name.equals(book.name) &&
                Arrays.equals(authors, book.authors) &&
                publisher.equals(book.publisher) &&
                Objects.equals(binding, book.binding);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, publisher, year, pages, price, binding);
        result = 31 * result + Arrays.hashCode(authors);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                '}';
    }
}
