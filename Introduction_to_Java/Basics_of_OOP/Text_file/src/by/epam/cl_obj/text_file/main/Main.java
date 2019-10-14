package by.epam.cl_obj.text_file.main;

import by.epam.cl_obj.text_file.file_objects.Directory;
import by.epam.cl_obj.text_file.file_objects.File;
import by.epam.cl_obj.text_file.file_objects.DirectoryRecords;
import by.epam.cl_obj.text_file.logic.StorageOperations;
import by.epam.cl_obj.text_file.logic.TextFileOperations;
import by.epam.cl_obj.text_file.report.DirectoryRecordsReport;
import by.epam.cl_obj.text_file.report.TextFileReport;

public class Main {
    public static void main(String[] args) {

        //создаем папку которая станет корневой в хранилище
        Directory root = new Directory("ROOT");

        //создаем хранилище и назначаем корневую папку для него
        DirectoryRecords flashCard = new DirectoryRecords(root);

        //создаем объект для доступа к методам оперирующим с папками и файлами
        //в хранилище
        StorageOperations storageOperations = new StorageOperations(flashCard);

        //создаем несколько папок и файлов
        Directory book = storageOperations.createDirectory(flashCard.getRoot(), "books");
        storageOperations.createDirectory(flashCard.getRoot(), "pictures");
        storageOperations.createDirectory(flashCard.getRoot(), "music");
        storageOperations.createDirectory(flashCard.getRoot(), "games");
        storageOperations.createDirectory(book, "stories");
        storageOperations.createDirectory(book, "poetry");
        storageOperations.createDirectory(book, "song lyrics");
        Directory classic = storageOperations.createDirectory(book, "classic");
        storageOperations.createDirectory(book, "scientific");
        Directory myth = storageOperations.createDirectory(book, "mithes");

        //пробуем создать папку с уже имеющимся именем
        storageOperations.createDirectory(book, "mithes");
        File f1 = storageOperations.createFile(myth, "ghosts", ".txt");
        File yetty = storageOperations.createFile(myth, "yetty", ".txt");
        storageOperations.createFile(myth, "yetty", ".txt");
        storageOperations.createFile(myth, "vampires", ".txt");
        File f2 = storageOperations.createFile(classic, "three men in a boat", ".txt");

        //создаем объект для доступа к методам управляющим
        // выводом информации о папках и файлах в хранилище
        DirectoryRecordsReport report = new DirectoryRecordsReport(flashCard);

        //выводим список папок содержащихся в папке book
        System.out.println(report.showChildren(book));

        //переименовываем папку и проверяем результат
        System.out.println("    переименовываем папку \"mithes\"\n");
        storageOperations.rename(myth, "myths");
        System.out.println(report.directoryTree(book));

        //выводим дерево папок и файлов для корневой папки
        System.out.println(report.directoryTree(flashCard.getRoot()));

        //удаляем файл и проверяем результат
        System.out.println("    удаляем файл \"yetty.txt\"\n");
        storageOperations.delete(yetty);
        System.out.println(report.directoryTree(flashCard.getRoot()));

        //удаляем папку и проверяем результат
        System.out.println("    удаляем папку \"myth\"\n");
        storageOperations.delete(myth);
        System.out.println(report.directoryTree(flashCard.getRoot()));

        //создаем объект для доступа к методам управляющим содержимым текстовых файлов
        TextFileOperations textOperations = new TextFileOperations();

        //добавляем ткст в файл
        textOperations.addTextToFile(f2,"Three invalids.—Sufferings of George and Harris.—" +
                "A victim to one hundred and seven fatal maladies.—Useful prescriptions.—Cure for " +
                "liver complaint in children.—We agree that we are overworked, and need rest.—A week" +
                " on the rolling deep?—George suggests the River.—Montmorency lodges an objection." +
                "—Original motion carried by majority of three to one.\n" +
                "There were four of us—George, and William Samuel Harris, " +
                "and myself, and Montmorency.  We were sitting in my room, smoking, and talking about " +
                "how bad we were—bad from a medical point of view I mean, of course.\n" +
                "We were all feeling seedy, and we were getting quite nervous about it.  " +
                "Harris said he felt such extraordinary fits of giddiness come over him at times, " +
                "that he hardly knew what he was doing; and then George said that he had fits of " +
                "giddiness too, and hardly knew what he was doing.  With me, it was my liver that was out of order." +
                "  I knew it was my liver that was out of order, because I had just been reading a" +
                " patent liver-pill circular, in which were detailed the various symptoms by which a man " +
                "could tell when his liver was out of order.  I had them all.\n");

        //создаем объект для получения доступа к методам управляющим выводом содержимого текстовых файлов
        TextFileReport textFileReport = new TextFileReport();

        //выводим содержимое файла в консоль
        System.out.println("Содержимое файла: " + f2.getName() + "\n");
        System.out.println(textFileReport.showTextFileContent(f2));

        //добавляем ткст в файл
        textOperations.addTextToFile(f2, "It is a most extraordinary thing, but I never read a patent " +
                "medicine advertisement without being impelled to the conclusion that I am suffering from " +
                "the particular disease therein dealt with in its most virulent form.  The diagnosis seems " +
                "in every case to correspond exactly with all the sensations that I have ever felt.\n");

        //выводим содержимое файла в консоль
        System.out.println("Содержимое файла: " + f2.getName() + "\n");
        System.out.println(textFileReport.showTextFileContent(f2));

        //очищаем содержимое файла
        textOperations.clearFile(f2);

        //выводим содержимое файла в консоль
        System.out.println("Содержимое файла: " + f2.getName());
        System.out.println(textFileReport.showTextFileContent(f2));
    }
}
