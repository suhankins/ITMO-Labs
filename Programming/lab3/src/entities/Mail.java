package planeflight.entities;

import planeflight.environment.*;

/**
* Mail
*/
public class Mail extends Entity {
    Location[] locations;
    public Mail(Location[] locations) {
        this.locations = locations;
        setName("Mail");
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < locations.length; i++) {
            result += locations[i].name();
            if (i != locations.length - 1) {
                result += ", ";
            }
        }
        return result;
    }
}