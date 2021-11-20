package hell.rides;

import hell.states.*;

public abstract class Ride implements Interactable {
    private boolean condition = true;
    private String name;

    //Name stuff
    public Ride(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    //Condition stuff
    //This one can be overriden, that's why we need getCondition
    public boolean canBeInteractedWith() {
        return condition;
    }
    public boolean getCondition() {
        return condition;
    }
    public void setCondition(boolean bool) {
        condition = bool;
        if (!condition) System.out.printf("%s is broken! ", this.getName());
        else System.out.printf("%s was fixed! ", this.getName());
    }

    @Override
    public boolean equals(Object o){
        if (o == this) {
            return true;
        }

        if (!(o instanceof Ride)) {
            return false;
        }

        Ride s = (Ride)o;

        return s.getName() == this.name
               && s.getCondition() == this.condition;
    }

    @Override
    public String toString() {
        return String.format("Ride %s; is broken: %b", this.getName(), !this.condition);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + getName().hashCode() + (getCondition() ? 1 : 0);
        return result;
    }
}