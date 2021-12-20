package planeflight.entities;

import planeflight.environment.*;

/**
* Radio. Doesn't respond.
*/
public class Radio extends Entity {
    public Radio() {
        setName("Radio");
    }

    @Override
    public void react(Location location) {
        if (Math.random() < 0.25) {
            System.out.println("Radio doesn't respond");
        }
    }
}