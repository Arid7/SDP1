// SocketMessageManager.java
// SocketMessageManager communicates with a DeitelMessengerServer using Sockets and MulticastSockets.

import java.net.*;
import java.io.*;

public class SocketMessageManager implements MessageManager {
    private Socket clientSocket;
    private String serverAddress; 
    private PacketReceivingThread receivingThread;
    private boolean connected = false;
							
    public SocketMessageManager( String address ) {								
        serverAddress = address;						
    }								
		 																
    public void connect( MessageListener listener ) {								
	// if already connected, return immediately						
        if ( connected )						
            return;					
										
	// open Socket connection to DeitelMessengerServer						
	try {						
            clientSocket = new Socket( InetAddress.getByName( serverAddress ), SocketMessengerConstants.SERVER_PORT );			
		
            receivingThread = new PacketReceivingThread( listener );					
            receivingThread.start();					
					 					
            connected = true;					
	} 												
	catch ( IOException ioException ) {						
            ioException.printStackTrace();					
	}
    } // end method connect								
		 								
    // disconnect from server and unregister given MessageListener								
    public void disconnect( MessageListener listener ) {								
	// if not connected, return immediately						
        if ( ! connected )						
            return;					
										
        // stop listening thread and disconnect from server						
	try {		 				
            // notify server that client is disconnecting					
            Thread disconnectThread = new SendingThread( clientSocket, "", SocketMessengerConstants.DISCONNECT_STRING );			
            disconnectThread.start();					
            disconnectThread.join( 10000 );					
            receivingThread.stopListening();					
            clientSocket.close(); 					
	} // end try						
	catch ( IOException ioException ) {						
            ioException.printStackTrace();					
        }						
	catch ( InterruptedException interruptedException ) {						
            interruptedException.printStackTrace();					
	}												
        connected = false;									
    } // end method disconnect									
	 									
    // send message to server									
    public void sendMessage( String from, String message ) {									
        // if not connected, return immediately							
	if ( ! connected )							
            return;					
        new SendingThread( clientSocket, from, message ).start();							
    }									
} // end method SocketMessageManager										
