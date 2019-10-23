package by.epam.basic_of_oop.dragon_treasures.tresure;

import java.util.Arrays;

public class Treasures {

    Treasure[] treasures;

    public Treasures() {
        this.treasures = new Treasure[0];
    }

    public Treasure[] getTreasures() {
        return treasures;
    }

    public Treasure getTreasures(int index) {
        return treasures[index];
    }

    public void setTreasures(Treasure[] treasures) {
        this.treasures = treasures;
    }

    public void setTreasure(Treasure treasure, int index) {
        this.treasures[index] = treasure;
    }

    public void add(Treasure treasure){
        setTreasures(Arrays.copyOf(getTreasures(), getTreasures().length + 1));
        setTreasure(treasure,getTreasures().length - 1);
    }
}
