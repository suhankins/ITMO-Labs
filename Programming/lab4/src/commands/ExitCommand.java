package assemblyline.commands;

public class ExitCommand extends Command {
    @Override
    public void execute(String[] args) {
        System.exit(0);
    }

    @Override
    public String getHelp() {
        return String.format("Closes the program.%n%nUsage: exit");
    }
}