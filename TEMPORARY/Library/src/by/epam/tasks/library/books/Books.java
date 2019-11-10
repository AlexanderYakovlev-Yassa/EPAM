package by.epam.tasks.library.books;

import java.util.ArrayList;
import java.util.Collection;

public class Books extends ArrayList<Book> {

    public Books(Collection<? extends Book> c) {
        super(c);
    }

    public Books() {
        super();
    }
}
