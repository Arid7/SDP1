// ClientGUI.java							
// ClientGUI provides a user interface for sending and receiving messages to and from the DeitelMessengerServer.							
														
import java.awt.*;							
import java.awt.event.*;							
import javax.swing.*;								
import javax.swing.border.*;								
									
public class ClientGUI extends JFrame { 							
    private JMenu serverMenu;	
    private JMenuItem connectMenuItem, disconnectMenuItem;
    private JTextArea messageArea, inputArea;	 						
    private JButton connectButton, disconnectButton, sendButton;
    private JLabel statusBar;
    private String userName;							
    private MessageManager messageManager;				 			
    private MessageListener messageListener;							
	 															
    public ClientGUI( MessageManager manager ) {			 				
	super( "Deitel Messenger" );										
            messageManager = manager;					
            messageListener = new MyMessageListener();					
									
            serverMenu = new JMenu ( "Server" );	 				
            serverMenu.setMnemonic( 'S' );					
            JMenuBar menuBar = new JMenuBar();					
            menuBar.add( serverMenu );					
            setJMenuBar( menuBar );					
														
            connectButton = new JButton( "Connect" );					
            connectMenuItem = new JMenuItem( "Connect" );					
            connectMenuItem.setMnemonic( 'C' );					
													
            ActionListener connectListener = new ConnectListener();					
            connectButton.addActionListener( connectListener );					
            connectMenuItem.addActionListener( connectListener ); 					
						
            disconnectButton = new JButton( "Disconnect" ); 					
            disconnectMenuItem = new JMenuItem( "Disconnect" ); 					
            disconnectMenuItem.setMnemonic( 'D' );													
            disconnectButton.setEnabled( false );					
            disconnectMenuItem.setEnabled( false );					
									
            ActionListener disconnectListener = new DisconnectListener();					
            disconnectButton.addActionListener( disconnectListener );					
            disconnectMenuItem.addActionListener( disconnectListener );					
            
            serverMenu.add( connectMenuItem );					
            serverMenu.add( disconnectMenuItem );					 
					
            JPanel buttonPanel = new JPanel();					
            buttonPanel.add( connectButton );					
            buttonPanel.add( disconnectButton );						

            messageArea = new JTextArea();												
            messageArea.setEditable( false );						
            messageArea.setWrapStyleWord( true );						
            messageArea.setLineWrap( true );						
														
            JPanel messagePanel = new JPanel();						
            messagePanel.setLayout( new BorderLayout( 10, 10 ) );						
            messagePanel.add( new JScrollPane( messageArea ), 						
            BorderLayout.CENTER );					
							
            inputArea = new JTextArea( 4, 20 );						
            inputArea.setWrapStyleWord( true );						
            inputArea.setLineWrap( true );						
            inputArea.setEditable( false );						
            
            sendButton = new JButton( "Send" ); //, sendIcon );						
            sendButton.setEnabled( false );						
            sendButton.addActionListener(						
                new ActionListener() {								
                    public void actionPerformed( ActionEvent event ) {			
			messageManager.sendMessage( userName, inputArea.getText() );		
                        inputArea.setText( "" );		
                    }			
                }					
            );						
															
            Box box = new Box( BoxLayout.X_AXIS );						
            box.add( new JScrollPane( inputArea ) );						
            box.add( sendButton );						
            messagePanel.add( box, BorderLayout.SOUTH );						
            
            statusBar = new JLabel( "Not Connected" );						
            statusBar.setBorder( new BevelBorder( BevelBorder.LOWERED ) );						
														
            Container container = getContentPane();						
            container.add( buttonPanel, BorderLayout.NORTH );						
            container.add( messagePanel, BorderLayout.CENTER );						
            container.add( statusBar, BorderLayout.SOUTH );						
				
            addWindowListener ( 						
                new WindowAdapter () {							
                    public void windowClosing ( WindowEvent event ) {			
			messageManager.disconnect( messageListener );		
			System.exit( 0 );		
                    }			
		}					
            );									
	} // end ClientGUI constructor								
	 								
	// ConnectListener listens for user requests to connect to server								
	private class ConnectListener implements ActionListener {	
            public void actionPerformed( ActionEvent event ) {											
                messageManager.connect( messageListener );								
		
                userName = JOptionPane.showInputDialog( ClientGUI.this, "Enter user name:" );							
		
                messageArea.setText( "" );					
		connectButton.setEnabled( false );					
		connectMenuItem.setEnabled( false );					
		disconnectButton.setEnabled( true );					
		disconnectMenuItem.setEnabled( true );					
		sendButton.setEnabled( true );					
		inputArea.setEditable( true );					
		inputArea.requestFocus();					
		statusBar.setText( "Connected: " + userName ); 					
            }									
	} // end ConnectListener inner class								
	 								
	// DisconnectListener listens for user requests to disconnect from DeitelMessengerServer								
	private class DisconnectListener implements ActionListener {								
            public void actionPerformed( ActionEvent event ) {						
		messageManager.disconnect( messageListener );					
									
		sendButton.setEnabled( false );					
		disconnectButton.setEnabled( false );					
		disconnectMenuItem.setEnabled( false );					
		inputArea.setEditable( false );					
		connectButton.setEnabled( true );				 	
		connectMenuItem.setEnabled( true );					
		statusBar.setText( "Not Connected" );				 	
            }									
	 } // end DisconnectListener inner class								
	 								
	 // MyMessageListener listens for new messages from MessageManager and 								
	 // displays messages in messageArea using MessageDisplayer.								
	 private class MyMessageListener implements MessageListener {								
            public void messageReceived( String from, String message ) {						
                // append message using MessageDisplayer and invokeLater, ensuring thread-safe access messageArea					
		SwingUtilities.invokeLater( new MessageDisplayer( from, message ) );			
            }						
	 }								
	 								
	 // MessageDisplayer displays a new message by appending the message to 								
	 // the messageArea JTextArea. This Runnable object should be executed 								
	 // only on the Event thread, because it modifies a live Swing component								
	 private class MessageDisplayer implements Runnable {								
            private String fromUser;						
            private String messageBody;						
									
            public MessageDisplayer( String from, String body )	{						
		fromUser = from;					
		messageBody = body;					
            }						
															
            public void run() {										
                messageArea.append( "\n" + fromUser + "> " + messageBody );
                messageArea.setCaretPosition( messageArea.getText().length() );					
            }												
	 } // end MessageDisplayer inner class												
} // end class ClientGUI						
