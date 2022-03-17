package assemblyline.commands;

import assemblyline.VehicleCollection;

import assemblyline.utils.IO;

public class InfoCommand extends Command {
    @Override
    public void execute(String[] args) {
        if (VehicleCollection.initializationDate == null) {
            IO.print("Vehicle collection was never initialized.%n");
        } else {
            IO.print("Type: %s%n", VehicleCollection.vehicleCollection.getClass().getName());
            IO.print("Initialization date: %s%n", VehicleCollection.initializationDate.toString());
            IO.print("Number of elements: %d%n", VehicleCollection.vehicleCollection.size());
        }
    }

    @Override
    public String getHelp() {
        return String.format("Prints information about current vehicle collection.%n%nUsage: info");
    }
}