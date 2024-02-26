package edu.iu.habahram.coffeeorder.repository;

import edu.iu.habahram.coffeeorder.model.*;
import org.springframework.stereotype.Repository;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@Repository
public class OrderRepository {
    public Receipt add(OrderData order) throws Exception {
        Beverage beverage = null;
        switch (order.beverage().toLowerCase()) {
            case "dark roast":
                beverage = new DarkRoast();
                break;
        }
        if (beverage == null) {
            throw new Exception("Beverage type '%s' is not valid!".formatted(order.beverage()));
        }
        for(String condiment : order.condiments()) {
            switch (condiment.toLowerCase()) {
                case "milk":
                   beverage = new Milk(beverage);
                   break;
                case "mocha":
                    beverage = new Mocha(beverage);
                    break;
                default:
                    throw new Exception("Condiment type '%s' is not valid".formatted(condiment));
            }
        }
        int id = (int) (100000 / Math.random());
        Receipt receipt = new Receipt(beverage.getDescription(), beverage.cost(), id);

        try (FileWriter fileWriter = new FileWriter("db.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter)){
            printWriter.println((String.format("%d, %.2f, %s", receipt.id(), receipt.cost(), receipt.description())));
        } catch (IOException e){
            e.printStackTrace();
        }
        return receipt;
    }
}
