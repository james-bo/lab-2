package ru.avalon.java.ocpjp.labs.actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Действие, которое копирует файлы в пределах дискового
 * пространства.
 */
public class FileCopyAction implements Action {
    
    private Path source;
    private Path target;
    
    public FileCopyAction(Path source, Path target) {
        this.source = source;
        this.target = target;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        try {
            Files.copy(source, target);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws Exception {
        /*
         * TODO №3 Реализуйте метод close класса FileCopyAction
         */
        throw new UnsupportedOperationException("Not implemented yet!");
    }
}
