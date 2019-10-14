package by.epam.cl_obj.text_file.logic;


import by.epam.cl_obj.text_file.file_objects.Directory;
import by.epam.cl_obj.text_file.file_objects.File;
import by.epam.cl_obj.text_file.file_objects.Record;
import by.epam.cl_obj.text_file.file_objects.DirectoryRecords;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*
 * Класс содержит методы выполняющие различные операции
 * с папками и файлами.
 * Поле объекта класса records содержит ссылку на таблицу хранилища
 * содержащую ссылки на папки и файлы и отношения между ними
 *       - Directory createDirectory(Directory parent, String name)
 * создает директорию с именем "name" в дериктории "parent".
 *       - File createFile(Directory parent, String name, String extension)
 * создает файл в директории "parent" с именем "name" и расширением "extension".
 *       - boolean rename(Directory directory, String newName)
 * переименовывает папку или файл "directory", новое имя "newName".
 *       - void delete(Directory directory)
 * удаляет указанную папку или файл
 * (удаляет записи из таблицы в хранилище содержащие указанную папку или файл)
 * вспомогательные методы:
 *       - boolean addRecord(Record record)
 * добавляет запись в таблицу хранилища
 *       - boolean isDirectoryAcceptableHere(Directory parent, Directory child)
 * проверяет является ли папка (файл) допустимой в указанной папке.
 * папка не может содержать папки с одинаковими именами,
 * файлы с одинаковыми именами и файлы не могут содержать дочерних объектов.
 *       - boolean isDirectoriesNameEqual(Directory dir1, Directory dir2)
 * проверяет являются ли имена указанных папок (файлов) одинаковыми
 *       - boolean isFileNameValid(String name)
 * проверяет правильность написания имени папки (файла)
 * можно применять буквы цыфры и знаки препинания кроме '\' и ':'
 *       - boolean isExtensionValid(String extension)
 * проверяет правильность написания имени расширения файла
 * первый знак - точка, второй знак - буква,
 * далее не более 5ти знаков - можно применять только буквы и цыфры
 * */
public class StorageOperations {

    private DirectoryRecords records;

    public StorageOperations(DirectoryRecords records) {
        this.records = records;
    }


    public Directory createDirectory(Directory parent, String name) {
        Directory directory = null;
        //StorageUtils utils = new StorageUtils(records);
        if (isFileNameValid(name)) {

            directory = new Directory(name);
            //System.out.println(name + "  " + utils.isDirectoryAcceptableHere(parent, directory));
            if (parent != null &&
                    isDirectoryAcceptableHere(parent, directory)) {

                Record record = new Record(parent, directory);
                addRecord(record);
            }
        }

        return directory;
    }

    public File createFile(Directory parent, String name, String extension) {

        File file = null;
        if (isFileNameValid(name) && isExtensionValid(extension)) {

            file = new File(name, extension);

            if (parent != null &&
                    isDirectoryAcceptableHere(parent, file)) {

                Record record = new Record(parent, file);
                addRecord(record);
            }
        }

        return file;
    }

    public boolean rename(Directory directory, String newName) {
        boolean res = false;

        Directory forValidation;
        if (isFileNameValid(newName)) {
            forValidation = new Directory(newName);
        } else {
            forValidation = null;
        }

        if (isDirectoryAcceptableHere(directory, forValidation)) {
            directory.setName(newName);
            res = true;
        } else {
            res = false;
        }

        return res;
    }

    public void delete(Directory directory) {

        Record[] oldTab = records.getRecords();
        Record[] newTab = new Record[records.getRecords().length];
        int count = 0;

        if (directory != null) {
            for (int i = 0; i < oldTab.length; i++) {

                if (oldTab[i].getParent() != directory && oldTab[i].getChild() != directory) {
                    newTab[count] = oldTab[i];
                    count++;
                }
            }
        }

        newTab = Arrays.copyOf(newTab,count);
        records.setRecords(newTab);
    }

    private boolean addRecord(Record record) {
        boolean res = false;
        if (records != null && record != null) {
            Record[] oldRelations = records.getRecords();
            Record[] newRelations = Arrays.copyOf(oldRelations, oldRelations.length + 1);
            newRelations[newRelations.length - 1] = record;
            records.setRecords(newRelations);
            res = true;
        }
        return res;
    }

    private boolean isDirectoryAcceptableHere(Directory parent, Directory child) {
        boolean res = true;
        if (parent != null && parent instanceof Directory) {

            for (Record rec : records.getRecords()) {
                if (rec.getParent() == parent) {
                    if (isDirectoriesNameEqual(rec.getChild(), child)) {
                        res = false;
                    }
                }
            }

        } else {
            res = false;
        }
        return res;
    }

    private boolean isDirectoriesNameEqual(Directory dir1, Directory dir2) {
        boolean res;
        if (dir1 == dir2) {
            res = true;
        }
        if (dir1.getClass() == dir2.getClass()) {
            if (dir1.getName().equals(dir2.getName())) {
                if (dir1 instanceof File) {
                    if (((File) dir1).getExtension().equals(((File) dir2).getExtension())) {
                        res = true;
                    } else {
                        res = false;
                    }
                } else {
                    res = true;
                }
            } else {
                res = false;
            }
        } else {
            res = false;
        }
        return res;
    }

    private boolean isFileNameValid(String name) {
        Pattern p = Pattern.compile("^[\\w\\s\\p{Punct}&&[^:\\\\]]+$");
        Matcher m = p.matcher(name);
        boolean res = m.find() ? true : false;
        return res;
    }

    private boolean isExtensionValid(String extension) {
        Pattern p = Pattern.compile("^([\\.][\\w &&[^\\d]][\\w\\d]{0,5})?$");
        Matcher m = p.matcher(extension);
        boolean res = m.find() ? true : false;
        return res;
    }
}
