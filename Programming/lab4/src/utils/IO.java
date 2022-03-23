package assemblyline.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class used for inputting text (and outputting too!)
 */
public class IO {
    private static Scanner keyboard = new Scanner(System.in);

    private static ArrayList<String> script = new ArrayList<String>();

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

    public static String nextLine() {
        if (script.isEmpty()) {
            return keyboard.nextLine();
        } else {
            String line = script.remove(0);
            IO.print("%s%n", line);
            return line;
        }
    }

    /**
     * Adds script to the beginning of the current script stack
     * @param string script
     */
    public static void addScript(List<String> string) {
        script.addAll(0, string);
    }
}