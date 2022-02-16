package assemblyline;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Hashtable;

/**
* Lab4 Programming. Based on the description
* you can find in text.docx file in the parent folder.
*
* @author  Dimitri Sukhankin
* @since   2022-02-14 
*/
public class Main {
    /**
     * Used when no parameter is given
     */
    final static String DEFAULT_FILENAME = "default.json";
    public static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        //=============== Initilization ===============
        String[] userInput;
        Hashtable<String, Vehicle> vehicleCollection = new Hashtable<String, Vehicle>();
        //=============== Save file loading routine ===============
        String filename;
        if (args.length > 0) {
            filename = args[0];
        } else {
            filename = DEFAULT_FILENAME;
        }
        try {
            FileManager.loadSave(filename);
        } catch (FeatureNotImplementedException exception) {
            System.out.println("File loading routine is still not implemented! Implement it already, you idiot!");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        //=============== Initial message ===============
        System.out.printf("Lab4 assemblyline%nUse 'help' command to see list of commands.%n%n");

        //=============== Handling user imput ===============
        while (true) {
            System.out.print("> ");
            userInput = keyboard.nextLine().split(" ");

            //All commands are lower case and i don't want people to suffer from not knowing it
            userInput[0] = userInput[0].toLowerCase();

            try {
                if (userInput.length > 1) {
                    Command.executeCommand(userInput[0], Arrays.copyOfRange(userInput, 1, userInput.length));
                } else {
                    Command.executeCommand(userInput[0]);
                }
            } catch(Exception e) {
                System.out.printf("ERROR: %s%n", e.getMessage());
            }
        }
    }
}