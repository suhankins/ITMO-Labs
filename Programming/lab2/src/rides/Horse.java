package hell.rides;

import hell.states.*;

public class Horse extends Ride {
    public Horse() {
        super("Wooden Horse");
    }
    public Result interactionResult() {
        double diceRoll = Math.random();
        
        //75% user had fun
        //15% user was bored
        //10% user fell off

        if (diceRoll > 0.25) {
            return Result.HADFUN;
        } else if (diceRoll > 0.1) {
            return Result.WASBORED;
        } else {
            setCondition(false);
            return Result.FELLOFF;
        }
    }
}