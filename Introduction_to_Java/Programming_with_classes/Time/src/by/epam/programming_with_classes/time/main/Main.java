package by.epam.programming_with_classes.time.main;

import by.epam.programming_with_classes.time.logic.Logic;
import by.epam.programming_with_classes.time.objects.Time;
import by.epam.programming_with_classes.time.view.View;

public class Main {
    public static void main(String[] args) {

        System.out.println("конструктор по умолчанию");
        Time time = new Time();

        Logic logic = new Logic();
        View view = new View();

        view.printTimeHMS(time);

        System.out.println("задаем поля времени методами set");
        time.setHour(3);
        time.setMinute(15);
        time.setSecond(5);

        view.printTimeHMS(time);

        System.out.println("задаем поля времени методами set. в каждом поле делаем ошибку.");
        time.setHour(35);
        time.setMinute(85);
        time.setSecond(-5);

        view.printTimeHMS(time);

        System.out.println("добавляем 25 часов.");
        logic.addHour(time, 25);

        view.printTimeHMS(time);

        System.out.println("добавляем 90 минут.");
        logic.addMinute(time,90);

        view.printTimeHMS(time);

        System.out.println("добавляем 90 секунд.");
        logic.addSecond(time,90);

        view.printTimeHMS(time);

        System.out.println("добавляем 3600 секунд.");
        logic.addSecond(time,3600);

        view.printTimeHMS(time);

        System.out.println("выводим время в коротком формате, часы:минуты.");
        view.printTimeHM(time);

        System.out.println("всего секунд:.");
        int sec = logic.totalSeconds(time);
        System.out.println(sec);

        System.out.println("создаем объект время конструктором принимающим секунды");
        Time time1 = new Time(sec);
        view.printTimeHMS(time1);


    }
}
