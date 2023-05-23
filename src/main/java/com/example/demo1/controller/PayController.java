package com.example.demo1.controller;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import com.example.demo1.MainApplication;
import com.example.demo1.model.DecimalCell;
import com.example.demo1.model.MANPOWERTYPE;
import com.example.demo1.model.Worker;
import com.example.demo1.model.WorkerList;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    public Button backBtn;

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
        colocarImgBtn();
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

    public void initialize(WorkerList workerList) {
        this.workerList = workerList;
        employeeSP.setFitToHeight(true);
        employeeSP.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        lastnameCol.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        chargeCol.setCellValueFactory(new PropertyValueFactory<>("charge"));
        manpoCol.setCellValueFactory(new PropertyValueFactory<>("manpowertype"));
        this.salaryCol.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getSueldoDevengado()).asObject());
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
        this.pensionSCol.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getPensionSeguridad()).asObject());
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

    public void onGenerateExcel(){
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Hoja1");
        int rowNum = 0;
        String[] header = {"APELLIDOS", "NOMBRES", "CARGOS", "CLASIFICACION", "SUELDO", "AUXTRANS", "TOTAL", "SALUD", "PENSIÓN", "TOTAL", "SALUD", "PENSIÓN", "ATEP", "TOTAL", "CENSANTÍA", "PRIMA LEGAL", "VACACIONES", "INTERESES CS", "TOTAL", "CAJACOMP", "SENA", "ICBF", "TOTAL" };
        String[] header1 = {"", "", "", "", "DEVENGADO", "", "", "DEDUCCIONES", "", "", "SEGURIDAD SOCIAL", "", "", "", "PRESTACIONES SOCIALES", "", "","", "", "APORTES PARAFISCALES", "", "", ""};
        Row rew = sheet.createRow(rowNum++);
        int colNums = 0;
        for (int i = 0; i < header1.length ; i++) {
            Cell cell = rew.createCell(colNums++);
            cell.setCellValue(header1[i]);
            if(!header1[i].equals("")){
                CellRangeAddress region = null;
                if(header1[i].equals("PRESTACIONES SOCIALES")){
                    region = new CellRangeAddress(0, 0, i, i+4);
                } else if (header1[i].equals("APORTES PARAFISCALES") || header1[i].equals("SEGURIDAD SOCIAL")) {
                    region = new CellRangeAddress(0, 0, i, i+3);
                }else{
                    region = new CellRangeAddress(0, 0, i, i+2);
                }
                CellStyle headerCellStyle = workbook.createCellStyle();
                headerCellStyle.setAlignment(HorizontalAlignment.CENTER); // Alinear el texto al centro
                cell.setCellStyle(headerCellStyle);
                sheet.addMergedRegion(region);
                if(header1[i].equals("PRESTACIONES SOCIALES")){
                    rew.createCell(colNums++);
                    rew.createCell(colNums++);
                    i+=2;
                }
                if(header1[i].equals("APORTES PARAFISCALES") || header1[i].equals("SEGURIDAD SOCIAL")){
                    rew.createCell(colNums++);
                    i+=1;
                }
                rew.createCell(colNums++);
                rew.createCell(colNums++);
                i+=2;
            }
            sheet.autoSizeColumn(i);
        }
        Row raw = sheet.createRow(rowNum++);
        colNums = 0;
        for (int i = 0; i < 23 ; i++) {
            Cell cell = raw.createCell(colNums++);
            cell.setCellValue(header[i]);
            sheet.autoSizeColumn(i);
        }
        CellStyle accountingStyle = workbook.createCellStyle();
        DataFormat dataFormat = workbook.createDataFormat();
        short accountingFormat = dataFormat.getFormat("\"$\"#,##0");
        accountingStyle.setDataFormat(accountingFormat);

        for (Worker persona : workerList.getWorkerList()) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;

            Cell cell = row.createCell(colNum);
            cell.setCellValue(persona.getLastname());
            sheet.autoSizeColumn(colNum++);
            cell.setCellStyle(accountingStyle);


            cell = row.createCell(colNum);
            cell.setCellStyle(accountingStyle);
            cell.setCellValue(persona.getName());
            sheet.autoSizeColumn(colNum++);

            cell = row.createCell(colNum);
            cell.setCellStyle(accountingStyle);
            cell.setCellValue(persona.getCharge());
            sheet.autoSizeColumn(colNum++);

            cell = row.createCell(colNum);
            cell.setCellValue(persona.getManpowertype().toString());
            sheet.autoSizeColumn(colNum++);
            cell.setCellStyle(accountingStyle);

            cell = row.createCell(colNum);
            cell.setCellStyle(accountingStyle);
            cell.setCellValue(persona.getSueldoDevengado());
            sheet.autoSizeColumn(colNum++);

            cell = row.createCell(colNum);
            cell.setCellStyle(accountingStyle);
            cell.setCellValue(persona.getAuxTransporte());
            sheet.autoSizeColumn(colNum++);

            cell = row.createCell(colNum);
            cell.setCellStyle(accountingStyle);
            cell.setCellValue(persona.getTotDevengado());
            sheet.autoSizeColumn(colNum++);

            cell = row.createCell(colNum);
            cell.setCellValue(persona.getSalud());
            cell.setCellStyle(accountingStyle);
            sheet.autoSizeColumn(colNum++);

            cell = row.createCell(colNum);
            cell.setCellValue(persona.getPension());
            cell.setCellStyle(accountingStyle);
            sheet.autoSizeColumn(colNum++);

            cell = row.createCell(colNum);
            cell.setCellValue(persona.getTotDeducciones());
            cell.setCellStyle(accountingStyle);
            sheet.autoSizeColumn(colNum++);

            cell = row.createCell(colNum);
            cell.setCellStyle(accountingStyle);
            cell.setCellValue(persona.getSaludSeguridad());
            sheet.autoSizeColumn(colNum++);

            cell = row.createCell(colNum);
            cell.setCellStyle(accountingStyle);
            cell.setCellValue(persona.getPensionSeguridad());
            sheet.autoSizeColumn(colNum++);

            cell = row.createCell(colNum);
            cell.setCellStyle(accountingStyle);
            cell.setCellValue(persona.getAtep());
            sheet.autoSizeColumn(colNum++);

            cell = row.createCell(colNum);
            cell.setCellStyle(accountingStyle);
            cell.setCellValue(persona.getTotSeguridad());
            sheet.autoSizeColumn(colNum++);

            cell = row.createCell(colNum);
            cell.setCellStyle(accountingStyle);
            cell.setCellValue(persona.getCesantia());
            sheet.autoSizeColumn(colNum++);

            cell = row.createCell(colNum);
            cell.setCellStyle(accountingStyle);
            cell.setCellValue(persona.getPrimaLegal());
            sheet.autoSizeColumn(colNum++);

            cell = row.createCell(colNum);
            cell.setCellStyle(accountingStyle);
            cell.setCellValue(persona.getVacaciones());
            sheet.autoSizeColumn(colNum++);

            cell = row.createCell(colNum);
            cell.setCellStyle(accountingStyle);
            cell.setCellValue(persona.getInteresesCS());
            sheet.autoSizeColumn(colNum++);

            cell = row.createCell(colNum);
            cell.setCellStyle(accountingStyle);
            cell.setCellValue(persona.getTotPrestacionesSo());
            sheet.autoSizeColumn(colNum++);

            cell = row.createCell(colNum);
            cell.setCellStyle(accountingStyle);
            cell.setCellValue(persona.getCajaComp());
            sheet.autoSizeColumn(colNum++);

            cell = row.createCell(colNum);
            cell.setCellStyle(accountingStyle);
            cell.setCellValue(persona.getSena());
            sheet.autoSizeColumn(colNum++);

            cell = row.createCell(colNum);
            cell.setCellStyle(accountingStyle);
            cell.setCellValue(persona.getIcbf());
            sheet.autoSizeColumn(colNum++);

            cell = row.createCell(colNum);
            cell.setCellStyle(accountingStyle);
            cell.setCellValue(persona.getTotParafiscales());
            sheet.autoSizeColumn(colNum++);
        }

        String path = (System.getProperty("user.dir")+"/hoja.xlsx");

        try {
            OutputStream fileOut = Files.newOutputStream(Paths.get(path));
            workbook.write(fileOut);
        }catch (IOException e){
            e.printStackTrace();
        }

        try {
            File file = new File(System.getProperty("user.dir"));
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                // En Windows
                Runtime.getRuntime().exec("cmd /c start " + file);
            } else if (os.contains("mac")) {
                // En macOS
                Runtime.getRuntime().exec("open " + file);
            } else {
                // En Linux u otros sistemas operativos
                Runtime.getRuntime().exec("xdg-open " + file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
