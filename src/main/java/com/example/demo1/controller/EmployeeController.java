package com.example.demo1.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeController implements Initializable {
    @FXML
    public TableView employeeTV;
    @FXML
    public ScrollPane employeeSP;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        employeeSP.setFitToHeight(true);
        employeeSP.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
    }
}
