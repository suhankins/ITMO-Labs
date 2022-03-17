package assemblyline.commands;

import assemblyline.VehicleCollection;

import assemblyline.vehicles.Vehicle;

import assemblyline.utils.InputArguments;

public class ReplaceIfLowerCommand extends Command {
    @Override
    public void execute(String[] args) {
        isArgumentGiven(args);

        int key = Integer.parseInt(args[0]);

        if (!VehicleCollection.vehicleCollection.containsKey(key)) {
            throw new NullPointerException(String.format("%s key doesn't exist", args[0]));
        }

        Vehicle vehicle = VehicleCollection.vehicleCollection.get(key);

        vehicle.updateData(InputArguments.inputArguments(false, true), true);
    }

    @Override
    public String getHelp() {
        return String.format("Replace fields of a car stored at a given key if new values are lower.%n%nUsage: replace_if_lower [key]");
    }
}