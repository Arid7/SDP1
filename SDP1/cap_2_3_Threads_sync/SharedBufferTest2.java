// SharedBufferTest2.java
// Autores: Deitel & Deitel
// SharedBufferTest2creates producer and consumer threads.

public class SharedBufferTest2 {
    public static void main( String [] args ) {
        // create shared object used by threads; we use a SynchronizedBuffer
        // reference rather than a Buffer reference so we can invoke 
        // SynchronizedBuffer method displayState from main
        SynchronizedBuffer sharedLocation = new SynchronizedBuffer();
        
        // Display column heads for output
        StringBuffer columnHeads = new StringBuffer( "Operation" );
        columnHeads.setLength( 40 );
        columnHeads.append( "Buffer\t\tOccupied Count" );
        System.err.println( columnHeads );
        System.err.println();
        sharedLocation.displayState( "Initial State" );
        
        // create producer and consumer objects
        Producer producer = new Producer( sharedLocation );
        Consumer consumer = new Consumer( sharedLocation );
        producer.start();  // start producer thread
        consumer.start();  // start consumer thread       
    } 
} 