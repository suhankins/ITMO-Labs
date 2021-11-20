package hell.rides;

import hell.states.*;

public class HeckingWheel extends Ride {
    public HeckingWheel() {
        super("Hecking Wheel");
    }

    @Override
    public boolean canBeInteractedWith() {
        //No one cares if hecking wheel is broken because it *being broken* is the point
        return true;
    }

    public Result interactionResult() {
        if (Math.random() < 0.1 && getCondition()) {
            setCondition(false);
        }

        double diceRoll = Math.random();

        if (!getCondition()) {
            diceRoll /= 2;
        }
        
        //60% had fun
        //15% was bored
        //25% fell off

        //After breaking
        //20% had fun
        //30% was bored
        //50% fell off

        if (diceRoll > 0.4) {
            return Result.HADFUN;
        } else if (diceRoll > 0.25) {
            return Result.WASBORED;
        } else {
            return Result.FELLOFF;
        }
    }
}