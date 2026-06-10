// Autor: Celso Paim
// Data: Abril/2026
// Objectivo: executar um servidor que ouvira conexoes UDP e mostrar as msgs recebidas

import java.net.*;

public class ServerUDP {
    public static void main(String[] args) {
        try {
            int port = 12345;
            DatagramSocket socket = new DatagramSocket( port );
            byte[] buffer = new byte[ 1024 ];
            DatagramPacket packet = new DatagramPacket( buffer, buffer.length );
            socket.receive( packet );
            String msg = new String( packet.getData(), 0, packet.getLength() );
            System.out.println( "Recebida a mensagem: " + msg );
        } 
        catch ( Exception e ) {
            e.printStackTrace();
        }
    }    
}
