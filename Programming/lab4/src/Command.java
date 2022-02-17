package assemblyline;

import java.util.Enumeration;
import java.util.Hashtable;

import assemblyline.FuelType;
import assemblyline.VehicleType;
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
                if (assemblyline.Main.initializationDate == null) {
                    System.out.println("Vehicle collection was never initialized.");
                } else {
                    System.out.printf("Type: %s%n", assemblyline.Main.vehicleCollection.getClass().getName());
                    System.out.printf("Initialization date: %s%n", assemblyline.Main.initializationDate.toString());
                    System.out.printf("Number of elements: %d%n", assemblyline.Main.vehicleCollection.size());
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
                Enumeration keys = assemblyline.Main.vehicleCollection.keys();
                System.out.println("List of vehicles:");
                while (keys.hasMoreElements()) {
                    String k = (String)keys.nextElement();
                    System.out.printf("[%s] %s%n%n", k, assemblyline.Main.vehicleCollection.get(k).toString());
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
                if (args.length == 0) {
                    throw new NoArgumentGivenException();
                }

                //This code sucks but I don't care enough to make it look good.
                //I know that nextInt, nextLong and nextDouble exist, but using them 
                //leads to a bunch of problems with nextLine.

                System.out.printf("Creating a new vehicle with the '%s' key:%n", args[0]);
                
                //=============== Argument input section ===============
                System.out.print("Name> ");
                String name = assemblyline.Main.keyboard.nextLine();
                Vehicle.isNameCorrect(name);

                //=============== Coordinates input section ===============
                System.out.print("X position (Double)> ");
                double x = Double.parseDouble(assemblyline.Main.keyboard.nextLine());
                Coordinates.isXCorrect(x);

                System.out.print("Y position (Long)> ");
                long y = Long.parseLong(assemblyline.Main.keyboard.nextLine());
                Coordinates.isXCorrect(y);

                Coordinates coordinates = new Coordinates(x, y);
                //=============== Coordinates input section END ===============

                System.out.print("Engine power (Integer)> ");
                int enginePower = Integer.parseInt(assemblyline.Main.keyboard.nextLine());
                Vehicle.isEnginePowerCorrect(enginePower);

                System.out.print("Number of wheels (Integer)> ");
                int numberOfWheels = Integer.parseInt(assemblyline.Main.keyboard.nextLine());
                Vehicle.isNumberOfWheelsCorrect(numberOfWheels);

                //=============== Vehicle type input ===============
                System.out.printf("%nVehicle types:%n");
                for (int i = 0; i < VehicleType.values().length; i++) {
                    System.out.println(VehicleType.values()[i]);
                }
                System.out.print("Vehicle type> ");
                VehicleType vehicleType = VehicleType.valueOf(
                    assemblyline.Main.keyboard.nextLine().toUpperCase().trim());
                Vehicle.isVehicleTypeCorrect(vehicleType);

                //=============== Fuel type input ===============
                System.out.printf("%nFuel types:%n");
                for (int i = 0; i < FuelType.values().length; i++) {
                    System.out.println(FuelType.values()[i]);
                }
                System.out.print("Fuel Type> ");
                FuelType fuelType = FuelType.valueOf(
                    assemblyline.Main.keyboard.nextLine().toUpperCase().trim());
                Vehicle.isFuelTypeCorrect(fuelType);
                //=============== Argument input section END ===============

                assemblyline.Main.vehicleCollection.put(args[0],
                new Vehicle(name, coordinates, enginePower, numberOfWheels, vehicleType, fuelType));

                assemblyline.Main.initializationDate = java.time.LocalDate.now();
                System.out.println("Done!");
            }

            @Override
            public String getHelp() {
                return String.format("Insert a new vehicle with a specified key.%n%nUsage: insert [key]");
            }
        });
        commandList.put("update", new Command());
        commandList.put("remove_key", new Command());
        commandList.put("clear", new Command());
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