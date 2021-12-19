package planeflight.inventory;

public class inventoryFullException extends RuntimeException { 
    public inventoryFullException(String errorMessage) {
        super(errorMessage);
    }
}