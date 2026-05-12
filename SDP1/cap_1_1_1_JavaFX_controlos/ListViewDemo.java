/*
  Autor: Celso Paim
  Data: Novembro/2025
  Prog_135: app JavaFX para utilizar um controlo ListView
*/

package edu.livrofundamentos.exemplos.cap4;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListViewDemo extends Application { 
    @Override
    public void start( Stage primaryStage ) {
        
        ListView listView = new ListView();
        listView.getSelectionModel().setSelectionMode( SelectionMode.MULTIPLE );       
        listView.getItems().add( "1.º de Agosto" );
        listView.getItems().add( "ASA" );        
        listView.getItems().add( "Inter" );        
        listView.getItems().add( "Kabuscorp Palanca");
        listView.getItems().add( "Petro de Luanda" );
        listView.getItems().add("Recreativo Libolo");
        listView.getItems().add( "Sagrada Esperanca" );

        Label labelQuestao = new Label( "Seleccione a(s) sua(s) equipa(s) preferida(s)" );
        
        Label labelResposta = new Label( "" );    
            
        Button button = new Button( "Ler seleccao" );
        button.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle( ActionEvent event ) {
                    String res = "";
                    ObservableList selectedItens = listView.getSelectionModel().getSelectedItems();
                    for( Object item : selectedItens ) 
                        res += item + "; ";
                    labelResposta.setText( "Escolhidas: " + res );                    
                }
            }
        );
        
        VBox vBox = new VBox( labelQuestao, listView, button, labelResposta );

        Scene scene = new Scene( vBox, 400, 200 );
       
        primaryStage.setTitle( "Testar ListView" );  
        primaryStage.setScene( scene );  
        primaryStage.show();  
    }
    
    public static void main(String[] args) {
        launch( args );
    }
}

