package assemblyline.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import assemblyline.VehicleCollection;
import assemblyline.vehicles.Coordinates;
import assemblyline.vehicles.FuelType;
import assemblyline.vehicles.VehicleType;
import assemblyline.vehicles.Vehicle;

/**
 * Class used for all things file management
 */
public class FileManager {
    /**
     * Loads and executes commands from a specified file
     * @param filename name of the file from which command list should be loaded
     */
    public static void loadScript(String filename) {
        File file = new File(filename);
        Scanner fileReader;
        try {
            fileReader = new Scanner(file);
        } catch(FileNotFoundException exception) {
            IO.print(ErrorMessages.FILE_DOES_NOT_EXIST);
            return;
        } catch(Exception e) {
            IO.print(ErrorMessages.TEMPLATE, e.getMessage());
            return;
        }
        ArrayList<String> lines = new ArrayList<String>();
        while (fileReader.hasNextLine()) {
            lines.add(fileReader.nextLine());
        }
        IO.addScript(lines, file);
        fileReader.close();
    }
    /**
     * Saves list of created vehicles to requested file
     * @param filename name of the file to which vehicle list should be written
     */
    public static void saveCollection(String filename) {
        if (VehicleCollection.isEmpty()) {
            IO.print("%s%n", ErrorMessages.COLLECTION_IS_EMPTY);
            return;
        }
        JSONObject save = new JSONObject().put("initializationDate", VehicleCollection.initializationDate.toString());

        JSONObject[] vehicles = new JSONObject[VehicleCollection.vehicleCollection.size()];

        Enumeration keys = VehicleCollection.vehicleCollection.keys();

        for (int i = 0; i < vehicles.length; i++){
            JSONObject vehicleJSON = new JSONObject();
            int k = (int)keys.nextElement();
            Vehicle vehicle = VehicleCollection.vehicleCollection.get(k);
            vehicleJSON.put("key", k);
            vehicleJSON.put("name", vehicle.getName());
            vehicleJSON.put("id", vehicle.getId());
            vehicleJSON.put("x", vehicle.getCoordinates().getX());
            vehicleJSON.put("y", vehicle.getCoordinates().getY());
            vehicleJSON.put("enginePower", vehicle.getEnginePower());
            vehicleJSON.put("numberOfWheels", vehicle.getNumberOfWheels());
            vehicleJSON.put("vehicleType", vehicle.getVehicleType().toString());
            vehicleJSON.put("fuelType", vehicle.getFuelType().toString());
            vehicleJSON.put("creationDate", vehicle.getCreationDate().toString());

            vehicles[i] = vehicleJSON;
        }

        save.put("vehicles", vehicles);

        try {
            FileWriter file = new FileWriter(filename);
            BufferedWriter writer = new BufferedWriter(file);
            writer.write(save.toString());
            writer.close();
        } catch(Exception e) {
            IO.print(ErrorMessages.TEMPLATE, e.getMessage());
            return;
        }

        IO.print("File successfully saved%n");
    }
    /**
     * Loads vehicle collection from a specified file
     * @param filename name of the file
     */
    public static void loadSave(String filename) {
        //Since this is probably the last thing I'm going to add to this project
        //before next lab, here's the song I listened to while writing this code
        // https://www.youtube.com/watch?v=oqLOBhaizy8
        File file = new File(filename);
        Scanner fileReader;
        try {
            fileReader = new Scanner(file);
        } catch(FileNotFoundException exception) {
            IO.print(ErrorMessages.FILE_DOES_NOT_EXIST);
            return;
        } catch(Exception e) {
            IO.print(ErrorMessages.TEMPLATE, e.getMessage());
            return;
        }
        String rawJSON = "";
        while (fileReader.hasNextLine()) {
            rawJSON = String.format("%s%n%s", rawJSON, fileReader.nextLine());
        }
        fileReader.close();
        JSONObject vehiclesJSON = new JSONObject(rawJSON);

        //Init date
        VehicleCollection.initializationDate = LocalDate.parse((String)vehiclesJSON.get("initializationDate"));
        //Vehicles
        JSONArray vehicles = (JSONArray)vehiclesJSON.get("vehicles");

        for (int i = 0; i < vehicles.length(); i++) {
            JSONObject vehicleJSON = (JSONObject)vehicles.get(i);

            Double x;
            try {
                x = ((BigDecimal)vehicleJSON.get("x")).doubleValue();
            } catch (Exception e) {
                x = (double)(int)vehicleJSON.get("x");
            }

            Long y;
            try {
                y = (long)vehicleJSON.get("y");
            } catch (Exception e) {
                y = (long)(int)vehicleJSON.get("y");
            }

            Vehicle vehicle = new Vehicle(
                (String)vehicleJSON.get("name"),
                new Coordinates(x, y),
                (int)vehicleJSON.get("enginePower"),
                (int)vehicleJSON.get("numberOfWheels"),
                VehicleType.valueOf((String)vehicleJSON.get("vehicleType")),
                FuelType.valueOf((String)vehicleJSON.get("fuelType"))
            );
            Integer id = (Integer)vehicleJSON.get("id");
            //If given ID already exists, we just skip this vehicle and continue on
            if (VehicleCollection.getById(id) != null) {
                IO.print(ErrorMessages.ID_ALREADY_EXISTS);
                continue;
            }
            vehicle.setId(id);
            vehicle.setCreationDate(LocalDate.parse((String)vehicleJSON.get("creationDate")));
            VehicleCollection.vehicleCollection.put(
                (int)vehicleJSON.get("key"),
                vehicle
            );
        }

        IO.print("Collection was successfully loaded!%n");
    }
}