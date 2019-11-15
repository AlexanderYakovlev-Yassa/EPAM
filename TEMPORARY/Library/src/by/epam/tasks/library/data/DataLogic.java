package by.epam.tasks.library.data;

import by.epam.tasks.library.books.*;
import by.epam.tasks.library.util.Util;
import by.epam.tasks.library.view.View;

import java.io.*;
import java.util.ArrayList;

public class DataLogic {

    public void saveBooks(Books books) throws IOException {

        View view = new View();
        Util util = new Util();

        String fileName = "src\\by\\epam\\tasks\\library\\data\\test.txt";
        StringBuilder text = view.printBooks(books);

        util.addToTextFile(fileName, text, false);
    }

    public Books readBooks() {

        Util util = new Util();
        Books books = new Books();
        String fileName = "src\\by\\epam\\tasks\\library\\data\\library.txt";
        StringBuilder sb = new StringBuilder();


        try {
            sb = util.readTextFile(fileName);

        } catch (IOException e) {

            e.printStackTrace();
        }

        ArrayList<String> arrayList = util.splitStringBuilder(sb, "\n\n");
        for(String r: arrayList){
            books.add(parseRecord(r));
        }

        return books;
    }

    public Book parseRecord(String string) {

        Book book = null;

        String type = null;
        String name = null;
        ArrayList<String> authors = new ArrayList<String>();
        String publisher = null;
        int year = 0;
        int pages = 0;
        String fileName = null;

        String[] fields = string.split("\n");

        for (String f : fields) {

            String fieldName = f.substring(0, f.indexOf(':'));
            String fieldValue = f.substring(f.indexOf(':') + 2, f.length());
            //System.out.println(fieldName + "  [" + fieldValue);
            switch (fieldName) {
                case "type": {
                    type = fieldValue;
                    break;
                }
                case "name": {
                    name = fieldValue;
                    break;
                }
                case "author": {
                    authors.add(fieldValue);
                    break;
                }
                case "publisher": {
                    publisher = fieldValue;
                    break;
                }
                case "year": {
                    try {
                        year = Integer.parseInt(fieldValue);
                    } catch (NumberFormatException e) {

                    }
                    break;
                }
                case "pages": {
                    try {
                        pages = Integer.parseInt(fieldValue);
                    } catch (NumberFormatException e) {

                    }
                    break;
                }
            }
        }

        if (type != null) {
            switch (type.toLowerCase()) {
                case "paperbook": {
                    book = createPaperBook(name, authors, publisher, year, pages);
                    break;
                }
                case "ebook": {
                    book = createEBook(name, authors, publisher, year, fileName);
                    break;
                }
                default: {
                }
            }
        }
        return book;
    }

    public Users readUsers(){
        Users users = new Users();//----------------------------- needs to change

        return users;
    }

    public User stringToUser(String string){

        Util util = new Util();
        User user = new User();

        string = util.suppressExcessWhiteSpaces(string);
        String[] fields = string.split("/s");

        return user;
    }

    private PBook createPaperBook(String name, ArrayList<String> authors, String publisher, int year, int pages) {

        if (name != null && name != "") {
            return new PBook(name, authors, publisher, year, pages);
        } else {
            return null;
        }
    }

    private EBook createEBook(String name, ArrayList<String> authors, String publisher, int year, String fileName) {

        if (name != null && name != "") {
            return new EBook(name, authors, publisher, year, fileName);
        } else {
            return null;
        }
    }
}