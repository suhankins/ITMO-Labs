package assemblyline;

public class NotEmptyException extends RuntimeException {
    public NotEmptyException(){
        super("You can't use an empty string.");
    }
}