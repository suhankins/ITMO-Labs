package planeflight.entities;

/**
* News office that prints bulletins
*/
public final class News extends Entity {
    {
        setName("News");
    }

    /**
     * Prints contents of the Mail object
     * @param letter Mail object you want to be printed
     */
    public static void receive(Mail letter) {
        System.out.println("News released bulletins about our crew flying by " + letter.toString());
    }
}