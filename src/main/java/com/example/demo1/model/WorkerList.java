package com.example.demo1.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class WorkerList {

    public ObservableList<Worker> workerList = FXCollections.observableArrayList();

    public WorkerList() {
    }

    public void editWorker(Worker old,Worker worker){
        workerList.remove(old);
        workerList.add(worker);
    }

    public void deleteWorker(Worker worker){
        workerList.remove(worker);
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
