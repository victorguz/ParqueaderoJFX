/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import view.Main;

/**
 * Controlador del fxml Vista
 *
 * @author Victor
 */
public class VistaController implements Initializable {

    @FXML
    private ImageView imgcargada;

    @FXML
    private ImageView imgresult;

    @FXML
    private TextArea textResult;

    private Mat imgcolor;

    private Mat imggray;

    private FileChooser fc;

    private File file;
    CascadeClassifier classifier = new CascadeClassifier("haar/haarcascade_frontalface_default.xml");

    public void addResult(String title, String text) {
        if (textResult.getText().isEmpty()) {
            textResult.setText(title + ": " + text + "\n");
        } else {
            textResult.setText(textResult.getText() + title + ": " + text + "\n");
        }
    }

    public void limpiar() {
        textResult.clear();
    }

    @FXML
    private void cargar() {
        //The user can be set the image file to compare...
        fc = new FileChooser();
        fc.setTitle("Seleccione una imagen");
        file = fc.showOpenDialog(Main.stageStatic);
        if (file != null) {
            //Read image from file first param:file location ,second param:color space
            imgcolor = Imgcodecs.imread(file.getAbsolutePath(), Imgcodecs.IMREAD_COLOR);
            imggray = Imgcodecs.imread(file.getAbsolutePath(), Imgcodecs.IMREAD_GRAYSCALE);
            imgcargada.setImage(new Image(file.toURI().toString()));
            //If the image is successfully read.
            if (imgcolor.empty()) {
                JOptionPane.showMessageDialog(null, "Imagen no encontrada");
                System.exit(1);
            } else {
                addResult("Rows", "" + imgcolor.rows());
                addResult("Cols", "" + imgcolor.cols());
            }

        }
    }

    public void detectarRostro() {
        MatOfRect faces = new MatOfRect();
        classifier.detectMultiScale(imgcolor, faces);
        for (Rect r : faces.toArray()) {
            Imgproc.rectangle(imgcolor, r.tl(), r.br(), new Scalar(0, 255, 0));
        }
        Imgcodecs.imwrite("result/result.jpg", imgcolor); 
        imgresult.setImage(new Image(new File("result/result.jpg").toURI().toString()));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Load native opencv library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

}
