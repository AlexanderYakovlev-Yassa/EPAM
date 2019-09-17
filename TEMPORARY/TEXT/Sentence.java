import java.util.Arrays;

public class Sentence {
    private  Word[] words; //массив слов входящих в предложение. Слово это набор символов между пробелами.
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

    public void addWord(Word newWord){
        this.words = Arrays.copyOf(this.words, this.words.length + 1);
        this.words[this.words.length-1] = newWord;
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
