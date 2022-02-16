package assemblyline.Vehicles;

import assemblyline.NotEmptyException;
import assemblyline.NotNullException;
import assemblyline.ValueOutOfRangeException;

public class Vehicle implements Comparable<Vehicle> {
    /**
     * Counts how many cars have already been created
     */
    private static int counter = 0;

    /**
     * <p>Unique vehicle id</p>
     * <p>* Generated automatically</p>
     * <p>* Cannot be null</p>
     * <p>* Must be more than 0</p>
     */
    private Integer id;
    /**
     * <p>Vehicle's name</p>
     * <p>* Cannot be null</p>
     * <p>* Cannot be an empty string</p>
     */
    private String name;
    /**
     * <p>Vehicle coordinates</p>
     * <p>* Cannot be null</p>
     */
    private Coordinates coordinates;
    /**
     * <p>Vehicle creation date</p>
     * <p>* Generated automatically</p>
     * <p>* Cannot be null</p>
     */
    private java.time.LocalDate creationDate;
    /**
     * <p>Vehicle engine power</p>
     * <p>* Must be more than 0</p>
     */
    private int enginePower;
    /**
     * <p>Amount of wheels a vehicle has</p>
     * <p>* Must be more than 0</p>
     */
    private int numberOfWheels;
    /**
     * <p>Vehicle type</p>
     * <p>* Cannot be null</p>
     */
    private VehicleType type;
    /**
     * <p>Vehicle fuel type</p>
     * <p>* Cannot be null</p>
     */
    private FuelType fuelType;

    public Integer getId() {
        return this.id;
    }

    /**
     * Constructor.
     * @param name <p>* Cannot be null</p><p>* Cannot be an empty string</p>
     * @param coordinates <p>* Cannot be null</p>
     * @param enginePower <p>* Must be more than 0</p>
     * @param numberOfWheels <p>* Must be more than 0</p>
     * @param vehicleType <p>* Cannot be null</p>
     * @param fuelType <p>* Cannot be null</p>
     */
    public Vehicle(String name, Coordinates coordinates, int enginePower,
                   int numberOfWheels, VehicleType vehicleType, FuelType fuelType)
    {
        //Is this how you're supposed to do it?
        if (name == null || coordinates == null || vehicleType == null || fuelType == null) {
            throw new NotNullException();
        }

        //Name cannot be empty. A space bar name is basically empty too if you think about it.
        if (name.isBlank()) {
            throw new NotEmptyException();
        }

        //These values must be higher than 0
        if (enginePower <= 0 || numberOfWheels <= 0) {
            throw new ValueOutOfRangeException();
        }

        counter += 1;

        this.id = counter;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = java.time.LocalDate.now();
        this.enginePower = enginePower;
        this.numberOfWheels = numberOfWheels;
        this.type = vehicleType;
        this.fuelType = fuelType;
    }

    @Override
	public int compareTo(Vehicle e) {
		return this.getId().compareTo(e.getId());
	}

    @Override
    public String toString() {
        String toReturn = String.format("%s - %s#%d%nCreation date: %s%nLocation: %s%nEngine Power: %d%nNumber of wheels: %d",
                                        this.name, this.type, this.id, this.creationDate.toString(),
                                        this.coordinates.toString(), this.enginePower, this.numberOfWheels);

        return toReturn;
    }
}