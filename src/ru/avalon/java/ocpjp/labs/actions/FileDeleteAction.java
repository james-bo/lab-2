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
public class FileDeleteAction implements Action {
    
    private File sourceFile;
    
    public FileDeleteAction(String sourceFile){
        this.sourceFile = new File(sourceFile);
    }

    @Override
    public void run() {
        if(sourceFile.delete()){
            System.out.println("Файл был удален \n");
        }else{
            System.out.println("Файл не был удален \n");
        }
    }

    @Override
    public void close() throws Exception {
        sourceFile = null;
    }
    
}
