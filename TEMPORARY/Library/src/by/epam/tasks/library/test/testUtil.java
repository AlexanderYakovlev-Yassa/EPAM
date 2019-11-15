package by.epam.tasks.library.test;


import by.epam.tasks.library.util.Util;

public class testUtil {

    public static void main(String[] args) {

        Util util = new Util();

        System.out.println(util.suppressExcessWhiteSpaces("Alexander      user        sashayassa@gmail.com              546977"));
    }
}
