package main;

import file.Directory;
import file.Storage;
import logic.*;
import report.Report;

public class Main {
    public static void main(String[] args) {

        Operator operator = new Operator();
        Storage flashCard = operator.createStorage();
        //operator.setStorage(flashCard);

        Directory book = operator.createDirectory(flashCard, flashCard.getRoot(), "books");
        operator.createDirectory(flashCard, flashCard.getRoot(), "stories");
        operator.createDirectory(flashCard, flashCard.getRoot(), "poetry");
        operator.createDirectory(flashCard, flashCard.getRoot(), "song lyrics");
        operator.createDirectory(flashCard, book, "classic");
        operator.createDirectory(flashCard, book, "scientific");
        Directory mith = operator.createDirectory(flashCard, book, "mithes");
        operator.createDirectory(flashCard, book, "mithes");
        operator.createFile(flashCard, mith, "ghosts", ".txt");
        operator.createFile(flashCard, mith, "yetty", ".txt");
        operator.createFile(flashCard, mith, "vampires", ".txt");

        Directory d1 = new Directory("dir1");

        //System.out.println(flashCard.getRecords().length);
        Report report = new Report(flashCard);

        System.out.println(report.dir(flashCard.getRoot(), 0));
        //report.dir(book);

       /* Directory[] a = new Directory[2];
        Directory d = new Directory("dir");
        Directory f = new File("file", ".txt");
        a[0] = d;
        a[1] = f;
        for (Directory dr : a){

            if (dr instanceof File){
                System.out.println(dr.getName() + ((File) dr).getExtension());
            } else {
                System.out.println(dr.getName());
            }
            System.out.println(dr.equals(d));
            System.out.println(dr.equals(f));
        }*/
    }
}
