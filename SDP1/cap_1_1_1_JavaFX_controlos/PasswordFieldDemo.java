/*
  Autor: Celso Paim
  Adaptado de Jakob Jenkov
  Data: Novembro/2025
  Prog_133: app JavaFX para utilizar um controlo PasswordField
*/

package edu.livrofundamentos.exemplos.cap4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PasswordFieldDemo extends Application { 
    @Override
    public void start( Stage primaryStage ) {
        Label msgLabel = new Label( "" );
        
        VBox boxVertical = new VBox();
        boxVertical.setPadding( new Insets( 10, 0, 0, 10 ) );
        boxVertical.setSpacing( 10 );

        HBox boxHorizontal = new HBox();
        boxHorizontal.setSpacing( 10 );
        boxHorizontal.setAlignment( Pos.CENTER_LEFT );

        Label label = new Label( "Password" );

        Tooltip tooltip1 = new Tooltip( "Digite a senha (teste com \"Angola\")" );

        PasswordField passwdField = new PasswordField();
        passwdField.setTooltip( tooltip1 );
        
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle( ActionEvent e ) {
                if ( ! passwdField.getText().equals( "Angola" ) ) {
                    msgLabel.setText( "Senha incorrecta! Tente novamente..." );
                    msgLabel.setTextFill( Color.RED );
                } 
                else {
                    msgLabel.setText( "Bem-vindo!" );
                    msgLabel.setTextFill( Color.GREEN );
                }
                passwdField.clear();
            }
        };  
        passwdField.setOnAction( event );        

        boxHorizontal.getChildren().addAll( label, passwdField );
        boxVertical.getChildren().addAll( boxHorizontal, msgLabel );

        Scene scene = new Scene( boxVertical, 280, 85 );
        
        primaryStage.setTitle( "Testar PasswordField" );  
        primaryStage.setScene( scene );  
        primaryStage.show();  
    }
    
    public static void main(String[] args) {
        launch( args );
    }
}