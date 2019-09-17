import java.util.Arrays;

public class Sentence {
    private  Word[] words; //массив слов входящих в предложение.
    //private Boolean isFirstLetterCapital; //true если предложение должно начинаться с заглавной буквы
    //private Boolean hasEndPoint; //true если в конце должна быть точка

    Sentence(){
        this.words = new Word[0];
        //this.isFirstLetterCapital = true;
        //this.hasEndPoint = true;
    }

    Sentence(Word[] words){
        this.words = words;
        //this.isFirstLetterCapital = true;
        //this.hasEndPoint = true;
    }

    Sentence(String str){
        this.words = parseToSentence(str);
    }

    private Word[] parseToSentence(String str){
        String[] rowWords = str.split("\\s");
        Word[] processedWords = new Word[rowWords.length];
        for (int i = 0; i < rowWords.length; i++) {
            processedWords[i] = new Word(rowWords[i]);
        }
        return processedWords;
    }

    private String delExcessWhitespases(String str){
        StringBuilder newStr = new StringBuilder();
        char[] oldStr = str.trim().toCharArray();
        for (int i = 1; i < oldStr.length; i++) {
            if ((oldStr[i] == ' ') || (oldStr[i] == '   ')) && )
        }
    }

    public void addWord(Word newWord){
        this.words = Arrays.copyOf(this.words, this.words.length + 1);
        this.words[this.words.length-1] = newWord;
    }

    public Word[] getWords() {
        return words;
    }
/*public Boolean isFirstLetterCapital() {
        return isFirstLetterCapital;
    }*/

    /*public void setFirstLetterCapital(Boolean firstLetterCapital) {
        isFirstLetterCapital = firstLetterCapital;
    }*/

    /*public Boolean HasEndPoint() {
        return hasEndPoint;
    }*/

    /*public void setEndPoint(Boolean hasEndPoint) {
        this.hasEndPoint = hasEndPoint;
    }*/

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < this.words.length; i++) {
            sb.append(this.words[i] + " ");
        }

        return sb.toString();
    }
}
