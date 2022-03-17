package assemblyline.commands;

import assemblyline.VehicleCollection;

import assemblyline.utils.IO;

public class ClearCommand extends Command {
    @Override
    public void execute(String[] args) {
        VehicleCollection.vehicleCollection.clear();
        VehicleCollection.initializationDate = null;
        IO.print("Vehicle collection has been cleared.%n");
    }

    @Override
    public String getHelp() {
        return String.format("Clears vehicle collection.%n%nUsage: clear");
    }
}