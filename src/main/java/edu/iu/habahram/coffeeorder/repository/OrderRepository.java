package edu.iu.habahram.coffeeorder.repository;

import edu.iu.habahram.coffeeorder.model.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;



@Repository
public class OrderRepository {

    String dbPath = "db.txt";
    public Receipt add(OrderData order) throws Exception {

        Beverage beverage = null;
        switch (order.beverage().toLowerCase()) {
            case "dark roast":
                beverage = new DarkRoast();
                break;
            case "decaf":
                beverage = new Decaf();
                break;
            case "espresso":
                beverage = new Espresso();
                break;
            case "house blend":
                beverage = new HouseBlend();
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
                case "soy":
                    beverage = new Soy(beverage);
                    break;
                case "whip":
                    beverage = new Whip(beverage);
                    break;
                default:
                    throw new Exception("Condiment type '%s' is not valid".formatted(condiment));
            }
        }
        Receipt receipt = new Receipt(generateRandNum(),beverage.getDescription(), beverage.cost());
        appendToFile(receipt);
        return receipt;
    }

    public List<String> getOrders() throws IOException {
        Path path = Path.of(dbPath);
        return Files.readAllLines(path);
    }

    private int generateRandNum() {
        double randNum = Math.random();
        int newNum = (int) (randNum * 100000);
        newNum = (int) Math.ceil(newNum);
        return newNum;
    }

    private void appendToFile(Receipt receipt) throws IOException{
        Path path = Path.of(dbPath);
        String data = receipt.toString() + "\n";
        if(Files.exists(path)){
            Files.write(path, data.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } else {
            Files.createFile(path);
            Files.write(path, data.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }
    }
}
