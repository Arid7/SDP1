// SynchronizedBuffer.java
// Autores: Deitel & Deitel
// SynchronizedBuffer synchronizes access to a single shared integer.

public class SynchronizedBuffer implements Buffer {
    private int buffer = -1; // shared by producer and consumer threads
    private int occupiedBufferCount = 0; // count of occupied buffers
    
    // place value into buffer
    public synchronized void set( int value ) {
        // for output purposes, get name of thread that called this method
        String name = Thread.currentThread().getName();
        
        // while there are no empty locations, place thread in waiting state
        while ( occupiedBufferCount == 1 ) {
            // output thread information and buffer information, then wait
            try {
                System.err.println( name + " tries to write." );
                displayState( "Buffer full. " + name + " waits." );
                wait();
            }
            catch ( InterruptedException exception ) {
                exception.printStackTrace();
            }
        } // end while            
        
        buffer = value; // set new buffer value
        // indicate producer cannot store another value until consumer retrieves current buffer value
        ++occupiedBufferCount;
        
        displayState( name + " writes " + buffer );
        notify(); // tell waiting thread to enter ready state
    } // end method set and releases lock on SynchronizedBuffer 

    // return value from buffer
    public synchronized int get() {
        // for output purposes, get name of thread that called this method
        String name = Thread.currentThread().getName();
        
        // while no data to read, place thread in waiting state
        while ( occupiedBufferCount == 0 ) {
            // output thread information and buffer information, then wait
            try {
                System.err.println( name + " tries to read." );
                displayState( "Buffer empty. " + name + " waits." );
                wait();
            }
            catch ( InterruptedException exception ) {
                exception.printStackTrace();
            }  
        } 

        // indicate that producer can store another value because consumer just retrieved buffer value
        --occupiedBufferCount;
        
        displayState( name + " reads " + buffer );
        notify(); // tell waiting thread to become ready to execute
        return buffer;
    } // end method get and releases lock on SynchronizedBuffer 

    // display current operation and buffer state
    public void displayState( String operation ) {
        StringBuffer outputLine = new StringBuffer( operation );
        outputLine.setLength( 40 );
        outputLine.append( buffer + "\t\t" + occupiedBufferCount );
        System.err.println( outputLine );
        System.err.println();
    }
} // end class SynchronizedBuffer


