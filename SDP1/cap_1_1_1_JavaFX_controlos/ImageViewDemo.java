/*
  Autor: Celso Paim
  Adaptado de Jakob Jenkov
  Data: Novembro/2025
  Prog_139: app JavaFX para utilizar um controlo ImageView 
*/

package edu.livrofundamentos.exemplos.cap4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ImageViewDemo extends Application { 
    @Override
    public void start( Stage primaryStage ) {
        try {
            FileInputStream input = new FileInputStream( "luanda_marginal.jpg" );
            Image image = new Image( input );
            ImageView imageView = new ImageView( image );

            ScrollPane scroller = new ScrollPane();
            scroller.setContent( imageView );

            HBox hBox = new HBox( scroller );
            Scene scene = new Scene( hBox, 300, 300 );

            primaryStage.setTitle( "Testar ImageView" );  
            primaryStage.setScene( scene );  
            primaryStage.show();  
        }
        catch( FileNotFoundException ex ) {
            System.out.println( "Ocorreu um erro ao manipular o ficheiro" );
        }
    }
    
    public static void main(String[] args) {
        launch( args );
    }
}
