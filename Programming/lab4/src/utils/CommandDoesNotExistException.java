package assemblyline.utils;

public class CommandDoesNotExistException extends RuntimeException {
    public CommandDoesNotExistException(String name){
        super(String.format("%s command doesn't exist.", name));
    }
}