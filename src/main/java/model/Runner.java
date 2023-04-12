package model;


import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class Runner {
    public static void main(String[] args) {
        Order order = new Order(1, "oil change", true);
        Repairer repairer = new Repairer(1, "Tom");

        Gson gson = new Gson();

        try(FileWriter writer = new FileWriter("files/orders.json")){
                writer.write(gson.toJson(order));
        }
        catch (Exception e){
            System.out.println("Parsing error: " + e.toString());
        }

        try(FileWriter writer = new FileWriter("files/repairers.json")){
            writer.write(gson.toJson(repairer));

        }
        catch (Exception e){
            System.out.println("Parsing error: " + e.toString());
        }


    }
}
