package assemblyline.commands;

import java.util.Enumeration;
import java.util.Hashtable;

import assemblyline.utils.CommandDoesNotExistException;
import assemblyline.utils.IO;

public class HelpCommand extends Command {
    @Override
    public void execute(String[] args) {
        Hashtable<String, Command> commandList = Command.getCommandList();
        if (args.length == 0) {
            Enumeration keys = commandList.keys();
            IO.print("List of commands:%n");
            while (keys.hasMoreElements()) {
                IO.print("%s%n", keys.nextElement());
            }
        } else {
            //commands can be lowercase
            args[0] = args[0].toLowerCase();
            if (!doesCommandExist(args[0])) {
                throw new CommandDoesNotExistException(args[0]);
            }

            IO.print("%s%n", commandList.get(args[0]).getHelp());
        }
    }

    @Override
    public String getHelp() {
        return String.format("Prints description of a command given in an argument.%n%nUsage: help [command]%n%nIf no arguments are given, prints list of existing commands.%n%nUsage: help");
    }
}