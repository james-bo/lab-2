/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.ocpjp.labs.actions;

import java.io.IOException;
import java.nio.file.*;

/**
 *
 * @author ArgoNesK
 */
public class FileDeleteAction implements Action {

    Path sourceFile;

    @Override
    public void run() {

        sourceFile = Paths.get("F:\\Программирование\\Java\\Work\\OCPJP\\LB2\\new\\Exam808_1.pdf");

        try {
            if (Files.deleteIfExists(sourceFile)) {
                System.out.println("File deleted");
            } else {
                System.out.println("error deleted file");
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
        System.out.println("delete closed");
    }
}
