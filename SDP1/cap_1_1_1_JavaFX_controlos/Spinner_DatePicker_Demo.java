/*
  Autor: Celso Paim
  Data: Novembro/2025
  Prog_136: app JavaFX para utilizar controlos Spinner e DatePicker
*/
package edu.livrofundamentos.exemplos.cap4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class Spinner_DatePicker_Demo extends Application {    
    @Override  
    public void start( Stage primaryStage ) {
        Label labelPeso = new Label( "Peso (g)" );
        
        Spinner spinPeso = new Spinner( 500, 5000, 3500 );
        spinPeso.setEditable( true );
        spinPeso.setPrefSize( 75, 25 );
        
        Label labelAlt = new Label( "Altura (cm)" );
        
        Spinner spinAlt = new Spinner( 20, 90, 50 );
        spinAlt.setEditable( true );
        spinAlt.setPrefSize( 75, 25 );    
        
        HBox hbox1 = new HBox( labelPeso, spinPeso, labelAlt, spinAlt );    
        hbox1.setPadding( new Insets( 10, 10, 10, 10 ) );
        hbox1.setSpacing( 10 );  
        
        Label labelData = new Label( "Data de nascimento" );
        
        DatePicker datePicker = new DatePicker();
          
        HBox hbox2 = new HBox( labelData, datePicker );    
        hbox2.setPadding( new Insets( 10, 10, 10, 10 ) );
        hbox2.setSpacing( 10 );  
        
        VBox root = new VBox( hbox1, hbox2 ); 
        root.setAlignment( Pos.CENTER );
        
        Scene scene = new Scene( root, 330, 100 );     
     
        primaryStage.setTitle( "Testar Spinner e DatePicker" );  
        primaryStage.setScene( scene );  
        primaryStage.show();  
    }  

    public static void main(String[] args) {  
        launch( args );  
    }    
} 


