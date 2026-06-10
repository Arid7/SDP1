// Autor: Celso Paim
// Data: Abril/2026
// Objectivo: fazer a traducao de um hostname no seu IP e o reverso

import java.net.InetAddress;
import java.net.UnknownHostException;

public class DNSResolver {
    public static void main(String[] args) {
        try {
            // resolver o nome para um endereco IP
            String hostname = "unitel.co.ao";            
            InetAddress address = InetAddress.getByName( hostname );
            System.out.println( "### Resolucao DNS\n\tHostname: " + hostname );
            System.out.println( "\tIP: " + address.getHostAddress() );
            
            // fazer resolucao reversa (endereco IP para hostname)
            String IP = "8.8.8.8"; 
            address = InetAddress.getByName( IP );
            System.out.println( "\n\n### Resolucao Reversa\n\tIP: " + IP );
            System.out.println( "\tHostname: " + address.getHostName() );
        } 
        catch ( UnknownHostException e ) {
            System.err.println("Não foi possível resolver o host: " + e.getMessage());
        }
    }
}