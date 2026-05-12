/*
  Autor: Celso Paim
  Data: Novembro/2025
  Prog_147: app JavaFX para utilizar um controlo TreeView
*/

package edu.livrofundamentos.exemplos.cap4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TreeViewDemo extends Application {
    @Override
    public void start( Stage primaryStage ) {        
        TreeItem rootItem = new TreeItem( "Cuando" );
   
        TreeItem cuitoItem= new TreeItem( "Cuito Cuanavale" );
        cuitoItem.getChildren().add( new TreeItem( "Cuito Cuanavale" ) );
        cuitoItem.getChildren().add( new TreeItem( "Lupire" ) );
        rootItem.getChildren().add( cuitoItem);
	        
        TreeItem dimaItem = new TreeItem( "Dima" );
        dimaItem.getChildren().add( new TreeItem( "Cunjamba" ) );
        dimaItem.getChildren().add( new TreeItem( "Cutuile" ) );
        rootItem.getChildren().add( dimaItem );

        TreeItem diricoItem = new TreeItem( "Dirico" );
        diricoItem.getChildren().add( new TreeItem( "Dirico" ) );
        diricoItem.getChildren().add( new TreeItem( "Xamavera" ) );
        rootItem.getChildren().add( diricoItem );

        TreeItem luengueItem = new TreeItem( "Luengue" );        
        rootItem.getChildren().add( luengueItem );

        TreeItem luianaItem = new TreeItem( "Luiana" );
        rootItem.getChildren().add( luianaItem );

        TreeItem mavingaItem = new TreeItem( "Mavinga" );        
        rootItem.getChildren().add( mavingaItem );

        TreeItem mucussoItem = new TreeItem( "Mucusso" );        
        rootItem.getChildren().add( mucussoItem );
       
        TreeItem rivungoItem = new TreeItem( "Rivungo" );        
        rootItem.getChildren().add( rivungoItem );

        TreeItem xipundoItem = new TreeItem( "Xipundo" );        
        rootItem.getChildren().add( xipundoItem );
        
        TreeView treeView = new TreeView();
        treeView.setRoot( rootItem );
        treeView.setShowRoot( true );

        VBox vbox = new VBox( treeView );
        Scene scene = new Scene( vbox );
        primaryStage.setScene( scene );
        primaryStage.setTitle( "Testar TreeView" ); 
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch( args );
    }
}


