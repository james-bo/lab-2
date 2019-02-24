package ru.avalon.java.ocpjp.labs.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import static ru.avalon.java.ocpjp.labs.actions.FileCopyAction.fileCopy;

/**
 * Действие, которое перемещает файлы в пределах дискового
 * пространства.
 */
public class FileMoveAction implements Action {
    private File sourceFile;
    private File destinationFile;
    
    private FileInputStream reader;
    private FileOutputStream writer;


    public FileMoveAction(String sourceFile, String destinationFile) {
        this.sourceFile = new File(sourceFile);
        this.destinationFile = new File(destinationFile);
    }

    @Override
    @SuppressWarnings("empty-statement")
    public void run() {
        try {
            destinationFile.createNewFile();
            reader = new FileInputStream(sourceFile);
            writer = new FileOutputStream(destinationFile);
            fileCopy(reader, writer);
            if(sourceFile.delete()){
                System.out.println("Файл был перемещен");
            }else{
                System.out.println("Файл не был перемещен");
            };
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws Exception {
        sourceFile = null;
        destinationFile = null;
        reader.close();
        writer.close();
        reader = null;
        writer = null;
    }
}
