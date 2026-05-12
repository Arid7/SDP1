// Celso Paim em Marco/2026
// Applet que recebe 2 numeros, faz a sua validacao e determina as operacoes aritmeticas

import java.awt.Graphics;
import javax.swing.*;

public class OpsAritmeticasApplet extends JApplet {
    double num1, num2, soma, sub, mult, div, mod;
  
    public void init() { 
	do {
            try {
                num1 = Double.parseDouble( JOptionPane.showInputDialog( "Introduza o primeiro numero real" ) ); 
                break;
            } 
            catch ( NumberFormatException e ) {
                JOptionPane.showMessageDialog( null, "O operando deve ser um numero real!", "Aviso", JOptionPane.WARNING_MESSAGE );
            }
        } 
        while ( true );
        
        do {
            try {
                num2 = Double.parseDouble( JOptionPane.showInputDialog( "Introduza o segundo numero real" ) );
                if( num2 == 0 )
                    JOptionPane.showMessageDialog( null, "O 2.º operando nao pode ser nulo!", "Erro", JOptionPane.ERROR_MESSAGE );
	        else
                    break;
	    }
	    catch( NumberFormatException ex ) {
                JOptionPane.showMessageDialog( null, "O operando deve ser um numero real!", "Aviso", JOptionPane.WARNING_MESSAGE );
	    }
	}
	while ( true );

	soma = num1 + num2;
	sub = num1 - num2;
        mult = num1 * num2; 
	div = num1 / num2;
	mod = num1 % num2;        
    } 

    public void paint( Graphics g ) {
        super.paint( g );
        g.drawRect( 15, 10, 90, 90 );
        g.drawString( num1 + " + " + num2 + " = " + soma, 25, 25 );
        g.drawString( num1 + " - " + num2 + " = " + sub, 25, 40 );
        g.drawString( num1 + " x " + num2 + " = " + mult, 25, 55 );
        g.drawString( num1 + " : " + num2 + " = " + div, 25, 70 );
        g.drawString( num1 + " % " + num2 + " = " + mod, 25, 85 );
    } 
} 

