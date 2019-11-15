package by.epam.tasks.library.books;

public class Library {

    Books books;
    Users users;
    User operator;

    public Library(Books books, Users users) {
        this.books = books;
        this.users = users;
        this.operator = null;
    }

    public Library() {

    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public User getOperator() {
        return operator;
    }

    public void setOperator(User operator) {
        this.operator = operator;
    }
}
