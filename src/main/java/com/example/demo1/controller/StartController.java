package com.example.demo1.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class StartController implements Initializable {
    @FXML
    public Button addEmployeeBtn;

    @FXML
    public Button liqNominaBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        colocarImgBtn();
    }

    private void colocarImgBtn(){
        URL link = getClass().getResource("/img/addEmployee.png");
        URL link1 = getClass().getResource("/img/nomina.png");
        Image image = new Image(link.toString(), 200, 200, false, true);
        Image image2 = new Image(link1.toString(), 200, 200, false, true);
        addEmployeeBtn.setGraphic(new ImageView(image));
        liqNominaBtn.setGraphic(new ImageView(image2));
    }

}