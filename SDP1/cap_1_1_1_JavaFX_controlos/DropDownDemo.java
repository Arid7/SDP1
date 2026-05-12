/*
  Autor: Celso Paim
  Data: Novembro/2025
  Prog_143: app JavaFX para utilizar controlos ChoiceBox, MenuButton, SplitMenuButton e SplitPane
*/

package edu.livrofundamentos.exemplos.cap4;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage; 

public class DropDownDemo extends Application { 
    @Override
    public void start( Stage primaryStage ) {     
        ChoiceBox choiceBox = new ChoiceBox( FXCollections.observableArrayList ( 
            "Portugues", "English", "Français", "Español", "Deutsch", "Italiano", "русский" 
        ) );
        choiceBox.getSelectionModel().selectFirst();        
        VBox boxEsq  = new VBox( new Label( "ChoiceBox" ), choiceBox );
        boxEsq.setPrefSize( 100, 220 );        
        
        MenuItem itemPT = new MenuItem( "Portugues" );
        MenuItem itemEN = new MenuItem( "English" );
        MenuItem itemFR = new MenuItem( "Français" );
        MenuItem itemES = new MenuItem( "Español" );
        MenuItem itemDE = new MenuItem( "Deutsch" );
        MenuItem itemIT = new MenuItem( "Italiano" );
        MenuItem itemRU = new MenuItem( "русский" );
        MenuButton menuButton = new MenuButton( "Idiomas", null, itemPT, itemEN, 
            itemFR, itemES, itemDE, itemIT, itemRU );
        VBox boxCentro = new VBox( new Label( "MenuButton" ), menuButton );
        boxCentro.setPrefSize( 100, 220 );        
        
        MenuItem itemPT2 = new MenuItem( "Portugues" );
        MenuItem itemEN2 = new MenuItem( "English" );
        MenuItem itemFR2 = new MenuItem( "Français" );
        MenuItem itemES2 = new MenuItem( "Español" );
        MenuItem itemDE2 = new MenuItem( "Deutsch" );
        MenuItem itemIT2 = new MenuItem( "Italiano" );
        MenuItem itemRU2 = new MenuItem( "русский" );
        
        SplitMenuButton splitMenuButton = new SplitMenuButton( itemPT2, itemEN2, 
            itemFR2, itemES2, itemDE2, itemIT2, itemRU2 );
        splitMenuButton.setText( "Idiomas" );        
        VBox boxDir = new VBox( new Label( "SplitMenuButton" ), splitMenuButton );
        boxDir.setPrefSize( 100, 220 );
        
        SplitPane splitPane = new SplitPane();
        splitPane.getItems().addAll( boxEsq, boxCentro, boxDir );         
        Scene scene = new Scene( splitPane, 300, 220 );
        primaryStage.setTitle( "Testar DropDown" );  
        primaryStage.setScene( scene );  
        primaryStage.show();          
    }
    
    public static void main(String[] args) {
        launch( args );
    }
}
