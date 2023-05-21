package com.example.demo1.controller;

import com.example.demo1.MainApplication;
import com.example.demo1.exceptions.LowSalaryException;
import com.example.demo1.model.MANPOWERTYPE;
import com.example.demo1.model.Worker;
import com.example.demo1.model.WorkerList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AddEmployeeController implements Initializable {

    @FXML
    public TextField fullNameTF;

    @FXML
    public TextField chargeTF;

    @FXML
    public TextField salaryTF;

    @FXML
    public DatePicker entryDateDP;



    @FXML
    public ComboBox<MANPOWERTYPE> manoObraCB;
    private WorkerList workerList;

    @FXML
    public Button backBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colocarImgBtn();
        ObservableList<MANPOWERTYPE> list = FXCollections.observableArrayList(MANPOWERTYPE.DIRECTA, MANPOWERTYPE.INDIRECTA);
        manoObraCB.setItems(list);
        manoObraCB.setPromptText("Elija el tipo de mano de obra");
        manoObraCB.getSelectionModel().selectedItemProperty().addListener((value, old, nu)->{
        });
    }

    public void initialize(WorkerList workerList){
        this.workerList = workerList;

    }

    public WorkerList getWorkerList() {
        return workerList;
    }

    public void setWorkerList(WorkerList workerList) {
        this.workerList = workerList;
    }

    private void colocarImgBtn(){
        URL link = getClass().getResource("/img/back.png");
        Image image = new Image(link.toString(), 30, 30, false, true);
        backBtn.setGraphic(new ImageView(image));
    }

    @FXML
    public void onAddWorker(ActionEvent event) {
        String fullName = fullNameTF.getText();
        String charge = chargeTF.getText();
        String salary = salaryTF.getText();
        LocalDate entryDate = entryDateDP.getValue();
        MANPOWERTYPE type = manoObraCB.getValue();
        try {
            if (Double.parseDouble(salary) < 1160000) {
                throw new LowSalaryException("El salario debe ser mayor o igual a 1.160.000");
            }
            Worker worker = new Worker(fullName, charge, Double.parseDouble(salary), entryDate, type);
            workerList.addWorker(worker);
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al agregar");
            alert.setContentText("El salario debe ser un número válido.");
            alert.showAndWait();
        } catch (LowSalaryException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al agregar");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    public void onGoBack(ActionEvent actionEvent) {
        EmployeeController con = MainApplication.loadWindow("manage-view.fxml").getController();
        con.initialize(this.workerList);
        Stage stage = (Stage) backBtn.getScene().getWindow();
        stage.close();
    }
}
