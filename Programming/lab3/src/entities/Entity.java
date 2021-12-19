/**
* Base class upon which every thing that
* PHYSICALLY EXISTS is based on.
*/

package planeflight.entities;

public abstract class Entity {
    private String name;

    public void setName(String newName) {
        this.name = newName;
    }

    public String getName() {
        return this.name;
    }
}