/*
  Autor: Celso Paim
  Data: Novembro/2025
  Arrumar um layout de JavaFX com GridPane
*/
package edu.livrofundamentos.exemplos.cap4;

import javafx.application.Application;  
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;  
 
public class GridPaneDemo extends Application {    
    @Override  
    public void start( Stage primaryStage ) {         
        Button botao1 = new Button( "Botao 1" );  
        Button botao2 = new Button( "Botao 2" ); 
        Button botao3 = new Button( "Botao 3" ); 
        Button botao4 = new Button( "Botao 4" );  
        Button botao5 = new Button( "Botao 5" ); 
        Button botao6 = new Button( "Botao 6" );
        
        GridPane root = new GridPane();
        root.add( botao1, 0, 0, 2, 2 );
        root.add( botao2, 2, 0, 1, 1 );
        root.add( botao3, 2, 1, 1, 1 );
        root.add( botao4, 0, 2, 1, 1 );
        root.add( botao5, 1, 2, 1, 1 );
        root.add( botao6, 2, 2, 1, 1 );
        
        Scene scene = new Scene( root, 230, 100 );         
     
        primaryStage.setTitle( "Testar GridPane" );  
        primaryStage.setScene( scene );  
        primaryStage.show();  
    }  

    public static void main(String[] args) {  
        launch( args );  
    }    
} 

