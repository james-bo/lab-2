package ru.avalon.java.ocpjp.labs.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Действие, которое копирует файлы в пределах дискового
 * пространства.
 */
public class FileCopyAction implements Action {
    private File sourceFile;
    private File destinationFile;

    private FileInputStream reader;
    private FileOutputStream writer;

    public FileCopyAction(String sourceFile, String destinationFile) {
        this.sourceFile = new File(sourceFile);
        this.destinationFile = new File(destinationFile);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        try {
            destinationFile.createNewFile();
            reader = new FileInputStream(sourceFile);
            writer = new FileOutputStream(destinationFile);
            fileCopy(reader, writer);
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }

    }
    
    public static void fileCopy(InputStream is, OutputStream os) throws IOException{
        int nLength;
        byte[] buf = new byte[8000];
        while(true){
            nLength = is.read(buf);
            if(nLength < 0){ 
                break;
            }
        os.write(buf, 0, nLength);
        }    
        is.close();
        os.close();
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

