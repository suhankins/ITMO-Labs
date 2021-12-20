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
                break;
            default:
                addMemory(location);
                break;
        }
    }

    public void addMemory(Location location) {
        for (int i = 0; i < memories.length; i++) {
            if (memories[i] == null) {
                memories[i] = location;
                //This is the last memory
                if (i == memories.length - 1 && hasItem("Paper") != -1) {
                    removeFromInventory(hasItem("Paper"));
                    Mail letter = new Mail(memories);
                    News.receive(letter);
                }
            }
        }
        return;
    }

    public Human(String name, int age) {
        super(3);
        this.setName(name);
        this.age = age;
    }

    public Human() {
        this("Unnamed", 18);
    }
}