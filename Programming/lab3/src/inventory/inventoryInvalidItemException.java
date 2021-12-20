package planeflight.inventory;

public class inventoryInvalidItemException extends Exception { 
    public inventoryInvalidItemException(String errorMessage) {
        super(errorMessage);
    }
}