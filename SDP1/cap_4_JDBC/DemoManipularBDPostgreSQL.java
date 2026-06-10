// Autor: Celso Paim 
// Data: Maio/2026
// Objectivo: inserir um registo e mostrar o conteudo uma tabela de uma BD PostgreSQL

import java.sql.*;

public class DemoManipularBDPostgreSQL {
    public static void main( String[] args ) throws Exception {
        
        final String URL = "jdbc:postgresql://localhost:5432/livros";
        final String USER = "postgres";                     //pratica pouco segura
        final String PASSWD = "ifsadmin";                   //pratica pouco segura
    
        Connection conexao = DriverManager.getConnection( URL, USER, PASSWD );
        lerTabelaAutores( conexao );
        
        System.out.println( "\nInserindo um novo registo na tabela..." );
        inserirAutor( conexao, 5, "Agostinho", "Netoo", new Date( 1924, 9, 17), 999 );
        
        lerTabelaAutores( conexao );
        
        conexao.close();
    }
    
    public static void lerTabelaAutores( Connection conexao ) {
        try {
            Statement stmt = conexao.createStatement();            
            String sqlQuery = "SELECT * FROM livro_schema.tb_autores ;";
            ResultSet rs = stmt.executeQuery( sqlQuery );

            System.out.println( "Tabela Autores\nID\tNome\tApelido\tData Nascimento\tTelefone" );
            while ( rs.next() ) {
                System.out.println( rs.getInt( "idAutor" ) + "\t" 
                    + rs.getString( "nomeAutor" ) + "\t"
                    + rs.getString( "apelidoAutor" ) + "\t"
                    + rs.getDate( "dataNasc" ) + "\t"
                    + rs.getInt( "telefone" ) );
            }
            rs.close();         
            stmt.close();
        }
        catch ( SQLException e ) {
            System.err.println( "Aconteceu um erro ao ler a tabela Autores: " + e.getMessage() );
        }      
    }
    
    public static void inserirAutor( Connection conexao, int id, String nome, String apel, Date data, int tel ) {
        try {
            String sqlQuery = "INSERT INTO livro_schema.tb_autores VALUES (?,?,?,?,?)";
            PreparedStatement ps = conexao.prepareStatement( sqlQuery );
            
            ps.setInt( 1, id );
            ps.setString( 2, nome );
            ps.setString( 3, apel );
            ps.setDate( 4, data );
            ps.setInt( 5, tel );
            
            int res = ps.executeUpdate();
            if ( res == 1 ) 
                System.out.println( "Registo inserido com sucesso!" );
            
            ps.close();         
        }
        catch ( SQLException e ) {
            System.err.println( "Aconteceu um erro ao inserir o registo na tabela: " + e.getMessage() );
        }      
    }
}
