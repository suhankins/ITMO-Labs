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
    public static Hashtable<Integer, Vehicle> vehicleCollection = new Hashtable<Integer, Vehicle>();
    public static java.time.LocalDate initializationDate = null;

    /**
     * Get vehicle from vehicle collection by its id
     * @param id
     * @return vehicle with corresponding id
     */
    public static Vehicle getById(int id) {
        Enumeration keys = vehicleCollection.keys();

        while (keys.hasMoreElements()) {
            int k = (int)keys.nextElement();
            if (vehicleCollection.get(k).getId() == id) {
                return vehicleCollection.get(k);
            }
        }
        
        return null;
    }
}