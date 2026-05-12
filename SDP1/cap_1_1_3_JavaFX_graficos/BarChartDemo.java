/*
  Autor: Celso Paim
  Adaptado de Jakob Jenkov
  Data: Novembro/2025
  Prog_161: app JavaFX para demonstrar um grafico circular
*/

package edu.livrofundamentos.exemplos.cap4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
 
public class BarChartDemo extends Application { 
    @Override 
    public void start( Stage primaryStage ) {
        FlowPane root = new FlowPane();  
        Scene scene = new Scene( root, 600, 400 ); 
        primaryStage.setTitle( "Demo grafico de barras" );
       
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel( "Provincias" );

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel( "Quantidade" );

        BarChart chart = new BarChart( xAxis, yAxis );
        chart.setTitle( "Distribuicao populacional em Angola" );
        chart.setPrefSize( 590, 390 );

        XYChart.Series series = new XYChart.Series();
        series.setName( "# Habitantes" );

        series.getData().add( new XYChart.Data( "Bengo", 351579 ) );
        series.getData().add( new XYChart.Data( "Benguela", 2036662 ) );
        series.getData().add( new XYChart.Data( "Bie", 1338923 ) );
        series.getData().add( new XYChart.Data( "Cabinda", 688285 ) );
        series.getData().add( new XYChart.Data( "Cuando-Cubango", 510369 ) );
        series.getData().add( new XYChart.Data( "Cuanza-Norte", 427971 ) );
        series.getData().add( new XYChart.Data( "Cuanza-Sul", 1793787 ) );
        series.getData().add( new XYChart.Data( "Cunene", 965288 ) );
        series.getData().add( new XYChart.Data( "Huambo", 1896147 ) );
        series.getData().add( new XYChart.Data( "Huila", 2354398 ) );
        series.getData().add( new XYChart.Data( "Luanda", 6542944 ) );
        series.getData().add( new XYChart.Data( "Lunda-Norte", 799950 ) );
        series.getData().add( new XYChart.Data( "Lunda-Sul", 516077 ) );
        series.getData().add( new XYChart.Data( "Malange", 968135 ) );
        series.getData().add( new XYChart.Data( "Moxico", 727594 ) );
        series.getData().add( new XYChart.Data( "Namibe", 471613 ) );
        series.getData().add( new XYChart.Data( "Uige", 1426354 ) );
        series.getData().add( new XYChart.Data( "Zaire", 567225 ) );

        chart.getData().add( series );

        root.getChildren().add( chart );
        primaryStage.setScene( scene );
        primaryStage.show();
    }
 
    public static void main(String[] args) {
        launch( args );
    }
}