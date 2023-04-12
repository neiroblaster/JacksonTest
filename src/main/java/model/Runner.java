package model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class Runner {
    public static void main(String[] args) throws JsonProcessingException {
        Order order = new Order(1, "oil change", true);
        Repairer repairer = new Repairer(1, "Tom");

        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("src/main/resources/files/orders.json"), order);
            mapper.writeValue(new File("src/main/resources/files/repairers.json"), repairer);

//            String jsonInString1 = mapper1.writerWithDefaultPrettyPrinter().writeValueAsString(order);
//            String jsonInString2 = mapper1.writer().writeValueAsString(repairer);

            Repairer repairer1 = mapper.readValue(new File("src/main/resources/files/repairers" +
                    ".json"), Repairer.class);
            String jsonInString3 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(repairer1);
            System.out.println(jsonInString3);

            Order order1 = mapper.readValue(new File("src/main/resources/files/repairers" +
                    ".json"), Order.class);
            String jsonInString4 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(order1);
            System.out.println(jsonInString4);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
