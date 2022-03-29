package assemblyline.commands;

import java.util.Hashtable;

import assemblyline.vehicles.*;
import assemblyline.VehicleCollection;

import assemblyline.utils.IO;
import assemblyline.utils.InputArguments;

/**
 * Inserts a new vehicle into vehicleCollection
 */
public class InsertCommand extends Command {
    @Override
    public void execute(String[] args) {
        isArgumentGiven(args);

        int key = Integer.parseInt(args[0]);

        IO.print("Creating a new vehicle with the '%d' key:%n", key);
        
        Hashtable<String, Object> listOfParams = InputArguments.inputArguments(true);

        VehicleCollection.vehicleCollection.put(key,
            new Vehicle((String)listOfParams.get("name"),
            new Coordinates((double)listOfParams.get("x"), (long)listOfParams.get("y")),
            (int)listOfParams.get("enginePower"),
            (int)listOfParams.get("numberOfWheels"),
            (VehicleType)listOfParams.get("vehicleType"),
            (FuelType)listOfParams.get("fuelType"))
        );
        
        //Setting initialization data since this is probably the first car in collection
        if (VehicleCollection.initializationDate == null)
            VehicleCollection.initializationDate = java.time.LocalDate.now();
        
        IO.print("Done!%n");
    }

    @Override
    public String getHelp() {
        return String.format("Insert a new vehicle with a specified key.%n%nUsage: insert [key]");
    }
}