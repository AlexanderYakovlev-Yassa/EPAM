import java.util.Arrays;

public class Word {
    private char[] word; //набор последовательно расположенных символов кроме пробела и управляющих символов.

    Word() {
        this.word = new char[0];
    }

    /*
    * Слово может состоять из букв, цифр и символов пунктуации (!"#$%&'()*+,-./:;<=>?@[\]^_`{|}~).
    * Слово не может содержать пробельные и управляющие символы.
    * Если в параметром приходит строка с управляющим символом он удаляется из слова.
    * Если в параметром приходит строка с пробельными символами по краям они удаляютс.
    * Если в параметром приходит строка с пробельными символами внутри словом
    * становится набор символов расположенный до первого пробельного символа.
    * */
    Word(String word) {
        setWord(word);
    }

    public String getWord() {
        return word.toString();
    }

    /*public void setWord(char[] word) {
        this.word = word;
    }*/

    public void setWord(String str) {
        char[] oldWord = str.trim().toCharArray();
        char[] newWord = new char[0];
        for (int i = 0; i < oldWord.length; i++) {
            if ((oldWord[i] != ' ') && (oldWord[i] != ' ')) {
                newWord = Arrays.copyOf(newWord, newWord.length + 1);
                newWord[newWord.length - 1] = oldWord[i];
            }
        }
        this.word = newWord.toString().toCharArray();
    }

    private static boolean isLegal(char ch){
        boolean flag;
        if (((int)ch >= 32 && (int)ch <= 126) || (Character.isLetter(ch))){
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    @Override
    public String toString() {
        return String.copyValueOf(this.word);
    }
}
