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

    //=============== Access to variables methods ===============
    public Integer getId() {
        return this.id;
    }
    //=============== Access to variables methods END ===============

    //=============== Check variable correctness ===============
    public static void isNameCorrect(String name) {
        if (name == null) throw new NotNullException("Name");
        if (name.isBlank()) throw new NotEmptyException("Name");
    }

    public static void isCoordinatesCorrect(Coordinates coordinates) {
        if (coordinates == null) throw new NotNullException("Coordinates");
    }

    public static void isVehicleTypeCorrect(VehicleType vehicleType) {
        if (vehicleType == null) throw new NotNullException("Vehicle Type");
    }

    public static void isFuelTypeCorrect(FuelType fuelType) {
        if (fuelType == null) throw new NotNullException("Fuel Type");
    }

    public static void isEnginePowerCorrect(int enginePower) {
        if (enginePower <= 0) throw new ValueOutOfRangeException(0, false);
    }

    public static void isNumberOfWheelsCorrect(int numberOfWheels) {
        if (numberOfWheels <= 0) throw new ValueOutOfRangeException(0, false);
    }
    //=============== Check variable correctness END ===============

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
        //Looking at it now, maybe it was a bad idea...
        isNameCorrect(name);
        isCoordinatesCorrect(coordinates);
        isEnginePowerCorrect(enginePower);
        isNumberOfWheelsCorrect(numberOfWheels);
        isVehicleTypeCorrect(vehicleType);
        isFuelTypeCorrect(fuelType);

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