package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import utils.LocalDateDeserializer;
import utils.LocalDateSerializer;

import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Order order = new Order(100);
        Order order1 = new Order(300);
        Order order2 = new Order(200);
        Repairer repairer = new Repairer("Tom");
        GarageSlot garageSlot = new GarageSlot();
        order.addRepair(repairer);
        order.setCompletionDate(LocalDate.now());

        List<Order> orders = new ArrayList<>();
        orders.add(order);
        orders.add(order1);
        orders.add(order2);


        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateSerializer());
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer());

        Gson gson = gsonBuilder.setPrettyPrinting().create();

        try(FileWriter writer = new FileWriter("files/orders.json")){
                writer.write(gson.toJson(orders));
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

        try(FileWriter writer = new FileWriter("files/garages.json")){
            writer.write(gson.toJson(garageSlot));

        }
        catch (Exception e){
            System.out.println("Parsing error: " + e.toString());
        }


    }
}
