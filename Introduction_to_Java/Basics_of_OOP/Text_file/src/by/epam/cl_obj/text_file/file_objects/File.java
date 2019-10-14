package by.epam.cl_obj.text_file.file_objects;

import java.util.Arrays;

/*
* Класс представляет файл
* */
public class File extends Directory{
    private String extension;
    private byte[] content;

    public File(String name, String extension){
        super(name);
        this.extension = extension;
        this.content = new byte[0];
    }

    public String getExtension() {
        return extension;
    }

    public String getName() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return Arrays.equals(getContent(), file.getContent());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(getContent());
    }
}
