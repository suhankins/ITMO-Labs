package hell.rides;

import hell.states.*;

public class MerryGoRound extends Ride {
    public MerryGoRound() {
        super("Merry-Go-Round");
    }
    public Result interactionResult() {
        double diceRoll = Math.random();
        
        //35% user had fun
        //64% user was bored
        //1% user fell off

        if (diceRoll > 0.65) {
            return Result.HADFUN;
        } else if (diceRoll > 0.01) {
            return Result.WASBORED;
        } else {
            setCondition(false);
            return Result.FELLOFF;
        }
    }
}