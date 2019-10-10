package report;

import file.Directory;
import file.File;
import file.Record;
import file.Storage;

public class Report {
    private Storage records;

    public Report(Storage records) {
        this.records = records;
    }

    public void dirAll(Directory directory, int nesting) {
        //int nesting = 1;
        StringBuilder sb = new StringBuilder();
        String prefix = nestPrefix(nesting);
        //sb.append(prefix + dirToString(directory));
        if (hasChildren(directory)) {
            sb.insert(0, sb.toString());
            //sb.append(prefix + dirToString(directory));
            for (Record r : records.getRecords()) {
                if (directory == r.getParent()) {
                    dirAll(r.getChild(), nesting + 1);
                }
            }
        } else {
            sb.append(prefix + dirToString(directory));
        }

        System.out.println(sb.toString());
    }

    public String dir(Directory directory, int nesting){
        StringBuilder sb = new StringBuilder();
        String prefix = nestPrefix(nesting);
        for (Record r : records.getRecords()) {
            if (directory == r.getParent()) {
                sb.append("\n" + prefix + dirToString(r.getChild()));
            }
        }
        return sb.toString();
    }

    private boolean hasChildren(Directory directory) {
        boolean res = false;
        for (Record rec : records.getRecords()) {
            if (rec.getParent() == directory) {
                res = true;
                break;
            }
        }
        return res;
    }

    private String dirToString(Directory directory) {
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
            //prefix.append((char)746);
        }
        return prefix.toString();
    }

    public void log(String str) {
        System.out.println(str);
    }
}
