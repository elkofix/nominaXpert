package com.example.demo1.controller;

import com.example.demo1.model.Worker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class PayController implements Initializable {
    @FXML
    public TableView<Worker> employeeTV;
    @FXML
    public ScrollPane employeeSP;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        employeeSP.setFitToHeight(true);
        employeeSP.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
    }
}
