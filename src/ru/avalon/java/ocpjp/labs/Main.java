package ru.avalon.java.ocpjp.labs;


import java.io.IOException;
import ru.avalon.java.ocpjp.labs.actions.*;
import ru.avalon.java.ocpjp.labs.console.ConsoleUI;

/**
 * Лабораторная работа №2
 * <p>
 * Курс: "DEV-OCPJP. Подготовка к сдаче сертификационных экзаменов серии Oracle
 * Certified Professional Java Programmer"
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
     * Инициализирует экземпляр базового типа с использоавнием перечисления
     * {@link Commands}.
     */
    Main() {
        super(Commands.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCommand(Commands command) throws IOException {
        Action action;
        switch (command) {
            case copy:
                action = new FileCopyAction();
                action.start();
                break;
                
            case move:
                action = new FileMoveAction();
                action.start();
                break;
                
            case exit:
                close();
                break;

            case delete:
                action = new FileDeleteAction();
                action.start();
                break;
                
            case create:
                action = new FileCreateAction();
                action.start();
                break;
        }
    }
}
