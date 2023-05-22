package com.example.demo1.model;

import com.google.gson.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.lang.reflect.Type;

public class WorkerListAdapter implements JsonSerializer<WorkerList>, JsonDeserializer<WorkerList> {

    @Override
    public JsonElement serialize(WorkerList workerList, Type type, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        JsonArray workerArray = context.serialize(workerList.getWorkerList()).getAsJsonArray();
        jsonObject.add("workerList", workerArray);
        return jsonObject;
    }

    @Override
    public WorkerList deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonArray workerArray = jsonObject.getAsJsonArray("workerList");
        WorkerList workerList = new WorkerList();
        ObservableList<Worker> workers = FXCollections.observableArrayList();
        for (JsonElement element : workerArray) {
            Worker worker = context.deserialize(element, Worker.class);
            workers.add(worker);
        }
        workerList.setWorkerList(workers);
        return workerList;
    }
}