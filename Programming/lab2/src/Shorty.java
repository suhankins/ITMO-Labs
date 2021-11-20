package hell;

import hell.rides.*;
import hell.states.*;

public class Shorty implements Interactor {
    public int id;
    private static int shortiesCount = 0;

    public Shorty() {
        shortiesCount++;
        id = shortiesCount;
    }

    public void interact(Ride ride) {
        if (!ride.canBeInteractedWith()) {
            if (Math.random() > 0.1) {
                System.out.printf("Shorty %d coudldn't ride %s!%n", this.id, ride.getName());
            } else {
                ride.setCondition(true);
                this.interact(ride);
            }
        } else {
            String flavorText = "";
            switch(ride.interactionResult()){
                case HADFUN:
                    flavorText = "had fun on";
                    break;
                case FELLOFF:
                    flavorText = "fell of";
                    break;
                case WASBORED:
                    flavorText = "was bored on";
                    break;
                default:
                    flavorText = "had something unspeakable happen to them on";
                    break;
            }
            System.out.printf("%s %s the %s%n", this.toString(), flavorText, ride.getName());
        }
    }

    @Override
    public boolean equals(Object o){
        if (o == this) {
            return true;
        }

        if (!(o instanceof Shorty)) {
            return false;
        }

        Shorty s = (Shorty)o;

        return s.id == this.id;
    }

    @Override
    public String toString() {
        return String.format("Shorty %d", this.id);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }
}