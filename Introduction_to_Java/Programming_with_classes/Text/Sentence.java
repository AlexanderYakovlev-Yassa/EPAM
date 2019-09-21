import java.util.Arrays;

public class Sentence {
    private Word[] words; //массив слов входящих в предложение.
    private char endSymbol; //символ в конце предложения (.?!)

    Sentence() {
        this.words = new Word[0];
        this.endSymbol = '.';
    }

    Sentence(Word[] words) {
        this.setEndSymbol(lastSymbolIs(words[words.length - 1])); //присваиваем атрибуту endSymbol значение последнего символа последнего слова если это (.?!)
        words[words.length - 1] = cutEndPoint(words[words.length - 1]);//обрезаем у последнего слова последний символ если это (.?!)
        this.words = words;
    }

    Sentence(String str) {
        Word[] words = parseToSentence(str);//раэбираем строку на литералы
        this.setEndSymbol(lastSymbolIs(words[words.length - 1]));//присваиваем атрибуту endSymbol значение последнего символа последнего слова если это (.?!)
        words[words.length - 1] = cutEndPoint(words[words.length - 1]);//обрезаем у последнего слова последний символ если это (.?!)
        this.words = words;
    }

    /*
    *присваивает значение атрибуту endSymbol
    * */
    public void setEndSymbol(char symbol) {
        switch (symbol) {
            case ('?'):
                this.endSymbol = '?';
                break;
            case ('!'):
                this.endSymbol = '!';
                break;
            default:
                this.endSymbol = '.';
                break;
        }
    }


    /*
    *добавляет слово в конец предложения
    * */
    public void appendWord(Word newWord) {
        this.words = Arrays.copyOf(this.words, this.words.length + 1);
        this.words[this.words.length - 1] = newWord;
    }

    /*
     *добавляет слово "word" в предложение в указанное место "index"
     *остальные слова сдвигаются вправо
     *возвращает 0 если слово успешно добавлено, иначе возвращает -1
     **/

    public boolean addWord(Word word, int position) {
        boolean res = false;
        if (position < this.words.length && position >= 0) {
            Word[] newSentence = new Word[this.words.length + 1];
            for (int i = 0; i < newSentence.length; i++) {
                if (i < position) {
                    newSentence[i] = this.words[i];
                } else if (i == position) {
                    newSentence[i] = word;
                } else {
                    newSentence[i] = this.words[i - 1];
                }
            }
            this.words = newSentence;
            res = true;
        } else if (position == this.words.length) {
            this.appendWord(word);
            res = true;
        }

        return res;
    }

    /*
    *удаляет слово в указанном месте
    */
    public boolean deleteWord(int position) {
        boolean res = false;
        if (position < this.words.length && position >= 0) {
            Word[] newSentence = new Word[this.words.length - 1];
            for (int i = 0; i < newSentence.length; i++) {
                if (position > i) {
                    newSentence[i] = this.words[i];
                } else {
                    newSentence[i] = this.words[i + 1];
                }
            }
            res = true;
            this.words = newSentence;
        }
        return res;
    }

    /*
    *возвращает все слова в предложении как массив типа Word
    */
    public Word[] getWords() {
        return words;
    }

    /*
    *разбирает строку на литералы.
    *Разделитель - любой пробельный символ или несколько пробельных символов вместе
    * */
    private Word[] parseToSentence(String str) {
        String[] rowWords = str.split("\\s+");
        Word[] processedWords = new Word[rowWords.length];
        for (int i = 0; i < rowWords.length; i++) {
            processedWords[i] = new Word(rowWords[i]);
        }
        return processedWords;
    }

    /*
     *обрезает в слове последний символ если он является
     *признаком конца предложения (.?!)
    * */
    private static Word cutEndPoint(Word word) {
        StringBuilder newWord = new StringBuilder();
        newWord.append(word.getWord());
        if (isEndPoint(newWord.charAt(newWord.length() - 1))) {
            newWord = new StringBuilder(newWord.substring(0, newWord.length() - 1));
        }
        return new Word(newWord.toString());
    }

    /*
    *возвращает true если символ является признаком конца предложения (.?!)
    * */
    private static boolean isEndPoint(char ch) {
        boolean res = false;
        if (ch == '.' || ch == '?' || ch == '!') {
            res = true;
        }
        return res;
    }

    /*
    *возвращает последний символ в слове типа Word
    * */
    private static char lastSymbolIs(Word word) {
        char ch = word.getWord().charAt(word.getWord().length() - 1);
        return ch;
    }

    /*
    *возвращает слово переданное в параметры метода
    *где первая буква переведена в верхний регистр
    * */
    private static Word capitalizeWord(Word oldWord) {
        char[] word = oldWord.getWord().toCharArray();
        word[0] = Character.toUpperCase(word[0]);
        StringBuilder str = new StringBuilder();
        str.append(word);
        Word newWord = new Word(str.toString());
        return newWord;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.words.length > 0) {
            Word firstWord = capitalizeWord(this.words[0]);
            sb.append(firstWord);
            if (this.words.length > 1) {
                for (int i = 1; i < this.words.length; i++) {
                    sb.append(" " + this.words[i]);
                }
            }
            sb.append(this.endSymbol);
        }
        return sb.toString();
    }
}