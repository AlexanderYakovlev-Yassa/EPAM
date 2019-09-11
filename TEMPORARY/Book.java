/*
* 9. Создать класс Book, спецификация которого приведена ниже.
* Определить конструкторы, set- и get- методы и метод toString().
* Создать второй класс, агрегирующий массив типа Book,
* с подходящими конструкторами и методами.
* Задать критерии выбора данных и вывести эти данные на консоль.
*Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
*Найти и вывести:
*a) список книг заданного автора;
*b) список книг, выпущенных заданным издательством;
*c) список книг, выпущенных после заданного года.*/

import java.util.Arrays;
import java.util.Objects;

public class Book {
    private int id;
    private String name;
    private String[] autors;
    private String publisher;
    private int year;
    private int pages;
    private int price;
    private String binding;
    private static int lastID = 100;

    public Book() {
        this.name = "";
        this.autors = new String[0];
        this.publisher = "";
        this.year = 0;
        this.pages = 0;
        this.price = 0;
        this.binding = "";
        this.id = ++lastID;
    }

    public Book(String name, String[] autors, String publisher, int year, int paperback, int price, String binding) {
        this.name = name;
        this.autors = autors;
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

    public String[] getAutors() {
        return autors;
    }

    public void setAutors(String[] autors) {
        this.autors = autors;
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
                Arrays.equals(autors, book.autors) &&
                publisher.equals(book.publisher) &&
                Objects.equals(binding, book.binding);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, publisher, year, pages, price, binding);
        result = 31 * result + Arrays.hashCode(autors);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(this.toStringShort());
        res.append(this.publisher + " " + this.year + "\n");
        res.append("pages " + this.pages + ".\nbinding " + this.binding + "\n");
        res.append("price " + this.price + ".");

        return res.toString();
    }

    public String toStringShort() {
        StringBuilder res = new StringBuilder("Book ID " + id + "\n\"" + name + "\"\n");
        for (int i = 0; i < this.autors.length; i++) {
            res.append(this.autors[i] + ", ");
        }
        res.append("\b\b.\n");

        return res.toString();
    }
}
