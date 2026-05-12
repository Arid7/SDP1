/*
  Autor: Celso Paim
  Data: Novembro/2025
  Arrumar um layout de JavaFX com VBox
*/

package edu.livrofundamentos.exemplos.cap4;

import javafx.application.Application;  
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;  
import javafx.stage.Stage;  
 
public class VBoxDemo extends Application {  
  
    @Override  
    public void start( Stage primaryStage ) throws Exception {         
        Button botao1 = new Button( "Botao 1" );  
        Button botao2 = new Button( "Botao 2" );  
        
        VBox root = new VBox( botao1, botao2 ); //tambem poderiamos fazer root.getChildren().addAll()
        root.setSpacing( 20 );
        root.setAlignment( Pos.CENTER );
        
        Scene scene = new Scene( root, 220, 100 );         
     
        primaryStage.setTitle( "Testar VBox" );  
        primaryStage.setScene( scene );  
        primaryStage.show();  
    }  

    public static void main(String[] args) {  
        launch( args );  
    }    
} 
