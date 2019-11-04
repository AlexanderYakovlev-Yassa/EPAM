package by.epam.programming_with_classes.text.logic;

import by.epam.programming_with_classes.text.text.Sentence;
import by.epam.programming_with_classes.text.text.Word;

public class Logic {

    public Sentence parseToSentence(String string) {

        Sentence sentence = new Sentence();
        Word nextWord = new Word();

        if(string != null) {
            for (char ch : string.toCharArray()) {

                if ((Character.isAlphabetic(ch) || Character.isDigit(ch) || ch == '-')) {
                    nextWord.appendSymbol(ch);
                } else {
                    sentence.appendWord(nextWord);
                    nextWord = new Word();
                    nextWord.appendSymbol(ch);
                    sentence.appendWord(nextWord);
                    nextWord = new Word();
                }
            }
            if (nextWord.getChars().length > 0) {
                sentence.appendWord(nextWord);
            }
        } 

        return sentence;
    }
}
