package assemblyline;

public class ValueOutOfRangeException extends RuntimeException {
    public ValueOutOfRangeException(){
        super("Given value out of required range.");
    }

    public ValueOutOfRangeException(int value, boolean max){
        super(String.format("Given value out of required range. Value should be %s than %d", max ? "lower" : "higher", value));
    }
}