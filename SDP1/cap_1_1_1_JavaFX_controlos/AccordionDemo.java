/*
  Autor: Celso Paim
  Adaptado de Jakob Jenkov
  Data: Novembro/2025
  Prog_134: app JavaFX para utilizar um controlo Accordion
*/

package edu.livrofundamentos.exemplos.cap4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AccordionDemo extends Application { 
    @Override
    public void start( Stage primaryStage ) {
         Accordion accordion = new Accordion();

        TitledPane painel1 = new TitledPane( "Clientes" , new Label( "Aqui estariam os componentes do painel 1" ) );
        TitledPane painel2 = new TitledPane( "Fornecedores"  , new Label( "Aqui estariam os componentes do painel 2" ) );
        TitledPane painel3 = new TitledPane( "Facturas", new Label( "Aqui estariam os componentes do painel 3" ) );

        accordion.getPanes().add( painel1 );
        accordion.getPanes().add( painel2 );
        accordion.getPanes().add( painel3 );

        VBox vbox = new VBox( accordion );    
        Scene scene = new Scene( vbox, 300, 200 );

        primaryStage.setTitle( "Testar Accordion" );  
        primaryStage.setScene( scene );  
        primaryStage.show();  
    }    
    
    public static void main(String[] args) {
        launch( args );
    }
}    
