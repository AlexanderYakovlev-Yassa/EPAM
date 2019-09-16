import java.util.Arrays;

public class Word {
    private char[] word;

    Word(char[] word) {
        this.word = word;
    }

    public char[] getWord() {
        return word;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (char ch : this.word){
            sb.append(ch);
        }
        return sb.toString();
    }
}
