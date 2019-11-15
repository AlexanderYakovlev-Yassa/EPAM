package by.epam.tasks.library.books;

import java.util.Objects;

public class User {

    String name;
    AccessGroup accessGroup;

    public User(String name, AccessGroup accessGroup) {
        this.name = name;
        this.accessGroup = accessGroup;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccessGroup getAccessGroup() {
        return accessGroup;
    }

    public void setAccessGroup(AccessGroup accessGroup) {
        this.accessGroup = accessGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getName(), user.getName()) &&
                getAccessGroup() == user.getAccessGroup();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAccessGroup());
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", accessGroup=" + accessGroup +
                '}';
    }
}
