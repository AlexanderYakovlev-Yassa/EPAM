package memory;

import java.util.Arrays;
import java.util.Objects;

public class Directory {
    String name;
    //Directory parent;
    Directory[] children;

    //***!!!***
    public Directory() {

        
    }

    public Directory(String name) {
        this.name = name;
        this.children = new Directory[0];
        //root = parent;
    }

    public Directory(String name, Directory parent) {
        this.name = name;
        this.children = new Directory[0];
        //root = parent;
    }

    private void addChild(Directory directory){
    children = Arrays.copyOf(children, children.length + 1);
    children[children.length - 1] = directory;
    }

    private boolean isExists(Directory directory){
    boolean res = false;
    return res;
    }


}
