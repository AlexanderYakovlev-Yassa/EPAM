package file;

public class Storage {
    private Directory root;
    private Record[] relations;

    public Storage(Directory root){
        this.root = root;
        this.relations = new Record[0];
    }

    public Record[] getRecords() {
        return relations;
    }

    public void setRecords(Record[] relations) {
        this.relations = relations;
    }

    public Directory getRoot() {
        return root;
    }

    public void setRoot(Directory root) {
        this.root = root;
    }
}
