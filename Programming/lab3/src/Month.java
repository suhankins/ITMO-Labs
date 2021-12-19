package planeflight;

public enum Month {
    JANUARY(0),
    FEBRUARY(1),
    MARCH(2),
    APRIL(3),
    MAY(4),
    JUNE(5),
    JULY(6),
    AUGUST(7),
    SEPTEMBER(8),
    OCTOBER(9),
    NOVEMBER(10),
    DECEMBER(11);

    public final int number;

    private Month(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public static Month nameOfNumber(int number) {
        for (Month m : values()) {
            if (m.number == number) {
                return m;
            }
        }
        return null;
    }
}