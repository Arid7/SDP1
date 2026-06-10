// SendingThread.java						
// SendingThread sends a message to the chat server in a separate Thread.						

import java.io.*;						
import java.net.*;						

public class SendingThread extends Thread {							
    // Socket over which to send message						
    private Socket clientSocket;						
    private String messageToSend;						
							
    // SendingThread constructor						
    public SendingThread( Socket socket, String userName, String message ) {						
        // invoke superclass constructor to name Thread				
        super( "SendingThread: " + socket );				
        clientSocket = socket;				
							
        // build the message to be sent				
        messageToSend = userName + SocketMessengerConstants.MESSAGE_SEPARATOR + message ;			
    }						
	 						
    // send message and exit Thread					
    public void run() {						
        // send message and flush PrintWriter				
        try {		 		
            PrintWriter writer = new PrintWriter( clientSocket.getOutputStream() );	
            writer.println( messageToSend );			
            writer.flush();			
	} 								
	catch ( IOException ioException ) {				
            ioException.printStackTrace();			
	}				
    } 					
} // end class 							
