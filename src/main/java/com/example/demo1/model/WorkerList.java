package com.example.demo1.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class WorkerList {

    public ObservableList<Worker> workerList = FXCollections.observableArrayList();

    public WorkerList() {
        addWorker(new Worker("John Doe Smith", "Operator", 10000000, java.time.LocalDate.now()));
    }

    public void addWorker(Worker worker){
        this.workerList.add(worker);
    }

    public ObservableList<Worker> getWorkerList() {
        return workerList;
    }

    public void setWorkerList(ObservableList<Worker> workerList) {
        this.workerList = workerList;
    }


}
