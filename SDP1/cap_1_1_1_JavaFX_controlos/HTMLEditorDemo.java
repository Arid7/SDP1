/*
  Autor: Celso Paim
  Data: Novembro/2025 
  Prog_150: app JavaFX para utilizar um controlo HTMLEditor
*/

package edu.livrofundamentos.exemplos.cap4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

public class HTMLEditorDemo extends Application {
    @Override
    public void start( Stage primaryStage ) {

        HTMLEditor htmlEditor = new HTMLEditor();

        VBox vBox = new VBox( htmlEditor );
        Scene scene = new Scene( vBox );

        primaryStage.setScene( scene );
        primaryStage.setTitle( "Testar HTMLEditor" );
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
