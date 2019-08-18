/*Cоздать приложение, разбирающее текст (текст хранится в строке)
 и позволяющее выполнять с текстом три различных операции:
 - отсортировать абзацы по количеству предложений;
 - в каждом предложении отсортировать слова по длине;
 - отсортировать лексемы в предложении по убыванию количества
 вхождений заданного символа, а в случае равенства – по алфавиту.*/


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_3_3_1 {
    String text;
    String[] p;
    String[][] s;
    String[][][] w;

    public Task_3_3_1() {
        this.text = sourceText();
        this.p = this.text.split("\n");
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

    public Task_3_3_1(String text) {
        this.text = text;
        this.p = this.text.split("\n");
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

    public static void main(String[] args) {
        Task_3_3_1 task = new Task_3_3_1();
        task.printBrokenText();
        /*for (int i = 0; i < task.p.length; i++) {
            System.out.println("");
            for (int j = 0; j < task.s[i].length; j++) {
                System.out.print("*");
                for (int k = 0; k < task.w[i][j].length; k++) {
                    System.out.print("[" + task.w[i][j][k] + "]");
                }
            }
        }*/
    }

    public static void sortParagraphs() {

    }

    public static String[] splitToParagraphs(String text) {
        String[] paragraphs = text.split("\n");
        // Pattern pattern = Pattern.compile("\n");
        return paragraphs;
    }

    public static String[] splitToSentances(String str) {
        String[] sentances = new String[0];
        Pattern sent = Pattern.compile("[\\.\\!\\?][\\s][A-Z]");
        Matcher s = sent.matcher(str);
        int start = 0;
        while (s.find()) {
            sentances = appendToArray(sentances, str.substring(start, s.start() + 1));
            start = s.end() - 1;
        }
        return sentances;
    }

    public static String[] splitToWords(String sentence) {
        String[] words = new String[0];
        Pattern word = Pattern.compile("[\\w]+");
        Matcher m = word.matcher(sentence);
        while (m.find()) {
            words = appendToArray(words, sentence.substring(m.start(), m.end()));
        }
        return words;
    }

    private static String[] appendToArray(String[] array, String str) {
        String[] newArray = new String[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[newArray.length - 1] = str;
        return newArray;
    }

    private static void print(String str) {
        System.out.println("\t" + str + "\n");
    }

    public static String sourceText() {
        String text = "There were four of us - George, and William? Samuel Harris, and myself, and Montmorency. We were! sitting in my room, smoking, and talking about how bad we were - bad from a medical point of view I mean, of course.\n" +
                "We were all feeling seedy, and we were getting quite nervous about it. Harris said he felt such extraordinary fits of giddiness come over him at times, that he hardly knew what he was doing; and then George said that HE had fits of giddiness too, and hardly knew what HE was doing. With me, it was my liver that was out of order. I knew it was my liver that was out of order, because I had just been reading a patent liver-pill circular, in which were detailed the various symptoms by which a man could tell when his liver was out of order. I had them all.\n" +
                "It is a most extraordinary thing, but I never read a patent medicine advertisement without being impelled to the conclusion that I am suffering from the particular disease therein dealt with in its most virulent form. The diagnosis seems in every case to correspond exactly with all the sensations that I have ever felt.\n" +
                "I remember going to the British Museum one day to read up the treatment for some slight ailment of which I had a touch - hay fever, I fancy it was. I got down the book, and read all I came to read; and then, in an unthinking moment, I idly turned the leaves, and began to indolently study diseases, generally. I forget which was the first distemper I plunged into - some fearful, devastating scourge, I know - and, before I had glanced half down the list of \"premonitory symptoms,\" it was borne in upon me that I had fairly got it.";
        return text;
    }

    public static void printArrayOfString(String[] str) {
        for (int i = 0; i < str.length; i++) {
            System.out.print("[" + str[i] + "] ");
        }
    }

    public void printBrokenText(){

        for (int i = 0; i < this.p.length; i++) {
            System.out.println("p[" + i + "] = " + this.p[i]);
            this.s[i] = Task_3_3_1.splitToSentances(this.p[i]);
            this.w[i] = new String[this.s[i].length][];
            for (int j = 0; j < this.s[i].length; j++) {
                System.out.println("\ts[" + i + "][" + j + "] = " + this.s[i][j]);
                this.w[i][j] = Task_3_3_1.splitToWords(this.s[i][j]);
                for (int k = 0; k < this.w[i][j].length; k++) {
                    System.out.println("\t\tw[" + i + "][" + j + "][" + k + "] = " + this.w[i] [j] [k]);
                }
            }
        }
    }

}
