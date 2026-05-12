/*
  Autor: Celso Paim
  Data: Novembro/2025
  Arrumar um layout de JavaFX com StackPane
*/
package edu.livrofundamentos.exemplos.cap4;

import javafx.application.Application;  
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;  
 
public class StackPaneDemo extends Application {    
    
    private StackPane stackPane;

    @Override
    public void start( Stage primaryStage ) {
        VBox root = new VBox();

        stackPane = new StackPane();
     
        Label label = new Label( "Esta e uma Label" );
        label.setPadding( new Insets( 5, 5, 5, 5 ) );
        label.setVisible( false );     
        stackPane.getChildren().add( label );
      
        Button button = new Button( "Botao" );      
        button.setPadding( new Insets( 5, 5, 5, 5 ) );
        button.setVisible( false );     
        stackPane.getChildren().add( button );     
     
        CheckBox checkBox = new CheckBox( "Este e um CheckBox" );
        checkBox.setPadding( new Insets( 5, 5, 5, 5 ) );   
        stackPane.getChildren().add( checkBox );    
       
        stackPane.setPrefSize( 300, 150 );
        stackPane.setStyle("-fx-background-color: Gainsboro;-fx-border-color: blue;");
        root.getChildren().add( stackPane );

        Button controlButton = new Button( "Mudar painel" );
        controlButton.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle( ActionEvent event ) {
                    mudarPainel();
                }
            }
        );

        root.getChildren().add( controlButton );
        root.setAlignment( Pos.CENTER );
        VBox.setMargin( stackPane, new Insets( 10, 10, 10, 10 ) );
        VBox.setMargin( controlButton, new Insets( 10, 10, 10, 10 ) );
    
        Scene scene = new Scene( root, 250, 100 );

        primaryStage.setTitle( "Testar StackPane" );
        primaryStage.setScene( scene );
        primaryStage.show();
    }

    private void mudarPainel() {
        ObservableList<Node> childs = this.stackPane.getChildren();
        if( childs.size() > 1 ) {
            Node topNode = childs.get( childs.size() - 1 );         
            Node newTopNode = childs.get( childs.size() - 2 );                 
            topNode.setVisible( false );
            topNode.toBack();         
            newTopNode.setVisible( true );
        }
    }

    public static void main( String[] args ) {
        launch( args );
    }   
} 

