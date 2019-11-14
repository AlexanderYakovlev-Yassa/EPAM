package by.epam.tasks.library.ui;

import java.util.Objects;

public class MenuItem {
    String name;
    Command command;

    public MenuItem(String name, Command command) {
        this.name = name;
        this.command = command;
    }

    public MenuItem() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(!(o instanceof MenuItem)){
            return false;
        }
        return this.getName().equals(((MenuItem)o).getName()) &&
                this.getCommand() == ((MenuItem)o).getCommand();
    }


    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCommand());
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "name='" + name + '\'' +
                ", command=" + command +
                '}';
    }
}
