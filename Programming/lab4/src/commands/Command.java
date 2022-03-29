package assemblyline.commands;

import java.util.Hashtable;

import assemblyline.utils.CommandDoesNotExistException;
import assemblyline.utils.NoArgumentGivenException;

/**
 * Class for commands
 */
public abstract class Command {
    /**
     * List of commands
     */
    private static Hashtable<String, Command> commandList = new Hashtable<String, Command>();

    /**
     * Used for history command. Stores last 12 successfully executed commands
     */
    public static String[] history = new String[12];

    //Static initialization block
    static {
        commandList.put("help", new HelpCommand());
        commandList.put("info", new InfoCommand());
        commandList.put("show", new ShowCommand());
        commandList.put("insert", new InsertCommand());
        commandList.put("update", new UpdateCommand());
        commandList.put("remove_key", new RemoveKeyCommand());
        commandList.put("clear", new ClearCommand());

        commandList.put("save", new SaveCommand());
        commandList.put("execute_script", new ExecuteScriptCommand());

        commandList.put("exit", new ExitCommand());
        commandList.put("history", new HistoryCommand());
        commandList.put("replace_if_lower", new ReplaceIfLowerCommand());
        commandList.put("remove_lower_key", new RemoveLowerKeyCommand());

        commandList.put("print_field_ascending_fuel_type", new PrintFieldSortedCommand("Fuel type", true));
        commandList.put("print_field_descending_engine_power", new PrintFieldSortedCommand("Engine power", false));
        commandList.put("print_field_descending_number_of_wheels", new PrintFieldSortedCommand("Number of wheels", false));
    }

    /**
     * Gets the whole command list
     * @return commandList
     */
    public static Hashtable<String, Command> getCommandList() {
        return commandList;
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
     * @return whether command exists or not
     */
    public static boolean doesCommandExist(String name) {
        return commandList.containsKey(name);
    }

    /**
     * Checks if argument was given. Throws NoArgumentGivenException if not.
     * @param args arguments
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
    public abstract void execute(String[] args);

    /**
     * Get command's description
     * @return command description
     */
    public abstract String getHelp();
}