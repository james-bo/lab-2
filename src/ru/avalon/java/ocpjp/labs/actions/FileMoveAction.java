package ru.avalon.java.ocpjp.labs.actions;

import java.io.File;

/**
 * Действие, которое перемещает файлы в пределах дискового
 * пространства.
 */
public class FileMoveAction implements Action {
    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        /*
         * TODO №4 Реализуйте метод run класса FileMoveAction
         */
        File destinationFolder = new File("C:\\Users\\UIS\\Downloads");
        File sourceFolder = new File("c:\\Users\\UIS\\Desktop\\Avalon\\lab-1\\lab-1\\src\\ru\\avalon\\java\\ocpjp\\labs\\resources\\newnames.txt");

        if(!destinationFolder.exists()) {
            destinationFolder.mkdirs();
        }

        if(sourceFolder.exists() && sourceFolder.isFile()) {
            File[] listOffFiles = sourceFolder.listFiles(); // список файлов в виде массива
            if(listOffFiles != null) {
                for (File child : listOffFiles) {
                    child.renameTo(new File(destinationFolder + "\\" + child.getName()));
                }
            }
        } else {
            System.out.println(sourceFolder + "Folder does not exists");
        }

        throw new UnsupportedOperationException("Not implemented yet!");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws Exception {
        /*
         * TODO №5 Реализуйте метод close класса FileMoveAction
         */
        throw new UnsupportedOperationException("Not implemented yet!");
    }

}
