/*
  Autor: Celso Paim
  Data: Novembro/2025
  Prog_131: app JavaFX para receber 2 inteiros num dialogo de entrada e apresentar
o resultado da soma num dialogo informativo
 */
package edu.livrofundamentos.exemplos.cap4;

import java.util.Optional;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class DialogPaneDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextInputDialog input = new TextInputDialog("");
        input.setTitle("Solicitacao");
        input.setHeaderText(null);
        input.setContentText("Introduza o seu nome: ");

        Optional<String> nome = input.showAndWait();
        int num1 = 0, num2 = 0;
        do {
            try {
                TextInputDialog dialog = new TextInputDialog("");
                dialog.setTitle("Solicitacao");
                dialog.setContentText("Digite o 1.º inteiro: ");
                Optional<String> tmp = dialog.showAndWait();
                num1 = Integer.parseInt(tmp.get());
                break;
            } catch (Exception ex) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Aviso");
                alert.setHeaderText("Atencao - Entrada invalida!");
                alert.setContentText("O 1.º operando deve ser um valor inteiro");
                alert.showAndWait();
            }
        } while (true);

        do {
            try {
                TextInputDialog dialog = new TextInputDialog("");
                dialog.setTitle("Solicitacao");
                dialog.setContentText("Digite o 2.º inteiro: ");
                Optional<String> tmp = dialog.showAndWait();
                num2 = Integer.parseInt(tmp.get());

                if (num2 == 0) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("ERRO");
                    alert.setHeaderText("Atencao - Entrada invalida!");
                    alert.setContentText("O 2.º operando nao pode ser nulo");
                    alert.showAndWait();
                } else {
                    break;
                }
            } catch (Exception ex) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Aviso");
                alert.setHeaderText("Atencao - Entrada invalida!");
                alert.setContentText("O 2.º operando deve ser um valor inteiro");
                alert.showAndWait();
            }
        } while (true);

        String msg = "Ola " + (nome.isPresent() ? nome.get() : "DESCONHECIDO");
        msg += "\n\nEis o resultado das operacoes aritmeticas:";
        msg += "\n" + num1 + " + " + num2 + " = " + (num1 + num2);
        msg += "\n" + num1 + " - " + num2 + " = " + (num1 - num2);
        msg += "\n" + num1 + " * " + num2 + " = " + (num1 * num2);
        msg += "\n" + num1 + " / " + num2 + " = " + (num1 / num2);
        msg += "\n" + num1 + " % " + num2 + " = " + (num1 % num2);

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Informacao");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
