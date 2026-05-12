/*
  Autor: Celso Paim
  Adaptado de Jakob Jenkov
  Data: Novembro/2025
  Prog_160: app JavaFX para demonstrar um grafico de linha
*/

package edu.livrofundamentos.exemplos.cap4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;  
import javafx.scene.chart.XYChart;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
 
public class LineChartDemo extends Application { 
    @Override 
    public void start( Stage primaryStage ) {
        FlowPane root = new FlowPane();  
        Scene scene = new Scene( root, 500, 375 ); 
        primaryStage.setTitle( "Demo grafico de linha" );
 
        NumberAxis xaxis = new NumberAxis( 2010, 2025, 1 );
        xaxis.setLabel( "Ano" ); 
        
        NumberAxis yaxis = new NumberAxis( 0, 1000, 50 );         
        yaxis.setLabel( "Valor" );  
          
        LineChart chart = new LineChart( xaxis, yaxis ); 
        chart.setTitle( "Taxa de cambio AOA-USD" );
          
        XYChart.Series series = new XYChart.Series();     
        series.setName( "Taxa de cambio AOA-USD" );   
        series.getData().add( new XYChart.Data( 2010, 93 ) );  
        series.getData().add( new XYChart.Data( 2011, 94 ) );  
        series.getData().add( new XYChart.Data( 2012, 95 ) );  
        series.getData().add( new XYChart.Data( 2013, 97 ) );  
        series.getData().add( new XYChart.Data( 2014, 100 ) );  
        series.getData().add( new XYChart.Data( 2015, 150 ) );  
        series.getData().add( new XYChart.Data( 2016, 165 ) );  
        series.getData().add( new XYChart.Data( 2017, 165 ) ); 
        series.getData().add( new XYChart.Data( 2018, 308 ) );
        series.getData().add( new XYChart.Data( 2019, 482 ) );
        series.getData().add( new XYChart.Data( 2020, 655 ) );
        series.getData().add( new XYChart.Data( 2021, 567 ) ); 
        series.getData().add( new XYChart.Data( 2022, 505 ) );          
        series.getData().add( new XYChart.Data( 2023, 846 ) );          
        series.getData().add( new XYChart.Data( 2024, 922 ) );          
        series.getData().add( new XYChart.Data( 2025, 915 ) ); 
        chart.getData().add( series );

        root.getChildren().add( chart );
        primaryStage.setScene( scene );
        primaryStage.show();
    }
 
    public static void main(String[] args) {
        launch( args );
    }
}

