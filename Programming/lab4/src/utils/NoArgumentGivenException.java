package assemblyline.utils;

public class NoArgumentGivenException extends RuntimeException {
    public NoArgumentGivenException(){
        super("No argument was given.");
    }
}