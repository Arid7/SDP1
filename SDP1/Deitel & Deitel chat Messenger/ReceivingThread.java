// ReceivingThread.java									
// ReceivingThread is a Thread that listens for messages from a particular client and delivers messages to a MessageListener.																		
											
import java.io.*;									
import java.net.*;									
import java.util.StringTokenizer;																		
											
public class ReceivingThread extends Thread {										
    private BufferedReader input;									
    private MessageListener messageListener;									
    private boolean keepListening = true;									
		 									
    // ReceivingThread constructor									
    public ReceivingThread( MessageListener listener, Socket clientSocket ) {																
        super( "ReceivingThread: " + clientSocket );													
        messageListener = listener;							
											
	// set timeout for reading from clientSocket and create	BufferedReader for reading incoming messages							
	try {				 			
            clientSocket.setSoTimeout( 5000 );						
            input = new BufferedReader( new InputStreamReader( clientSocket.getInputStream() ) );				
	}							
        catch ( IOException ioException ) {							
            ioException.printStackTrace();						
	}							
    } // end ReceivingThread constructor									
		 									
    // listen for new messages and deliver them to MessageListener									
    public void run() {									
        String message;							
        // listen for messages until stopped							
	while ( keepListening ) {	 						
            // read message from BufferedReader						
            try {						
                message = input.readLine();				
            }											
            catch ( InterruptedIOException interruptedIOException ) {											
                // continue to next iteration to keep listening			 	
		continue;				
            }											
            catch ( IOException ioException ) {						
		ioException.printStackTrace();				
		break;				
            }						
											
            // ensure non-null message						
            if ( message != null ) {						
                // tokenize message to retrieve user name and message body				
		StringTokenizer tokenizer = new StringTokenizer( message, SocketMessengerConstants.MESSAGE_SEPARATOR ); 			
											
		// ignore messages that do not contain a username and message body				
		if ( tokenizer.countTokens() == 2 ) 				
                     // send message to MessageListener			
                    messageListener.messageReceived( tokenizer.nextToken(), tokenizer.nextToken() ); 	
		else				
                    // if disconnect message received, stop listening 			
                    if ( message.equalsIgnoreCase( SocketMessengerConstants.MESSAGE_SEPARATOR +	SocketMessengerConstants.DISCONNECT_STRING ) ) 	
                        stopListening();											
            } 					
	} // end while							
											
	// close BufferedReader (also closes Socket)							
	try {				 			
            input.close();							
	}								
	catch ( IOException ioException ) {			
            ioException.printStackTrace();		 					
	}									
    } // end method run										
	 										
     // stop listening for incoming messages										
    public void stopListening() {										
        keepListening = false;								
    }										
} // end class ReceivingThread											
