package planeflight.entities;

import planeflight.environment.*;

/**
* Dog. Absolutely useless.
*/
public class Dog extends Entity {
    public Dog() {
        setName("Dog");
    }

    @Override
    public void react(Location location) {
        if (Math.random() < 0.1) {
            System.out.println("Bark!");
        }
    }
}