package assemblyline.utils;

import java.util.Scanner;

/**
 * Class used for inputting text (and outputting too!)
 */
public class IO {
    private static IOState state = IOState.KEYBOARD;

    private static Scanner keyboard = new Scanner(System.in);

    private static String[] script;

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
        return keyboard.nextLine();
    }

    public static void executeScript(String string) {
        //TODO: Implement
        throw new FeatureNotImplementedException();
    }
}