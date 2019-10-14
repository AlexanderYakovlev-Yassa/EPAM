package by.epam.cl_obj.text_file.file_objects;

/*
* Класс представляет хранилище, содержит записи
* об отношениях между папками и файлами.
* */
public class DirectoryRecords {
    private Directory root;
    private Record[] records;

    public DirectoryRecords(Directory root){
        this.root = root;
        this.records = new Record[0];
    }

    public Record[] getRecords() {
        return records;
    }

    public void setRecords(Record[] relations) {
        this.records = relations;
    }

    public Directory getRoot() {
        return root;
    }

    public void setRoot(Directory root) {
        this.root = root;
    }
}
