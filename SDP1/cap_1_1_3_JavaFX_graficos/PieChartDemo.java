/*
  Autor: Celso Paim
  Adaptado de Jakob Jenkov
  Data: Novembro/2025
  Prog_158: app JavaFX para demonstrar um grafico circular
*/

package edu.livrofundamentos.exemplos.cap4;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
 
public class PieChartDemo extends Application { 
    @Override 
    public void start( Stage primaryStage ) {
        FlowPane root = new FlowPane();  
        Scene scene = new Scene( root, 475, 375 ); 
        primaryStage.setTitle( "Demo grafico circular" );
 
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
            new PieChart.Data( "Kikongo", 2000000 ),
            new PieChart.Data( "Kimbundo", 3000000 ),
            new PieChart.Data( "Nganguela", 300000 ),
            new PieChart.Data( "Tchokwe", 456000 ),
            new PieChart.Data( "Umbundo", 6980000 )
        );
        PieChart chart = new PieChart( pieChartData );
        chart.setTitle( "Linguas nacionais de Angola" );
        chart.setLabelLineLength( 10 );
        chart.setLegendSide( Side.LEFT );

        root.getChildren().add( chart );
        primaryStage.setScene( scene );
        primaryStage.show();
    }
 
    public static void main(String[] args) {
        launch( args );
    }
}

