package ru.avalon.java.ocpjp.labs.actions;

import java.io.IOException;
import java.nio.file.*;

/**
 * Действие, которое копирует файлы в пределах дискового пространства.
 */
public class FileCopyAction implements Action {

    Path sourceFile;
    Path destination;

    @Override
    public void run() {
        sourceFile = Paths.get("Exam808_SampleQuestion.pdf");
        destination = Paths.get("Exam808_1_SampleQuestion.pdf");
        try {
            Files.copy(sourceFile, destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            System.out.println("error in copy files");
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws Exception {
        sourceFile = null;
        destination = null;
        System.out.println("copy closed");

    }
}
