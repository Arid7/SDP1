/*
  Autor: Celso Paim
  Adaptado de Jakob Jenkov
  Data: Novembro/2025
  Prog_162: app JavaFX para demonstrar um grafico de barras empilhadas
*/

package edu.livrofundamentos.exemplos.cap4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
 
public class StackedBarChartDemo extends Application { 
    @Override 
    public void start( Stage primaryStage ) {
        FlowPane root = new FlowPane();  
        Scene scene = new Scene( root, 400, 325 ); 
        primaryStage.setTitle( "Demo grafico de barras empilhadas" );

        Label label = new Label( "  Penetracao de devices moveis na Africa Sub-sahariana" );
        root.getChildren().add( label );

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel( "Dispositivos moveis" );
        xAxis.getCategories().addAll( "GSM (2G)", "UMTS (3G)", "LTE (4G)", "5G");

        NumberAxis yAxis = new NumberAxis( 0, 100, 5 ); 
        yAxis.setLabel( "Percentagem" );

        StackedBarChart chart = new StackedBarChart( xAxis, yAxis );
        chart.setPrefSize( 300, 295 );

        XYChart.Series series2G = new XYChart.Series();
        series2G.setName( "GSM (2G)" );
        series2G.getData().add( new XYChart.Data( "2020", 42 ) );
        series2G.getData().add( new XYChart.Data( "2026", 30 ) );
        chart.getData().add( series2G );

        XYChart.Series series3G = new XYChart.Series();
        series3G.setName( "UMTS (3G)" );
        series3G.getData().add( new XYChart.Data( "2020", 43 ) );
        series3G.getData().add( new XYChart.Data( "2026", 35 ) );
        chart.getData().add( series3G );

        XYChart.Series series4G = new XYChart.Series();
        series4G.setName( "LTE (4G)" );
        series4G.getData().add( new XYChart.Data( "2020", 15 ) );
        series4G.getData().add( new XYChart.Data( "2026" , 28 ) );
        chart.getData().add( series4G );
        
        XYChart.Series series5G = new XYChart.Series();
        series5G.setName( "5G" );
        series5G.getData().add( new XYChart.Data( "2020", 0 ) );
        series5G.getData().add( new XYChart.Data( "2026", 7 ) ); 
        chart.getData().add( series5G );

        root.getChildren().add( chart );
        primaryStage.setScene( scene );
        primaryStage.show();
    }
 
    public static void main(String[] args) {
        launch( args );
    } 
}

