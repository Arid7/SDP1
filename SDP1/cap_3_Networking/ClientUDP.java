// Autor: Celso Paim
// Data: Abril/2026
// Objectivo: executar um cliente que se conectara a um servidor com UDP e enviar uma msg

import java.net.*;

public class ClientUDP {
    public static void main( String[] args ) {
        try {
            DatagramSocket socket = new DatagramSocket();
            String msg = "Ola server UDP !";
            byte[] buffer = msg.getBytes();
            InetAddress server_IP = InetAddress.getByName( "localhost" );
            int server_port = 12345;
            DatagramPacket packet = new DatagramPacket( buffer, buffer.length, server_IP, server_port );
            socket.send( packet );
            System.out.println( "Mensagem enviada ao servidor" );
        } 
        catch ( Exception e ) {
            e.printStackTrace();
        }
    }    
}