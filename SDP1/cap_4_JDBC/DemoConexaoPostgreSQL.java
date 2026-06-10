// Autor: Celso Paim 
// Data: Maio/2026
// Objectivo: efectuar uma conexao a um servidor de BD PostgreSQL

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DemoConexaoPostgreSQL {
    public static void main( String[] args ) {
        final String URL = "jdbc:postgresql://localhost:5432/livros";
        final String USER = "postgres";                     //pratica pouco segura
        final String PASSWD = "ifsadmin";                   //pratica pouco segura
        
        try {
            Class.forName( "org.postgresql.Driver" );
            Connection conexao = DriverManager.getConnection( URL, USER, PASSWD );
            System.out.println( "Conexao estabelecida com sucesso" ); 
            conexao.close();
        }
        catch ( ClassNotFoundException e ) {
            System.err.println( "Aconteceu um erro ao localizar o driver: " + e.getMessage() );
        }
        catch ( SQLException e ) {
            System.err.println( "Aconteceu um erro ao conectar: " + e.getMessage() );
        }
    }
}