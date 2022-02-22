package assemblyline.utils;

public class NotNullException extends RuntimeException {
    public NotNullException(String name){
        super(String.format("%s cannot be null!", name));
    }

    public NotNullException(){
        this("Field");
    }
}