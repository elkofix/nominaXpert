module com.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;

    opens com.example.demo1 to javafx.fxml;
    exports com.example.demo1;
    exports com.example.demo1.controller;
    opens com.example.demo1.controller to javafx.fxml;
    exports com.example.demo1.model;
    opens com.example.demo1.model to javafx.fxml, com.google.gson;
}