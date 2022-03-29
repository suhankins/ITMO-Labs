package assemblyline.commands;

import assemblyline.utils.FileManager;

/**
 * Executes script from a specified file
 */
public class ExecuteScriptCommand extends Command {
    @Override
    public void execute(String[] args) {
        isArgumentGiven(args);
        
        FileManager.loadScript(args[0]);
    }

    @Override
    public String getHelp() {
        return String.format("Executes script from specified files.%n%nUsage: execute_script [file path]");
    }
}