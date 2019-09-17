public class Test {
    public static void main(String[] args) {

        //создаем 4 объекта типа Word
        Word w1 = new Word("today");
        Word w2 = new Word("is");
        Word w3 = new Word("sunny");
        Word w4 = new Word("day");

        //проверяем метод Word.toString
        System.out.println(w1);

        /*//создаем объект типа Sentence
        Word[] words = {w1, w2, w3, w4};
        Sentence s1 = new Sentence(words);

        //проверяем метод Sentence.toString
        System.out.println(s1);

        //печатаем предложение как набор слов,
        //без заглавной буквы и точки
        //s1.setFirstLetterCapital(false);
        //s1.setEndPoint(false);
        System.out.println(s1);

        String originalText = "The chief beauty of this book lies not so much " +
                "in its literary style or in the extent and usefulness " +
                "of the information it conveys as in its " +
                "simple truthfulness. Its pages form the record " +
                "of events that really happened. All that has " +
                "been done is to color them. And for this no extra " +
                "charge has been made. George and Harris " +
                "and Montmorency are not poetic ideals but " +
                "things of flesh and blood especially George " +
                "who weighs about twelve stone. Other works " +
                "may excel this in depth of thought and knowledge " +
                "of human nature. Other books may rival " +
                "it in originality and size. But for hopeless " +
                "and incurable veracity nothing yet discovered " +
                "can surpass it. This more than all its other " +
                "charms will it is felt make the volume precious " +
                "in the eye of the earnest reader and will " +
                "lend additional weight to the lesson that the " +
                "story teaches.";

        Text text = Text.parseText(originalText);
        System.out.println(text);*/
    }

}
