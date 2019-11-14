package by.epam.tasks.library.view;

import by.epam.tasks.library.books.Book;
import by.epam.tasks.library.books.Books;
import by.epam.tasks.library.books.EBook;
import by.epam.tasks.library.books.PBook;
import by.epam.tasks.library.ui.Menu;
import by.epam.tasks.library.ui.MenuItem;

public class View {

    public String printBook(Book book) {

        StringBuilder sb = new StringBuilder();
        String separator = "\n";
        try {
            sb.append("name: " + book.getName() + separator);
            for (String a : book.getAuthors()) {
                sb.append("author: " + a + separator);
            }
            sb.append("publisher: " + book.getPublisher() + separator);
            sb.append("year: " + book.getYear() + separator);

            if (book instanceof PBook) {
                sb.insert(0, "type: PaperBook\n");
                sb.append("pages: " + ((PBook) (book)).getPages());
            } else if (book instanceof EBook) {
                sb.insert(0, "type: EBook:\n");
                sb.append("fileName: " + ((EBook) (book)).getFileName());
            }

            sb.append("\n\n");
        } catch (NullPointerException e) {
            sb.append("no book");
        } catch (Exception e) {
            sb.append("error " + e);
        }

        return sb.toString();
    }

    public StringBuilder printBooks(Books books) {

        StringBuilder booksInfo = new StringBuilder();
        try {
            for (Book b : books) {

                booksInfo.append(printBook(b));
            }
        } catch (NullPointerException e) {
            System.out.println("there are no books");
        } catch (Exception e) {
            System.out.println("error " + e);
        }

        return booksInfo;
    }

    public void printMenu(Menu menu){

        if(menu != null){
            if(menu.getItems().size() != 0){
                for(int i = 0; i < menu.getItems().size(); i++){
                    System.out.println(String.format("%2d. %s", i, menu.getItem(i).getName()));
                }
            }
        }
    }
}
