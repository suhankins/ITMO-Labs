package assemblyline;

import java.util.Enumeration;
import java.util.Hashtable;

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
        commandList.put("info", new Command());
        commandList.put("show", new Command());
        commandList.put("insert", new Command());
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
                return String.format("Prints 12 last executed commands.%n%nUsage: history");
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