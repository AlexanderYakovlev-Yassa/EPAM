package by.epam.tasks.library.data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public boolean isUserNameValid(String name){

        if(name != null) {
            Pattern p = Pattern.compile("^[\\p{L}]+$");
            Matcher m = p.matcher(name);
            return m.find();
        } else {
            return false;
        }
    }

    public boolean isEMailValid(String eMail){

        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$");

        return isValid(eMail, pattern);

    }

    private boolean isValid(String string, Pattern pattern){

        System.out.println(string + "  " + pattern);

        if(pattern != null && pattern != null) {

            System.out.println("***");

            Matcher m = pattern.matcher(string);
            return m.find();
        } else {
            return false;
        }
    }
}
