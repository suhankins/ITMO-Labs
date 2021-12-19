/**
* Class for humans, duh
*/

package planeflight.entities;

import planeflight.inventory.*;

public class Human extends EntityWithInventory {
    public int age;

    public Human(String name, int age) {
        super(3);
        
        this.setName(name);
        this.age = age;
    }

    public Human() {
        this("Unnamed", 18);
    }
}