package assemblyline;

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
                    String k = (String)keys.nextElement();
                    System.out.printf("[%s] %s%n%n", k, VehicleCollection.vehicleCollection.get(k).toString());
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

                System.out.printf("Creating a new vehicle with the '%s' key:%n", args[0]);
                
                Hashtable<String, Object> listOfParams = Vehicle.inputArguments(true);

                VehicleCollection.vehicleCollection.put(args[0],
                    new Vehicle((String)listOfParams.get("name"),
                    (Coordinates)listOfParams.get("coordinates"),
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

                Hashtable<String, Object> listOfParams = Vehicle.inputArguments(false);
                Enumeration keys = listOfParams.keys();

                //I really should consider finding a better way to do this...
                while (keys.hasMoreElements()) {
                    String k = (String)keys.nextElement();
                    Object v = listOfParams.get(k);
                    switch(k) {
                        case "name":
                            vehicle.setName((String)v);
                            break;
                        case "coordinates":
                            vehicle.setCoordinates((Coordinates)v);
                            break;
                        case "enginePower":
                            vehicle.setEnginePower((int)v);
                            break;
                        case "numberOfWheels":
                            vehicle.setNumberOfWheels((int)v);
                            break;
                        case "vehicleType":
                            vehicle.setVehicleType((VehicleType)v);
                            break;
                        case "fuelType":
                            vehicle.setFuelType((FuelType)v);
                            break;
                        case "x":
                            vehicle.setCoordinates(new Coordinates((double)v, vehicle.getCoordinates().getY()));
                            break;
                        case "y":
                            vehicle.setCoordinates(new Coordinates(vehicle.getCoordinates().getX(), (long)v));
                            break;
                    }
                }
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

                if (!VehicleCollection.vehicleCollection.containsKey(args[0])) {
                    throw new NullPointerException(String.format("%s key doesn't exist", args[0]));
                }

                VehicleCollection.vehicleCollection.remove(args[0]);

                System.out.printf("%s key was removed.%n", args[0]);
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
                for (int i = 0; i < history.length; i++) {
                    if (history[i] == null) {
                        break;
                    }
                    System.out.println(history[i]);
                }
            }

            @Override
            public String getHelp() {
                return String.format("Prints 12 last successfully executed commands.%n%nUsage: history");
            }
        });

        commandList.put("replace_if_lower", new Command());
        commandList.put("remove_lower_key", new Command());
        commandList.put("print_field_ascending_fuel_type", new Command());
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