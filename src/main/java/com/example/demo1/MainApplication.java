package com.example.demo1;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        loadWindow("start-view.fxml");
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