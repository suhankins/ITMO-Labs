package planeflight.entities;

/**
* News office that prints bulletins
*/
public final class News extends Entity {
    {
        setName("News");
    }

    /**
     * Prints contents of the string
     * @param letter string you want to be printed
     */
    public static void receive(String letter) {
        System.out.println("News released bulletins about our crew flying by " + letter);
    }
}