// Autor: Celso Paim
// Data: Abril/2026
// Objectivo: executar um cliente que se conectara a um servidor e enviar uma msg

import java.io.*;
import java.net.*;

public class Client {
    public static void main( String[] args ) {
        try {
            String server_IP = "localhost";
            int server_port = 12345;
            Socket socket = new Socket( server_IP, server_port );
            
            BufferedReader input = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
            PrintWriter output = new PrintWriter( socket.getOutputStream(), true ); 
        
            output.println( "Ola Server!" );
            
            System.out.println( input.readLine() );
        } 
        catch ( Exception e) {
            e.printStackTrace();
        }
    }
}