/*
  Autor: Celso Paim
  Data: Novembro/2025
  Prog_142: app JavaFX para utilizar controlos ContextMenu e ToolBar 
*/

package edu.livrofundamentos.exemplos.cap4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage; 

public class ContextMenuDemo extends Application { 
    @Override
    public void start( Stage primaryStage ) {
        String msg = "Este e um texto de exemplo, o utilizador pode cortar, ";
        msg += "ou \ncopiar depois de selecionar e colar aonde quiser...";
        TextArea textArea = new TextArea();
        textArea.setText( msg );
        
        EventHandler<ActionEvent> eventCut = new EventHandler<ActionEvent>() {
            @Override
            public void handle( ActionEvent e ) {
                Clipboard clipboard = Clipboard.getSystemClipboard();
                ClipboardContent content = new ClipboardContent();
                content.putString( textArea.getSelectedText() );
                clipboard.setContent( content );
                textArea.replaceSelection( "" );
                Alert alert = new Alert( AlertType.INFORMATION, "TEXTO CORTADO", ButtonType.OK );
                alert.show();
            }
        }; 
        
        EventHandler<ActionEvent> eventCopy = new EventHandler<ActionEvent>() {
            @Override
            public void handle( ActionEvent e ) {
                Clipboard clipboard = Clipboard.getSystemClipboard();
                ClipboardContent content = new ClipboardContent();
                content.putString( textArea.getSelectedText() );
                clipboard.setContent( content );
                Alert alert = new Alert( AlertType.INFORMATION, "TEXTO COPIADO", ButtonType.OK );
                alert.show();
            }
        }; 
        
        EventHandler<ActionEvent> eventPaste = new EventHandler<ActionEvent>() {
            @Override
            public void handle( ActionEvent e ) {
                Clipboard clipboard = Clipboard.getSystemClipboard();
                if( ! clipboard.hasContent( DataFormat.PLAIN_TEXT ) ) 
                    return;  
                String txt = clipboard.getString();
                textArea.replaceSelection( txt );
                Alert alert = new Alert( AlertType.INFORMATION, "TEXTO COLADO", ButtonType.OK );
                alert.show();
            }
        };
        
        ToolBar toolBar = new ToolBar();

        Button buttonCut = new Button();
        buttonCut.setGraphic( new ImageView( "file:cut.gif" ) );  
        buttonCut.setTooltip( new Tooltip( "Cortar o texto selecionado" ) );
        buttonCut.setOnAction( eventCut ); 

        Button buttonCopy = new Button();
        buttonCopy.setGraphic( new ImageView( "file:copy.gif" ) );        
        buttonCopy.setTooltip( new Tooltip( "Copiar o texto selecionado" ) );
        buttonCopy.setOnAction( eventCopy ); 
        
        Button buttonPaste = new Button();
        buttonPaste.setGraphic( new ImageView( "file:paste.gif" ) );      
        buttonPaste.setTooltip( new Tooltip( "Colar o texto selecionado" ) );
        buttonPaste.setOnAction( eventPaste ); 
        
        toolBar.getItems().addAll( buttonCut, buttonCopy, buttonPaste );
        
        ContextMenu menu = new ContextMenu();
      
        MenuItem itemCut = new MenuItem( "Cortar" ); 
        itemCut.setGraphic( new ImageView( "file:cut.gif" ) );
        itemCut.setOnAction( eventCut );             
        
        MenuItem itemCopy = new MenuItem( "Copiar" );  
        itemCopy.setGraphic( new ImageView( "file:copy.gif" ) );
        itemCopy.setOnAction( eventCopy );       
        
        MenuItem itemPaste = new MenuItem( "Colar" );
        itemPaste.setGraphic( new ImageView( "file:paste.gif" ) );
        itemPaste.setOnAction( eventPaste );
        
        menu.getItems().addAll( itemCut, itemCopy, itemPaste );        

        textArea.setContextMenu( menu );

        VBox vBox = new VBox( textArea );
        
        BorderPane root = new BorderPane();  
        root.setTop( toolBar );    
        root.setCenter( vBox );         
        Scene scene = new Scene( root, 350, 200 );
        primaryStage.setTitle( "Testar ToolBar e ContextMenu" );  
        primaryStage.setScene( scene );  
        primaryStage.show();          
    }
    
    public static void main(String[] args) {
        launch( args );
    }
}

