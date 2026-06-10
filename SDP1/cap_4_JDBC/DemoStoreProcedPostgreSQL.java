// Autor: Celso Paim 
// Data: Maio/2026
// Objectivo: invocar um stored procedure armazenado numa BD PostgreSQL

import java.sql.*;

public class DemoStoreProcedPostgreSQL {
    public static void main( String[] args ) {
        final String URL = "jdbc:postgresql://localhost:5432/livros";
        final String USER = "postgres";                     //pratica pouco segura
        final String PASSWD = "ifsadmin";                   //pratica pouco segura
        
        try (
            Connection conn = DriverManager.getConnection( URL, USER, PASSWD ) ) {
            
            // preparar a chamada do stored procedure
            String sqlQuery = "{call consultarAutor(?, ?)}";
            CallableStatement stmt = conn.prepareCall( sqlQuery );

            // definir o parametro de entrada (IN)
            stmt.setInt( 1, 1 );

            // registar o parâmetro de saída (OUT)
            stmt.registerOutParameter( 2, java.sql.Types.VARCHAR );

            // executar o stored procedure
            stmt.execute();

            // reecuperar o valor de saída
            String nome = stmt.getString( 2 );
            System.out.println( "Nome do Autor: " + nome );
    
            stmt.close();
        } 
        catch ( SQLException e ) {
            System.err.println( "Aconteceu um erro ao invocar o stored procedure: " + e.getMessage() );

        }    
    }
}