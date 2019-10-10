package file;

import java.util.Arrays;
import java.util.Objects;

public class Directory {
    private String name;
    private boolean readonly;

    public Directory(){
        this.name = "newDirectory";
    }

    public Directory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Directory directory = (Directory) o;
        return name.equals(directory.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
