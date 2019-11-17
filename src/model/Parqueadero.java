/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import javax.imageio.ImageIO;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.objdetect.CascadeClassifier;

/**
 *
 * @author Victor
 */
public class Parqueadero {
    private CascadeClassifier diceCascade = new
        CascadeClassifier("res/newMethod/diceCascade.xml");
    private Mat image;
    private String loc = "path/to/image.png";
    private String output = "path/to/output.png";
    
    public Parqueadero(){
        
    }
 
    
}
