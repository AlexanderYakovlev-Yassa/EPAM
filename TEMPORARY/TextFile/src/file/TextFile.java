package file;

import java.io.File;

public class TextFile {
    private Path path;
    private String name;
    private final String extension = "txt";
    private StringBuilder text;


    public TextFile(Path path, String name){
        this.name = name;
        this.path = path;
        this.text = new StringBuilder();
    }

//method do not completed
    public boolean addText(String text){
        boolean res = false;
        this.text.append(text);
        return res;
    }

    //method do not completed
    public boolean create(Path path, String name){
        boolean res = false;
        return res;
    }

    public boolean isExists(Path path, String name){
        boolean res = false;
        return res;
    }

}
