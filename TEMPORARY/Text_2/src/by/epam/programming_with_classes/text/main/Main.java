package by.epam.programming_with_classes.text.main;

import by.epam.programming_with_classes.text.logic.Logic;
import by.epam.programming_with_classes.text.text.Sentence;
import by.epam.programming_with_classes.text.text.Word;
import by.epam.programming_with_classes.text.view.View;

public class Main {

    public static void main(String[] args) {


        //create a sentence from string
        Logic logic = new Logic();
        View view = new View();

        Sentence sentence1 = logic.parseToSentence("The newborn-program sentence.");

        System.out.println(sentence1.toString());

        sentence1.addWord(new Word("second".toCharArray()), 1);
        sentence1.addWord(new Word(" ".toCharArray()), 1);

        System.out.println(sentence1.toString());

        System.out.println("\n" + view.print(sentence1.getWord(0)));
        System.out.println("\n" + view.print(sentence1));
    }
}
