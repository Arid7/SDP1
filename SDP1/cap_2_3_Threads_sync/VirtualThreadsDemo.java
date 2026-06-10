// Autor: Celso Paim, adaptado de Pablo Ruiz 
// Data: Marco/2026
// Objectivo: demonstrar o uso de vitual threads (so funciona com Java 21 ou superior)

public class VirtualThreadsDemo {

    public static void main( String[] args ) throws InterruptedException {
        Counter count = new Counter();

        Runnable tarefa = () -> {
            for( int i = 0; i < 1000; i++ ) {
                count.increment();
            }
        };

        Thread t1 = Thread.startVirtualThread( tarefa );
        Thread t2 = Thread.startVirtualThread( tarefa );

        t1.join();
        t2.join();

        System.out.println( "Valor final do count =" + count.getCount());
    }
}

class Counter {
    private int count = 0;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}