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
        private static final Location[] LOCATIONS = {Location.NOTHING, Location.SNOW_PILLAR, Location.NOTHING,
                                                     Location.NOTHING, Location.NOTHING, Location.MINE,
                                                     Location.MOUNTAIN, Location.NOTHING};
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

        World.updateTime(30 * 60 + (int)(Math.random() * 60.0));

        return true;
    }

    /**
     * Mainly prints all the cargo
     */
    public void describe() {
        String toReturn = "On the plane there was ";
        String[] checked = new String[70];
        int[] checkedCount = new int[70];
        Entity[] cargo = getInventory();
        for (int i = 0; i < cargo.length; i++) {
            if (cargo[i] == null) break;
            String currentName = cargo[i].getName();
            for (int j = 0; j < checked.length; j++) {
                if (checked[j] == null) {
                    checked[j] = currentName;
                    checkedCount[j] = 1;
                    break;
                } else if (checked[j].equals(currentName)) {
                    checkedCount[j]++;
                    break;
                }
            }
        }
        for (int i = 0; i < checked.length; i++) {
            if (checked[i] == null) {
                toReturn += "and that's about it.";
                break;
            } else {
                if (checkedCount[i] > 1) {
                    toReturn += checkedCount[i] + " " + checked[i] + "s, ";
                } else {
                    toReturn += checked[i] + ", ";
                }
            }
        }

        System.out.println(toReturn);
    }

    @Override
    public String toString() {
        return getName() + " at position " + Journey.getPosition() + ", cargo: " + getInventory().toString();
    }

    @Override
    public int hashCode() {
        return 1 + getName().hashCode() + 2 * Journey.getPosition() + 4 * getInventory().hashCode();
    }
}