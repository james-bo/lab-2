package ru.avalon.java.ocpjp.labs;

import ru.avalon.java.ocpjp.labs.actions.FileCopyAction;
import ru.avalon.java.ocpjp.labs.actions.FileMoveAction;
import ru.avalon.java.ocpjp.labs.console.ConsoleUI;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

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

        Path source;
        Path target;

        switch (command) {
            case copy:
                source = Paths.get("C:\\Users\\zhura\\Desktop\\Test\\Source\\test.txt");
                target = Paths.get("C:\\Users\\zhura\\Desktop\\Test\\Target\\test_copied.txt");
                FileCopyAction onCopy = new FileCopyAction(source, target);
                onCopy.start();
                break;
            case move:
                source = Paths.get("C:\\Users\\zhura\\Desktop\\Test\\Source\\test.txt");
                target = Paths.get("C:\\Users\\zhura\\Desktop\\Test\\Target\\test_moved.txt");
                FileMoveAction onMove = new FileMoveAction(source, target);
                onMove.start();
                break;
            case exit:
                close();
                break;
                /*
                 * TODO №9 Обработайте необработанные команды
                 */
        }
    }
    
}
