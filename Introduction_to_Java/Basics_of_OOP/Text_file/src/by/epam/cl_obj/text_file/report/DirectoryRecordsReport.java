package by.epam.cl_obj.text_file.report;

import by.epam.cl_obj.text_file.file_objects.Directory;
import by.epam.cl_obj.text_file.file_objects.File;
import by.epam.cl_obj.text_file.file_objects.Record;
import by.epam.cl_obj.text_file.file_objects.DirectoryRecords;

/*
* Класс содержит методы для вывода информации о хранилище
*
* */
public class DirectoryRecordsReport {

    private DirectoryRecords records;

    public DirectoryRecordsReport(DirectoryRecords records) {
        this.records = records;
    }

    public String directoryTree(Directory directory) {
        StringBuilder sb = new StringBuilder("\t\ttree of " + directory.getName());

        addDirectoryChildrenToReport(sb, directory, 0);
        sb.append("\n");
        return sb.toString();
    }

    private void addDirectoryChildrenToReport(StringBuilder report, Directory parent, int nesting) {

        String prefix = "\n" + nestPrefix(nesting);
        for (Record rec : records.getRecords()) {
            if (rec.getParent() == parent) {
                report.append(prefix + directoryNameForReport(rec.getChild()));
                if (hasDirChildren(rec.getChild())) {
                    addDirectoryChildrenToReport(report, rec.getChild(), nesting + 1);
                }
            }
        }
    }

    public String showChildren(Directory directory) {
        StringBuilder report = new StringBuilder("\t\tlist of " + directory.getName());

        for (Record rec : records.getRecords()) {
            if (rec.getParent() == directory) {
                report.append("\n" + directoryNameForReport(rec.getChild()));
            }
        }
        report.append("\n");

        return report.toString();
    }



    private boolean hasDirChildren(Directory directory) {
        boolean res = false;
        for (Record rec : records.getRecords()) {
            if (rec.getParent() == directory) {
                res = true;
                break;
            }
        }
        return res;
    }

    private String directoryNameForReport(Directory directory) {
        String str;
        if (directory instanceof File) {
            str = "[f] " + directory.getName() + ((File) directory).getExtension();
        } else {
            str = "[D] " + directory.getName();
        }
        return str;
    }

    private String nestPrefix(int nesting) {
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < nesting; i++) {
            prefix.append("  ");
        }
        if (nesting > 0) {

        }
        return prefix.toString();
    }
}
