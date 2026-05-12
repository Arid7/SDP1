/*
  Autor: Celso Paim
  Data: Novembro/2025 
  Prog_141: app JavaFX para utilizar controlos Menu, MenuItem e MenuBar 
*/

package edu.livrofundamentos.exemplos.cap4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;  
import javafx.stage.Stage; 

public class MenuDemo extends Application { 
    @Override
    public void start( Stage primaryStage ) {
        BorderPane root = new BorderPane(); 
        
        MenuBar barraMenus = new MenuBar();
        
        Menu menuFile = new Menu( "Ficheiro" );  
        MenuItem itemFile1 = new MenuItem( "Novo" );  
        itemFile1.setAccelerator( KeyCombination.keyCombination( "Ctrl+N" ) );
        itemFile1.setOnAction( e -> {
            Alert alert = new Alert( Alert.AlertType.INFORMATION );
            alert.setTitle( "Informacao" );
            alert.setHeaderText( null );
            alert.setContentText( "Aqui seria executada a accao para o item NOVO" );
            alert.show(); 
        });
        MenuItem itemFile2 = new MenuItem( "Abrir" );  
        MenuItem itemFile3 = new MenuItem( "Guardar" );
        MenuItem itemFile4 = new MenuItem( "Sair" );
        itemFile4.setOnAction( e -> {
            System.exit( 0 );
        });
        menuFile.getItems().addAll( itemFile1, itemFile2, itemFile3, new SeparatorMenuItem(), itemFile4 );  
        
        Menu menuEdit = new Menu( "Editar" );  
        MenuItem itemEdit1 = new MenuItem( "Cortar" ); 
        itemEdit1.setAccelerator( KeyCombination.keyCombination( "Ctrl+X" ) );
        itemEdit1.setGraphic( new ImageView( "file:cut.gif" ) );
        MenuItem itemEdit2 = new MenuItem( "Copiar" );  
        itemEdit2.setAccelerator( KeyCombination.keyCombination( "Ctrl+C" ) );
        itemEdit2.setGraphic( new ImageView( "file:copy.gif" ) );
        MenuItem itemEdit3 = new MenuItem( "Colar" );
        itemEdit3.setAccelerator( KeyCombination.keyCombination( "Ctrl+V" ) );
        itemEdit3.setGraphic( new ImageView( "file:paste.gif" ) );
        menuEdit.getItems().addAll( itemEdit1, itemEdit2, itemEdit3 );        
        
        barraMenus.getMenus().addAll( menuFile, menuEdit );         
        root.setTop( barraMenus );                 
        Scene scene = new Scene( root, 300, 200 );
        primaryStage.setTitle( "Testar Menus" );  
        primaryStage.setScene( scene );  
        primaryStage.show();          
    }
    
    public static void main(String[] args) {
        launch( args );
    }
}

