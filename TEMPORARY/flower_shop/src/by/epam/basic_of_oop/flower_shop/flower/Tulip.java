package by.epam.basic_of_oop.flower_shop.flower;

public class Tulip extends Flower{

    public Tulip(Color color) {
        super.color = color;
    }

    @Override
    public void whatKindOfFlower() {
        System.out.println(super.color + " Tulip");
    }
}
