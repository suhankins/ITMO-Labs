package hell.rides;

import hell.states.*;

public class HeckingWheel extends Ride {
    private String name;
    public HeckingWheel() {
        super("Hecking Wheel");
    }
    public boolean canBeInteractedWith() {
        //No one cares if hecking wheel is broken because it *being broken* is the point
        return true;
    }
    public Result interactionResult() {
        double diceRoll = Math.random();
        
        //50% user had fun
        //40% user fell off
        //10% user was bored

        if (diceRoll > 0.5) {
            return Result.HADFUN;
        } else if (diceRoll > 0.1) {
            return Result.FELLOFF;
        } else {
            return Result.WASBORED;
        }
    }
}