/*Cоздать приложение, разбирающее текст (текст хранится в строке)
 и позволяющее выполнять с текстом три различных операции:
 - отсортировать абзацы по количеству предложений;
 - в каждом предложении отсортировать слова по длине;
 - отсортировать лексемы в предложении по убыванию количества
 вхождений заданного символа, а в случае равенства – по алфавиту.*/


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Task_3_3_1 {
    String text;
    String[] p;
    String[][] s;
    String[][][] w;
    String[][][] l;

    public Task_3_3_1(String text) {
        this.text = text;
        processText();
        processParagraphs();
    }

    public static void main(String[] args) {
        String sourceText = inputText();
        Task_3_3_1 text = new Task_3_3_1(sourceText);
        boolean flag = true;
        char keySymbol;
        while (flag) {
            int key = chooseOption();
            switch (key) {
                case 1:
                    text.sortParagraphs();
                    System.out.println("\nParagraphs are sorted by number of sentences:");
                    text.printParagraphs();
                    break;
                case 2:
                    text.sortAllSentences();
                    System.out.println("\nWords in every sentence are sorted by number of letters:");
                    text.printWordSentences();
                    break;
                case 3:
                    System.out.println("To complete third part of the task needs a \"key\" symbol");
                    keySymbol = chooseSymbol();
                    text.sortSentencesByRule(keySymbol);
                    System.out.println("\nLexemes in every sentence are sorted by number of symbol " + "\'" + keySymbol + "\' in every word or if they haven't this symbol by alphabet:");
                    text.printLexemSentences();
                    break;
                case 4:
                    text.processText();
                    text.processParagraphs();
                    System.out.println("This text has been returned to original state");
                    text.printParagraphs();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
            }

        }
        System.out.println("\nGOOD BYE...");
    }

    public static String inputText() {
        Scanner scan = new Scanner(System.in);
        StringBuilder text = new StringBuilder("");
        String newPhrase = " ";
        boolean flag = true;
        System.out.print("Insert text ");
        while (flag) {
            System.out.print(">");
            newPhrase = scan.nextLine();

            if (!newPhrase.equals("")) {
                if (newPhrase.charAt(newPhrase.length() - 1) == '\n') {
                    text.append(newPhrase);
                } else {
                    text.append(newPhrase + "\n");
                }
            } else {
                flag = false;
            }
        }

        String resText = text.toString();
        return resText;
    }

    private static int chooseOption() {

        int res = 0;
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("\nChoose the option:");
            System.out.println("\tpress 1 for Option 1\n\tpress 2 for Option 2\n\tpress 3 for Option 3\n\tpress 4 to return to original state\n\tpress 0 for Exit");
            System.out.print(" >");
            String str = scan.nextLine();
            switch (str) {
                case "1":
                case "2":
                case "3":
                case "4":
                case "0":
                    res = Integer.valueOf(str);
                    flag = false;
                    break;
                default:
                    System.out.println("There is no Option " + str + "\n");
            }
        }
        return res;
    }

    public static char chooseSymbol() {
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        String symbol;
        char ch = ' ';
        while (flag) {
            System.out.print("Type a \"key\" symbol >");
            symbol = scan.nextLine();
            if (symbol.length() == 1) {
                flag = false;
                ch = symbol.charAt(0);
            } else {
                System.out.println("It must be an only one symbol, please try again");
            }
        }
        return ch;
    }

    //splits paragraphs to sentences and words
    private void processParagraphs() {
        this.s = new String[this.p.length][];
        this.w = new String[this.p.length][][];
        this.l = new String[this.p.length][][];

        for (int i = 0; i < this.p.length; i++) {
            this.s[i] = splitToSentances(this.p[i]);
            this.w[i] = new String[this.s[i].length][];
            this.l[i] = new String[this.s[i].length][];
            for (int j = 0; j < this.s[i].length; j++) {
                this.w[i][j] = splitToWords(this.s[i][j]);
            }
            for (int j = 0; j < this.s[i].length; j++) {
                this.l[i][j] = splitToLexemes(this.s[i][j]);
            }
        }
    }

    //splits text to paragraphs
    private void processText() {
        this.p = this.text.split("\n");
    }

    //First part of the task
    public void sortParagraphs() {
        int min;
        for (int i = 0; i < p.length; i++) {
            min = i;
            for (int j = i + 1; j < p.length; j++) {
                min = s[j].length < s[min].length ? j : min;
            }
            swap(p, i, min);
            swap(s, i, min);
        }
        processParagraphs();
    }

    //Second part of the task
    public void sortAllSentences() {
        int min = 0;
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                for (int k = 0; k < w[i][j].length; k++) {
                    min = k;
                    for (int l = k + 1; l < w[i][j].length; l++) {
                        min = w[i][j][l].length() < w[i][j][min].length() ? l : min;
                    }
                    swap(w[i][j], k, min);
                }
            }
        }
    }

    //Third part of the task
    public void sortSentencesByRule(char ch) {
        int min = 0;
        ch = Character.toLowerCase(ch);
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                sortByRule(l[i][j], ch);
            }
        }
    }

    //splits source text to paragraphs and return array of paragraphs (String)
    public static String[] splitToParagraphs(String text) {
        String[] paragraphs = text.split("\n");
        return paragraphs;
    }

    //splits paragraph to sentences and returns array of sentances (String)
    public static String[] splitToSentances(String str) {
        String[] sentances = new String[0];
        Pattern sent = Pattern.compile("([\\.\\!\\?][\\s][A-Z])|([\\.\\!\\?]$)");
        Matcher s = sent.matcher(str);
        int start = 0;
        while (s.find()) {
            sentances = appendToArray(sentances, str.substring(start, s.start() + 1));
            start = s.end() - 1;
        }
        return sentances;
    }

    //splits the sentence to words and returns array of words (String)
    public static String[] splitToWords(String sentence) {
        String[] words = new String[0];
        //Pattern word = Pattern.compile("[\\w]+");
        Pattern word = Pattern.compile("[A-Za-z]+[-]?[A-Za-z]+");
        Matcher m = word.matcher(sentence);
        while (m.find()) {
            words = appendToArray(words, sentence.substring(m.start(), m.end()));
        }
        return words;
    }

    //splits the sentence to words and returns array of words (String)
    public static String[] splitToLexemes(String sentence) {
        String[] words = new String[0];
        Pattern word = Pattern.compile("([.\\S&&[^\"\\-\\$~()\\d,\\.\\[\\]:;]])+|([~\\$]?[\\d]+[\\,\\.]?[%\\d]+)");
        Matcher m = word.matcher(sentence);
        while (m.find()) {
            words = appendToArray(words, sentence.substring(m.start(), m.end()));
        }
        return words;
    }

    //appends String to the array of Strings
    public static String[] appendToArray(String[] array, String str) {
        String[] newArray = new String[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[newArray.length - 1] = str;
        return newArray;
    }

    //sorts array of String alphabetically
    public static void sortByRule(String[] str, char ch) {
        int min = 0;
        for (int i = 0; i < str.length; i++) {
            min = i;
            for (int j = i + 1; j < str.length; j++) {
                min = compareWords(str[min], str[j], ch) <= 0 ? min : j;
            }
            swap(str, min, i);
        }
    }

    //compares two words alphabetically
    public static int compareWords(String w1, String w2, char ch) {
        int res = 0;
        int chi1 = charsIn(w1, ch);
        int chi2 = charsIn(w2, ch);
        if (chi1 < chi2) {
            res = 1;
        } else if (chi1 > chi2) {
            res = -1;
        } else {
            if (w1.compareToIgnoreCase(w2) > 0) {
                res = 1;
            } else if (w1.compareToIgnoreCase(w2) < 0) {
                res = -1;
            }
        }
        return res;
    }

    //counts the number of the specified symbol in the word
    public static int charsIn(String str, char ch) {
        char[] letters = str.toCharArray();
        int c = 0;
        int k = 0;
        int start = 0;
        for (int i = 0; i < letters.length; i++) {
            if (ch == Character.toLowerCase(letters[i])) {
                c++;
            }
        }
        return c;
    }

    //returns the length of a word with the maximal length
    public static int lengthOfMaxWord(String[] str) {
        int max = str[0].length();
        for (int i = 1; i < str.length; i++) {
            max = max > str[i].length() ? max : str[i].length();
        }
        return max;
    }

    //returns the spetial way formatted string to facilitate the sorting
    public static char[] ghost(String str, int length) {
        char[] origin = str.toCharArray();
        char[] gh = new char[length];
        for (int i = 0; i < length; i++) {
            if (i < origin.length) {
                gh[i] = Character.toLowerCase(origin[i]);
            } else {
                gh[i] = 'a';
            }
        }
        return gh;
    }

    //prints paragraphs
    public void printParagraphs() {
        char[] pChars = new char[p.length];
        int carriage = 0;
        for (int i = 0; i < p.length; i++) {
            pChars = p[i].toCharArray();

            System.out.print("\t");
            System.out.println(p[i]);
            //System.out.println("sentences" + s[i].length);
            System.out.println("");
        }
    }

    public void printWordSentences() {
        System.out.println("");
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                for (int k = 0; k < w[i][j].length; k++) {
                    System.out.print(w[i][j][k] + " ");
                }
                System.out.println("");
            }
        }
    }

    public void printLexemSentences() {
        System.out.println("");
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                for (int k = 0; k < l[i][j].length; k++) {
                    System.out.print(l[i][j][k] + " ");
                }
                System.out.println("");
            }
        }
    }

    //swaps elements in the array of integer
    public static void swap(int[] array, int ind1, int ind2) {
        int bubble = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = bubble;
    }

    //swaps elements in the array of String
    public static void swap(String[] array, int ind1, int ind2) {
        String bubble = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = bubble;
    }

    //swaps elements(arrays of string) in the array of array of String
    public static void swap(String[][] array, int ind1, int ind2) {
        String[] bubble = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = bubble;
    }
}