/*
  Autor: Celso Paim
  Data: Novembro/2025 
  Prog_144: app JavaFX para utilizar um controlo ColorPicker
*/

package edu.livrofundamentos.exemplos.cap4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ColorPickerDemo extends Application {
    @Override
    public void start( Stage primaryStage ) {
        ColorPicker colorPicker = new ColorPicker();
        
        VBox vBox = new VBox( colorPicker );
        
        colorPicker.setOnAction( e -> { //funcao lambda para a accao do colorPicker
            vBox.setBackground(
                new Background( 
                    new BackgroundFill( colorPicker.getValue(), CornerRadii.EMPTY, Insets.EMPTY )
                )
            );
        });
 
        Scene scene = new Scene( vBox, 250, 100  );
        primaryStage.setScene( scene );
        primaryStage.setTitle( "Testar ColorPicker" ); 
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch( args );
    }
}
