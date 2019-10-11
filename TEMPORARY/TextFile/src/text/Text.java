
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {
    Sentence head;
    Sentence[] sentences;

    Text(){
        this.head = new Sentence();
        this.sentences = new Sentence[0];
    }

    Text(Sentence head, Sentence[] sentences){
        this.head = head;
        this.sentences = sentences;
    }

    /*
    * добавляет предложение (Sentence) к тексту
    * */
    public void appendSentence(Sentence newSentence){
        this.sentences = Arrays.copyOf(this.sentences, this.sentences.length + 1);
        this.sentences[this.sentences.length-1] = newSentence;
    }

    /*
    * разбирает строку (String) на предложения (Sentence) и добавляет их к тексту
    * */
    public void appendText(String newText){
        Sentence[] newSentences = parseText(newText);
        for (Sentence s : newSentences){
            this.appendSentence(s);
        }
    }

   /*
   *добавляет предложение в указанное место
   * */
    public boolean addSentence(Sentence sentence, int position){
        boolean res = false;
        if (position < this.sentences.length && position >= 0) {
            Sentence[] newSentences = new Sentence[this.sentences.length + 1];
            for (int i = 0; i < newSentences.length; i++) {
                if (i < position) {
                    newSentences[i] = this.sentences[i];
                } else if (i == position) {
                    newSentences[i] = sentence;
                } else {
                    newSentences[i] = this.sentences[i - 1];
                }
            }
            this.sentences = newSentences;
            res = true;
        } else if (position == this.sentences.length) {
            this.appendSentence(sentence);
            res = true;
        }

        return res;
    }

    /*
    *удаляет предложение в указанное место
    * */
    public boolean deleteSentence(int position) {
        boolean res = false;
        if (position < this.sentences.length && position >= 0) {
            Sentence[] sentence = new Sentence[this.sentences.length - 1];
            for (int i = 0; i < sentence.length; i++) {
                if (position > i) {
                    sentence[i] = this.sentences[i];
                } else {
                    sentence[i] = this.sentences[i + 1];
                }
            }
            res = true;
            this.sentences = sentence;
        }
        return res;
    }

    public Sentence getHead() {
        return head;
    }

    public Sentence[] getSentences() {
        return sentences;
    }

    public void setHead(Sentence head) {
        this.head = head;
    }

    /*
    * разбирает строку на предложения (Sentence) и слова (Word)
    * и возвращает массив предложений (Sentence[])
    * */
    private static Sentence[] parseText(String text){
        Sentence[] newSentences = new Sentence[0];
        Pattern pSentence = Pattern.compile("\\.\\s");
        Matcher m = pSentence.matcher(text);
        Sentence nextSentence = new Sentence();
        int last = 0;
        while (m.find()){
            nextSentence = new Sentence(text.substring(last, m.end()-1));
            last = m.end();
            newSentences = Arrays.copyOf(newSentences,newSentences.length+1);
            newSentences[newSentences.length-1] = nextSentence;
        }
        return newSentences;
    }

    @Override
    public String toString() {
        char[] h = this.head.toString().toCharArray();
        for (int i = 0; i < h.length; i++) {
            h[i] = Character.toUpperCase(h[i]);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(h);
        sb.append("\n");
        for (Sentence s : this.sentences){
            sb.append(s.toString() + " ");
        }
        sb.append("\b");
        return sb.toString();
    }
}
