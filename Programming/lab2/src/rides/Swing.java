package hell.rides;

import hell.states.*;

public class Swing extends Ride {
    public Swing() {
        super("Swing");
    }
    public Result interactionResult() {
        double diceRoll = Math.random();
        
        //65% user had fun
        //25% user was bored
        //10% user fell off

        if (diceRoll > 0.35) {
            return Result.HADFUN;
        } else if (diceRoll > 0.1) {
            return Result.WASBORED;
        } else {
            setCondition(false);
            return Result.FELLOFF;
        }
    }
}