package hell;

import hell.rides.*;
import hell.states.*;

public class Main {
    public static void main(String[] args) {
        Ride heckingWheel = new HeckingWheel();
        Shorty shorty = new Shorty();
        shorty.interact(heckingWheel);
    }
}