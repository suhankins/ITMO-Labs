package assemblyline.commands;

import java.util.Arrays;
import java.util.Comparator;

import assemblyline.vehicles.*;
import assemblyline.VehicleCollection;

import assemblyline.utils.IO;
import assemblyline.utils.ErrorMessages;

/**
 * Prints specified field in specified order
 */
public class PrintFieldSortedCommand extends Command {
    /**
     * Fieldname by which vehicles should be sorted
     */
    private final String fieldName;
    /**
     * Whether we should sort in ascending or descending order
     */
    private final boolean ascending;

    /**
     * Constructor
     * @param fieldName Fieldname by which vehicles should be sorted
     * @param ascending Whether we should sort in ascending or descending order
     */
    public PrintFieldSortedCommand(String fieldName, boolean ascending) {
        this.fieldName = fieldName;
        this.ascending = ascending;
    }

    @Override
    public void execute(String[] args) {
        if (VehicleCollection.vehicleCollection.isEmpty()) {
            IO.print("%s%n", ErrorMessages.COLLECTION_IS_EMPTY);
            return;
        }
        Vehicle[] vehicles = VehicleCollection.toArray();
        //Sort the array
        Arrays.sort(vehicles, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle v1, Vehicle v2) {
                int mod = 1;
                if (ascending) mod = -1;
                switch(fieldName) {
                    case "Fuel type":
                        return v1.getFuelType().compareTo(v2.getFuelType()) * mod;
                    case "Engine power":
                        return (v1.getEnginePower() - v2.getEnginePower()) * mod;
                    case "Number of wheels":
                        return (v1.getNumberOfWheels() - v2.getNumberOfWheels()) * mod;
                }
                return 0;
            }
        });
        //Print it!
        for (int i = 0; i < vehicles.length; i++) {
            IO.print("[%s #%d] %s:", vehicles[i].getVehicleType(), vehicles[i].getId(), fieldName);
            switch(fieldName) {
                case "Fuel type":
                    IO.print("%s%n", vehicles[i].getFuelType());
                    break;
                case "Engine power":
                    IO.print("%d%n", vehicles[i].getEnginePower());
                    break;
                case "Number of wheels":
                    IO.print("%d%n", vehicles[i].getNumberOfWheels());
                    break;
            }
        }
    }

    @Override
    public String getHelp() {
        return String.format("Prints fuel types of every vehicle in ascending order.%n%nUsage: print_field_ascending_fuel_type");
    }
}