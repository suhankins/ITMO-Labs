package assemblyline;

public class NotNullException extends RuntimeException {
    public NotNullException(){
        super("Field cannot be null!");
    }
}