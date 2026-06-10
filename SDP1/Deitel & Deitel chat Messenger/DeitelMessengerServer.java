// DeitelMessengerServer.java								
// DeitelMessengerServer is a multi-threaded, socket- and packet-based chat server.																

import java.net.*;								
import java.io.*;								

public class DeitelMessengerServer implements MessageListener {																
    public void startServer() {								
        // create server and manage new clients						
        try {						
            ServerSocket serverSocket = new ServerSocket( SocketMessengerConstants.SERVER_PORT, 100 );			
            System.out.println( "Server listening on port " + 					
            SocketMessengerConstants.SERVER_PORT + " ..." );			
            
            while ( true ) {					
                Socket clientSocket = serverSocket.accept();			
		new ReceivingThread( this, clientSocket ).start();			
		System.out.println( "Connection received from: " + clientSocket.getInetAddress() );		
            } 		 			
	} 												
	catch ( IOException ioException ) {						
            ioException.printStackTrace();					
	}						
    } // end method startServer								
	 								
    // when new message is received, broadcast message to clients								
    public void messageReceived( String from, String message ) {														
        String completeMessage = from + SocketMessengerConstants.MESSAGE_SEPARATOR + message;					
	new MulticastSendingThread( completeMessage.getBytes() ).start();						
    }	 							
	 								
    public static void main ( String args[] ) {								
        new DeitelMessengerServer().startServer();						
    }					
} // end class DeitelMessengerServer									
