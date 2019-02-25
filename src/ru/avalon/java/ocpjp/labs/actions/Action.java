package ru.avalon.java.ocpjp.labs.actions;

/**
 * Абстрактное представление о действии, как функциональном
 * элементе приложения.
 * <p>
 * Действие является потоковым объектом, что позволяет
 * исполнять несколько действий параллельно и не блокировать
 * основной поток исполнения.
 */
public interface Action extends Runnable, AutoCloseable {
    /**
     * Запускает потоковый объект на исполнение в отдельном
     * потоке исполнения.
     */
    default void start() {
        /*
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Action.this.run();
                Action.this.close();
            }
        });
        */
        try {
            Thread thread = new Thread(() -> {run(); close();});
            thread.start();
        } catch (Exception e) {
            
        }
    }
    
}
