package com.javarush.island.engine;

import com.javarush.island.animals.Animal;
import com.javarush.island.animals.herbivore.*;
import com.javarush.island.animals.plant.Plant;
import com.javarush.island.animals.predator.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Configuration {
    private static int numberCellX;
    private static int numberCellY;
    private static Animal targetAnimal;

    public static int getNumberCellX() {
        return numberCellX;
    }

    public static int getNumberCellY() {
        return numberCellY;
    }

    public static Animal getTargetAnimal() {
        return targetAnimal;
    }

    public static void setConfig() {
        //
        // Обработка значений ширины и длины поля
        //
        Configuration.numberCellX =
                ((Long) Configuration.jsonParse("island.json", "size", "numberCellX")).intValue();
        Configuration.numberCellY =
                ((Long) Configuration.jsonParse("island.json", "size", "numberCellY")).intValue();

        //
        // Обработка значений целевого животного
        //
        String target = (String) Configuration.jsonParse("island.json","targetAnimal", "target");

        switch(target) {
            case "wolf" -> targetAnimal = new Wolf();
            case "boa" -> targetAnimal = new Boa();
            case "fox" -> targetAnimal = new Fox();
            case "bear" -> targetAnimal = new Bear();
            case "eagle" -> targetAnimal = new Eagle();
            case "horse" -> targetAnimal = new Horse();
            case "deer" -> targetAnimal = new Deer();
            case "rabbit" -> targetAnimal = new Rabbit();
            case "mouse" -> targetAnimal = new Mouse();
            case "goat" -> targetAnimal = new Goat();
            case "sheep" -> targetAnimal = new Sheep();
            case "boar" -> targetAnimal = new Boar();
            case "buffalo" -> targetAnimal = new Buffalo();
            case "duck" -> targetAnimal = new Duck();
            case "caterpillar" -> targetAnimal = new Caterpillar();
            default -> {
                if (targetAnimal == null)
                    throw new RuntimeException("Неправильно указан targetAnimal в JSON");
            }
        }
    }

    public static Object jsonParse(String fileName, String key, String value) {
        File file = new File("src/main/resources/" + fileName);
        JSONParser parser = new JSONParser();
        Object result = null;

        try(FileReader reader = new FileReader(file)) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONObject jsonMap = (JSONObject) jsonObject.get(key);
            result = jsonMap.get(value);
        }
        catch (IOException exception) {
            System.out.println("Проблема открытия файла Json/reader: " + fileName);
            exception.printStackTrace();
        }
        catch (ParseException exception) {
            System.out.println("Проблема парсинга Json: " + fileName);
            exception.printStackTrace();
        }

        return result;
    }
}
