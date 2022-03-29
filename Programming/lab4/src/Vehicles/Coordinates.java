package assemblyline.vehicles;

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

    /**
     * Checks if X value is within allowed range
     * @param x the X value
     * @return whether value is within range or not
     */
    public static boolean isXCorrect(double x) {
        return !(x > MAX_X);
    }
    /**
     * Checks if Y value is within allowed range
     * @param y the Y value
     * @return whether value is within range or not
     */
    public static boolean isYCorrect(long y) {
        return y <= MAX_Y;
    }
    //=============== Check variable correctness END ===============
    
    // =============== Access to variables methods ===============

    /**
     * Return X value
     * @return X value
     */
    public double getX() {
        return x;
    }

    /**
     * Return Y value
     * @return Y value
     */
    public long getY() {
        return y;
    }
    // =============== Access to variables methods END ===============

    // =============== Set variables ===============
    public void setX(double x) {
        if (!isXCorrect(x)) throw new ValueOutOfRangeException((int)MAX_X, true, "X");
        this.x = x;
    }
    public void setY(long y) {
        if (!isYCorrect(y)) throw new ValueOutOfRangeException((int)MAX_Y, true, "Y");
        this.y = y;
    }
    // =============== Set variables END ===============

    public Coordinates(double x, long y) {
        if (!isXCorrect(x)) throw new ValueOutOfRangeException((int)MAX_X, true, "X");
        if (!isYCorrect(y)) throw new ValueOutOfRangeException((int)MAX_Y, true, "Y");
        this.x = x;
        this.y = y;
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