package com.example.demo1.controller;

import com.example.demo1.MainApplication;
import com.example.demo1.model.DecimalCell;
import com.example.demo1.model.Worker;
import com.example.demo1.model.WorkerList;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.time.LocalDate;

public class EmployeeController{

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
        MainApplication.loadWindow("add-employee-view.fxml");
        Stage stage = (Stage) addBtn.getScene().getWindow();
        stage.close();
    }

    public void initialize() {
        this.workerList = new WorkerList();

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
}
