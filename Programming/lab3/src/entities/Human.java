package planeflight.entities;

import planeflight.environment.*;

/**
* Class for humans, duh
*/
public class Human extends EntityWithInventory {
    public int age;
    public Location[] memories = new Location[3];

    @Override
    public void react(Location location) {
        switch(location) {
            case NOTHING:
                if (Math.random() < 0.25) System.out.println("Passenger " + getName() + " has a bad feeling about this flight.");
                break;
            default:
                if (Math.random() < 0.75) System.out.println("Passenger " + getName() + " is amazed at sight of " + location);
                addMemory(location);
                break;
        }
    }

    /**
     * Adds a location to person's memory. Only used when sending letters.
     * @param location Location to add to human's memory.
     */
    public void addMemory(Location location) {
        for (int i = 0; i < memories.length; i++) {
            if (memories[i] == null) {
                memories[i] = location;
                //This is the last memory
                if (i == memories.length - 1 && hasItem("Paper") != -1) {
                    removeFromInventory(hasItem("Paper"));
                    class Mail {
                        Location[] locations;
                        public Mail(Location[] locations) {
                            this.locations = locations;
                        }
                    
                        @Override
                        public String toString() {
                            String result = "";
                            for (int i = 0; i < locations.length; i++) {
                                result += locations[i].name().replace("_", " ");
                                if (i != locations.length - 1) {
                                    result += ", ";
                                }
                            }
                            return result;
                        }
                    }
                    Mail letter = new Mail(memories);
                    News.receive(letter.toString());
                }
                return;
            }
        }
        return;
    }

    /**
     * @param name Human's name
     * @param age Human's age
     */
    public Human(String name, int age) {
        super(3);
        this.setName(name);
        this.age = age;
    }

    /**
     * Creates a human named "Unnamed", age 18
     */
    public Human() {
        this("Unnamed", 18);
    }

    @Override
    public String toString() {
        return getName() + ", " + age + ", memories right now: " + memories[0] + ", " + memories[1] + ", " + memories[2];
    }

    @Override
    public int hashCode() {
        return 1 + getName().hashCode() + age * 2 + memories.hashCode() * 4;
    }
}