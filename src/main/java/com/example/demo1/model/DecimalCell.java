package com.example.demo1.model;

import com.example.demo1.model.Worker;
import javafx.scene.control.TableCell;
import java.text.DecimalFormat;

public class DecimalCell extends TableCell<Worker, Double> {
    private final DecimalFormat decimalFormat;

    public DecimalCell() {
        decimalFormat = new DecimalFormat("#,##0.00"); // Define el formato decimal deseado
    }

    @Override
    protected void updateItem(Double item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            setText(null);
        } else {
            setText(decimalFormat.format(item)); // Aplica el formato decimal al texto
        }
    }
}