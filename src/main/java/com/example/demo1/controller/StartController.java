package com.example.demo1.controller;

import com.example.demo1.MainApplication;
import com.example.demo1.model.Worker;
import com.example.demo1.model.WorkerList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

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

    public void onManageEmployee(ActionEvent actionEvent) {
        AddEmployeeController a = MainApplication.loadWindow("employee-view.fxml").getController();
        a.setWorkerList(new WorkerList());
        Stage stage = (Stage) liqNominaBtn.getScene().getWindow();
        stage.close();
    }

    public void onEmployees(ActionEvent actionEvent) {
        EmployeeController a = MainApplication.loadWindow("manage-view.fxml").getController();
        WorkerList aa = new WorkerList();
        System.out.println(aa);
        a.initialize(aa);
        Stage stage = (Stage) liqNominaBtn.getScene().getWindow();
        stage.close();
    }
}