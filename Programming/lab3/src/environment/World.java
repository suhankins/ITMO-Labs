package planeflight.environment;

public final class World {
    public static float temperature = 17.4f;
    public static int month = Month.JANUARY.getNumber();
    public static int day = 5;
    /**
    * Time, defined in seconds since midnight
    * Default value: 7 hours, 15 minutes
    */
    public static int time = (7 * 60 + 15) * 60;
    public static Weather weather = Weather.SUNNY;
}