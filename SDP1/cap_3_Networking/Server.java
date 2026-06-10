// Autor: Celso Paim
// Data: Abril/2026
// Objectivo: executar um servidor que ouvira conexoes TCP e mostrar as msgs recebidas

import java.io.*;
import java.net.*;

public class Server {
    public static void main( String[] args ) {
        try {
            int port = 12345;
            ServerSocket serverSocket = new ServerSocket( port );
            System.out.println( "Servidor iniciado, aguardando por conexoes..." );
            
            Socket clientSocket = serverSocket.accept(); // esperando conexoes de clientes            
            BufferedReader input = new BufferedReader( new InputStreamReader( clientSocket.getInputStream() ) );
            
            PrintWriter output = new PrintWriter( clientSocket.getOutputStream(), true );
            String msg = input.readLine();
            System.out.println( "Mensagem recebida a partir do cliente: " + msg );
            output.println( "Servidor confirma que recebeu a mensagem: " + msg );
        } 
        catch ( IOException e ) {
            e.printStackTrace();
        }
    }
}
