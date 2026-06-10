// PacketReceivingThread.java							
// PacketReceivingThread listens for DatagramPackets containing	messages from a DeitelMessengerServer.														
									
import java.io.*;							
import java.net.*;							
import java.util.*;							
																	
public class PacketReceivingThread extends Thread {
    // MessageListener to whom messages should be delivered							
    private MessageListener messageListener;							
		 							
    // MulticastSocket for receiving broadcast messages							
    private MulticastSocket multicastSocket;							
		 							
    // InetAddress of group for messages							
    private InetAddress multicastGroup;							
									
    // flag for terminating PacketReceivingThread							
    private boolean keepListening = true;							
		 							
    // PacketReceivingThread constructor							
    public PacketReceivingThread( MessageListener listener ) {												
	super( "PacketReceivingThread" );					
	messageListener = listener;					
	try {					
            multicastSocket = new MulticastSocket( SocketMessengerConstants.MULTICAST_LISTENING_PORT );		
            multicastGroup = InetAddress.getByName( SocketMessengerConstants.MULTICAST_ADDRESS );					
            multicastSocket.joinGroup( multicastGroup ); 								
            multicastSocket.setSoTimeout( 5000 );				
	}					
        catch ( IOException ioException ) {					
            ioException.printStackTrace();				
	}					
    } // end PacketReceivingThread constructor							
		 							
    // listen for messages from multicast group 							
    public void run() {							
	while ( keepListening ) {					
            byte[] buffer = new byte[ SocketMessengerConstants.MESSAGE_SIZE ];		
            DatagramPacket packet = new DatagramPacket( buffer, SocketMessengerConstants.MESSAGE_SIZE );		
            try {				
		multicastSocket.receive( packet );		
            }								
            catch ( InterruptedIOException interruptedIOException ) {						
		continue;		
            }			
            catch ( IOException ioException ) {				
		ioException.printStackTrace();		
		break;		
            }				
									
            String message = new String( packet.getData() );				
            message = message.trim();				
			
            StringTokenizer tokenizer = new StringTokenizer( message, SocketMessengerConstants.MESSAGE_SEPARATOR ); 		
            if ( tokenizer.countTokens() == 2 ) 					
                messageListener.messageReceived( tokenizer.nextToken(), tokenizer.nextToken() );	
	} 						
							
	try {						
            multicastSocket.leaveGroup( multicastGroup );					
            multicastSocket.close();					
	}						
	catch ( IOException ioException ) { 						
            ioException.printStackTrace();					
	}						
    } // end method run								
	 								
    // stop listening for new messages								
    public void stopListening() {								
        keepListening = false;						
    }									
} // end class PacketReceivingThread							
