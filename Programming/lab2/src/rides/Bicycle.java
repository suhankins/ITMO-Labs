package hell.rides;

import hell.states.*;

public class Bicycle extends Ride {
    //There are only 2 bicycles and if both break -
    //ride can no longer be interacted with
    public int breakCount = 0;
    public Bicycle() {
        super("Bicycle");
    }

    @Override
    public boolean canBeInteractedWith() {
        //If both bicycles are broken ride can no
        //longer be interacted with
        return breakCount < 2;
    }

    @Override
    public void setCondition(boolean bool) {
        super.setCondition(bool);
        //resetting break counter
        if (getCondition()) breakCount = 0;
    }

    public Result interactionResult() {
        double diceRoll = Math.random();
        
        //75% user had fun
        //10% user was bored
        //15% user fell off

        if (diceRoll > 0.25) {
            return Result.HADFUN;
        } else if (diceRoll > 0.15) {
            return Result.WASBORED;
        } else {
            setCondition(false);
            breakCount++;
            return Result.FELLOFF;
        }
    }

    //overriding equals because we need to take into account
    //break count too
    @Override
    public boolean equals(Object o){
        if (o == this) {
            return true;
        }

        if (!(o instanceof Bicycle)) {
            return false;
        }

        Bicycle s = (Bicycle)o;

        return s.getName() == this.getName()
               && s.getCondition() == this.getCondition()
               && s.breakCount == this.breakCount;
    }

    //overriding tostring to print break count
    @Override
    public String toString() {
        return String.format("Ride %s; is broken: %b; broken bicycles: %d", this.getName(), !this.getCondition(), this.breakCount);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + getName().hashCode() + (getCondition() ? 1 : 0) + breakCount;
        return result;
    }
}