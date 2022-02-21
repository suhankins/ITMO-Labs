package assemblyline;

import java.util.Hashtable;
import java.util.Enumeration;

import assemblyline.Vehicles.Vehicle;

/**
 * Here all vehicle are stored.
 * +Awsum methods for changing stuff and all that
 */
public class VehicleCollection {
    /**
     * Hashtable where vehicles are stored.
     */
    public static Hashtable<String, Vehicle> vehicleCollection = new Hashtable<String, Vehicle>();
    public static java.time.LocalDate initializationDate = null;

    /**
     * Get vehicle from vehicle collection by its id
     * @param id
     * @return vehicle with corresponding id
     */
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