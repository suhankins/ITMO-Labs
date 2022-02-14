package assemblyline;

public class FeatureNotImplementedException extends RuntimeException {
    public FeatureNotImplementedException(){
        super("Requested feature is not implemented yet!");
    }
}