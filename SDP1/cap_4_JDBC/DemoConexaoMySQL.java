// Autor: Celso Paim 
// Data: Maio/2026
// Objectivo: efectuar uma conexao a um servidor de BD MySQL

import java.sql.*;

public class DemoConexaoMySQL {
    public static void main( String[] args ) {
        final String URL = "jdbc:mysql://localhost:3306/livrosbd";
        final String USER = "root";                    //pratica pouco segura 
        final String PASSWD = "dbDoctor7";             //pratica pouco segura 
        
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
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
