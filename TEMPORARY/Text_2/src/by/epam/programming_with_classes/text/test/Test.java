package by.epam.programming_with_classes.text.test;

import by.epam.programming_with_classes.text.text.Word;

public class Test {

    public static void main(String[] args) {

        classWordTest();
    }

    private static void classWordTest(){

        System.out.println("constructor Word():");
        try {
            Word word = new Word();
            System.out.println("passed");
        } catch (Exception e){
            System.out.println("error " + e);
        }

        System.out.println("constructor Word(\"word\"):");
        try {
            Word word = new Word("word".toCharArray());
            System.out.println("passed");
        } catch (Exception e){
            System.out.println("error " + e);
        }

        System.out.println("setWord:");
        try {
            Word word = new Word("word".toCharArray());
            word.setChars("newWord".toCharArray());
            System.out.println("passed");
        } catch (Exception e){
            System.out.println("error " + e);
        }

        System.out.println("getWord:");
        try {
            Word word = new Word("word".toCharArray());
            word.getChars();
            System.out.println("passed");
        } catch (Exception e){
            System.out.println("error " + e);
        }

        System.out.println("get:");
        try {
            Word word = new Word("word".toCharArray());
            word.getChars();
            System.out.println("passed");
        } catch (Exception e){
            System.out.println("error " + e);
        }


    }

    private static void classSentenceTest(){


    }
}
