package assemblyline;

public class ValueOutOfRangeException extends RuntimeException {
    public ValueOutOfRangeException(){
        super("Given value out of required range.");
    }
}