package by.epam.basic_of_oop.dragon_treasures.menu;

import java.util.Arrays;

public class Menu {
    String name;
    Option[] options;

    public Menu(String name) {
        this.name = name;
        this.options = new Option[0];
    }

    public Option[] getOptions() {
        return options;
    }

    public Option getOption(int index) {
        return options[index];
    }

    public void setOptions(Option[] options) {
        this.options = options;
    }

    public void setOption(Option option, int index) {
        this.options[index] = option;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(Option option){
        setOptions(Arrays.copyOf(getOptions(), getOptions().length + 1));
        setOption(option, getOptions().length - 1);
    }
}
