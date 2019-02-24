package ru.avalon.java.ocpjp.labs.actions;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Действие, которое копирует файлы в пределах дискового
 * пространства.
 */
public class FileCopyAction implements Action {
    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        /*
         * TODO №2 Реализуйте метод run класса FileCopyAction
         */
        ArrayList<String> newnames = new ArrayList<>();
        File file = new File("c:\\Users\\UIS\\Desktop\\Avalon\\lab-1\\lab-1\\src\\ru\\avalon\\java\\ocpjp\\labs\\resources\\first-names.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                newnames.add(scanner.nextLine()); // записал в все строки из файла в ArrayList
                Writer writer = null;
                writer = new FileWriter("c:\\Users\\UIS\\Desktop\\Avalon\\lab-1\\lab-1\\src\\ru\\avalon\\java\\ocpjp\\labs\\resources\\newnames.txt");
                for (String line : newnames) { // перезаписал в другой файл всё из ArrayList
                    writer.write(line);
                    writer.write(System.getProperty(" "));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new UnsupportedOperationException("Not implemented yet!");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws Exception {
        /*
         * TODO №3 Реализуйте метод close класса FileCopyAction
         */
        close();
        throw new UnsupportedOperationException("Not implemented yet!");
    }
}
