package by.epam.basic_oop.calendar.main;

import by.epam.basic_oop.calendar.enumerators.DayOfWeek;
import by.epam.basic_oop.calendar.enumerators.Month;
import by.epam.basic_oop.calendar.logic.Logic;
import by.epam.basic_oop.calendar.objects.Calendar;
import by.epam.basic_oop.calendar.view.View;

public class Main {

    public static void main(String[] args) {

        //создаем календарь на 2020 год
        Calendar c2020 = new Calendar("Производственный календарь РБ на 2020 г.",
        DayOfWeek.WED, true);

        Logic logic = new Logic();
        View view = new View();

        //заводим в календарь праздничные дни, сокращенные дни и переносы рабочих дней
        c2020.addHoliday(Month.JAN, 1, "Новый Год", true, false);
        c2020.addHoliday(Month.JAN, 2, "перенос", true, false);
        c2020.addHoliday(Month.JAN, 4, "перенос", false, false);
        c2020.addHoliday(Month.JAN, 6, "перенос", true, false);
        c2020.addHoliday(Month.JAN, 7, "Рождество Христово (православное)", true, false);
        c2020.addHoliday(Month.JAN, 11, "перенос", false, false);
        c2020.addHoliday(Month.MAR, 7, "предпраздничный день", false, true);
        c2020.addHoliday(Month.MAR, 8, "Международный женский день", true, false);
        c2020.addHoliday(Month.APR, 4, "перенос", false, false);
        c2020.addHoliday(Month.APR, 27, "перенос", true, false);
        c2020.addHoliday(Month.APR, 28, "Радоница", true, false);
        c2020.addHoliday(Month.APR, 30, "предпраздничный день", false, true);
        c2020.addHoliday(Month.MAY, 1, "Праздник труда", true, false);
        c2020.addHoliday(Month.MAY, 8, "предпраздничный день", false, true);
        c2020.addHoliday(Month.MAY, 9, "День Победы", true, false);
        c2020.addHoliday(Month.JUL, 2, "предпраздничный день", false, true);
        c2020.addHoliday(Month.JUL, 3, "День Независимости Республики Беларусь (День Республики)", true, false);
        c2020.addHoliday(Month.DES, 24, "предпраздничный день", false, true);
        c2020.addHoliday(Month.DES, 25, "Рождество Христово (католическое)", true, false);

        //выводим информацию о дыух днях года
        System.out.println(view.dayInfo(c2020, Month.MAR, 7));
        System.out.println(view.dayInfo(c2020, Month.MAR, 8));

        //выводим список всех празников в календаре
        System.out.println(view.allHolidays(c2020));

        //пробуем вывести информацию о дне который не существует
        System.out.println(view.dayInfo(c2020, Month.APR, 31));

        //выводим инфо о каждом дне в календаре
        for (int i = 1; i < 367; i++) {
            System.out.println( view.dayInfo(c2020, logic.month(c2020.isLeapYear(), i), logic.date(c2020.isLeapYear(), i)));
        }
    }
}
