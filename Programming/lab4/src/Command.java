package assemblyline;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Hashtable;

import assemblyline.Vehicles.FuelType;
import assemblyline.Vehicles.VehicleType;
import assemblyline.Vehicles.Coordinates;
import assemblyline.Vehicles.Vehicle;

/**
 * Class for commands
 */
public class Command {
    /**
     * List of commands
     */
    private static Hashtable<String, Command> commandList = new Hashtable<String, Command>();

    private static String[] history = new String[12];

    //Static initialization block
    static {
        commandList.put("help", new Command() {
            @Override
            public void execute(String[] args) {
                if (args.length == 0) {
                    Enumeration keys = commandList.keys();
                    System.out.println("List of commands:");
                    while (keys.hasMoreElements()) {
                        System.out.println(keys.nextElement());
                    }
                } else {
                    //commands can be lower case
                    args[0] = args[0].toLowerCase();
                    if (!doesCommandExist(args[0])) {
                        throw new CommandDoesNotExistException(args[0]);
                    }

                    System.out.println(commandList.get(args[0]).getHelp());
                }
            }

            @Override
            public String getHelp() {
                return String.format("Prints description of a command given in an argument.%n%nUsage: help [command]%n%nIf no arguments are given, prints list of existing commands.%n%nUsage: help");
            }
        });

        commandList.put("info", new Command() {
            @Override
            public void execute(String[] args) {
                if (VehicleCollection.initializationDate == null) {
                    System.out.println("Vehicle collection was never initialized.");
                } else {
                    System.out.printf("Type: %s%n", VehicleCollection.vehicleCollection.getClass().getName());
                    System.out.printf("Initialization date: %s%n", VehicleCollection.initializationDate.toString());
                    System.out.printf("Number of elements: %d%n", VehicleCollection.vehicleCollection.size());
                }
            }

            @Override
            public String getHelp() {
                return String.format("Prints information about current vehicle collection.%n%nUsage: info");
            }
        });

        commandList.put("show", new Command() {
            @Override
            public void execute(String[] args) {
                Enumeration keys = VehicleCollection.vehicleCollection.keys();
                System.out.println("List of vehicles:");
                while (keys.hasMoreElements()) {
                    int k = (int)keys.nextElement();
                    System.out.printf("[%d] %s%n%n", k, VehicleCollection.vehicleCollection.get(k).toString());
                }
            }

            @Override
            public String getHelp() {
                return String.format("Prints list of vehicles.%n%nUsage: show");
            }
        });

        commandList.put("insert", new Command(){
            @Override
            public void execute(String[] args) {
                isArgumentGiven(args);

                int key = Integer.parseInt(args[0]);

                System.out.printf("Creating a new vehicle with the '%d' key:%n", key);
                
                Hashtable<String, Object> listOfParams = Vehicle.inputArguments(true);

                VehicleCollection.vehicleCollection.put(key,
                    new Vehicle((String)listOfParams.get("name"),
                    new Coordinates((double)listOfParams.get("x"), (long)listOfParams.get("y")),
                    (int)listOfParams.get("enginePower"),
                    (int)listOfParams.get("numberOfWheels"),
                    (VehicleType)listOfParams.get("vehicleType"),
                    (FuelType)listOfParams.get("fuelType"))
                );
                
                //Setting initialization data since this is probably the first car in collection
                if (VehicleCollection.initializationDate == null)
                    VehicleCollection.initializationDate = java.time.LocalDate.now();
                
                System.out.println("Done!");
            }

            @Override
            public String getHelp() {
                return String.format("Insert a new vehicle with a specified key.%n%nUsage: insert [key]");
            }
        });

        commandList.put("update", new Command() {
            @Override
            public void execute(String[] args) {
                isArgumentGiven(args);

                Vehicle vehicle = VehicleCollection.getById(Integer.parseInt(args[0]));
                if (vehicle == null) {
                    throw new NullPointerException(String.format("Vehicle with ID %s does not exist.", args[0]));
                }

                Vehicle.updateVehicle(vehicle, false);
            }

            @Override
            public String getHelp() {
                return String.format("Update vehicle's parameters with new data.%nYou can skip parameters you don't want to update by inputting an empty string.%n%nUsage: update [id]");
            }
        });

        commandList.put("remove_key", new Command() {
            @Override
            public void execute(String[] args) {
                isArgumentGiven(args);

                int key = Integer.parseInt(args[0]);

                if (!VehicleCollection.vehicleCollection.containsKey(key)) {
                    throw new NullPointerException(String.format("%d key doesn't exist", key));
                }

                VehicleCollection.vehicleCollection.remove(key);

                System.out.printf("%d key was removed.%n", key);
            }

            @Override
            public String getHelp() {
                return String.format("Removes a vehicle with the specified key.%n%nUsage: remove_key [key]");
            }
        });

        commandList.put("clear", new Command() {
            @Override
            public void execute(String[] args) {
                VehicleCollection.vehicleCollection.clear();
                VehicleCollection.initializationDate = null;
                System.out.println("Vehicle collection has been cleared.");
            }

            @Override
            public String getHelp() {
                return String.format("Clears vehicle collection.%n%nUsage: clear");
            }
        });

        //TODO: these two
        commandList.put("save", new Command());
        commandList.put("execute_script", new Command());

        commandList.put("exit", new Command() {
            @Override
            public void execute(String[] args) {
                System.exit(0);
            }

            @Override
            public String getHelp() {
                return String.format("Closes the program.%n%nUsage: exit");
            }
        });

        commandList.put("history", new Command() {
            @Override
            public void execute(String[] args) {
                for (int i = 11; i >= 0; i--) {
                    if (history[i] != null) {
                        System.out.println(history[i]);
                    }
                }
            }

            @Override
            public String getHelp() {
                return String.format("Prints 12 last successfully executed commands.%n%nUsage: history");
            }
        });

        commandList.put("replace_if_lower", new Command() {
            @Override
            public void execute(String[] args) {
                isArgumentGiven(args);

                int key = Integer.parseInt(args[0]);

                if (!VehicleCollection.vehicleCollection.containsKey(key)) {
                    throw new NullPointerException(String.format("%s key doesn't exist", args[0]));
                }

                Vehicle vehicle = VehicleCollection.vehicleCollection.get(key);

                Vehicle.updateVehicle(vehicle, true);
            }

            @Override
            public String getHelp() {
                return String.format("Replace fields of a car stored at a given key if new values are lower.%n%nUsage: replace_if_lower [key]");
            }
        });

        commandList.put("remove_lower_key", new Command() {
            @Override
            public void execute(String[] args) {
                isArgumentGiven(args);

                int key = Integer.parseInt(args[0]);

                Enumeration keys = VehicleCollection.vehicleCollection.keys();
                System.out.printf("Removing keys lower than %d:%n", key);
                while (keys.hasMoreElements()) {
                    int k = (int)keys.nextElement();
                    if (k < key) {
                        VehicleCollection.vehicleCollection.remove(k);
                        System.out.printf("Key %d was removed%n", k);
                    }
                }
                System.out.printf("Every key lower than %d has been successfully removed.%n", key);
            }

            @Override
            public String getHelp() {
                return String.format("Replace fields of a car stored at a given key if new values are lower.%n%nUsage: replace_if_lower [key]");
            }
        });
        commandList.put("print_field_ascending_fuel_type", new Command() {
            @Override
            public void execute(String[] args) {
                //This is ridiculous
                Vehicle[] vehicles = new Vehicle[VehicleCollection.vehicleCollection.size()];
                Enumeration keys = VehicleCollection.vehicleCollection.keys();
                //Here we put stuff from hashtable into an array
                for (int i = 0; i < vehicles.length; i++) {
                    int k = (int)keys.nextElement();
                    vehicles[i] = VehicleCollection.vehicleCollection.get(k);
                }
                //Sort the array
                Arrays.sort(vehicles, new Comparator<Vehicle>() {
                    @Override
                    public int compare(Vehicle v1, Vehicle v2) {
                        return v1.getFuelType().compareTo(v2.getFuelType());
                    }
                });
                //Print it!
                for (int i = 0; i < vehicles.length; i++) {
                    System.out.printf("[%s #%d] %s%n", vehicles[i].getVehicleType(), vehicles[i].getId(), vehicles[i].getFuelType());
                }
            }

            @Override
            public String getHelp() {
                return String.format("Prints fuel types of every vehicle in ascending order.%n%nUsage: print_field_ascending_fuel_type");
            }
        });
        commandList.put("print_field_descending_engine_power", new Command());
        commandList.put("print_field_descending_number_of_wheels", new Command());
    }

