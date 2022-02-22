package assemblyline.Vehicles;

import java.util.Hashtable;

import assemblyline.utils.ValueOutOfRangeException;
import assemblyline.utils.NotEmptyException;
import assemblyline.utils.NotNullException;
import assemblyline.utils.ErrorMessages;

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
    public static boolean isNameCorrect(String name) {
        if (name == null) return false;
        if (name.isBlank()) return false;
        return true;
    }
    public static boolean isCoordinatesCorrect(Coordinates coordinates) {
        if (coordinates == null) return false;
        return true;
    }
    public static boolean isEnginePowerCorrect(int enginePower) {
        if (enginePower <= 0) return false;
        return true;
    }
    public static boolean isNumberOfWheelsCorrect(int numberOfWheels) {
        if (numberOfWheels <= 0) return false;
        return true;
    }
    public static boolean isVehicleTypeCorrect(VehicleType vehicleType) {
        if (vehicleType == null) return false;
        return true;
    }
    public static boolean isFuelTypeCorrect(FuelType fuelType) {
        if (fuelType == null) return false;
        return true;
    }
    // =============== Check variable correctness END ===============

    // =============== Set variables ===============
    public void setName(String name) {
        if (!isNameCorrect(name)) {
            throw new NotEmptyException("Name");
        }
        this.name = name;
    }
    public void setCoordinates(Coordinates coordinates) {
        if (!isCoordinatesCorrect(coordinates)) {
            throw new NotNullException("Coordinates");
        }
        this.coordinates = coordinates;
    }
    public void setEnginePower(int enginePower) {
        if (!isEnginePowerCorrect(enginePower)) {
            throw new ValueOutOfRangeException(0, false, "Engine Power");
        }
        this.enginePower = enginePower;
    }
    public void setNumberOfWheels(int numberOfWheels) {
        if (!isNumberOfWheelsCorrect(numberOfWheels)) {
            throw new ValueOutOfRangeException(0, false, "Number of wheels");
        }
        this.numberOfWheels = numberOfWheels;
    }
    public void setVehicleType(VehicleType vehicleType) {
        if (!isVehicleTypeCorrect(vehicleType)) {
            throw new NotNullException("Vehicle type");
        }
        this.type = vehicleType;
    }
    public void setFuelType(FuelType fuelType) {
        if (!isFuelTypeCorrect(fuelType)) {
            throw new NotNullException("Fuel type");
        }
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
        boolean correct = false;
        String raw;

        //This code sucks but I don't care enough to make it look good.
        //I know that nextInt, nextLong and nextDouble exist, but using them 
        //leads to a bunch of problems with nextLine.

        //21.02.2022 UPDATE: Wow, now it's even worse.

        // =============== Argument input section ===============
        while (!correct) {
            System.out.print("Name> ");
            raw = assemblyline.Main.keyboard.nextLine();
            //if you inputed anything, we might as well check if it's correct
            if (shouldCheck(isRequired, raw)) {
                correct = Vehicle.isNameCorrect(raw);
                if (correct) {
                    toReturn.put("name", raw);
                } else {
                    System.out.println(ErrorMessages.NAME_EMPTY);
                }
            } else {
                correct = true;
            }
        }

        // =============== Coordinates input section ===============
        correct = false;
        double x = 99999;
        while (!correct) {
            System.out.print("X position (Double)> ");
            raw = assemblyline.Main.keyboard.nextLine();
            if (shouldCheck(isRequired, raw)) {
                try {
                    x = Double.parseDouble(raw);
                    correct = Coordinates.isXCorrect(x);
                    if (!correct) {
                        //I'm not sure if this is a good idea...
                        System.out.print(ErrorMessages.X_OUT_OF_RANGE);
                    }
                } catch(Exception e) {
                    System.out.printf(ErrorMessages.TEMPLATE, e.getMessage());
                }
            } else {
                correct = true;
                x = 99999;
            }
        }
        
        correct = false;
        long y = 99999;
        while (!correct) {
            System.out.print("Y position (Long)> ");
            raw = assemblyline.Main.keyboard.nextLine();
            if (shouldCheck(isRequired, raw)) {
                try {
                    y = Long.parseLong(raw);
                    correct = Coordinates.isYCorrect(y);
                    if (!correct) {
                        System.out.print(ErrorMessages.Y_OUT_OF_RANGE);
                    }
                } catch(Exception e) {
                    System.out.printf(ErrorMessages.TEMPLATE, e.getMessage());
                }
            } else {
                correct = true;
                y = 99999;
            }
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

        correct = false;
        while (!correct) {
            System.out.print("Engine power (Integer)> ");
            raw = assemblyline.Main.keyboard.nextLine();
            if (shouldCheck(isRequired, raw)) {
                try {
                    int enginePower = Integer.parseInt(raw);
                    correct = isEnginePowerCorrect(enginePower);

                    if (correct) {
                        toReturn.put("enginePower", enginePower);
                    } else {
                        System.out.print(ErrorMessages.ENGINE_POWER_OUT_OF_RANGE);
                    }
                } catch (Exception e) {
                    System.out.printf(ErrorMessages.TEMPLATE, e.getMessage());
                }
            } else {
                correct = true;
            }
        }

        correct = false;
        while (!correct) {
            System.out.print("Number of wheels (Integer)> ");
            raw = assemblyline.Main.keyboard.nextLine();
            if (shouldCheck(isRequired, raw)) {
                try {
                    int numberOfWheels = Integer.parseInt(raw);
                    correct = isNumberOfWheelsCorrect(numberOfWheels);
                    if (correct) {
                        toReturn.put("numberOfWheels", numberOfWheels);
                    } else {
                        System.out.print(ErrorMessages.NUMBER_OF_WHEELS_OUT_OF_RANGE);
                    }
                } catch(Exception e) {
                    System.out.printf(ErrorMessages.TEMPLATE, e.getMessage());
                }
            } else {
                correct = true;
            }
        }  

        // =============== Vehicle type input ===============
        System.out.printf("%nVehicle types:%n");
        for (int i = 0; i < VehicleType.values().length; i++) {
            System.out.println(VehicleType.values()[i]);
        }

        correct = false;
        while (!correct) {
            System.out.print("Vehicle type> ");
            raw = assemblyline.Main.keyboard.nextLine();
            if (shouldCheck(isRequired, raw)) {
                try {
                    VehicleType vehicleType = VehicleType.valueOf(raw.toUpperCase().trim());
                    correct = isVehicleTypeCorrect(vehicleType);
                    if (correct) {
                        toReturn.put("vehicleType", vehicleType);
                    } else {
                        System.out.print(ErrorMessages.CANNOT_BE_NULL);
                    }
                } catch(Exception e) {
                    System.out.printf(ErrorMessages.TEMPLATE, e.getMessage());
                }
            } else {
                correct = true;
            }
        }

        // =============== Fuel type input ===============
        System.out.printf("%nFuel types:%n");
        for (int i = 0; i < FuelType.values().length; i++) {
            System.out.println(FuelType.values()[i]);
        }

        correct = false;
        while (!correct) {
            System.out.print("Fuel Type> ");
            raw = assemblyline.Main.keyboard.nextLine();
            if (shouldCheck(isRequired, raw)) {
                try {
                    FuelType fuelType = FuelType.valueOf(raw.toUpperCase().trim());
                    correct = isFuelTypeCorrect(fuelType);
                    if (correct) {
                        toReturn.put("fuelType", fuelType);
                    } else {
                        System.out.print(ErrorMessages.CANNOT_BE_NULL);
                    }
                } catch(Exception e) {
                    System.out.printf(ErrorMessages.TEMPLATE, e.getMessage());
                }
            } else {
                correct = true;
            }
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
        if (!isNameCorrect(name)) throw new NotEmptyException("Name");
        if (!isCoordinatesCorrect(coordinates)) throw new NotNullException("Coordinates");
        if (!isEnginePowerCorrect(enginePower)) throw new ValueOutOfRangeException(1, false, "Engine Power");
        if (!isNumberOfWheelsCorrect(numberOfWheels)) throw new ValueOutOfRangeException(1, false, "Number of wheels");
        if (!isVehicleTypeCorrect(vehicleType)) throw new NotNullException("Vehicle type");
        if (!isFuelTypeCorrect(fuelType)) throw new NotNullException("Fuel type");

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