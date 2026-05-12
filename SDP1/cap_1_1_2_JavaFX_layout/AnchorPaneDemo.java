/*
  Autor: Celso Paim
  Data: Novembro/2025
  Arrumar um layout de JavaFX com AnchorPane
*/
package edu.livrofundamentos.exemplos.cap4;

import javafx.application.Application;  
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;  
 
public class AnchorPaneDemo extends Application {    
    @Override  
    public void start( Stage primaryStage ) throws Exception {         
        
        Label label = new Label( "Esta e uma label" );
  
        AnchorPane root = new AnchorPane( label );
        AnchorPane.setTopAnchor( label, 70.0 );
        AnchorPane.setLeftAnchor( label, 10.0 );
        AnchorPane.setRightAnchor( label, 180.0 );
        AnchorPane.setBottomAnchor( label, 70.0 );
  
        Button button = new Button( "Botao 1" );
        AnchorPane.setTopAnchor( button, 65.0 );
        AnchorPane.setLeftAnchor( button, 120.0 );
        AnchorPane.setRightAnchor( button, 60.0 );
        AnchorPane.setBottomAnchor( button, 65.0 );  
        root.getChildren().add( button );  
        root.setMinHeight( 200 );
        root.setMinWidth( 250 );
        
        Scene scene = new Scene( root, 300, 250 );         
     
        primaryStage.setTitle( "Testar AnchorPane" );  
        primaryStage.setScene( scene );  
        primaryStage.show();  
    }  

    public static void main(String[] args) {  
        launch( args );  
    }    
} 
