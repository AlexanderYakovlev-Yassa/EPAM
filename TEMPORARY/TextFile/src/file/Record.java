package file;

import file.Directory;
import file.File;

public class Record {
    private Directory parent;
    private Directory child;

    public Record(Directory parent, Directory child){
        this.parent = parent;
        this.child = child;
    }

    public Directory getParent() {
        return parent;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public Directory getChild() {
        return child;
    }

    public void setChild(Directory child) {
        this.child = child;
    }
}
