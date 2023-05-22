package com.example.demo1.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

public class FileManager {
    private static FileManager instance;


    public static WorkerList getWorkerList() {
        return workerList;
    }

    public static void setWorkerList(WorkerList workerList) {
        FileManager.workerList = workerList;
    }

    private static WorkerList workerList;

    private static Gson gson = new GsonBuilder()
            .registerTypeAdapter(WorkerList.class, new WorkerListAdapter())
            .registerTypeAdapter(Worker.class, new WorkerAdapter())
            .create();
    private FileManager(){}

    //getInstance -> Obtener la unica instancia de la clase

    public static FileManager getInstance(){
        if(instance == null){
            instance = new FileManager();
        }
        return instance;
    }
    public static void importData(){
        File result = new File(System.getProperty("user.dir")+"/resources/data/dat.json");
        try {
            FileInputStream fis = new FileInputStream(result);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String line;
            StringBuilder json = new StringBuilder();
            while ( (line = reader.readLine()) != null){
                json.append(line);
            }
            workerList = gson.fromJson(json.toString(), WorkerList.class);
        } catch (FileNotFoundException e){
            System.out.println("No hay datos para cargar");
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void saveData(){
        File dataDirectory = new File(System.getProperty("user.dir")+"/resources/data");
        File result = new File(System.getProperty("user.dir")+"/resources/data/dat.json");

        if(!dataDirectory.exists()){
            dataDirectory.mkdirs();
        }

        String json =  gson.toJson(workerList);
        try{
            FileOutputStream fos = new FileOutputStream(result);
            fos.write(json.getBytes(StandardCharsets.UTF_8));
            fos.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
