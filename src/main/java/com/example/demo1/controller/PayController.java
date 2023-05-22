package com.example.demo1.controller;

import com.example.demo1.model.DecimalCell;
import com.example.demo1.model.MANPOWERTYPE;
import com.example.demo1.model.Worker;
import com.example.demo1.model.WorkerList;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class PayController implements Initializable {
    @FXML
    public TableView<Worker> employeeTV;
    @FXML
    public ScrollPane employeeSP;
    @FXML
    public TableColumn<Worker, String> lastnameCol;
    @FXML
    public TableColumn<Worker, String> nameCol;
    @FXML
    public TableColumn<Worker, String> chargeCol;
    @FXML
    public TableColumn<Worker, MANPOWERTYPE> manpoCol;
    @FXML
    public TableColumn<Worker, Double> salaryCol;
    @FXML
    public TableColumn<Worker, Double> auxtransCol;
    @FXML
    public TableColumn<Worker, Double> devengaCol;
    @FXML
    public TableColumn<Worker, Double> healthCol;
    @FXML
    public TableColumn<Worker, Double> pensionCol;
    @FXML
    public TableColumn<Worker, Double> deduCol;
    @FXML
    public TableColumn<Worker, Double> healthSCol;
    @FXML
    public TableColumn<Worker, Double> pensionSCol;
    @FXML
    public TableColumn<Worker, Double> atepSCol;
    @FXML
    public TableColumn<Worker, Double> socialSecCol;
    @FXML
    public TableColumn<Worker, Double> censantiaCol;
    @FXML
    public TableColumn<Worker, Double> primaCol;
    @FXML
    public TableColumn<Worker, Double> vacationCol;
    @FXML
    public TableColumn<Worker, Double> interesesCol;
    @FXML
    public TableColumn<Worker, Double> socialLoanCol;
    @FXML
    public TableColumn<Worker, Double> cajacomCol;
    @FXML
    public TableColumn<Worker, Double> senaCol;
    @FXML
    public TableColumn<Worker, Double> icbfCol;
    @FXML
    public TableColumn<Worker, Double> parafiscalAportCol;

    public WorkerList getWorkerList() {
        return workerList;
    }

    public void setWorkerList(WorkerList workerList) {
        this.workerList = workerList;
    }

    private WorkerList workerList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        employeeSP.setFitToHeight(true);
        employeeSP.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
    }

    public void initialize(WorkerList workerList) {
        this.workerList = workerList;
        employeeSP.setFitToHeight(true);
        employeeSP.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        lastnameCol.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        chargeCol.setCellValueFactory(new PropertyValueFactory<>("charge"));
        manpoCol.setCellValueFactory(new PropertyValueFactory<>("manpowertype"));
        this.salaryCol.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getSalary()).asObject());
        this.salaryCol.setCellFactory(column -> new DecimalCell());
        this.auxtransCol.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getAuxTransporte()).asObject());
        this.auxtransCol.setCellFactory(column -> new DecimalCell());
        this.devengaCol.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getTotDevengado()).asObject());
        this.devengaCol.setCellFactory(column -> new DecimalCell());
        this.healthCol.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getSalud()).asObject());
        this.healthCol.setCellFactory(column -> new DecimalCell());
        this.pensionCol.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getPension()).asObject());
        this.pensionCol.setCellFactory(column -> new DecimalCell());
        this.deduCol.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getTotDeducciones()).asObject());
        this.deduCol.setCellFactory(column -> new DecimalCell());
        this.healthSCol.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getSaludSeguridad()).asObject());
        this.healthSCol.setCellFactory(column -> new DecimalCell());
        this.pensionSCol.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getSaludSeguridad()).asObject());
        this.pensionSCol.setCellFactory(column -> new DecimalCell());
        this.atepSCol.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getAtep()).asObject());
        this.atepSCol.setCellFactory(column -> new DecimalCell());
        this.pensionSCol.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getSaludSeguridad()).asObject());
        this.pensionSCol.setCellFactory(column -> new DecimalCell());
        this.socialSecCol.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getTotSeguridad()).asObject());
        this.socialSecCol.setCellFactory(column -> new DecimalCell());
        this.censantiaCol.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getCesantia()).asObject());
        this.censantiaCol.setCellFactory(column -> new DecimalCell());
        this.primaCol.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getPrimaLegal()).asObject());
        this.primaCol.setCellFactory(column -> new DecimalCell());
        this.vacationCol.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getVacaciones()).asObject());
        this.vacationCol.setCellFactory(column -> new DecimalCell());
        this.interesesCol.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getInteresesCS()).asObject());
        this.interesesCol.setCellFactory(column -> new DecimalCell());
        this.socialLoanCol.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getTotPrestacionesSo()).asObject());
        this.socialLoanCol.setCellFactory(column -> new DecimalCell());
        this.cajacomCol.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getCajaComp()).asObject());
        this.cajacomCol.setCellFactory(column -> new DecimalCell());
        this.senaCol.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getSena()).asObject());
        this.senaCol.setCellFactory(column -> new DecimalCell());
        this.icbfCol.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getIcbf()).asObject());
        this.icbfCol.setCellFactory(column -> new DecimalCell());
        this.parafiscalAportCol.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getTotParafiscales()).asObject());
        this.parafiscalAportCol.setCellFactory(column -> new DecimalCell());
        this.employeeTV.setItems(this.workerList.getWorkerList());
    }
}
