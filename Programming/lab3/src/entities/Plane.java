package planeflight.entities;

import planeflight.environment.*;

/**
* Plane
*/
public class Plane extends EntityWithInventory {
    public Plane() {
        super(70);
        this.setName("Plane");
        World.describe();
    }

    class Journey {
        private static final Location[] LOCATIONS = {Location.NOTHING, Location.SNOW_PILLAR, Location.MOUNTAIN, Location.NOTHING, Location.MINE, Location.NOTHING};
        private static int position = -1;

        public static int getPosition() {
            return position;
        }

        public static Location getNextLocation() {
            position++;
            if (position >= LOCATIONS.length) {
                return null;
            }
            return LOCATIONS[position];
        }
    }

    /**
     * Update plane's position and cargo's reaction to the environment.
     * @return Is flight over or not
     */
    public boolean update() {
        Entity[] cargo = getInventory();
        Location currentLocation = Journey.getNextLocation();

        if (currentLocation == null) {
            System.out.println("Flight is finished!");
            World.describe();
            return false;
        }

        for (int i = 0; i < cargo.length; i++) {
            if (cargo[i] == null) {
                break;
            }
            cargo[i].react(currentLocation);
        }

        World.updateTime(30 * 60);

        return true;
    }

    @Override
    public String toString() {
        return getName() + " at position " + Journey.getPosition() + ", cargo: " + getInventory().toString();
    }
}