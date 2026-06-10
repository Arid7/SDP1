// MulticastSendingThread.java						
// MulticastSendingThread is a Thread that broadcasts a chat message using a multicast datagram.						

import java.io.*;						
import java.net.*;						

public class MulticastSendingThread extends Thread {					
	private byte[] messageBytes;						
	 											
	public MulticastSendingThread( byte[] bytes ) { 										
            super( "MulticastSendingThread" );				
            messageBytes = bytes; 				
        }						
							
	// deliver message to MULTICAST_ADDRESS over DatagramSocket						
	public void run() {										
            try {				 
                DatagramSocket socket = new DatagramSocket( SocketMessengerConstants.MULTICAST_SENDING_PORT );	
		
                InetAddress group = InetAddress.getByName( SocketMessengerConstants.MULTICAST_ADDRESS );	
					
		DatagramPacket packet = new DatagramPacket( messageBytes, 			
						messageBytes.length, 
                                                group,	
						SocketMessengerConstants.MULTICAST_LISTENING_PORT );	 
				 						
		socket.send( packet );			
		socket.close();			
            } 				
            catch ( IOException ioException ) { 				
                ioException.printStackTrace();			
            }				
	 } // end method run					
} // end class MulticastSendingThread							
