/**
* Class for humans, duh
*/

package planeflight.entities;

import planeflight.inventory.*;

public class Human extends EntityWithInventory {
    public Human(String name) {
        this.setName(name);
        System.out.printf(getName());
    }

    public Human() {
        this("Беззымянный");
    }
}