package file;

import java.util.Objects;

public class File extends Directory{
    private String extension;
    private byte[] content;

    public File(String name, String extension){
        super(name);
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
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
        if (!(o instanceof File)) return false;
        if (!super.equals(o)) return false;
        File file = (File) o;
        return extension.equals(file.extension);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), extension);
    }
}
