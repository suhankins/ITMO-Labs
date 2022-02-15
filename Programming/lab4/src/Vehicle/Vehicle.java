package assemblyline.Vehicle;

public class Vehicle {
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

    public Vehicle(String name, Coordinates coordinates, int enginePower,
                   int numberOfWheels, VehicleType vehicleType, FuelType fuelType)
    {
        //Is this how you're supposed to do it?
        if (name == null || coordinates == null || vehicleType == null || fuelType == null) {
            throw new NotNullException();
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
}