package by.epam.programming_with_classes.text.text;

import java.util.Arrays;

public class Sentence {

    Word[] words;

    public Sentence(Word[] words) {
        this.words = words;
    }

    public Sentence() {
        this.words = new Word[0];
    }

    public Word[] getWords() {
        return words;
    }

    public Word getWord(int index) {
        return words[index];
    }

    public void setWords(Word[] words) {
        this.words = words;
    }

    public void setWord(Word word, int index) {
        this.words[index] = word;
    }

    public void appendWord(Word word) {
        setWords(Arrays.copyOf(getWords(), getWords().length + 1));
        setWord(word, getWords().length - 1);
    }

    public boolean addWord(Word word, int index) {

        boolean success;

        Sentence newSentence = new Sentence();
        newSentence.setWords(new Word[getWords().length + 1]);

        try {
            for (int i = 0; i < newSentence.getWords().length; i++) {

                if (i < index) {
                    newSentence.setWord(getWord(i), i);
                } else if (i == index) {
                    newSentence.setWord(word, i);
                } else {
                    newSentence.setWord(getWord(i - 1), i);
                }
            }

            success = true;

        } catch (IndexOutOfBoundsException e) {

            success = false;
        }

        setWords(newSentence.getWords());

        return success;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sentence sentence = (Sentence) o;
        return Arrays.equals(getWords(), sentence.getWords());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(getWords());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (Word w : getWords()){
            sb.append(w.toString());
        }
        sb.append("]");
        return sb.toString();
    }
}
