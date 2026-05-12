/*
  Autor: Celso Paim
  Adaptado de Jakob Jenkov
  Data: Novembro/2025 
  Prog_148: app JavaFX para utilizar um controlo TreeTableView
*/

package edu.livrofundamentos.exemplos.cap4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class TreeTableViewDemo extends Application {    
    @Override
    public void start( Stage primaryStage ) {     
        
        TreeTableView<Carro> treeTableView = new TreeTableView<Carro>();
        
        TreeTableColumn<Carro, String> colMarca = new TreeTableColumn<>( "Marca" );
        colMarca.setCellValueFactory( new TreeItemPropertyValueFactory<>( "marca" ) );
        treeTableView.getColumns().add( colMarca );        
        
        TreeTableColumn<Carro, String> colModelo = new TreeTableColumn<>( "Modelo" );        
        colModelo.setCellValueFactory( new TreeItemPropertyValueFactory<>( "modelo" ) );
        treeTableView.getColumns().add( colModelo );
        
        TreeItem audi1 = new TreeItem( new Carro( "Audi", "A5" ) );
        TreeItem audi2 = new TreeItem( new Carro( "Audi", "A6" ) );
        TreeItem audi3 = new TreeItem( new Carro( "Audi", "Q7" ) );
        TreeItem audi = new TreeItem( new Carro( "Audi", "..." ) );
        audi.getChildren().add( audi1 );
        audi.getChildren().add( audi2 );
        audi.getChildren().add( audi3 );
        
        TreeItem ford1 = new TreeItem( new Carro( "Ford", "Edge" ) );
        TreeItem ford2 = new TreeItem( new Carro( "Ford", "Ranger" ) );
        TreeItem ford = new TreeItem( new Carro( "Ford", "..." ) );
        ford.getChildren().add( ford1 );
        ford.getChildren().add( ford2 ); 
        
        TreeItem hyundai1 = new TreeItem( new Carro( "Hyundai", "Accent" ) );
        TreeItem hyundai2 = new TreeItem( new Carro( "Hyundai", "Creta" ) );
        TreeItem hyundai3 = new TreeItem( new Carro( "Hyundai", "Elantra" ) );
        TreeItem hyundai4 = new TreeItem( new Carro( "Hyundai", "Santa Fe" ) );
        TreeItem hyundai5 = new TreeItem( new Carro( "Hyundai", "Tucson" ) );
        TreeItem hyundai = new TreeItem( new Carro( "Hyundai", "..." ) );
        hyundai.getChildren().add( hyundai1 );
        hyundai.getChildren().add( hyundai2 );    
        hyundai.getChildren().add( hyundai3 );
        hyundai.getChildren().add( hyundai4 );
        hyundai.getChildren().add( hyundai5 );
        
        TreeItem kia1 = new TreeItem( new Carro( "Kia", "Picanto" ) );
        TreeItem kia2 = new TreeItem( new Carro( "Kia", "Rio" ) );
        TreeItem kia3 = new TreeItem( new Carro( "Kia", "Sportage" ) );
        TreeItem kia = new TreeItem( new Carro( "Kia", "..." ) );
        kia.getChildren().add( kia1 );
        kia.getChildren().add( kia2 );
        kia.getChildren().add( kia3 );
        
        TreeItem toyota1 = new TreeItem( new Carro( "Toyota", "Starlet" ) );
        TreeItem toyota2 = new TreeItem( new Carro( "Toyota", "Corolla" ) );
        TreeItem toyota3 = new TreeItem( new Carro( "Toyota", "VX" ) );
        TreeItem toyota = new TreeItem( new Carro( "Toyota", "..." ) );
        toyota.getChildren().add( toyota1 );
        toyota.getChildren().add( toyota2 );   
        toyota.getChildren().add( toyota3 );        

        TreeItem carros = new TreeItem( new Carro( "Carros", "..." ) );
        carros.getChildren().add( audi );
        carros.getChildren().add( ford );
        carros.getChildren().add( hyundai );
        carros.getChildren().add( kia );
        carros.getChildren().add( toyota );

        treeTableView.setRoot( carros );  
        treeTableView.setPrefSize( 300, 250 );
      
        FlowPane root = new FlowPane( treeTableView );        
        Scene scene = new Scene( root, 300, 250 );                 
        primaryStage.setScene( scene );
        primaryStage.setTitle( "Testar TreeTableView" ); 
        primaryStage.show();
    }
    
    public class Carro {
        private String marca;
        private String modelo;

        public Carro() { }

        public Carro( String marca, String modelo ) {
            this.marca = marca;
            this.modelo = modelo;
        }

        public String getMarca() { return marca; }
        public void setMarca( String marca ) { this.marca = marca; }

        public String getModelo() { return modelo; }
        public void setModelo( String modelo ) { this.modelo = modelo; }
    }
    
    public static void main(String[] args) {
        launch( args );
    }
}
