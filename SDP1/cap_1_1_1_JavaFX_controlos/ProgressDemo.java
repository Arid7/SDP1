/*
  Autor: Celso Paim
  Adaptado de Jakob Jenkov
  Data: Novembro/2025
  Prog_138: app JavaFX para utilizar controlos de progresso (Slider, ProgressBar e ProgressIndicator)
*/

package edu.livrofundamentos.exemplos.cap4;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProgressDemo extends Application { 
    @Override
    public void start( Stage primaryStage ) {
        Slider slider = new Slider();
        slider.setMin( 0 );
        slider.setMax( 100 );
        slider.setShowTickLabels(true);
         
        ProgressBar barraProg = new ProgressBar( 0 );
        
        ProgressIndicator indicaProg = new ProgressIndicator( 0 );
 
        slider.valueProperty().addListener( //funcao lambda para o listener
            ( ObservableValue<? extends Number> value, Number oldValue, Number newValue ) -> {
                barraProg.setProgress( newValue.doubleValue() / 100 );
                indicaProg.setProgress( newValue.doubleValue() / 100 );
        });
 
        VBox vbox = new VBox();
        vbox.setSpacing( 5 );
        vbox.setAlignment( Pos.CENTER );
        vbox.getChildren().addAll( slider, barraProg, indicaProg );
        Scene scene = new Scene( vbox, 285, 125 );

        primaryStage.setTitle( "Controlos de progresso" );  
        primaryStage.setScene( scene );  
        primaryStage.show();  
    }
    
    public static void main(String[] args) {
        launch( args );
    }
}
    