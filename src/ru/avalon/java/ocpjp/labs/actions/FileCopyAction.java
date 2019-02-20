package ru.avalon.java.ocpjp.labs.actions;

import java.io.*;

/**
 * Действие, которое копирует файлы в пределах дискового
 * пространства.
 */
public class FileCopyAction implements Action {

    private File sourceFile;
    private File destinationFile;

    private FileInputStream reader;
    private FileOutputStream writer;

    public FileCopyAction(String sourceFile, String destinationFile) {
        this.sourceFile = new File(sourceFile);
        this.destinationFile = new File(destinationFile);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        try {
            destinationFile.createNewFile();
            reader = new FileInputStream(sourceFile);
            writer = new FileOutputStream(destinationFile);
            int data = reader.read();
            while(data != -1) {
                writer.write(data);
                data = reader.read();
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws Exception {
        reader.close();
        writer.close();
        reader = null;
        writer = null;
    }
}
