package by.epam.tasks.library.ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Menu{
    ArrayList<MenuItem> items;

    public Menu(ArrayList<MenuItem> items) {
        this.items = items;
    }

    public Menu() {
        this.items = new ArrayList<MenuItem>();
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }

    public MenuItem getItem(int index) {
        return items.get(index);
    }

    public void setItems(ArrayList<MenuItem> items) {
        this.items = items;
    }

    public void setItem(MenuItem item, int index) {
        this.items.set(index, item);
    }

    public void add(MenuItem item){
        this.items.add(item);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Menu)) return false;
        Menu menu = (Menu) o;
        return Objects.equals(getItems(), menu.getItems());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItems());
    }

    @Override
    public String toString() {
        return "Menu{" +
                "items=" + items +
                '}';
    }
}
