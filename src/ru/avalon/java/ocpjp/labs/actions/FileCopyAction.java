package ru.avalon.java.ocpjp.labs.actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Semaphore;

/**
 * Действие, которое копирует файлы в пределах дискового
 * пространства.
 */
public class FileCopyAction implements Action {

    private Path source;
    private Path target;

    private static final Semaphore SEMAPHORE = new Semaphore(1);

    public FileCopyAction (Path source, Path target) {
        this.source = source;
        this.target = target;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        try {
            synchronized (SEMAPHORE) {
                SEMAPHORE.acquire();
                try {
                    Files.copy(source, target);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                SEMAPHORE.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace(System.err);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws Exception {
        source = null;
        target = null;
    }
}
