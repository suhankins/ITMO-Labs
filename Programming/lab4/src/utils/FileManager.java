package assemblyline.utils;

import java.util.Enumeration;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

import org.json.JSONObject;

import assemblyline.VehicleCollection;
import assemblyline.vehicles.Vehicle;

/**
 * Class used for all things file managment 
 */
public class FileManager {
    /**
     * Used when no parameter is given
     */
    final static String DEFAULT_FILENAME = "default.json";
    /**
     * Loads list of created vehicles from requested file
     * @param filename name of the file from which vehicle list should be loaded
     */
    public static String loadScript(String filename) {
        Path path = Paths.get(filename);
        if (Files.exists(path)) {
            if (Files.isReadable(path)) {
                try {
                    IO.addScript(Files.readAllLines(path));
                } catch(Exception e) {
                    return e.getMessage();
                }
            } else {
                return ErrorMessages.FILE_NOT_READABLE;
            }
        } else {
            return ErrorMessages.FILE_DOES_NOT_EXIST;
        }
        return ErrorMessages.UNKNOWN_ERROR;
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

        Path path = Paths.get(filename);

        JSONObject save = new JSONObject().put("initializationDate", VehicleCollection.initializationDate.toString());

        JSONObject[] vehicles = new JSONObject[VehicleCollection.vehicleCollection.size()];

        Enumeration keys = VehicleCollection.vehicleCollection.keys();

        for (int i = 0; i < vehicles.length; i++){
            JSONObject vehicleJSON = new JSONObject();
            int k = (int)keys.nextElement();
            Vehicle vehicle = VehicleCollection.vehicleCollection.get(k);
            vehicleJSON.put("key", k);
            vehicleJSON.put("id", vehicle.getId());
            vehicleJSON.put("x", vehicle.getCoordinates().getX());
            vehicleJSON.put("y", vehicle.getCoordinates().getY());
            vehicleJSON.put("enginePower", vehicle.getEnginePower());
            vehicleJSON.put("numberOfWheels", vehicle.getNumberOfWheels());
            vehicleJSON.put("type", vehicle.getVehicleType().toString());
            vehicleJSON.put("fuel", vehicle.getFuelType().toString());

            vehicles[i] = vehicleJSON;
        }

        save.put("vehicles", vehicles);

        try {
            Files.write(path, save.toString().getBytes());
        } catch(Exception e) {
            IO.print(ErrorMessages.TEMPLATE, e.getMessage());
        }

        IO.print("File successfuly saved%n");
    }
}