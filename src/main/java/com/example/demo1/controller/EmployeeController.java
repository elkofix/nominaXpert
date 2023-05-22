package com.example.demo1.controller;

import com.example.demo1.MainApplication;
import com.example.demo1.model.DecimalCell;
import com.example.demo1.model.FileManager;
import com.example.demo1.model.Worker;
import com.example.demo1.model.WorkerList;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class EmployeeController {

    @FXML
    public TableColumn<Worker, Void> deleteColumn;

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



    @FXML
    public TableColumn<Worker, Void> editCol;
    @FXML
    public Button backBtn;

    public WorkerList getWorkerList() {
        return workerList;
    }

    public void setWorkerList(WorkerList workerList) {
        System.out.println("Init");
        this.workerList = workerList;
    }

    private void colocarImgBtn(){
        URL link = getClass().getResource("/img/back.png");
        Image image = new Image(link.toString(), 30, 30, false, true);
        backBtn.setGraphic(new ImageView(image));
    }

    public void onGoBack(ActionEvent actionEvent) {
        StartController con = MainApplication.loadWindow("start-view.fxml").getController();
        con.setWorkerList(this.workerList);
        Stage stage = (Stage) backBtn.getScene().getWindow();
        stage.close();
    }


    private WorkerList workerList;

    public void onAddEmployee(ActionEvent actionEvent) {
        AddEmployeeController con = MainApplication.loadWindow("add-employee-view.fxml").getController();
        con.initialize(this.workerList);
        Stage stage = (Stage) addBtn.getScene().getWindow();
        stage.close();
    }

    public void initialize(WorkerList workerList) {
        colocarImgBtn();
        this.workerList = workerList;
        this.surnameCol.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        this.nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.chargeCol.setCellValueFactory(new PropertyValueFactory<>("charge"));
        this.salaryCol.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getSalary()).asObject());
        this.salaryCol.setCellFactory(column -> new DecimalCell());
        this.workDaysCol.setCellValueFactory(new PropertyValueFactory<>("diasTrabajados"));
        this.starDateCol.setCellValueFactory(new PropertyValueFactory<>("entryDate"));
        this.deleteColumn.setCellFactory(column -> new TableCell<>() {
            private final Button button = new Button("Borrar");

            {
                button.setOnAction(event -> {

                    Worker person = getTableRow().getItem();
                    workerList.deleteWorker(person);
                    FileManager.setWorkerList(getWorkerList());
                    FileManager.saveData();
                    employeesTB.setItems(workerList.getWorkerList());
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(button);
                }
            }
        });
        this.editCol.setCellFactory(column -> new TableCell<>() {
            private final Button button = new Button("Editar");
            {
                button.setOnAction(event -> {
                    Worker person = getTableRow().getItem();
                    AddEmployeeController con = MainApplication.loadWindow("add-employee-view.fxml").getController();
                    con.initialize(person, workerList);
                    Stage stage = (Stage) addBtn.getScene().getWindow();
                    stage.close();
                });
            }
            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(button);
                }
            }
        });
        this.employeesTB.setItems(getWorkerList().getWorkerList());
        employeesTB.prefWidthProperty().bind(borderPane.widthProperty());
        employeesTB.prefHeightProperty().bind(borderPane.heightProperty());
    }

}