    /**
     * Execute a command with arguments
     * @param name command name
     * @param args list of arguments
     */
    public static void executeCommand(String name, String[] args){
        if (!doesCommandExist(name)) {
            throw new CommandDoesNotExistException(name);
        }

        commandList.get(name).execute(args);

        appendHistory(name);
    }

    /**
     * Execute a command without arguments
     * @param name command name
     */
    public static void executeCommand(String name){
        executeCommand(name, new String[0]);
    }

    /**
     * Append a new command to history list
     * @param name
     */
    public static void appendHistory(String name) {
        for (int i = history.length - 1; i > 0; i--) {
            history[i] = history[i - 1];
        }
        history[0] = name;
    }

    /**
     * Checks if command exists
     * @param name command name
     * @return 
     */
    public static boolean doesCommandExist(String name) {
        return commandList.containsKey(name);
    }

    /**
     * Checks if argument was given. Throws NoArgumentGivenException if not.
     * @param args
     */
    public static void isArgumentGiven(String[] args) {
        if (args.length == 0) {
            throw new NoArgumentGivenException();
        }
    }

    //=============== Instance methods ===============

    /**
     * Execute the command
     * @param args arguments
     */
    public void execute(String[] args) {
        throw new FeatureNotImplementedException();
    }

    /**
     * Get command's description
     * @return command description
     */
    public String getHelp() {
        return "No description.";
    }
}