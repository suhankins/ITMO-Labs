package assemblyline;

import java.util.Arrays;

import assemblyline.commands.Command;
import assemblyline.utils.ErrorMessages;
import assemblyline.utils.FeatureNotImplementedException;
import assemblyline.utils.FileManager;
import assemblyline.utils.IO;

/**
* Lab4 Programming. Based on the description
* you can find in text.docx file in the parent folder.
*
* @author  Dimitri Sukhankin
* @since   2022-02-14 
*/
public class Main {
    public static void main(String[] args) {
        //=============== Initialization ===============
        String[] userInput;
        //=============== Save file loading routine ===============
        try {
            if (args.length > 0) { 
                FileManager.loadSave(args[0]);
            }
        } catch (FeatureNotImplementedException exception) {
            IO.print("File loading routine is still not implemented! Implement it already, you idiot!%n");
        } catch (Exception exception) {
            IO.print(ErrorMessages.TEMPLATE, exception.getMessage());
        }

        //=============== Initial message ===============
        IO.print("Lab4 'assemblyline'%nUse 'help' command to see list of commands.%n%n");

        //=============== Handling user input ===============
        while (true) {
            System.out.print("> ");
            userInput = IO.nextLine().split(" ");

            //All commands are lower case, and I don't want people to suffer from not knowing it
            userInput[0] = userInput[0].toLowerCase();

            try {
                if (userInput.length > 1) {
                    Command.executeCommand(userInput[0], Arrays.copyOfRange(userInput, 1, userInput.length));
                } else {
                    Command.executeCommand(userInput[0]);
                }
            } catch(java.util.InputMismatchException e) {
                IO.print("ERROR: Wrong type of data was inputted%n");
            } catch(Exception e) {
                //Apparently that can happen /shrug
                if (e.getMessage() == null) {
                    IO.print(ErrorMessages.TEMPLATE, e.getClass());
                } else {
                    IO.print(ErrorMessages.TEMPLATE, e.getMessage());
                }
            }
        }
    }
}