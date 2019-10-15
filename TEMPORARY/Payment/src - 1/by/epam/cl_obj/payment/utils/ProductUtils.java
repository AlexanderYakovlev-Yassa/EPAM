package by.epam.cl_obj.payment.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductUtils {

    public boolean isNameValid(String name){

        Pattern p = Pattern.compile("^[\\p{javaAlphabetic}]+[\\p{javaAlphabetic}\\d\\s]+$");
        Matcher m = p.matcher(name);

        return m.find();
    }

   /* public boolean isQuantityValid(int quantity){
       return quantity > 0;
    }*/

    public boolean isPriceValid(double price){
        return (price > 0);
    }
}
