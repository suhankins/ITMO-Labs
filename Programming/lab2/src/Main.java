package hell;

import hell.rides.*;
import hell.states.*;

public class Main {
    public static void main(String[] args) {
        Ride[] rides = {new HeckingWheel(), new Swing(), new Horse(), new Bicycle(), new MerryGoRound()};
        //In the description it's said that there were "thousands" of shorties,
        //but i don't it would be a good idea to actually create a thousand of objects
        Shorty[] shorties = new Shorty[100];
        for (int i = 0; i < shorties.length; i++) {
            shorties[i] = new Shorty();

            shorties[i].interact(rides[(int)Math.floor((Math.random() * rides.length))]);
        }
    }
}