/*
  Autor: Celso Paim
  Data: Novembro/2025
  Prog_149: app JavaFX para criar um mini-browser com controlos Hyperlink e WebView
*/

package edu.livrofundamentos.exemplos.cap4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class MiniBrowserDemo extends Application {
    @Override
    public void start( Stage primaryStage ) {
        WebView webView = new WebView(); 
                
        Hyperlink linkLegis = new Hyperlink( "Assembleia Nacional" );
        linkLegis.setOnAction( e -> { //expressao lambda para a accao do link
            webView.getEngine().load( "https://www.parlamento.ao" );
        });

        Hyperlink linkExec = new Hyperlink( "Executivo" );
        linkExec.setOnAction( e -> { //expressao lambda para a accao do link
            webView.getEngine().load( "https://governo.gov.ao" );
        });
        
        Hyperlink linkJud = new Hyperlink( "Tribunal Constitucional" );
        linkJud.setOnAction( e -> { //expressao lambda para a accao do link
            webView.getEngine().load( "https://www.tribunalconstitucional.ao" );
        });
        
        VBox vBoxLinks = new VBox( linkLegis, linkExec, linkJud );
        vBoxLinks.setSpacing( 20 );
        vBoxLinks.setAlignment( Pos.TOP_LEFT );
        vBoxLinks.setPrefSize( 140, 390 ); 
        vBoxLinks.setBackground(
        new Background( 
                    new BackgroundFill( Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY )
                ) );

        VBox vBoxContent = new VBox( webView );       
        vBoxContent.setPrefSize( 350, 390 );
        
        FlowPane root = new FlowPane();
        root.getChildren().add( vBoxLinks );
        root.getChildren().add( vBoxContent );
        
        Scene scene = new Scene( root, 500, 400 );      
        primaryStage.setTitle( "Mini-browser com JavaFX" );
        primaryStage.setScene( scene );
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch( args );
    }
}

