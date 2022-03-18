package assemblyline.utils;

import java.util.ArrayList;
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
            return script.remove(0);
        }
    }

    /**
     * Adds script to the beginning of the currect script stack
     * @param string script
     */
    public static void addScript(String string) {
        String[] toAdd = string.split("\n");
        for (int i = toAdd.length - 1; i >= 0; i--){
            script.add(0, toAdd[i]);
        }
    }
}