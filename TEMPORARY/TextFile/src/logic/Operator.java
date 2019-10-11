package logic;


import file.Directory;
import file.File;
import file.Record;
import file.Storage;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operator {

    private class Path {
        private Directory[] path;

        Path(){
            this.path = new Directory[0];
        }

        public void add(Directory dir){
            path = Arrays.copyOf(path, path.length + 1);
            path[path.length -1] = dir;
        }

        public String getPathString(){
            StringBuilder sb = new StringBuilder();
            for (int i = path.length-1; i >= 0 ; i--) {
                //System.out.println(path.length);
                if (path[i] instanceof File){
                    sb.append(path[i].getName()+((File)path[i]).getExtension());
                } else {
                    sb.append(path[i].getName() + "\\");
                }
            }
            return sb.toString();
        }
    }

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

    public String getPath(Storage storage, Directory file){
        Path path = new Path();
        path.add(file);
        Directory parent = file;
        while (parent != storage.getRoot()){
            for (Record rec : storage.getRecords()){
                if (rec.getChild() == parent){
                    parent = rec.getParent();
                    path.add(parent);
                    break;
                }
            }
        }

        return path.getPathString();
    }

    private void log(Object o){
        System.out.println("log-" + o.toString());
    }

}
