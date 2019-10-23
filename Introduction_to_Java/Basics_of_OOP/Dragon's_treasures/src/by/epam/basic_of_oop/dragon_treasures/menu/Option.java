package by.epam.basic_of_oop.dragon_treasures.menu;

public abstract class Option {
    private String name;

    public Option(String name){
        this.name = name;
    }

    public abstract void action();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
