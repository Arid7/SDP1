/* 
Autor: Celso Paim 
Data: Novembro/2025
Prog_177: Implementar um relogio digital com uma thread
*/
 
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;  
import javax.swing.*;  
	 
public class RelogioDigital extends JFrame {          
	private JLabel horaLabel;
	  
	public RelogioDigital() {  
	        super( "Relogio digital" );  
	        Container container = getContentPane();
                container.setLayout( new FlowLayout() );
	        horaLabel = new JLabel();
                horaLabel.setFont( new Font("Times New Roman", Font.BOLD, 50 ) );
	        container.add( horaLabel );        
	        setSize( 240, 150 );   
	        setVisible( true ); 
	    }    
	    
	    public void setHora( String str ) { horaLabel.setText( str ); }
	 
	    public static void main(String[] args) {  
	        RelogioDigital relogio = new RelogioDigital(); 
	        new Thread() {
	            public void run() {
	                try {  
	                    while( true ) {  
	                        Calendar cal = Calendar.getInstance();  
	                        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");  
	                        Date date = cal.getTime();  
	                        String horaStr = formatter.format( date );
	                        relogio.setHora( horaStr );
	                        this.sleep( 1000 );
	                    }  
	                }  
	                catch ( Exception ex ) { }
	            }
	        }.start();      
	    }  
} 
