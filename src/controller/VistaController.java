/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;

/**
 * Controlador del fxml Vista
 * @author Victor
 */
public class VistaController implements Initializable {
 @FXML
    private ImageView imgview;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        //Load native opencv library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        //Read image from file first param:file location ,second param:color space
        Mat img = Imgcodecs.imread("src/images/est.png", Imgcodecs.IMREAD_COLOR);
        imgview.setImage(new Image("images/est.png"));
        //If the image is successfully read.
        if (img.empty()) {
            JOptionPane.showMessageDialog(null, "Imagen no encontrada");
            System.exit(1);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
