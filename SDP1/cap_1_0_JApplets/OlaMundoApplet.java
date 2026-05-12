// Celso Paim em Marco/2026
// Exemplo de applet em Java

import java.awt.Graphics; 
import javax.swing.JApplet;

public class OlaMundoApplet extends JApplet {
    public void paint( Graphics g ) {                                                                      
        super.paint( g );                                      
        g.drawString( "Ola Mundo!", 25, 25 );
        g.drawString( "Esta foi a minha primeira applet em Java...", 25, 45 );                                                               
    }     
}