package model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws JsonProcessingException {
        Order order = new Order(1, "oil change", true);
        Repairer repairer = new Repairer(1, "Tom");

        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("src/main/resources/files/orders.json"), order);
            mapper.writeValue(new File("src/main/resources/files/repairers.json"), repairer);

            String jsonInString1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(order);
            String jsonInString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(repairer);

            System.out.println(jsonInString1);
            System.out.println(jsonInString2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
