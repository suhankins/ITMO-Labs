package assemblyline.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Class used for inputting text (and outputting too!)
 */
public class IO {
    /**
     * Scanner used for reading keyboard input
     */
    private static Scanner keyboard = new Scanner(System.in);
    /**
     * Arraylist for storing script commands
     */
    private static ArrayList<String> script = new ArrayList<String>();
    /**
     * Stack for checking if infinite loop was started
     */
    private static Stack<File> stack = new Stack<File>();

    /**
     * Outputs text to where ever we need
     * @param text
     */
    public static void print(String text) {
        System.out.printf(text);
    }

    /**
     * Outputs text to where ever we need
     * @param text
     * @param args
     */
    public static void print(String text, Object... args) {
        System.out.printf(text, args);
    }

    /**
     * Get next inputted line
     * @return next script line, or next keyboard input
     */
    public static String nextLine() {
        if (!script.isEmpty()) {
            String line = script.remove(0);
            //If next line in null - remove it, and remove first thing in stack
            if (line != null) {
                IO.print("%s%n", line);
                return line;
            } else {
                stack.pop();
            }
        }
        return keyboard.nextLine();
    }

    /**
     * Adds script to the beginning of the current script stack
     * @param string script
     */
    public static void addScript(List<String> string, File filename) {
        if (script.size() > 0) {
            if (script.get(0) == null) {
                script.remove(0);
                stack.pop();
            }
        }
        if (stack.search(filename) != -1) {
            throw new InfiniteLoopException();
        }
        stack.push(filename);
        script.addAll(0, string);
        //Null means that given script has finished execution
        script.add(null);
    }
}