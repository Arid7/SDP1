/*
  Autor: Celso Paim
  Adaptado de Jakob Jenkov
  Data: Novembro/2025
  app JavaFX para demonstrar um grafico de area
*/

package edu.livrofundamentos.exemplos.cap4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;  
import javafx.scene.chart.XYChart;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
 
public class AreaChartDemo extends Application { 
    @Override 
    public void start( Stage primaryStage ) {
        FlowPane root = new FlowPane();  
        Scene scene = new Scene( root, 500, 400 ); 
        primaryStage.setTitle( "Demo grafico de area" );

        NumberAxis xaxis = new NumberAxis( 1, 12, 1 ); 
        xaxis.setLabel( "Mes" ); 
        
        NumberAxis yaxis = new NumberAxis( 10, 510, 50 );          
        yaxis.setLabel( "Valor" );  
          
        AreaChart<Number, Number> chart = new AreaChart( xaxis, yaxis );  
        chart.setTitle( "Vendas por regiao" );  
      
        XYChart.Series seriesNorth = new XYChart.Series();  
        seriesNorth.setName( "Regiao Norte" );  
        seriesNorth.getData().add( new XYChart.Data( 1, 120 ) );  
        seriesNorth.getData().add( new XYChart.Data( 2, 140 ) );  
        seriesNorth.getData().add( new XYChart.Data( 3, 50 ) );  
        seriesNorth.getData().add( new XYChart.Data( 4, 80 ) );  
        seriesNorth.getData().add( new XYChart.Data( 5, 150 ) );  
        seriesNorth.getData().add( new XYChart.Data( 6, 130 ) );  
        seriesNorth.getData().add( new XYChart.Data( 7, 110 ) );  
        seriesNorth.getData().add( new XYChart.Data( 8, 90 ) );  
        seriesNorth.getData().add( new XYChart.Data( 9, 200 ) );  
        seriesNorth.getData().add( new XYChart.Data( 10, 120 ) );  
        seriesNorth.getData().add( new XYChart.Data( 11, 100 ) );  
        seriesNorth.getData().add( new XYChart.Data( 12, 120 ) );  
      
        XYChart.Series seriesSouth = new XYChart.Series();  
        seriesSouth.setName( "Regiao Sul" );  
        seriesSouth.getData().add( new XYChart.Data( 1,220 ) );  
        seriesSouth.getData().add( new XYChart.Data( 2,40 ) );  
        seriesSouth.getData().add( new XYChart.Data( 3,250 ) );  
        seriesSouth.getData().add( new XYChart.Data( 4,180 ) );  
        seriesSouth.getData().add( new XYChart.Data( 5,450 ) );  
        seriesSouth.getData().add( new XYChart.Data( 6,230 ) );  
        seriesSouth.getData().add( new XYChart.Data( 7,110 ) );  
        seriesSouth.getData().add( new XYChart.Data( 8,100 ) );  
        seriesSouth.getData().add( new XYChart.Data( 9,123 ) );  
        seriesSouth.getData().add( new XYChart.Data( 10,125 ) );  
        seriesSouth.getData().add( new XYChart.Data( 11,225 ) );  
        seriesSouth.getData().add( new XYChart.Data( 12,127 ) );    
     
        chart.getData().addAll( seriesNorth, seriesSouth );    

        root.getChildren().add( chart );
        primaryStage.setScene( scene );
        primaryStage.show();
    }
 
    public static void main(String[] args) {
        launch( args );
    }
}

