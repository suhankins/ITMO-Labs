package assemblyline.Vehicles;

import assemblyline.ValueOutOfRangeException;

public class Coordinates {
    /**
     * * Max value: 591
     */
    private double x;
    /**
     * * Max value: 387
     */
    private long y;

    //=============== Check variable correctness ===============
    public static void isXCorrect(double x) {
        if (x > 591) throw new ValueOutOfRangeException(591, true, "X");
    }

    public static void isYCorrect(long y) {
        if (y > 387) throw new ValueOutOfRangeException(387, true, "Y");
    }
    //=============== Check variable correctness END ===============


    public Coordinates(double x, long y) {
        isXCorrect(x);
        isYCorrect(y);
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