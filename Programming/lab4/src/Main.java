package assemblyline;

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

    public static void main(String[] args) {
        //=============== Save file loading routine ===============
        String filename;
        if (args.length > 0) {
            filename = args[0];
        } else {
            filename = DEFAULT_FILENAME;
        }
        try {
            FileManager.loadSave(filename);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}