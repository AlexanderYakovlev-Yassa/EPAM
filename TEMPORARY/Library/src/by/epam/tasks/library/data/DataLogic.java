package by.epam.tasks.library.data;

import by.epam.tasks.library.books.Book;
import by.epam.tasks.library.books.Books;
import by.epam.tasks.library.books.PBook;
import by.epam.tasks.library.util.TextFileRW;
import by.epam.tasks.library.view.View;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataLogic {

    public void saveLibrary(Books books) throws IOException {

        View view = new View();
        TextFileRW textFileRW = new TextFileRW();

        String fileName = "src\\by\\epam\\tasks\\library\\data\\library.txt";
        StringBuilder text = view.printBooks(books);

        textFileRW.addToTextFile(fileName, text, false);
    }

    public Books readLibrary() {

        TextFileRW textFileRW = new TextFileRW();
        Books books = new Books();
        String fileName = "src\\by\\epam\\tasks\\library\\data\\library.txt";
        StringBuilder sb = new StringBuilder();

        try {
            sb = textFileRW.readTextFile(fileName);
        } catch (IOException e) {

            e.printStackTrace();
        }

        //System.out.println(sb.toString());

        return books;
    }

    public Book parseRecord(String string) {

        Book book = new Book();

        String[] fields = string.split("\n");

        for (String f : fields) {

            //Pattern p = Pattern.compile("^[/w]+[:][/s]");
            //f.matches("^[/w]+[:]");
            String fieldName = f.substring(0, f.indexOf(':'));
            String fieldValue = f.substring(f.indexOf(':') + 2, f.length());
            System.out.println(fieldName + "  [" + fieldValue);
            switch (fieldName){
                case "name":{
                    book.setName(fieldValue);
                    break;
                }
                case "author":{
                    book.addAuthor(fieldValue);
                    break;
                }
                case "publisher":{
                    ((PBook)(book)).setPublisher(fieldValue);
                    break;
                }
                case "year":{
                    int year = Integer.parseInt(fieldValue);
                    ((PBook)(book)).setYear(year);
                    break;
                }
                case "pages":{
                    int pages = Integer.parseInt(fieldValue);
                    ((PBook)(book)).setPages(pages);
                    break;
                }
            }
        }

        return book;
    }
}