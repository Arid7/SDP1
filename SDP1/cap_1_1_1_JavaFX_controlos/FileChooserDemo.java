/*
  Autor: Celso Paim
  Data: Novembro/2025 
  Prog_140: app JavaFX para utilizar um controlo FileChooser e um DirectoryChooser
*/

package edu.livrofundamentos.exemplos.cap4;

import java.io.File;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileChooserDemo extends Application {
    @Override
    public void start( Stage primaryStage ) { 
        
        Label dirLabel = new Label( "" );
        
        DirectoryChooser dirChooser = new DirectoryChooser();

        Button dirButton = new Button( "Escolha uma pasta" );
        dirButton.setOnAction( e -> {
            File selectedDirectory = dirChooser.showDialog( primaryStage );
            dirLabel.setText( "ESCOLHEU " + selectedDirectory.getAbsolutePath() );
        });

        HBox hbox1 = new HBox( dirButton, dirLabel );
        hbox1.setSpacing( 5 );
        hbox1.setAlignment( Pos.BASELINE_LEFT );
        
        Label fileLabel = new Label( "" );
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Ficheiros AAC", "*.aac"),
            new FileChooser.ExtensionFilter("Ficheiros OGG", "*.ogg"),
            new FileChooser.ExtensionFilter("Ficheiros MP3", "*.mp3"),
            new FileChooser.ExtensionFilter("Ficheiros WAV", "*.wav"),
            new FileChooser.ExtensionFilter("Ficheiros WMA", "*.wma")
        );

        Button fileButton = new Button( "Escolha um ficheiro de audio" );
        fileButton.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog( primaryStage );
            fileLabel.setText( "ESCOLHEU " + selectedFile.getAbsolutePath() );
        });
        
        HBox hbox2 = new HBox( fileButton, fileLabel );
        hbox2.setSpacing( 5 );
        hbox2.setAlignment( Pos.BASELINE_LEFT );
        
        VBox root = new VBox( hbox1, hbox2 ); 
        root.setSpacing( 5 );
        root.setAlignment( Pos.CENTER );        
 
        Scene scene = new Scene( root, 400, 100  );
        primaryStage.setScene( scene );
        primaryStage.setTitle( "Testar FileChooser e DirectoryChooser" ); 
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch( args );
    }
}


