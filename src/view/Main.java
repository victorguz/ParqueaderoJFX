/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Realizar una implementación práctica de identificación de razas de pájaros/
 * gatos/peces (al menos 5 diferentes razas) o plantas/árboles/flores (al menos
 * 5 diferentes) al cual se le muestre una imagen no entrenada y esta diga a que
 * raza o especie corresponde etiquetando sobre la imagen el tipo
 * correspondiente: Calificación máxima 4.5
 *
 * @author Victor
 */
public class Main extends Application {
    public static Stage stageStatic;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Vista.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stageStatic=stage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
