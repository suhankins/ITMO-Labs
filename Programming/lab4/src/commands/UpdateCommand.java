package assemblyline.commands;

import assemblyline.vehicles.Vehicle;
import assemblyline.VehicleCollection;

import assemblyline.utils.InputArguments;

/**
 * Updates information about vehicle using inputArguments
 */
public class UpdateCommand extends Command {
    @Override
    public void execute(String[] args) {
        isArgumentGiven(args);

        Vehicle vehicle = VehicleCollection.getById(Integer.parseInt(args[0]));
        if (vehicle == null) {
            throw new NullPointerException(String.format("Vehicle with ID %s does not exist.", args[0]));
        }

        vehicle.updateData(InputArguments.inputArguments(false, false), false);
    }

    @Override
    public String getHelp() {
        return String.format("Update vehicle's parameters with new data.%nYou can skip parameters you don't want to update by inputting an empty string.%n%nUsage: update [id]");
    }
}