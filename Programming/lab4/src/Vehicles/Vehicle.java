package assemblyline.Vehicles;

import java.util.Hashtable;

import assemblyline.NotEmptyException;
import assemblyline.NotNullException;
import assemblyline.ValueOutOfRangeException;

public class Vehicle implements Comparable<Vehicle> {
    /**
     * Counts how many cars have already been created
     */
    private static int counter = 0;

    /**
     * <p>
     * Unique vehicle id
     * </p>
     * <p>
     * * Generated automatically
     * </p>
     * <p>
     * * Cannot be null
     * </p>
     * <p>
     * * Must be more than 0
     * </p>
     */
    private Integer id;
    /**
     * <p>
     * Vehicle's name
     * </p>
     * <p>
     * * Cannot be null
     * </p>
     * <p>
     * * Cannot be an empty string
     * </p>
     */
    private String name;
    /**
     * <p>
     * Vehicle coordinates
     * </p>
     * <p>
     * * Cannot be null
     * </p>
     */
    private Coordinates coordinates;
    /**
     * <p>
     * Vehicle creation date
     * </p>
     * <p>
     * * Generated automatically
     * </p>
     * <p>
     * * Cannot be null
     * </p>
     */
    private java.time.LocalDate creationDate;
    /**
     * <p>
     * Vehicle engine power
     * </p>
     * <p>
     * * Must be more than 0
     * </p>
     */
    private int enginePower;
    /**
     * <p>
     * Amount of wheels a vehicle has
     * </p>
     * <p>
     * * Must be more than 0
     * </p>
     */
    private int numberOfWheels;
    /**
     * <p>
     * Vehicle type
     * </p>
     * <p>
     * * Cannot be null
     * </p>
     */
    private VehicleType type;
    /**
     * <p>
     * Vehicle fuel type
     * </p>
     * <p>
     * * Cannot be null
     * </p>
     */
    private FuelType fuelType;

    // =============== Access to variables methods ===============
    public Integer getId() {
        return this.id;
    }
    public Coordinates getCoordinates() {
        return this.coordinates;
    }
    // =============== Access to variables methods END ===============

    // =============== Check variable correctness ===============
    public static void isNameCorrect(String name) {
        if (name == null)
            throw new NotNullException("Name");
        if (name.isBlank())
            throw new NotEmptyException("Name");
    }
    public static void isCoordinatesCorrect(Coordinates coordinates) {
        if (coordinates == null)
            throw new NotNullException("Coordinates");
    }
    public static void isEnginePowerCorrect(int enginePower) {
        if (enginePower <= 0)
            throw new ValueOutOfRangeException(0, false);
    }
    public static void isNumberOfWheelsCorrect(int numberOfWheels) {
        if (numberOfWheels <= 0)
            throw new ValueOutOfRangeException(0, false);
    }
    public static void isVehicleTypeCorrect(VehicleType vehicleType) {
        if (vehicleType == null)
            throw new NotNullException("Vehicle Type");
    }
    public static void isFuelTypeCorrect(FuelType fuelType) {
        if (fuelType == null)
            throw new NotNullException("Fuel Type");
    }
    // =============== Check variable correctness END ===============

    // =============== Set variables ===============
    public void setName(String name) {
        isNameCorrect(name);
        this.name = name;
    }
    public void setCoordinates(Coordinates coordinates) {
        isCoordinatesCorrect(coordinates);
        this.coordinates = coordinates;
    }
    public void setEnginePower(int enginePower) {
        isEnginePowerCorrect(enginePower);
        this.enginePower = enginePower;
    }
    public void setNumberOfWheels(int numberOfWheels) {
        isNumberOfWheelsCorrect(numberOfWheels);
        this.numberOfWheels = numberOfWheels;
    }
    public void setVehicleType(VehicleType vehicleType) {
        isVehicleTypeCorrect(vehicleType);
        this.type = vehicleType;
    }
    public void setFuelType(FuelType fuelType) {
        isFuelTypeCorrect(fuelType);
        this.fuelType = fuelType;
    }
    // =============== Set variables END ===============

