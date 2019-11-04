package by.epam.programming_with_classes.text.main;

import by.epam.programming_with_classes.text.logic.Logic;
import by.epam.programming_with_classes.text.text.Sentence;
import by.epam.programming_with_classes.text.text.Text;
import by.epam.programming_with_classes.text.view.View;

public class Main {

    public static void main(String[] args) {


        Logic logic = new Logic();
        View view = new View();

        Sentence head = logic.parseToSentence("Выпрашивание сладостей на Хэлоуин (Trick-or-treat).");

        Sentence s1 = logic.parseToSentence("Традиция наряжаться в костюмы и ходить от дома к дому," +
                " выпрашивая сладости, появилась ещё в Средневековье и первоначально была связана с Рождеством.");
        Sentence s2 = logic.parseToSentence("В Англии и Ирландии бедняки издревле ходили по домам и " +
                "выпрашивали так называемые «духовные пирожные» в День всех святых (1 ноября), обещая в обмен " +
                "молиться за души умерших родственников хозяев.");
        Sentence s3 = logic.parseToSentence("Хотя этот обычай считается исконно британским," +
                " исследователи также находили упоминания о нём на юге Италии.");
        Sentence s4 = logic.parseToSentence("Один из персонажей комедии Уильяма Шекспира " +
                "«Два веронца» произносит фразу «Ты скулишь, как нищий на День всех святых», что " +
                "свидетельствует о широком распространении данного обычая уже в конце XVI столетия.");
        Sentence s5 = logic.parseToSentence("Термин Trick-or-treat впервые стал использоваться в " +
                "США, первый раз его использование зафиксировано в 1934 году, а сам он начал активно " +
                "распространяться только с 1939 года.");
        Sentence s6 = logic.parseToSentence("Литературно его можно перевести как шутка или угощение" +
                " (распространённые варианты — проделка или угощение, сладость или гадость и др.) " +
                "что указывает на шуточную угрозу нанести вред, если хозяин не принесёт детям угощение.");
        Sentence s7 = logic.parseToSentence("Но устоявшегося перевода термина на русский язык нет и " +
                "обычно он даётся в оригинале, либо с заменой на фразу кошелёк или жизнь.");
        Sentence s8 = logic.parseToSentence("Хотя термин вначале упоминался лишь на западе " +
                "Северной Америки, к 1940-м годам отмечено уже широкое распространение по всей стране.");
        Sentence s9 = logic.parseToSentence("В нынешние времена фраза носит отчётливо шутливый " +
                "оттенок и её часто используют за пределами США, например, в Ирландии и Японии," +
                " не боясь получить обвинение в вымогательстве.");

        Text text = new Text();

        System.out.println();

        text.setHead(head);
        Sentence[] sentences = {s1, s2, s3, s4, s5, s6, s7, s8, s9};
        text.setSentences(sentences);

        System.out.println(view.print(text));
    }
}
