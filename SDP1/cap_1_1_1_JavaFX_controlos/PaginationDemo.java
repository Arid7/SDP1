/*
  Autor: Celso Paim
  Data: Novembro/2025
  Prog_137: app JavaFX para utilizar um controlo Pagination
*/

package edu.livrofundamentos.exemplos.cap4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PaginationDemo extends Application { 
    @Override
    public void start( Stage primaryStage ) {
        Pagination pagination = new Pagination();
        pagination.setPageCount( 5 );
        pagination.setCurrentPageIndex( 2 );
        pagination.setMaxPageIndicatorCount( 3 );

        pagination.setPageFactory( ( pageIndex ) -> {
            Label label1 = new Label( "Poema 'A vida deve ser bebida' (Mia Couto) " );
            label1.setFont( new Font( "Arial", 12 ) );
            
            TextArea area = new TextArea();
            area.setText( lerEstrofe ( pageIndex ) );
            return new VBox( label1, area );
        });

        VBox vbox = new VBox( pagination );
        
        Scene scene = new Scene( vbox, 300, 200 );

        primaryStage.setTitle( "Testar Pagination" );  
        primaryStage.setScene( scene );  
        primaryStage.show();  
    }
    
    public String lerEstrofe( int num ) {
        String res = ( num + 1 ) + ".ª ESTROFE\n\n";
        switch( num ) {
            case 0: res += "Estou\nE num breve instante\nSinto tudo\nSinto-me tudo"; 
                break;
            case 1: res += "Deito-me no meu corpo\nE despeco-me de mim\nPara me ";
                res += "encontrar\nNo proximo olhar"; 
                break;
            case 2: res += "Ausento-me da morte\nnao quero nada\neu sou tudo\n";
                res += "respiro-me ate a exaustao";
                break;
            case 3: res += "Nada me alimenta\nporque sou feito de todas as coisas";
                res += "\ne adormeco onde tombam a luz e a poeira";
                break;
            case 4: res += "A vida (ensinaram-me assim)\nDeve ser bebida";
                break;
        }
        return res;
    }
    
    public static void main(String[] args) {
        launch( args );
    }
}
    