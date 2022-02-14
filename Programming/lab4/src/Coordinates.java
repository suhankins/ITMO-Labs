package assemblyline;

public class Coordinates {
    /**
     * * Max value: 591
     */
    private double x;
    /**
     * * Max value: 387
     */
    private long y;

    public Coordinates(double x, long y) {
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