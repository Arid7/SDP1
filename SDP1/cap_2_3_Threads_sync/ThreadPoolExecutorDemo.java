// Autor: Celso Paim, adaptado de Pranav Tiwari
// Data: Marco/2026
// Objectivo: demonstrar o uso de um ScheduledExecutorService que executa uma vez

import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            2,  // core pool
            4,  // max pool 
            1,  // keepalive time
            TimeUnit.SECONDS,  
            new LinkedBlockingQueue<>()  // queue de tarefas
        );

        // submeter 5 tarefas ao executor
        for( int i = 1; i <= 5; i++ ) {
            final int taskId = i;
            executor.execute(() -> {
                System.out.println( "Tarefa " + taskId + " a ser executada pela " + Thread.currentThread().getName());
                try {
                    Thread.sleep( 1000 );  
                } 
                catch ( InterruptedException e ) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Tarefa " + taskId + " completada pela " + Thread.currentThread().getName());
            });
        }

        executor.shutdown();
    }
}