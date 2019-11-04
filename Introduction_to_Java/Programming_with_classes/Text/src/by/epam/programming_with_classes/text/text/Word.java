package by.epam.programming_with_classes.text.text;

import java.util.Arrays;

public class Word {

    char[] chars;

    public Word(char[] chars) {
        this.chars = chars;
    }

    public Word(String string) {
        this.chars = string.toCharArray();
    }

    public Word() {
        this.chars = new char[0];
    }

    public char[] getChars() {
        return chars;
    }

    public char getChar(int index) {
        return chars[index];
    }

    public void setChars(char[] chars) {
        this.chars = chars;
    }

    public void setChar(char symbol, int index) {
        this.chars[index] = symbol;
    }

    public void appendSymbol(char symbol) {
        setChars(Arrays.copyOf(getChars(), getChars().length + 1));
        setChar(symbol, getChars().length - 1);
    }

    public boolean addSymbol(char symbol, int index) {

        boolean success;

        Word newWord = new Word();

        newWord.setChars(new char[getChars().length + 1]);

        try {

            for (int i = 0; i < newWord.getChars().length; i++){

                if (i < index) {

                    newWord.setChar(getChar(i), i);
                } else if (i == index) {

                    newWord.setChar(symbol, i);
                } else {

                    newWord.setChar(getChar(i - 1), i);
                }
            }

            success = true;

        } catch (IndexOutOfBoundsException e) {

            success = false;
        }

        setChars(newWord.getChars());

        return success;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Arrays.equals(getChars(), word.getChars());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(getChars());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        sb.append(getChars());
        sb.append("]");
        return sb.toString();
    }
}