    /**
     * Asks user to input all the required arguments for creating a new instance of a vehicle class.
     * @param isRequired is it required that all parameters are inputed?
     * @return a hashlist where key is a name of the variable and value is a corresponding object
     */
    public static Hashtable<String, Object> inputArguments(boolean isRequired) {
        Hashtable<String, Object> toReturn = new Hashtable<String, Object>();

        //This code sucks but I don't care enough to make it look good.
        //I know that nextInt, nextLong and nextDouble exist, but using them 
        //leads to a bunch of problems with nextLine.

        // =============== Argument input section ===============
        System.out.print("Name> ");
        String raw = assemblyline.Main.keyboard.nextLine();
        //if you inputed anything, we might as well check if it's correct
        if (shouldCheck(isRequired, raw)) {
            Vehicle.isNameCorrect(raw);
            toReturn.put("name", raw);
        }

        // =============== Coordinates input section ===============
        System.out.print("X position (Double)> ");
        raw = assemblyline.Main.keyboard.nextLine();
        double x = 99999;
        if (shouldCheck(isRequired, raw)) {
            x = Double.parseDouble(raw);
            Coordinates.isXCorrect(x);
        }
        
        System.out.print("Y position (Long)> ");
        raw = assemblyline.Main.keyboard.nextLine();
        long y = 99999;
        if (shouldCheck(isRequired, raw)) {
            y = Long.parseLong(raw);
            Coordinates.isYCorrect(y);
        }

        if (x < 99999 && y < 99999) {
            Coordinates coordinates = new Coordinates(x, y);
            toReturn.put("coordinates", coordinates);
        } else if (x < 99999) {
            toReturn.put("x", x);
        } else if (y < 99999) {
            toReturn.put("y", y);
        }
        // =============== Coordinates input section END ===============

        System.out.print("Engine power (Integer)> ");
        raw = assemblyline.Main.keyboard.nextLine();
        if (shouldCheck(isRequired, raw)) {
            int enginePower = Integer.parseInt(raw);
            Vehicle.isEnginePowerCorrect(enginePower);

            toReturn.put("enginePower", enginePower);
        }

        System.out.print("Number of wheels (Integer)> ");
        raw = assemblyline.Main.keyboard.nextLine();
        if (shouldCheck(isRequired, raw)) {
            int numberOfWheels = Integer.parseInt(raw);
            Vehicle.isNumberOfWheelsCorrect(numberOfWheels);

            toReturn.put("numberOfWheels", numberOfWheels);
        }

        // =============== Vehicle type input ===============
        System.out.printf("%nVehicle types:%n");
        for (int i = 0; i < VehicleType.values().length; i++) {
            System.out.println(VehicleType.values()[i]);
        }
        System.out.print("Vehicle type> ");
        raw = assemblyline.Main.keyboard.nextLine();
        if (shouldCheck(isRequired, raw)) {
            VehicleType vehicleType = VehicleType.valueOf(raw.toUpperCase().trim());
            Vehicle.isVehicleTypeCorrect(vehicleType);

            toReturn.put("vehicleType", vehicleType);
        }

        // =============== Fuel type input ===============
        System.out.printf("%nFuel types:%n");
        for (int i = 0; i < FuelType.values().length; i++) {
            System.out.println(FuelType.values()[i]);
        }
        System.out.print("Fuel Type> ");
        raw = assemblyline.Main.keyboard.nextLine();
        if (shouldCheck(isRequired, raw)) {
            FuelType fuelType = FuelType.valueOf(raw.toUpperCase().trim());
            Vehicle.isFuelTypeCorrect(fuelType);

            toReturn.put("fuelType", fuelType);
        }
        // =============== Argument input section END ===============

        return toReturn;
    }

    public static boolean shouldCheck(boolean isRequired, String string) {
        return isRequired || !string.isBlank();
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
            int numberOfWheels, VehicleType vehicleType, FuelType fuelType) {
        // Looking at it now, maybe it was a bad idea...
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
        String toReturn = String.format("%s#%d - %s%nCreation date: %s%nLocation: %s%nEngine Power: %d%nNumber of wheels: %d",
            this.name, this.id, this.type, this.creationDate.toString(),
            this.coordinates.toString(), this.enginePower, this.numberOfWheels);

        return toReturn;
    }
}