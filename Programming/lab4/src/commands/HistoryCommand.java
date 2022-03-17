package assemblyline.commands;

import assemblyline.utils.IO;

public class HistoryCommand extends Command {
    @Override
    public void execute(String[] args) {
        for (int i = 11; i >= 0; i--) {
            if (history[i] != null) {
                IO.print("%s%n", history[i]);
            }
        }
    }

    @Override
    public String getHelp() {
        return String.format("Prints 12 last successfully executed commands.%n%nUsage: history");
    }
}