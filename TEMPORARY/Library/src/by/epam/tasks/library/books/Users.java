package by.epam.tasks.library.books;

import java.util.ArrayList;
import java.util.Objects;

public class Users {

    ArrayList<User> users;

    public Users(ArrayList<User> users) {
        this.users = users;
    }

    public Users() {
        this.users =new ArrayList<User>();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public User getUsers(int index) {
        return users.get(index);
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void setUsers(User user, int index) {
        this.users.set(index, user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users users1 = (Users) o;
        return Objects.equals(getUsers(), users1.getUsers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsers());
    }

    @Override
    public String toString() {
        return "Users{" +
                "users=" + users +
                '}';
    }
}
