package by.epam.tasks.library.test;

import by.epam.tasks.library.data.Validation;

public class TestValidation {
    public static void main(String[] args) {

        Validation v = new Validation();

        String name = "Alexander";

        System.out.println(v.isUserNameValid(name));

        String eMail = "sashayassa@gmail.com";

        System.out.println("E Mail " + eMail + " is " + v.isEMailValid(eMail));
    }
}
