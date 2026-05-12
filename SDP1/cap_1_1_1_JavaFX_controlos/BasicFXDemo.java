/*
  Autor: Celso Paim
  Data: Novembro/2025
  Prog_132: app JavaFX para utilizar os controlos basicos como etiquetas, caixa de texto, botao de comando, etc
*/
package edu.livrofundamentos.exemplos.cap4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BasicFXDemo extends Application {    
    @Override  
    public void start( Stage primaryStage ) {
        Label labelNome = new Label( "Nome" );        
        TextField txtNome = new TextField();
        txtNome.setPrefSize( 210, 25 );
                
        HBox hbox1 = new HBox( labelNome, txtNome );    
        hbox1.setPadding( new Insets( 10, 10, 10, 10 ) );
        hbox1.setSpacing( 10 );  
        hbox1.setAlignment( Pos.BASELINE_LEFT );
        
        Label labelSexo = new Label( "Sexo" );
        RadioButton radioM = new RadioButton( "M" );
        radioM.setSelected( true );
        RadioButton radioF = new RadioButton( "F" );
        ToggleGroup radioGroup = new ToggleGroup();
        radioM.setToggleGroup( radioGroup );
        radioF.setToggleGroup( radioGroup ); 
                
        HBox hbox2 = new HBox( labelSexo, radioM, radioF );    
        hbox2.setPadding( new Insets( 10, 10, 10, 10 ) );
        hbox2.setSpacing( 10 );  
        hbox2.setAlignment( Pos.BASELINE_LEFT );
        
        Label labelEstCivil = new Label( "Estado civil" );
        ComboBox comboBox = new ComboBox();
        comboBox.getItems().add( "Solteiro" );
        comboBox.getItems().add( "Casado" );
        comboBox.getItems().add( "Divorciado" );
        comboBox.getItems().add( "Viuvo" );  
        comboBox.getSelectionModel().selectFirst();
                
        HBox hbox3 = new HBox( labelEstCivil, comboBox );    
        hbox3.setPadding( new Insets( 10, 10, 10, 10 ) );
        hbox3.setSpacing( 10 );  
        hbox3.setAlignment( Pos.BASELINE_LEFT );
        
        CheckBox checkBox = new CheckBox( "Confirmo que as informacoes sao verdadeiras" );
        checkBox.setPadding( new Insets( 10, 10, 10, 10 ) );
        HBox hbox4 = new HBox( checkBox );  
        
        Button button = new Button( "Processar" );
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle( ActionEvent e ) {                
                Alert dialogo = new Alert( AlertType.INFORMATION );
                dialogo.setTitle( "Resultado do processamento" );
                dialogo.setHeaderText( "Informacao lida com sucesso!" );
                
                String res = "Nome: " + txtNome.getText() + "\n";
                res += "Sexo: " + ( radioM.isSelected() ? "Masculino" : "Feminino" );
                res += "\nEstado civil: " + comboBox.getSelectionModel().getSelectedItem();
                res += "\nConfirmou? " + ( checkBox.isSelected() ? "Sim" : "Nao" );
                
                dialogo.setContentText( res ); 
                dialogo.show();
            }
        };  
        button.setOnAction( event );  
        HBox hbox5 = new HBox( button );  
        hbox5.setAlignment( Pos.CENTER );        
        
        VBox root = new VBox( hbox1, hbox2, hbox3, hbox4, hbox5 ); 
        root.setAlignment( Pos.CENTER );
        
        Scene scene = new Scene( root, 350, 210 );     
     
        primaryStage.setTitle( "Testar controlos basicos JavaFX" );  
        primaryStage.setScene( scene );  
        primaryStage.show();  
    }  

    public static void main(String[] args) {  
        launch( args );  
    }    
} 
