package assemblyline.utils;

import assemblyline.vehicles.Coordinates;

/**
 * A ton of predefined error messages
 */
public class ErrorMessages {
    public static final String TEMPLATE = "ERROR: %s%n";

    public static final String X_OUT_OF_RANGE =
        String.format(TEMPLATE, new ValueOutOfRangeException((int)Coordinates.MAX_X, true, "X").getMessage());
    public static final String Y_OUT_OF_RANGE =
        String.format(TEMPLATE, new ValueOutOfRangeException((int)Coordinates.MAX_Y, true, "Y").getMessage());
    public static final String NAME_EMPTY =
        String.format(TEMPLATE, new NotEmptyException("Name").getMessage());
    public static final String ENGINE_POWER_OUT_OF_RANGE =
        String.format(TEMPLATE, new ValueOutOfRangeException(1, false, "Engine Power").getMessage());
    public static final String NUMBER_OF_WHEELS_OUT_OF_RANGE =
        String.format(TEMPLATE, new ValueOutOfRangeException(1, false, "Number of wheels").getMessage());
    public static final String CANNOT_BE_NULL =
        String.format(TEMPLATE, new NotNullException().getMessage());
    public static final String COLLECTION_IS_EMPTY = 
        String.format(TEMPLATE, "Vehicle collection is empty.");
    public static final String FILE_DOES_NOT_EXIST =
        String.format(TEMPLATE, "Requested file does not exist.");
    public static final String UNKNOWN_ERROR =
        String.format(TEMPLATE, "Unknown error.");
    public static final String FILE_NOT_READABLE =
        String.format(TEMPLATE, "File cannot be read.");
    public static final String ID_ALREADY_EXISTS =
        String.format(TEMPLATE, "Given ID already exists.");
}