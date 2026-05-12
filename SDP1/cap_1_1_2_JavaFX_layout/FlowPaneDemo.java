/*
  Autor: Celso Paim
  Data: Novembro/2025
  Arrumar um layout de JavaFX com FlowPane
*/

package edu.livrofundamentos.exemplos.cap4;

import javafx.application.Application;  
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;  
 
public class FlowPaneDemo extends Application {  
  
    @Override  
    public void start( Stage primaryStage ) throws Exception {         
        Button botao1 = new Button( "Botao 1" );  
        Button botao2 = new Button( "Botao 2" ); 
        Button botao3 = new Button( "Botao 3" ); 
        
        FlowPane root = new FlowPane();
        root.getChildren().add( botao1 );
        root.getChildren().add( botao2 );
        root.getChildren().add( botao3 );
        root.setHgap( 10 );
        root.setVgap( 10 );
        root.setOrientation( Orientation.VERTICAL );
        
        Scene scene = new Scene( root, 230, 110 );         
     
        primaryStage.setTitle( "Testar FlowPane" );  
        primaryStage.setScene( scene );  
        primaryStage.show();  
    }  

    public static void main(String[] args) {  
        launch( args );  
    }    
} 
