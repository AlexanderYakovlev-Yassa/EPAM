public class Sentence {
    private  Word[] words; //массив слов входящих в предложение
    private Boolean isFirstLetterCapital; //true если предложение должно начинаться с заглавной буквы
    private Boolean hasEndPoint; //true если в конце должна быть точка

    Sentence(){
        this.words = new Word[0];
        this.isFirstLetterCapital = true;
        this.hasEndPoint = true;
    }

    Sentence(Word[] words){
        this.words = words;
        this.isFirstLetterCapital = true;
        this.hasEndPoint = true;
    }

    public Boolean getFirstLetterCapital() {
        return isFirstLetterCapital;
    }

    public void setFirstLetterCapital(Boolean firstLetterCapital) {
        isFirstLetterCapital = firstLetterCapital;
    }

    public Boolean getHasEndPoint() {
        return hasEndPoint;
    }

    public void setHasEndPoint(Boolean hasEndPoint) {
        this.hasEndPoint = hasEndPoint;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.isFirstLetterCapital) {
            char[] firstWord = this.words[0].getWord().clone();
            firstWord[0] = Character.toUpperCase(firstWord[0]);
            sb.append(firstWord);
        } else {
            sb.append(this.words[0]);
        }
        sb.append(" ");

        for (int i = 1; i < this.words.length; i++) {
            sb.append(this.words[i] + " ");
        }

        if (this.hasEndPoint) {
            sb.append("\b.");
        } else {
            sb.append("\b");
        }
        return sb.toString();
    }
}
