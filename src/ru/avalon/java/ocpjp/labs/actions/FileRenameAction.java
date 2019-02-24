/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.ocpjp.labs.actions;

import java.io.File;

/**
 *
 * @author Павлик
 */
public class FileRenameAction implements Action {
    private File sourceFile;
    private File destFile;
    
    public FileRenameAction(String sourceFile, String destFile){
        this.sourceFile = new File(sourceFile);
        this.destFile = new File(destFile);
    }

    @Override
    public void run() {
        try {
            if(sourceFile.renameTo(destFile)){
                System.out.println("Файл был переименован \n");
            }else{
                System.out.println("Файл не был переименован \n");
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }

    @Override
    public void close() throws Exception {
        sourceFile = null;
        destFile = null;
    }
}
