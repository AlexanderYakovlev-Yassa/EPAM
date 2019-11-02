package by.epam.programming_with_classes.decimal_counter.main;

import by.epam.programming_with_classes.decimal_counter.objects.Counter;

public class Main {

    public static void main(String[] args) {

        //создаем сетчик по умолчаню
        Counter counterDefault = new Counter();

        //выводим информацию о нем
        System.out.println(counterDefault.info());

        System.out.println("");

        //увелициваем значение счетчика 15 раз и выводим каждое новое его значение
        for (int i = 0; i < 15; i++) {

            counterDefault.increase();
            System.out.println(counterDefault.getValue());
        }

        //уменьшаем значение счетчика 15 раз и выводим каждое новое его значение
        for (int i = 0; i < 15; i++) {

            counterDefault.decrease();
            System.out.println(counterDefault.getValue());
        }

        System.out.println("");

        //создаем счетчик с за
        Counter counter = new Counter(-100, 100, 0);

        counter.info();

        //увелициваем значение счетчика 15 раз и выводим каждое новое его значение
        for (int i = 0; i < 15; i++) {

            counter.increase();
            System.out.println(counter.getValue());
        }

        //уменьшаем значение счетчика 25 раз и выводим каждое новое его значение
        for (int i = 0; i < 25; i++) {

            counter.decrease();
            System.out.println(counter.getValue());
        }

        System.out.println("");

        //создаем счетчик с параметрами, но при этом параметры не корректные
        Counter counter1 = new Counter(1000, 500, 0);
        System.out.println(counter1.info());
    }
}
