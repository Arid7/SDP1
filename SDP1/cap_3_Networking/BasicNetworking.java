// Autor: Celso Paim
// Data: Abril/2026
// Objectivo: pegar o IP e o MAC address do NIC activo e mostrar no ecra

import java.net.*;

public class BasicNetworking {
    public static void main (String args[]) { 
        try {
            InetAddress localhost = InetAddress.getLocalHost();
            System.out.println( "Endereco IP: " + localhost.getHostAddress().trim() );
                        
            NetworkInterface ni = NetworkInterface.getByInetAddress( localhost );           
            byte[] macAddress = ni.getHardwareAddress();
            String[] macAddressHexa = new String[ macAddress.length ];
            for (int i = 0; i < macAddress.length; i++ ) 
                macAddressHexa[ i ] = String.format( "%02X", macAddress[ i ] );        
            System.out.println( "Endereco MAC: " + String.join( "-", macAddressHexa ) );            
        }
        catch( Exception ex ) {
            ex.printStackTrace();        
        }        
    }
}