public class Test {
    public static void main(String[] args) {
        Word w1 = new Word("today".toCharArray());
        Word w2 = new Word("is".toCharArray());
        Word w3 = new Word("sunny".toCharArray());
        Word[] words = {w1, w2, w3};
        Sentence s1 = new Sentence(words);
        System.out.println(w1);
        System.out.println(s1);
        s1.setFirstLetterCapital(false);
        s1.setHasEndPoint(false);
        System.out.println(s1);
    }
}
