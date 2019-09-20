import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {
    Sentence head;
    Sentence[] text;

    Text(){
        this.head = new Sentence();
        this.text = new Sentence[0];
    }

    Text(Sentence head, Sentence[] sentences){
        this.head = head;
        this.text = sentences;
    }

    public void appendSentence(Sentence newSentence){
        this.text = Arrays.copyOf(this.text, this.text.length + 1);
        this.text[this.text.length-1] = newSentence;
    }

    public static Text parseText(String rowText){
        Text processedText = new Text();
        Pattern pSentence = Pattern.compile("[\\w\\s]+[\\.\\!\\?]");
        Matcher m = pSentence.matcher(rowText);
        Pattern pWord = Pattern.compile("[\\w]+[^\\p{Punct}]");
        Matcher m1;
        Word nextWord;
        Sentence nextSentence;
        while (m.find()){
            nextSentence = new Sentence();
            m1 = pWord.matcher(m.group());
            while (m1.find()){
                nextWord = new Word(m1.group());
                nextSentence.appendWord(nextWord);
            }
            processedText.appendSentence(nextSentence);
        }
        return processedText;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Sentence s : this.text){
            sb.append(s + " ");
        }
        sb.append("\b");
        return sb.toString();
    }
}
