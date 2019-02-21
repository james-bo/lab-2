package ru.avalon.java.ocpjp.labs.actions;

import java.io.IOException;
import java.nio.file.*;

/**
 * Действие, которое перемещает файлы в пределах дискового пространства.
 */
public class FileMoveAction implements Action {

    Path sourceFile;
    Path destination;

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        sourceFile = Paths.get("Exam808_SampleQuestion.pdf");
        destination = Paths.get("F:\\Программирование\\Java\\Work\\OCPJP\\LB2\\new\\Exam808_1.pdf");
        try {
            if (Files.exists(sourceFile)) {
                Files.move(sourceFile, destination, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("File moved");
            } else {
                System.err.println("File doesn't exist");
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
//        throw new UnsupportedOperationException("Not implemented yet!");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws Exception {
        sourceFile = null;
        destination = null;
        close();
        System.out.println("move closed");
        //throw new UnsupportedOperationException("Not implemented yet!");
    }

}
