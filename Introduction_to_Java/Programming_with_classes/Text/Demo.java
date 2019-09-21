public class Demo {
    public static void main(String[] args) {

        //создаем 4 объекта типа Word
        Word w1 = new Word("today");
        Word w2 = new Word("is");
        Word w3 = new Word("sunny");
        Word w4 = new Word("day!");

        //проверяем метод Word.toString
        System.out.println(w1.toString());

        //создаем объект типа Sentence
        Word[] words = {w1, w2, w3, w4};
        Sentence s1 = new Sentence(words);

        //проверяем метод Sentence.toString
        System.out.println(s1);

        //проверяем метод Sentence.addWord
        s1.addWord(new Word("hot"), 2);
        System.out.println(s1);

        //проверяем метод Sentence.deleteWord
        s1.deleteWord(3);
        System.out.println(s1);

        //проверяем конструктор Sentence с параметром String
        //и качество разбора предыдущего предложения на слова
        Sentence s2 = new Sentence("К рассмотрению принимаются доработанные статьи.");
        //*System.out.println(s2);
        for (Word s : s2.getWords()){
            //*System.out.println(s);
        }

        System.out.println("\n\t\tработаем с текстом\n");

        //создаем объект типа Text
        //добавляум в текст предложение
        //и добавляем заголовок
        Text text = new Text();
        text.appendSentence(s2);
        text.setHead(new  Sentence("Three men in the boat."));
        System.out.println(text.toString());

        //добавляем к тексту строку
        //и выводим весь текст с заголовком на косоль
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
        text.appendText(originalText);
        System.out.println("\n\t\tдополненный текст\n");
        System.out.println(text);

        //добавляем в середину текста предложение
        //и выводим измененный текст на консоль
        System.out.println("\n\t\tтекст с добаленным в середину предложением\n");
        text.addSentence(s2,5);
        System.out.println(text);

        //удаляем два предложения из текста
        // и выводим тект на консоль
        System.out.println("\n\t\tтекст с удаленными двумя предложениями\n");
        text.deleteSentence(0);
        text.deleteSentence(4);
        System.out.println(text);

    }

}
