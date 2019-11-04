package by.epam.programming_with_classes.text.view;

import by.epam.programming_with_classes.text.text.Sentence;
import by.epam.programming_with_classes.text.text.Text;
import by.epam.programming_with_classes.text.text.Word;

public class View {

    public String print(Word word){

        StringBuilder sb = new StringBuilder();

        if (word != null) {

            sb.append(word.getChars());
        } else {

            sb.append("there is no word");
        }

        return sb.toString();
    }

    public String print(Sentence sentence){

        StringBuilder sb = new StringBuilder();

        if(sentence != null) {

            for (Word w : sentence.getWords()) {
                sb.append(print(w));
            }
        } else {

            sb.append("there is no sentence");
        }

        return sb.toString();
    }



    public String print(Text text){

        StringBuilder sb = new StringBuilder("\t\t");

        if(text != null) {
            sb.append(print(text.getHead()));
            sb.append("\n\n\t");

            for (Sentence s : text.getSentences()) {

                sb.append(print(s));
                sb.append(" ");
            }
        } else {

            sb.append("there is no text");
        }

        return sb.toString();
    }
}
