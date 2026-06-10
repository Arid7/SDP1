// Autor: Celso Paim 
// Data: Jan/2026
// Demonstrar o uso de prioridades numa thread

public class ThreadTestPriority {
    public static void main( String[] args ){
        Thread r = Thread.currentThread();
        r.setPriority( Thread.MAX_PRIORITY );
        NewThread highPrioThread = new NewThread( Thread.MAX_PRIORITY );
        NewThread lowPrioThread = new NewThread( Thread.MIN_PRIORITY );
        
        lowPrioThread.start();
        highPrioThread.start();
        
        try {
            r.sleep( 5000 );
        }
        catch( InterruptedException ex ) {
            ex.printStackTrace(); 
        }
        highPrioThread.interrupt();
        lowPrioThread.interrupt();

        System.out.println( "qtas vezes a HIGH foi processada = " + highPrioThread.counter );
        System.out.println( "qtas vezes a LOW foi processada = " + lowPrioThread.counter );
    }
}

class NewThread extends Thread{
    long counter = 0;

    NewThread( int p ) {
        setPriority( p );
    }
    
    public void run() {
        while( true ) {
            counter++;
        }
    }
}
