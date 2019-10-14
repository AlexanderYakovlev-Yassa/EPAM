package by.epam.cl_obj.text_file.file_objects;

/*
* Класс представляет директорию.
* */
public class Directory {
    private String name;

    public Directory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
