package by.epam.programming_with_classes.text.view;

import by.epam.programming_with_classes.text.text.Sentence;
import by.epam.programming_with_classes.text.text.Word;

public class View {

    public String print(Word word){

        StringBuilder sb = new StringBuilder();

        sb.append(word.getChars());

        return sb.toString();
    }

    public String print(Sentence sentence){
        StringBuilder sb = new StringBuilder();

        for (Word w : sentence.getWords()) {
            sb.append(print(w));
        }

        return sb.toString();
    }
}
