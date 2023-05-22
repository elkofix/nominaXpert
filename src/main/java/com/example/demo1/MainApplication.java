package com.example.demo1;

import com.example.demo1.controller.StartController;
import com.example.demo1.model.FileManager;
import com.example.demo1.model.WorkerList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class MainApplication extends javafx.application.Application {

    private WorkerList workerList;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader =  loadWindow("start-view.fxml");
        StartController con = loader.getController();
        FileManager.importData();
        con.setWorkerList(FileManager.getWorkerList());

    }

    public static FXMLLoader loadWindow(String FXML) {
        FXMLLoader fxmlLoader = null;
        try {
            fxmlLoader = new FXMLLoader(MainApplication.class.getResource(FXML));
            Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
            Stage stage = new Stage();
            stage.setTitle("NominaXpert");
            stage.setScene(scene);
            stage.show();
            return fxmlLoader;
        } catch (IOException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return fxmlLoader;
    }

    public static void main(String[] args) {
        launch();
    }
}