package logic;

import file.File;
import sun.text.normalizer.UTF16;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class TextLogic {

    public String readFromFile(File file){
        String str;
        try {
            byte[] fileContent = file.getContent();
            Charset charset = Charset.forName("UTF-16");
            str = new String(fileContent, charset);
        } catch (Exception e) {
            str = "";
        }
        return str;
    }

    public boolean writeToFile(File file, String str){
        boolean res;
        try{
            Charset charset = Charset.forName("UTF-16");
            byte[] fileContent = str.getBytes(charset);
            file.setContent(fileContent);
            res = true;
        } catch (Exception e) {
            res = false;
        }
        return res;
    }

    public boolean addTextToFile(File file, String str){
        boolean res;
        if (file != null) {
            String oldText = readFromFile(file);
            StringBuilder sb = new StringBuilder(oldText);
            sb.append(str);
            writeToFile(file, sb.toString());
            res = true;
        } else {
            res = false;
        }
        return res;
    }
}
