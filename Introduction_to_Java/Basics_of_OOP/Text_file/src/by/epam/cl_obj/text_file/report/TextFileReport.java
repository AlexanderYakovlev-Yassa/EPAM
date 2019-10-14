package by.epam.cl_obj.text_file.report;

import by.epam.cl_obj.text_file.file_objects.Directory;
import by.epam.cl_obj.text_file.file_objects.File;
import by.epam.cl_obj.text_file.logic.TextFileOperations;

/*
* Класс содержит методы для выводжа информации
* о содержании текстового файла
* */
public class TextFileReport {

    public String showTextFileContent(Directory file) {
        TextFileOperations textFileOperations = new TextFileOperations();
        String content;
        if (file instanceof File) {
            content = textFileOperations.readFromFile((File)file);
        } else {
            content = null;
        }
        return content;
    }
}
