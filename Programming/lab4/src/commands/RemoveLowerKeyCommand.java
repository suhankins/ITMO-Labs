package assemblyline.commands;

import java.util.Enumeration;

import assemblyline.VehicleCollection;

import assemblyline.utils.ErrorMessages;
import assemblyline.utils.IO;

public class RemoveLowerKeyCommand extends Command {
    @Override
    public void execute(String[] args) {
        isArgumentGiven(args);
        if (VehicleCollection.isEmpty()) {
            IO.print("%s%n", ErrorMessages.COLLECTION_IS_EMPTY);
            return;
        }

        int key = Integer.parseInt(args[0]);

        Enumeration keys = VehicleCollection.vehicleCollection.keys();
        IO.print("Removing keys lower than %d:%n", key);
        while (keys.hasMoreElements()) {
            int k = (int)keys.nextElement();
            if (k < key) {
                VehicleCollection.vehicleCollection.remove(k);
                IO.print("Key %d was removed%n", k);
            }
        }
        IO.print("Every key lower than %d has been successfully removed.%n", key);
    }

    @Override
    public String getHelp() {
        return String.format("Replace fields of a car stored at a given key if new values are lower.%n%nUsage: replace_if_lower [key]");
    }
}