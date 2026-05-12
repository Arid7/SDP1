/*
  Autor: Celso Paim
  Data: Novembro/2025
  Arrumar um layout de JavaFX com BorderPane
*/

package edu.livrofundamentos.exemplos.cap4;

import javafx.application.Application;  
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;  
 
public class BorderPaneDemo extends Application {  
  
    @Override  
    public void start( Stage primaryStage ) throws Exception {         
        BorderPane root = new BorderPane();  
        root.setTop( new Label( "Topo do BorderPane" ) ); 
 
        Label labelEsq = new Label( "Esquerda" );
        labelEsq.setStyle( "-fx-background-color: #ebafed;" );
        root.setLeft( labelEsq );
   
        Label labelDir = new Label( "Direita" );
        labelDir.setStyle( "-fx-background-color: #c4eb86;" );
        root.setRight( labelDir ); 
 
        HBox hbox = new HBox();
        hbox.setStyle("-fx-background-color: #f7f4ba;"); 
        hbox.getChildren().add( new Button( "Centro" ) );
        hbox.setAlignment( Pos.CENTER );
        root.setCenter( hbox ); 
    
        root.setBottom( new Label( "Fundo do BorderPane" ) );  
        
        Scene scene = new Scene( root, 400, 200 );         
     
        primaryStage.setTitle( "Border Demo" );  
        primaryStage.setScene( scene );  
        primaryStage.show();  
    }  

    public static void main(String[] args) {  
        launch( args );  
    }    
} 

