package assemblyline.utils;

public class ValueOutOfRangeException extends RuntimeException {
    /**
     * Exception for when wrong value is given
     */
    public ValueOutOfRangeException(){
        super("Given value out of required range.");
    }

    /**
     * Exception for when wrong value is given
     * @param value max/min value
     * @param max is value max?
     */
    public ValueOutOfRangeException(int value, boolean max){
        super(String.format("Given value out of required range. %s value is %d", max ? "Maximum" : "Minimum", value));
    }

    /**
     * Exception for when wrong value is given
     * @param value max/min value
     * @param max is value max?
     * @param name name of the variable
     */
    public ValueOutOfRangeException(int value, boolean max, String name){
        super(String.format("Given value for %s out of required range. %s value is %d", name, max ? "Maximum" : "Minimum", value));
    }
}