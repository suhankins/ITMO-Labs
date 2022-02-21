package assemblyline;

import java.util.Hashtable;
import java.util.Enumeration;

import assemblyline.Vehicles.Vehicle;

public class VehicleCollection {
    public static Hashtable<String, Vehicle> vehicleCollection = new Hashtable<String, Vehicle>();
    public static java.time.LocalDate initializationDate = null;

    public static Vehicle getById(int id) {
        Enumeration keys = vehicleCollection.keys();

        while (keys.hasMoreElements()) {
            String k = (String)keys.nextElement();
            if (vehicleCollection.get(k).getId() == id) {
                return vehicleCollection.get(k);
            }
        }
        
        return null;
    }
}