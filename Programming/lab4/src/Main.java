package assemblyline;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Hashtable;

import assemblyline.Vehicles.Vehicle;
import assemblyline.utils.ErrorMessages;

/**
* Lab4 Programming. Based on the description
* you can find in text.docx file in the parent folder.
*
* @author  Dimitri Sukhankin
* @since   2022-02-14 
*/
public class Main {
    public static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        //=============== Initilization ===============
        String[] userInput;
        //=============== Save file loading routine ===============
        try {
            FileManager.loadSave(args.length > 0 ? args[0] : "");
        } catch (FeatureNotImplementedException exception) {
            System.out.println("File loading routine is still not implemented! Implement it already, you idiot!");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        //=============== Initial message ===============
        System.out.printf("Lab4 'assemblyline'%nUse 'help' command to see list of commands.%n%n");

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
            } catch(java.util.InputMismatchException e) {
                System.out.printf("ERROR: Wrong type of data was inputed%n");
            } catch(Exception e) {
                //Apparently that can happen /shrug
                if (e.getMessage() == null) {
                    System.out.printf(ErrorMessages.TEMPLATE, e.getClass());
                } else {
                    System.out.printf(ErrorMessages.TEMPLATE, e.getMessage());
                }
            }
        }
    }
}