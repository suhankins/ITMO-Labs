package assemblyline.commands;

import assemblyline.VehicleCollection;

import assemblyline.utils.IO;

public class RemoveKeyCommand extends Command {
    @Override
    public void execute(String[] args) {
        isArgumentGiven(args);

        int key = Integer.parseInt(args[0]);

        if (!VehicleCollection.vehicleCollection.containsKey(key)) {
            throw new NullPointerException(String.format("%d key doesn't exist", key));
        }

        VehicleCollection.vehicleCollection.remove(key);

        IO.print("%d key was removed.%n", key);
    }

    @Override
    public String getHelp() {
        return String.format("Removes a vehicle with the specified key.%n%nUsage: remove_key [key]");
    }
}