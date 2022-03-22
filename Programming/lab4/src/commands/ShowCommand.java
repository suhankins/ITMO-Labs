package assemblyline.commands;

import java.util.Enumeration;

import assemblyline.VehicleCollection;
import assemblyline.utils.IO;

public class ShowCommand extends Command {
    @Override
    public void execute(String[] args) {
        Enumeration keys = VehicleCollection.vehicleCollection.keys();
        IO.print("List of vehicles:%n");
        while (keys.hasMoreElements()) {
            int k = (int)keys.nextElement();
            IO.print("[%d] %s%n%n", k, VehicleCollection.vehicleCollection.get(k).toString());
        }
    }

    @Override
    public String getHelp() {
        return String.format("Prints list of vehicles.%n%nUsage: show");
    }
}