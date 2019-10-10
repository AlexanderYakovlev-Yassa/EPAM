package logic;


import file.Directory;
import file.File;
import file.Record;
import file.Storage;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operator {

    /*
    *проверяет правильность написания имени папки (файла)
    * можно применять буквы цыфры и знаки препинания кроме '\' и ':'
    * */
    public boolean isFileNameValid(String name){
        Pattern p = Pattern.compile("^[\\w\\s\\p{Punct}&&[^:\\\\]]+$");
        Matcher m = p.matcher(name);
        boolean res = m.find() ? true : false;
        return res;
    }

    /*
     *проверяет правильность написания имени расширения файла
     *первый знак - точка, второй знак - буква,
     * далее не более 5ти знаков - можно применять только буквы и цыфры
     * */
    public boolean isExtensionValid(String extension){
        Pattern p = Pattern.compile("^([\\.][\\w &&[^\\d]][\\w\\d]{0,5})?$");
        Matcher m = p.matcher(extension);
        boolean res = m.find() ? true : false;
        return res;
    }

    public Storage createStorage(){
        Directory directory = new Directory("root");
        Storage storage = new Storage(directory);

        return storage;
    }

    public Directory createDirectory(Storage storage, Directory parent, String name){
        Directory directory = new Directory(name);
        if (isFileNameValid(name) &&
                parent != null &&
                !isSuchDirectoryExists(storage, parent, directory)){
            Record relation = new Record(parent, directory);
            addRelation(storage, relation);
        } else {
            directory = null;
        }
        return directory;
    }

    public Directory createFile(Storage storage, Directory parent, String name, String extension){
        Directory file = new File(name, extension);
        if (isFileNameValid(name) &&
                parent != null &&
                !isSuchDirectoryExists(storage, parent, file)){
            Record relation = new Record(parent, file);
            addRelation(storage, relation);
        } else {
            file = null;
        }
        return file;
    }

    public boolean isSuchDirectoryExists(Storage storage, Directory parent, Directory child){
        boolean res = false;
        for (Record r : storage.getRecords()){
            if (parent.equals(r.getParent()) && child.equals(r.getChild())){
                res = true;
                break;
            }
        }
        return  res;
    }

    /*public boolean isFileNameExists(Storage storage, File file, String name, String extension){
        boolean res = false;
        for (Relation r : storage.getRelations()){
            if (r.getParent() == dir && r.getChild().getName().equals(name)){
                res = true;
                break;
            }
        }
        return  res;
    }*/

    public boolean addRelation(Storage storage, Record relation){
        boolean res = false;
        if (storage != null && relation != null) {
            Record[] oldRelations = storage.getRecords();
            Record[] newRelations = Arrays.copyOf(oldRelations, oldRelations.length + 1);
            newRelations[newRelations.length - 1] = relation;
            storage.setRecords(newRelations);
            res = true;
        }
        return  res;
    }

    public boolean isDirEmpty(Storage storage, Directory directory){
        boolean res = true;
        for (Record r : storage.getRecords()){
            if (r.getParent() == directory){
                res = false;
                break;
            }
        }
        return res;
    }

    private void log(Object o){
        System.out.println("log-" + o.toString());
    }

}
