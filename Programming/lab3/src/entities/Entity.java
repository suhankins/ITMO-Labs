package planeflight.entities;

import planeflight.environment.*;

/**
* Base class upon which every thing that
* PHYSICALLY EXISTS is based on.
*/
public abstract class Entity implements React {
    private String name;

    public void setName(String newName) {
        this.name = newName;
    }

    public String getName() {
        return this.name;
    }

    public void react(Location location) {

    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public int hashCode() {
        return 1 + name.hashCode();
    }

    @Override
    public boolean equals(Object o){
        if (o == this) {
            return true;
        }
        if (!(o instanceof Entity)) {
            return false;
        }
        Entity s = (Entity)o;
        return s.hashCode() == this.hashCode();
    }
}