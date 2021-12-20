package planeflight.entities;

import planeflight.environment.*;

/**
* Plane
*/
public class Plane extends EntityWithInventory {
    public int position = 0;

    public Plane() {
        super(70);
        this.setName("Plane");
        World.describe();
    }

    public void update() {
        Entity[] cargo = getInventory();

        for (int i = 0; i < cargo.length; i++) {
            cargo[i].react(World.LOCATIONS[position]);
        }

        position++;
        World.updateTime(30 * 60);

        if (position >= World.LOCATIONS.length) {
            System.out.println("Flight is finished!");
            World.describe();
        }
    }
}