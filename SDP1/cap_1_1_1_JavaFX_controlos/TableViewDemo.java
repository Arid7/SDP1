/*
  Autor: Celso Paim
  Adaptado de Jakob Jenkov
  Data: Novembro/2025
  Prog_146: app JavaFX para utilizar um controlo TableView
*/

package edu.livrofundamentos.exemplos.cap4;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TableViewDemo extends Application {
    
    @Override
    public void start( Stage primaryStage ) {
        Scene scene = new Scene( new Group() );
        
        final Label label = new Label( "Lista de contactos" );
        label.setFont( new Font( "Arial", 14 ) );
        
        TableView<Pessoa> tabela = new TableView<>();
        tabela.setEditable( true );
 
        TableColumn colNome = new TableColumn( "Nome" );
        colNome.setMinWidth( 100 );
        colNome.setCellValueFactory( new PropertyValueFactory<>( "nome" ) );
 
        TableColumn colApelido = new TableColumn( "Apelido" );
        colApelido.setMinWidth( 100 );
        colApelido.setCellValueFactory( new PropertyValueFactory<>( "apelido" ) );
 
        TableColumn colEmail = new TableColumn("E-mail");
        colEmail.setMinWidth( 200 );
        colEmail.setCellValueFactory( new PropertyValueFactory<>( "email" ) );
                
        ObservableList<Pessoa> dados = FXCollections.observableArrayList(        
            new Pessoa( "Andre", "Paulino", "andre.paulino@ebonet.net" ),
            new Pessoa( "Carla", "Trocio", "carla.trocio@aol.com" ),
            new Pessoa( "Florips", "Goncalves", "florips.goncalves@gmail.com" ),
            new Pessoa( "Gizelda", "Soares", "gizasoares1@aeiou.pt" ),            
            new Pessoa( "Manuel", "Domingos", "manuel_domingos@hotmail.com" ),
            new Pessoa( "Maria", "Monteiro", "mmariamonteiro@outlook.com" ),
            new Pessoa( "Zacarias", "Lopes", "zacariaslopes23@yahoo.fr" )
        ); 
        tabela.setItems(dados);
        tabela.getColumns().addAll( colNome, colApelido, colEmail );
 
        VBox vBox = new VBox();
        vBox.setSpacing( 5 );
        vBox.setPadding( new Insets( 10, 0, 0, 10 ) );
        vBox.getChildren().addAll( label, tabela );
 
        ( ( Group ) scene.getRoot() ).getChildren().addAll( vBox );
        
        primaryStage.setScene( scene );
        primaryStage.setWidth( 440 );
        primaryStage.setHeight( 475 );
        primaryStage.setTitle( "Testar TableView" ); 
        primaryStage.show();
    }
    
    public class Pessoa { 
        private final SimpleStringProperty nome;
        private final SimpleStringProperty apelido;
        private final SimpleStringProperty email;
 
        private Pessoa( String nome, String apelido, String email ) {
            this.nome = new SimpleStringProperty( nome );
            this.apelido = new SimpleStringProperty( apelido );
            this.email = new SimpleStringProperty( email );
        }
 
        public String getNome() { return nome.get(); } 
        public void setNome( String s ) { nome.set( s ); }
 
        public String getApelido() { return apelido.get(); } 
        public void setApelido( String s ) { apelido.set( s ); }
 
        public String getEmail() { return email.get(); } 
        public void setEmail( String s ) { email.set( s ); }
    }
    
    public static void main(String[] args) {
        launch( args );
    }
}
