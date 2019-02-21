package ru.avalon.java.ocpjp.labs.actions;

import java.io.IOException;
import java.nio.file.*;

/**
 *
 * @author ArgoNesK
 */
public class FileCreateAction implements Action {

    Path sourceFile;

    @Override
    public void run() {

        sourceFile = Paths.get("F:\\Программирование\\Java\\Work\\OCPJP\\LB2\\new\\Exam808_1.pdf");

        try {
            if (Files.notExists(sourceFile)) {
                Files.createFile(sourceFile);
                System.out.println("File created");
            } else {
                System.out.println("File already exists");
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
        sourceFile = null;
        System.out.println("create closed");
    }

}
