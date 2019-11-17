/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

/**
 * Controlador del fxml Vista
 * @author Victor
 */
public class VistaController implements Initializable {

    @FXML
    private void handleButtonAction(ActionEvent event) {
        //Load native opencv library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        //Read image from file first param:file location ,second param:color space
        Mat img = Imgcodecs.imread("images.estacionamiento.png", Imgcodecs.IMREAD_COLOR);
        //If the image is successfully read.
        if (img.empty()) {
            System.exit(1);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
