package by.epam.programming_with_classes.text.text;

import java.util.Arrays;

public class Text {

    Sentence head;
    Sentence[] sentences;

    public Text(Sentence head, Sentence[] sentences) {
        this.head = head;
        this.sentences = sentences;
    }

    public Text() {
        this.head = new Sentence();
        this.sentences = new Sentence[0];
    }

    public Sentence getHead() {
        return head;
    }

    public void setHead(Sentence head) {
        this.head = head;
    }

    public Sentence[] getSentences() {
        return sentences;
    }

    public Sentence getSentence(int index) {
        return sentences[index];
    }

    public void setSentences(Sentence[] sentences) {
        this.sentences = sentences;
    }

    public void setSentence(Sentence sentence, int index) {
        this.sentences[index] = sentence;
    }

    public void appendSentence(Sentence sentence) {
        setSentences(Arrays.copyOf(getSentences(), getSentences().length + 1));
        setSentence(sentence, getSentences().length - 1);
    }

    public boolean addSentence(Sentence sentence, int index) {

        boolean success;

        Text newText = new Text();
        newText.setSentences(new Sentence[getSentences().length + 1]);

        try {
            for (int i = 0; i < newText.getSentences().length; i++) {

                if (i < index) {
                    newText.setSentence(getSentence(i), i);
                } else if (i == index) {
                    newText.setSentence(sentence, i);
                } else {
                    newText.setSentence(getSentence(i - 1), i);
                }
            }

            success = true;

        } catch (IndexOutOfBoundsException e) {

            success = false;
        }

        setSentences(newText.getSentences());

        return success;
    }
}
