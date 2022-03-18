package assemblyline.utils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

/**
 * Class used for all things file managment 
 */
public class FileManager {
    /**
     * Used when no parameter is given
     */
    final static String DEFAULT_FILENAME = "default.json";
    /**
     * Loads list of created vehicles from requested file
     * @param filename name of the file from which vehicle list should be loaded
     */
    public static String loadFile(String filename) {
        Path path = Paths.get(filename);
        if (Files.exists(path)) {
            IO.print("yay");
        } else {
            return ErrorMessages.FILE_DOES_NOT_EXIST;
        }
        return ErrorMessages.UNKNOWN_ERROR;
    }
    /**
     * Saves list of created vehicles to requested file
     * @param filename name of the file to which vehicle list should be written
     */
    public static void saveFile(String filename) {
        //TODO: Implement
        throw new FeatureNotImplementedException();
    }
}