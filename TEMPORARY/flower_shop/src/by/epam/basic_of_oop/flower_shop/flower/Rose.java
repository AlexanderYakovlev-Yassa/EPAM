package by.epam.basic_of_oop.flower_shop.flower;

public class Rose extends Flower{

    public Rose(Color color) {
        super.color = color;
    }

    @Override
    public void whatKindOfFlower() {
        System.out.println(super.color + " Rose");
    }
}
