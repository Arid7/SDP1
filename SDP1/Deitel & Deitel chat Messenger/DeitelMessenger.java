// DeitelMessenger.java						
// DeitelMessenger is a chat application that uses a ClientGUI						
// and SocketMessageManager to communicate with DeitelMessengerServer.												
							
public class DeitelMessenger {						
		 					
    public static void main( String args[] ) {						
	MessageManager messageManager;				
							
	// create new DeitelMessenger				
	if ( args.length == 0 )				
            messageManager = new SocketMessageManager( "localhost" );			
	else				
            messageManager = new SocketMessageManager( args[ 0 ] );			
							
	// create GUI for SocketMessageManager				
	ClientGUI clientGUI = new ClientGUI( messageManager );				
	clientGUI.setSize( 300, 400 );				
	clientGUI.setResizable( false );				
	clientGUI.setVisible( true );				
    }							
} // end class DeitelMessenger							