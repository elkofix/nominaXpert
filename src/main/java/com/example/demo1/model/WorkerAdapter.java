package com.example.demo1.model;

import com.google.gson.*;
import java.lang.reflect.Type;
import java.time.LocalDate;

public class WorkerAdapter implements JsonSerializer<Worker>, JsonDeserializer<Worker> {

    @Override
    public JsonElement serialize(Worker worker, Type type, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", worker.getName());
        jsonObject.addProperty("lastname", worker.getLastname());
        jsonObject.addProperty("cargo", worker.getCharge());
        jsonObject.addProperty("sueldo", worker.getSalary());
        jsonObject.addProperty("entryDate", worker.getEntryDate().toString());
        jsonObject.addProperty("manpowertype", worker.getManpowertype().toString());
        // Serializar otros atributos de la clase Worker aquí

        return jsonObject;
    }

    @Override
    public Worker deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String name = jsonObject.get("name").getAsString();
        name += " "+jsonObject.get("lastname").getAsString();
        String cargo = jsonObject.get("cargo").getAsString();
        double sueldo = jsonObject.get("sueldo").getAsDouble();
        LocalDate entryDate = LocalDate.parse(jsonObject.get("entryDate").getAsString());
        MANPOWERTYPE manpowertype = MANPOWERTYPE.valueOf(jsonObject.get("manpowertype").getAsString());
        // Deserializar otros atributos de la clase Worker aquí

        Worker worker = new Worker(name, cargo, sueldo, entryDate, manpowertype);
        // Establecer otros atributos de la clase Worker aquí

        return worker;
    }
}