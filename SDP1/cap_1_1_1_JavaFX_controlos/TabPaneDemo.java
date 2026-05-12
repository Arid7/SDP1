/*
  Autor: Celso Paim
  Data: Novembro/2025 
  Prog_145: app JavaFX para utilizar um controlo TabDemo
*/

package edu.livrofundamentos.exemplos.cap4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TabPaneDemo extends Application {
    @Override
    public void start( Stage primaryStage ) {
        TabPane tabPane = new TabPane();

        Tab tab1 = new Tab( "Clientes", new Label( "Este e o painel 1" ) );
        Tab tab2 = new Tab( "Fornecedores", new Label( "Este e o painel 2" ) );
        Tab tab3 = new Tab( "Facturas", new Label( "Este e o painel 3" ) );
        tabPane.getTabs().add( tab1 );
        tabPane.getTabs().add( tab2 );
        tabPane.getTabs().add( tab3 );

        VBox vBox = new VBox( tabPane );

        Scene scene = new Scene( vBox, 250, 100  );
        primaryStage.setScene( scene );
        primaryStage.setTitle( "Testar TabPane" ); 
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch( args );
    }
}
