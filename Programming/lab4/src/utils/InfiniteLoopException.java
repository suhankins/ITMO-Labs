package assemblyline.utils;

public class InfiniteLoopException extends RuntimeException {
    public InfiniteLoopException(){
        super(String.format("Infinite loop exception."));
    }
}