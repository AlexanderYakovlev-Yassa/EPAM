package by.epam.tasks.library.util;

import by.epam.tasks.library.view.View;

import java.io.*;

public class TextFileRW {

    public boolean addToTextFile(String fileName, StringBuilder text, boolean append) throws IOException {

        boolean res = false;
        View view = new View();

        File f = new File(fileName);

        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter(f, append);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            pw.print(text);

        } catch (IOException e) {
            System.err.println("open stream error " + e);
        } finally {
            if (pw != null) {

                pw.close();
                res = true;
            }

            return res;
        }
    }

    public StringBuilder readTextFile(String fileName) throws IOException {

        StringBuilder text = new StringBuilder();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(fileName));
            String tmp = "";
            while ((tmp = br.readLine()) != null) {
                text.append(tmp + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return text;
    }
}
