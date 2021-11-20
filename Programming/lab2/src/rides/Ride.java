package hell.rides;

import hell.states.*;

public abstract class Ride implements Interactable {
    private String name;
    
    public Ride(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}