package assemblyline.utils;

public class NotEmptyException extends RuntimeException {
    public NotEmptyException(String name){
        super(String.format("%s can't be an empty string.", name));
    }

    public NotEmptyException(){
        super("You can't use an empty string.");
    }
}