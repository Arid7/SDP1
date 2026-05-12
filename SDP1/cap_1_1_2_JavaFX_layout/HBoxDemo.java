/*
  Autor: Celso Paim
  Data: Novembro/2025
  Arrumar um layout de JavaFX com HBox
*/

package edu.livrofundamentos.exemplos.cap4;

import javafx.application.Application;  
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;  
import javafx.stage.Stage;  
 
public class HBoxDemo extends Application {  
  
    @Override  
    public void start( Stage primaryStage ) throws Exception {         
        Button botao1 = new Button( "Botao 1" );  
        Button botao2 = new Button( "Botao 2" );  
        
        HBox root = new HBox();          
        root.getChildren().addAll( botao1, botao2 );
        root.setAlignment( Pos.TOP_CENTER );  
        root.setSpacing( 40 );  
        root.setFillHeight( true );   
        
        Scene scene = new Scene( root, 220, 65 ); 
     
        primaryStage.setTitle( "Testar HBox" );  
        primaryStage.setScene( scene );  
        primaryStage.show();  
    }  

    public static void main(String[] args) {  
        launch( args );  
    }    
} 
