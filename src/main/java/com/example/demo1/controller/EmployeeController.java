package com.example.demo1.controller;

import com.example.demo1.MainApplication;
import com.example.demo1.model.DecimalCell;
import com.example.demo1.model.Worker;
import com.example.demo1.model.WorkerList;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class EmployeeController implements Initializable {

    @FXML
    public Button addBtn;

    @FXML
    public TableColumn<Worker, String> surnameCol;

    @FXML
    public TableColumn<Worker, String> nameCol;

    @FXML
    public TableColumn<Worker, String> chargeCol;

    @FXML
    public TableColumn<Worker, Double> salaryCol;

    @FXML
    public TableColumn<Worker, Integer> workDaysCol;

    @FXML
    public TableColumn<Worker, LocalDate> starDateCol;

    @FXML
    public TableView<Worker> employeesTB;

    @FXML
    public BorderPane borderPane;


    private WorkerList workerList;

    public void onAddEmployee(ActionEvent actionEvent) {
        AddEmployeeController con = MainApplication.loadWindow("add-employee-view.fxml").getController();
        System.out.println(workerList);
        con.initialize(this.workerList);
        Stage stage = (Stage) addBtn.getScene().getWindow();
        stage.close();
    }

    public void initialize(WorkerList workerList) {
        this.workerList = workerList;
        this.surnameCol.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        this.nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.chargeCol.setCellValueFactory(new PropertyValueFactory<>("charge"));
        this.salaryCol.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getSalary()).asObject());
        this.salaryCol.setCellFactory(column -> new DecimalCell());
        this.workDaysCol.setCellValueFactory(new PropertyValueFactory<>("diasTrabajados"));
        this.starDateCol.setCellValueFactory(new PropertyValueFactory<>("entryDate"));
        this.employeesTB.setItems(this.workerList.getWorkerList());
        employeesTB.prefWidthProperty().bind(borderPane.widthProperty());
        employeesTB.prefHeightProperty().bind(borderPane.heightProperty());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initialize(new WorkerList());
    }
}
