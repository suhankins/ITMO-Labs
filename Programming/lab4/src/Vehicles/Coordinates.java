package assemblyline.Vehicles;

import assemblyline.utils.ValueOutOfRangeException;

public class Coordinates {
    public final static double MAX_X = 591;
    public final static long MAX_Y = 387;
    /**
     * * Max value: 591
     */
    private double x;
    /**
     * * Max value: 387
     */
    private long y;

    //=============== Check variable correctness ===============
    public static boolean isXCorrect(double x) {
        if (x > MAX_X) return false;
        return true;
    }

    public static boolean isYCorrect(long y) {
        if (y > MAX_Y) return false;
        return true;
    }
    //=============== Check variable correctness END ===============


    public Coordinates(double x, long y) {
        if (!isXCorrect(x)) throw new ValueOutOfRangeException((int)MAX_X, true, "X");
        if (!isYCorrect(y)) throw new ValueOutOfRangeException((int)MAX_Y, true, "Y");
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }
    public long getY() {
        return y;
    }

    @Override
    public String toString() {
        return "X: " + x + "; Y: " + y;
    }

    @Override
    public int hashCode() {
        return 1 + Double.valueOf(x).hashCode() * 2 + Long.valueOf(y).hashCode() * 4;
    }
}