// Autor: Celso Paim, adaptado de Tafseer Mannan
// Data: Marco/2026
// Objectivo: demonstrar o uso de um ScheduledExecutorService que executa uma vez

import java.util.concurrent.*;

public class ScheduledExecutorRunnable {
    public static void main(String[] args) {

        ScheduledExecutorService ses = Executors.newScheduledThreadPool( 1 );

        Runnable task2 = () -> System.out.println( "Executando a tarefa 2..." );

        task1();

        ses.schedule( task2, 5, TimeUnit.SECONDS );

        task3();

        ses.shutdown();
    }

    public static void task1() {
        System.out.println( "Executando a tarefa 1..." );
    }

    public static void task3() {
        System.out.println( "Executando a tarefa 3..." );
    }
}
