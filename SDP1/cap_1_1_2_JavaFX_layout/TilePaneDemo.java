/*
  Autor: Celso Paim
  Data: Novembro/2025
  Arrumar um layout de JavaFX com TilePane
*/
package edu.livrofundamentos.exemplos.cap4;

import javafx.application.Application;  
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;  
 
public class TilePaneDemo extends Application {    
    @Override  
    public void start( Stage primaryStage ) throws Exception {         
        Button botao1 = new Button( "Botao 1" );  
        Button botao2 = new Button( "Botao 2" ); 
        Button botao3 = new Button( "Botao 3" ); 
        Button botao4 = new Button( "Botao 4" );  
        Button botao5 = new Button( "Botao 5" ); 
        Button botao6 = new Button( "Botao 6" );
        
        TilePane root = new TilePane();
        root.getChildren().add( botao1 );
        root.getChildren().add( botao2 );
        root.getChildren().add( botao3 );
        root.getChildren().add( botao4 );
        root.getChildren().add( botao5 );
        root.getChildren().add( botao6 );
        root.setHgap( 10 );
        root.setVgap( 10 );
        root.setTileAlignment( Pos.TOP_LEFT );
        
        Scene scene = new Scene( root, 230, 90 );         
     
        primaryStage.setTitle( "Testar TilePane" );  
        primaryStage.setScene( scene );  
        primaryStage.show();  
    }  

    public static void main(String[] args) {  
        launch( args );  
    }    
} 


