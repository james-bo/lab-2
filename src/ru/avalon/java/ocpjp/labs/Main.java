package ru.avalon.java.ocpjp.labs;

import ru.avalon.java.ocpjp.labs.actions.FileCopyAction;
import ru.avalon.java.ocpjp.labs.actions.FileMoveAction;
import ru.avalon.java.ocpjp.labs.console.ConsoleUI;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

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
    protected void onCommand(Commands command) throws IOException {
        switch (command) {
            case copy:
                FileCopyAction copyAction = new FileCopyAction("txt.txt", "txt2.txt");
                copyAction.start();
                break;
            case move:
                FileMoveAction moveAction = new FileMoveAction("txt.txt", "txt2.txt");
                moveAction.start();
                break;
            case exit:
                close();
                break;
            case run:
                System.err.println("Nothing to do on command: " + command.toString());
                break;
            case begin:
                System.err.println("Nothing to do on command: " + command.toString());
        }
    }
    
}
