package ru.avalon.java.ocpjp.labs;

import ru.avalon.java.ocpjp.labs.console.ConsoleUI;

import java.io.IOException;
import java.util.Scanner;
import ru.avalon.java.ocpjp.labs.actions.FileCopyAction;
import ru.avalon.java.ocpjp.labs.actions.FileDeleteAction;
import ru.avalon.java.ocpjp.labs.actions.FileMoveAction;
import ru.avalon.java.ocpjp.labs.actions.FileRenameAction;

/**
 * Лабораторная работа №2
 * <p>
 * Курс: "DEV-OCPJP. Подготовка к сдаче
 * сертификационных экзаменов серии Oracle Certified
 * Professional Java Programmer"
 * <p>
 * Тема: "Потоки исполнения (Threads) и многозадачность" 
 *
 * @author Daniel Alpatov <danial.alpatov@gmail.com>
 */
public class Main extends ConsoleUI<Commands> {
   String source, dest;
    Scanner in;
    /**
     * Точка входа в приложение.
     * 
     * @param args 
     */
    public static void main(String[] args) {
        new Main().run();
    }
    /**
     * Конструктор класса.
     * <p>
     * Инициализирует экземпляр базового типа с использоавнием
     * перечисления {@link Commands}.
     */
    Main() {
        super(Commands.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected synchronized void onCommand(Commands command) throws IOException {
        in = new Scanner(System.in);
        switch (command) {
            case copy:
                initScanIn();
                initScanOut();
                FileCopyAction copyAction = new FileCopyAction(source, dest);
                copyAction.start();
                break;
            case move:
                initScanIn();
                initScanOut();
                FileMoveAction moveAction = new FileMoveAction(source, dest);
                moveAction.start();
                break;
            case exit:
                close();
                break;
            case rename:
                initScanIn();
                initScanOut();
                FileRenameAction renameAction = new FileRenameAction(source, dest);
                renameAction.start();
                break;
            case delete:
                initScanIn();
                FileDeleteAction deleteAction = new FileDeleteAction(source);
                deleteAction.start();
                break;
        }
    }
    
    void initScanIn(){
        
        System.out.println("Введите исходный адрес файла");
        source = in.nextLine();
        
    }
    
    void initScanOut(){
        System.out.println("Отлично. Теперь введите новый адрес файла");
        dest = in.nextLine();
    }
    
}
