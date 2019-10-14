package by.epam.cl_obj.text_file.logic;

import by.epam.cl_obj.text_file.file_objects.Directory;
import by.epam.cl_obj.text_file.file_objects.File;

import java.nio.charset.Charset;

/*
* класс содержит методы для работы с содержимым текстовых файлов:
*       - String readFromFile(File file)
* читает содержимое текстового файла и возвращает его в виде строки.
*       - boolean clearFile(File file)
* удаляет содержимое файла.
*       - boolean addTextToFile(Directory file, String str)
* добавляет к содержимому файла текст.
*       - boolean isTextFile(Directory file)
* проверяет существует ли файл и является ли он текстовым.
* */
public class TextFileOperations {

    public String readFromFile(File file){
        String str;

        if (isTextFile(file)) {
            byte[] fileContent = file.getContent();
            Charset charset = Charset.forName("UTF-16");
            str = new String(fileContent, charset);
        } else {
            str = null;
        }

        return str;
    }

    public boolean clearFile(File file){

        boolean res = false;
        StringBuilder newContent = new StringBuilder();

        if (isTextFile(file)) {

            byte[] fileContent = new byte[0];
            file.setContent(fileContent);

            res = true;
        }
        return res;
    }

    public boolean addTextToFile(Directory file, String str){
        boolean res;
        Charset charset = Charset.forName("UTF-16");
        if (isTextFile(file)) {
            String oldText = readFromFile((File)file);
            StringBuilder sb = new StringBuilder(oldText);
            sb.append(str);
            ((File)file).setContent(sb.toString().getBytes(charset));
            res = true;
        } else {
            res = false;
        }
        return res;
    }

    private boolean isTextFile(Directory file){
        boolean res = false;
        if (file != null){

                if (((File)file).getExtension().equals(".txt")){
                    res = true;
                }

        }
        return  res;
    }
}
