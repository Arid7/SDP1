// Autor: Celso Paim 
// Data: Jan/2026
// Demonstrar o uso de multiplas threads em tempos diferentes
      
package edu;

public class ThreadTester {
    
    public static void main( String [] args ) {
        // criar e nomear as threads
        PrintThread thread1 = new PrintThread( "thread_APLHA" );
        PrintThread thread2 = new PrintThread( "thread_BETA" );
        PrintThread thread3 = new PrintThread( "thread_GAMA" );
        
        System.out.println( "Iniciando as threads" );
        thread1.start(); 
        thread2.start(); 
        thread3.start(); 
        
        System.out.println( "Inciadas as threads, termino das instrucoes do main" );
    }
} // fim da classe ThreadTester

// classe PrintThread               
class PrintThread extends Thread {                           
    private int sleepTime;                                    

    public PrintThread( String name ) {
        super( name );
        sleepTime = ( int ) ( Math.random() * 5001 );
    }        
        
    public void run() {                                                              
        try {                                                   
            System.out.println( getName() + " vai adormecer " + sleepTime +  " ms" ); 
            Thread.sleep( sleepTime );                           
        }                                                       
        catch ( InterruptedException exception ) {              
            exception.printStackTrace();                         
        }                                                                                          
        System.out.println( getName() + " acordou..." );                                                                      
    }                                         
} 