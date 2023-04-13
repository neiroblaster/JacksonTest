package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import utils.LocalDateDeserializer;
import utils.LocalDateSerializer;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {
        Order order = new Order(100);
        Order order1 = new Order(300);
        Order order2 = new Order(200);

        order.setId(3);
        order1.setId(1);
        order2.setId(2);

        Repairer repairer = new Repairer("Tom");
        Repairer repairer1 = new Repairer("Jhon");
        GarageSlot garageSlot = new GarageSlot();
        order.addRepair(repairer);
        order.setCompletionDate(LocalDate.now());

        List<Order> orders = new ArrayList<>();
        orders.add(order);
        orders.add(order1);
        orders.add(order2);

        Collection<Repairer> repairers = new ArrayList<>();
        repairers.add(repairer);
        repairers.add(repairer1);

        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateSerializer());
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer());

        Gson gson = gsonBuilder.setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter("files/orders.json")) {
            writer.write(gson.toJson(orders));
        } catch (Exception e) {
            System.out.println("Parsing error: " + e.toString());
        }

        try (FileWriter writer = new FileWriter("files/repairers.json")) {
            writer.write(gson.toJson(repairer));
        } catch (Exception e) {
            System.out.println("Parsing error: " + e.toString());
        }

        try (FileWriter writer = new FileWriter("files/garages.json")) {
            writer.write(gson.toJson(garageSlot));
        } catch (Exception e) {
            System.out.println("Parsing error: " + e.toString());
        }


        //Read List<Order>
        try (FileReader fileReader = new FileReader("files/orders.json")) {
            Type listFromJson = new TypeToken<List<Order>>() {}.getType();
            List<Order> newList = gson.fromJson(fileReader, listFromJson);

            System.out.println(gson.toJson(newList.stream()
                    .sorted(Comparator.comparingInt(Order::getId)).collect(Collectors.toList())));
        } catch (Exception e) {
            System.out.println("Parsing error: " + e.toString());
        }

        // Collection of repairers
        //Write
        try (FileWriter writer = new FileWriter("files/repairersCollection.json")) {
            writer.write(gson.toJson(repairers));
        } catch (Exception e) {
            System.out.println("Parsing error: " + e.toString());
        }

        //Read
        try (FileReader fileReader = new FileReader("files/repairersCollection.json")) {
            Type listFromJson = new TypeToken<Collection<Repairer>>() {}.getType();
            Collection<Repairer> newList = gson.fromJson(fileReader, listFromJson);

            System.out.println(gson.toJson(newList));
        } catch (Exception e) {
            System.out.println("Parsing error: " + e.toString());
        }

    }
}
