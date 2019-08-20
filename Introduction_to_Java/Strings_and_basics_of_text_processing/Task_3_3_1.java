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

    public Task_3_3_1() {
        this.text = sourceText();
        this.p = this.text.split("\n");
        processParagraphs();
    }

    public Task_3_3_1(String text) {
        this.text = text;
        this.p = this.text.split("\n");
        processParagraphs();
    }

    public static void main(String[] args) {
        Task_3_3_1 text = new Task_3_3_1();
        //text.print();
        boolean flag = true;
        while (flag) {
            int key = chooseOption();
            switch (key) {
                case 1:
                    text.sortParagraphs();
                    text.print();
                    break;
                case 2:
                    text.sortAllSentences();
                    text.print();
                    break;
                case 3:
                    text.sortSentencesByRule('a');
                    text.print();
                    break;
                case 4:

                    break;
                case 0:
                    flag = false;
                    break;
                default:
            }
        }

    }

    private static int chooseOption() {

        int res = 0;
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("Choose the option:");
            System.out.println("\tpress 1 for Option 1\n\tpress 2 for Option 2\n\tpress 3 for Option 3\n\tpress 0 for Exit");
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

    //splits paragraphs to sentences and words
    private void processParagraphs() {
        this.s = new String[this.p.length][];
        this.w = new String[this.p.length][][];

        for (int i = 0; i < this.p.length; i++) {
            this.s[i] = splitToSentances(this.p[i]);
            this.w[i] = new String[this.s[i].length][];
            for (int j = 0; j < this.s[i].length; j++) {
                this.w[i][j] = splitToWords(this.s[i][j]);
            }
        }
    }

    //First part of the task
    public void sortParagraphs() {
        int min = 0;
        for (int i = 0; i < p.length; i++) {
            min = i;
            for (int j = i + 1; j < p.length; j++) {
                min = s[j].length < s[min].length ? j : min;
            }
            swap(p, i, min);
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
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                sortByRule(w[i][j], ch);
            }
        }
    }

  /*  //enter the character
    public static int enterKey(){
        boolean flag = true;
    }
*/
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
        Pattern word = Pattern.compile("[\\w]+");
        Matcher m = word.matcher(sentence);
        while (m.find()) {
            words = appendToArray(words, sentence.substring(m.start(), m.end()));
        }
        return words;
    }

    //appends String to the array of Strings
    private static String[] appendToArray(String[] array, String str) {
        String[] newArray = new String[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[newArray.length - 1] = str;
        return newArray;
    }

    //returns the default source text
    public static String sourceText() {
        String text = "There were four of us - George, and William? Samuel Harris, and myself, and Montmorency. We were! Sitting in my room, smoking, and talking about how bad we were - bad from a medical point of view I mean, of course.\n" +
                "We were all feeling seedy, and we were getting quite nervous about it. Harris said he felt such extraordinary fits of giddiness come over him at times, that he hardly knew what he was doing; and then George said that HE had fits of giddiness too, and hardly knew what HE was doing. With me, it was my liver that was out of order. I knew it was my liver that was out of order, because I had just been reading a patent liver-pill circular, in which were detailed the various symptoms by which a man could tell when his liver was out of order. I had them all.\n" +
                "It is a most extraordinary thing, but I never read a patent medicine advertisement without being impelled to the conclusion that I am suffering from the particular disease therein dealt with in its most virulent form. The diagnosis seems in every case to correspond exactly with all the sensations that I have ever felt.\n" +
                "I remember going to the British Museum one day to read up the treatment for some slight ailment of which I had a touch - hay fever, I fancy it was. I got down the book, and read all I came to read; and then, in an unthinking moment, I idly turned the leaves, and began to indolently study diseases, generally. I forget which was the first distemper I plunged into - some fearful, devastating scourge, I know - and, before I had glanced half down the list of \"premonitory symptoms,\" it was borne in upon me that I had fairly got it.";
        return text;
    }

    //prints the entire object Test_3_3_1
    public void print() {
        for (int i = 0; i < this.p.length; i++) {
            System.out.println("p[" + i + "] = " + this.p[i]);
            for (int j = 0; j < this.s[i].length; j++) {
                System.out.println("\ts[" + i + "][" + j + "] = " + this.s[i][j]);
                for (int k = 0; k < this.w[i][j].length; k++) {
                    System.out.println("\t\tw[" + i + "][" + j + "][" + k + "] = " + this.w[i][j][k]);
                }
            }
        }
    }

    //sorts the array of integers
    public static void sortArray(int[] array) {
        int min = 0;
        for (int i = 0; i < array.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++) {
                min = array[min] < array[j] ? min : j;
            }
            swap(array, i, min);
        }
    }

    //sorts array of String alphabetically
    public static void sortByRule(String[] str, char ch) {
        //int maxLength = lengthOfMaxWord(str);
        //boolean flag = true;
        //int letter = 0;
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

        /*int max = (w1.length() <= w2.length()) ? w2.length() : w1.length();
        char[] g1 = ghost(w1, max);
        char[] g2 = ghost(w2, max);
        int letter = 0;
        while (letter < max) {
            if (g1[letter] > g2[letter]) {
                res = 1;
                break;
            } else if (g1[letter] < g2[letter]) {
                res = -1;
                break;
            } else {
                letter++;
            }
        }*/
        return res;
    }

    public static int charsIn(String str, char ch) {
        int c = 0;
        int k = 0;
        int start = 0;
        while (k >= 0) {
            k = str.indexOf(ch, start);
            if (k >= 0) {
                c++;
                start = k + 1;
            }
        }
        return c;
    }

    //compare two words by the rule
    /*public static int compareRule(String w1, String w2, char ch) {
        int res = 0;
        int max = (w1.length() <= w2.length()) ? w2.length() : w1.length();
        char[] g1 = w1.;
        char[] g2 = w2.toCharArray();
        int letter = 0;
    }*/

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
