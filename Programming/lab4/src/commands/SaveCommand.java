package assemblyline.commands;

import assemblyline.utils.FileManager;

public class SaveCommand extends Command {
    @Override
    public void execute(String[] args) {
        isArgumentGiven(args);
        
        FileManager.saveCollection(args[0]);
    }

    @Override
    public String getHelp() {
        return String.format("Saves vehicle collection to a specified JSON file.%n%nUsage: save [file path]");
    }
}