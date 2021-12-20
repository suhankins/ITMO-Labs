package planeflight;

import planeflight.entities.*;
import planeflight.environment.*;
import planeflight.inventory.*;

/**
* Lab3 Programming. Based on the description
* you can find in text.docx file in the parent folder.
*
* @author  Dimitri Sukhankin
* @since   2021-12-18 
*/
public class Main {
    public static void main(String[] args) {
        Plane plane = new Plane();

        Human human = new Human("Main Character", 54);

        try {
            human.addToInventory(new Paper());
            plane.addToInventory(human);
            plane.addToInventory(new Human("McTighe", 43));
            plane.addToInventory(new Human("Danforth", 56));
            plane.addToInventory(new Human("Lake", 40));
            plane.addToInventory(new Human("Baird", 58));
            plane.addToInventory(new Human("Larsen", 39));
            for (int i = 0; i < 7; i++) plane.addToInventory(new Dog());
            plane.addToInventory(new Skies());
            plane.addToInventory(new Fuel());
            plane.addToInventory(new Radio());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        while (plane.update()) {

        }
    }
}